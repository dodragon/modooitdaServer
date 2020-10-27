package com.baobab.m.service.rsa;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.baobab.m.vo.MeCertVO;

@Service
public class KmcDecryptUtil {
	
	public MeCertVO decrypt(HttpServletRequest request) throws ParseException, UnsupportedEncodingException {
		String rec_cert       = request.getParameter("rec_cert").trim();
        String k_certNum      = request.getParameter("certNum").trim(); 
        
		String certNum		= "";			// 요청번호
	    String date			= "";			// 요청일시
		String CI	    	= "";			// 연계정보(CI)
		String DI	    	= "";			// 중복가입확인정보(DI)
	    String phoneNo		= "";			// 휴대폰번호
		String phoneCorp	= "";			// 이동통신사
		String birthDay		= "";			// 생년월일
		String gender		= "";			// 성별
		String nation		= "";			// 내국인
		String name			= "";			// 성명
		String M_name		= "";			// 미성년자 성명
		String M_birthDay	= "";			// 미성년자 생년월일
		String M_Gender		= "";			// 미성년자 성별
		String M_nation		= "";			// 미성년자 내외국인
	    String result		= "";			// 결과값

	    String certMet		= "";			// 인증방법
	    String ip			= "";			// ip주소
		String plusInfo		= "";

		String encPara		= "";
		String encMsg1		= ""; 
		String encMsg2		= "";
		
		com.icert.comm.secu.IcertSecuManager seed = new com.icert.comm.secu.IcertSecuManager();
		rec_cert  = seed.getDec(rec_cert, k_certNum);
		
		int inf1 = rec_cert.indexOf("/", 0);
		int inf2 = rec_cert.indexOf("/", inf1 + 1);
		
		encPara = rec_cert.substring(0, inf1);
		encMsg1 = rec_cert.substring(inf1 + 1, inf2);
		encMsg2 = seed.getMsg(encPara);
		
		String msgChk = "N";
		if(encMsg2.equals(encMsg1)) {
			msgChk = "Y";
		}
		
		if(msgChk.equals("N")) {
			//TODO: 비정상적인 접근
		}
		
		rec_cert = seed.getDec(encPara, k_certNum);
		
		int info1  = rec_cert.indexOf("/",0);
        int info2  = rec_cert.indexOf("/",info1+1);
        int info3  = rec_cert.indexOf("/",info2+1);
        int info4  = rec_cert.indexOf("/",info3+1);
        int info5  = rec_cert.indexOf("/",info4+1);
        int info6  = rec_cert.indexOf("/",info5+1);
        int info7  = rec_cert.indexOf("/",info6+1);
        int info8  = rec_cert.indexOf("/",info7+1);
		int info9  = rec_cert.indexOf("/",info8+1);
		int info10 = rec_cert.indexOf("/",info9+1);
		int info11 = rec_cert.indexOf("/",info10+1);
		int info12 = rec_cert.indexOf("/",info11+1);
		int info13 = rec_cert.indexOf("/",info12+1);
		int info14 = rec_cert.indexOf("/",info13+1);
		int info15 = rec_cert.indexOf("/",info14+1);
		int info16 = rec_cert.indexOf("/",info15+1);
		int info17 = rec_cert.indexOf("/",info16+1);
		int info18 = rec_cert.indexOf("/",info17+1);

        certNum		= rec_cert.substring(0,info1);
        date		= rec_cert.substring(info1+1,info2);
        CI			= rec_cert.substring(info2+1,info3);
        phoneNo		= rec_cert.substring(info3+1,info4);
        phoneCorp	= rec_cert.substring(info4+1,info5);
        birthDay	= rec_cert.substring(info5+1,info6);
        gender		= rec_cert.substring(info6+1,info7);
        nation		= rec_cert.substring(info7+1,info8);
		name		= rec_cert.substring(info8+1,info9);
		result		= rec_cert.substring(info9+1,info10);
		certMet		= rec_cert.substring(info10+1,info11);
		ip			= rec_cert.substring(info11+1,info12);
		M_name		= rec_cert.substring(info12+1,info13);
		M_birthDay	= rec_cert.substring(info13+1,info14);
		M_Gender	= rec_cert.substring(info14+1,info15);
		M_nation	= rec_cert.substring(info15+1,info16);
		plusInfo	= rec_cert.substring(info16+1,info17);
		DI      	= rec_cert.substring(info17+1,info18);
		
		CI  = seed.getDec(CI, k_certNum);
        DI  = seed.getDec(DI, k_certNum);
        
        MeCertVO vo = new MeCertVO();
        vo.setCertNum(certNum);
        vo.setDate(date);
        vo.setCI(CI);
        vo.setPhoneNo(phoneNo);
        vo.setPhoneCorp(phoneCorp);
        vo.setBirthDay(birthDay);
        vo.setGender(gender);
        vo.setNation(nation);
        vo.setName(name);
        vo.setResult(result);
        vo.setCertMet(certMet);
        vo.setIp(ip);
        vo.setM_name(M_name);
        vo.setM_birthDay(M_birthDay);
        vo.setM_Gender(M_Gender);
        vo.setM_nation(M_nation);
        vo.setPlusInfo(plusInfo);
        vo.setDI(DI);
        
        return vo;
	}
}
