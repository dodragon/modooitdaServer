package com.baobab.m.service.license;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.baobab.m.vo.CertificationVO;
import com.icert.comm.secu.IcertSecuManager;
import com.icert.comm.secu.hmac.IcertHmac;

@Service
public class Certification {
	
	public String makeUrl(HttpServletRequest request) {
		String cpId = request.getParameter("cpId");
		String urlCode = request.getParameter("urlCode");
		String phoneNo = request.getParameter("phoneNo");
		String authNo = request.getParameter("authNo");
		
		Calendar today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String reqDate = sdf.format(today.getTime());

		java.util.Random ran = new Random();
		int numLength = 6;
		String randomStr = "";

		for (int i = 0; i < numLength; i++) {
			randomStr += ran.nextInt(10);
		}

		String certNo = reqDate + randomStr;
		String extendVar = "0000000000000000";
		
		IcertSecuManager seed  = new IcertSecuManager();  


		String enc_tr_cert = "";
		String tr_cert     = cpId +"/"+ urlCode +"/"+ certNo +"/"+ reqDate +"/"+ phoneNo +"/"+ authNo +"/"+ extendVar;
		enc_tr_cert = seed.getEnc(tr_cert, "");

		String hmacMsg = IcertHmac.HMacEncript(enc_tr_cert);

		tr_cert  = seed.getEnc(enc_tr_cert +"/"+ hmacMsg +"/"+ extendVar, "");  

		return "https://www.kmcert.com/ics/smsAuth/smsAuthT_10.jsp?tr_cert="+tr_cert;
	}
	
	public CertificationVO certResult(HttpServletRequest request) {
		URL url = null;
        BufferedReader in = null;
        URLConnection con = null;

        String rec_cert = "";
        String urlstr   = makeUrl(request);
        try {
            url = new URL(urlstr);
            con = url.openConnection();
            con.connect();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String tmp_msg = "";
            while ((tmp_msg = in.readLine()) != null) {
                if (!"".equals(tmp_msg)) {
                    rec_cert = tmp_msg;
                }
            }
        } catch (MalformedURLException malformedurlexception) {
            rec_cert = "URL Error("+malformedurlexception+")";
        } catch (IOException ioexception) {
            rec_cert = "IO Error("+ioexception+")";
		} finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex3) {
                System.out.println(ex3.toString());
            }
        }

        try 
		{
			//����� ����--------------------------------------------------------------------------------------------
            String encPara      = "";	//��ȣȭ�� ���� �Ķ����
            String encMsg1      = "";	//��ȣȭ�� ���� �Ķ������ Hash��
			String encMsg2      = "";	//��ȣȭ�� ���� �Ķ������ Hash�� �񱳸� ���� Hash��
			
			String r_certNo		= "";	//������ȣ
			String r_reqDate    = "";	//��û�Ͻ�
			String r_result     = "";	//��������� 
			String r_resultCode = "";	//��������ڵ�
			String r_phoneNo    = "";	//�޴�����ȣ
			String r_authNo		= "";	//SMS���ι�ȣ 
			String r_extendVar	= "";	//Ȯ�庯��
			//-------------------------------------------------------------------------------------------------------

			//07. 1�� ��ȣȭ (������ȣ�� �̿��� ��ȣȭ)
			IcertSecuManager seed  = new IcertSecuManager();
			rec_cert = seed.getDec(rec_cert, "");  

			int inf1 = rec_cert.indexOf("/",0);
			int inf2 = rec_cert.indexOf("/",inf1+1);

            encPara = rec_cert.substring(0, inf1);      
            encMsg1 = rec_cert.substring(inf1+1, inf2); 

			//08. 1�� ��ȣȭ �����Ϳ� ���� ������ ������ ����
			encMsg2 = seed.getMsg(encPara);

			if(!encMsg1.equals(encMsg2)){
				System.out.println("�������� ����");
            }

			//09. 2�� ��ȣȭ (������ȣ�� �̿��� ��ȣȭ)
			rec_cert  = seed.getDec(encPara, "");  

			int info1  = rec_cert.indexOf("/",0);
			int info2  = rec_cert.indexOf("/",info1+1);
			int info3  = rec_cert.indexOf("/",info2+1);
			int info4  = rec_cert.indexOf("/",info3+1);
			int info5  = rec_cert.indexOf("/",info4+1);
			int info6  = rec_cert.indexOf("/",info5+1);

			r_certNo	 = rec_cert.substring(0,info1);            
			r_reqDate    = rec_cert.substring(info1+1,info2);      
			r_result     = rec_cert.substring(info2+1,info3);      
			r_resultCode = rec_cert.substring(info3+1,info4);      
			r_phoneNo    = rec_cert.substring(info4+1,info5);      
			r_authNo     = rec_cert.substring(info5+1,info6);
			
			
			CertificationVO vo = new CertificationVO();
			vo.setCertNo(r_certNo);
			vo.setReqDate(r_reqDate);
			vo.setResult(r_result);
			vo.setResultCode(r_resultCode);
			vo.setPhoneNo(r_phoneNo);
			vo.setAuthNo(r_authNo);
			vo.setExtendVar(r_extendVar);
			
			return vo;
        } catch (Exception ex) {
            System.out.println("[ICS] Receive Error -" + ex.getMessage());
        }
		return null;
	}
}
