package com.baobab.m.service.payple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.vo.AccountAndroidVO;
import com.baobab.m.vo.AccountCancelVO;
import com.baobab.m.vo.AccountSelectVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PaypleCancelVO;
import com.baobab.m.vo.PaypleMCertVO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class PaypleServiceImpl implements PaypleService {
	
	@Autowired
	PaymentDAO payment;

	@Override
	public String httpRequest(String param, String urlStr, String method, int work) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod(method);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Cache-Control", "no-cache");
		if(work == 5) {
			con.setRequestProperty("Referer", "https://baobab858.com/jsp/payple.api"); //결제창을 호출하는 서버의 URL
		}else if (work == 3 || work == 4) {
			con.setRequestProperty("Referer", "https://baobab858.com");
		}
		
		con.setDoOutput(true);
		
		OutputStream os = con.getOutputStream();
		
		os.write(param.getBytes("UTF-8"));
		os.flush();
		os.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();			

		return response.toString();
	}

	@Override
	public String marchantCert(int reciptCheck) throws IOException {
		String cstId = "thegreat";
		String custKey = "671e687153f42d0b0bf44f003fbdaf684e0ba7cb8895d4fa0479c6d8accd5200";
		
		String param;
		if(reciptCheck == 0) {
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\"}";
			//일반 결제
		}else if(reciptCheck == 1) {
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\", \"PCD_PAY_WORK\":\"TSREG\"}";
			//현금영수증 신청
		}else if(reciptCheck == 2){
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\", \"PCD_PAY_WORK\":\"TSCANCEL\"}";
			//현금영수증 취소
		}else if(reciptCheck == 3){
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\", \"PCD_PAY_WORK\":\"PUSERINFO\"}";
			//등록계좌 조회
		}else if(reciptCheck == 4){
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\", \"PCD_PAY_WORK\":\"PUSERDEL\"}";
			//등록계좌 해지
		}else if(reciptCheck == 5){
			param = "{\"cst_id\":\"" + cstId + "\", \"custKey\":\"" + custKey + "\", \"PCD_PAYCANCEL_FLAG\":\"Y\"}";
			//결제 승인취소
		}else {
			param = "";
		}
		
		return httpRequest(param, "https://cpay.payple.kr/php/auth.php", "POST", reciptCheck);
	}

	@Override
	public List<AccountAndroidVO> regAccountSelect(String email, List<String> payerId) throws IOException {
		Gson gson = new Gson();
		
		List<AccountAndroidVO> result = new ArrayList<>();
		for(int i=0;i<payerId.size();i++) {
			PaypleMCertVO mCertVO = gson.fromJson(marchantCert(3), PaypleMCertVO.class);
			String param = "{\r\n" + 
					"   \"PCD_CST_ID\": \"" + mCertVO.getCst_id() + "\",                           \r\n" + 
					"   \"PCD_CUST_KEY\": \"" + mCertVO.getCustKey() + "\",                        \r\n" + 
					"   \"PCD_AUTH_KEY\": \"" + mCertVO.getAuthKey() + "\",                        \r\n" + 
					"   \"PCD_PAYER_ID\": \"" + payerId.get(i) + "\", \r\n" + 
					"   \"PCD_PAYER_NO\": \"" + "number" + "\"                             \r\n" + 
					"}";
			
			AccountSelectVO asvo = gson.fromJson(httpRequest(param, "https://cpay.payple.kr/php/cPayUser/api/cPayUserAct.php?ACT_=PUSERINFO", "POST", 3)
					, AccountSelectVO.class);
			if(asvo.getPCD_PAY_RST().equals("success")) {
				AccountAndroidVO aavo = new AccountAndroidVO();
				aavo.setAccountHolder(asvo.getPCD_PAYER_NAME());
				aavo.setAccountNumber(asvo.getPCD_PAY_BANKNUM());
				aavo.setBankCode(asvo.getPCD_PAY_BANK());
				aavo.setBankName(asvo.getPCD_PAY_BANKNAME());
				aavo.setEmail(email);
				aavo.setPayerId(asvo.getPCD_PAYER_ID());
				aavo.setPhoneNumber(asvo.getPCD_PAYER_HP());
				
				result.add(aavo);
				
			}
			System.out.println("mSert : " + mCertVO.toString());
			System.out.println("asVO : " + asvo.toString());
		}
		System.out.println("계좌 조회2 : " + result);
		return result;
	}

	@Override
	public String regAccountDelete(HttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		PaypleMCertVO mCertVO = gson.fromJson(marchantCert(4), PaypleMCertVO.class);
		
		String param = "{\r\n" + 
				"  \"PCD_CST_ID\": \"" + mCertVO.getCst_id() + "\",	\r\n" + 
				"  \"PCD_CUST_KEY\": \"" + mCertVO.getCustKey() + "\", \r\n" + 
				"  \"PCD_AUTH_KEY\" : \"" + mCertVO.getAuthKey() + "\",\r\n" + 
				"  \"PCD_PAYER_ID\" : \"" + request.getParameter("payerId") + "\",					\r\n" + 
				"  \"PCD_PAYER_NO\" : \"" + "number" + "\"\r\n" + 
				"}";
		
		AccountCancelVO vo = gson.fromJson(httpRequest(param, mCertVO.getPCD_PAY_HOST() + mCertVO.getPCD_PAY_URL(), "POST", 4), AccountCancelVO.class);
		if(vo.getPCD_PAY_RST().equals("success")) {
			payment.deletePayerId(request.getParameter("payerId"));
		}
		return vo.getPCD_PAY_RST();
	}

	@Override
	public PaypleCancelVO cancel(String oid) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		PaypleMCertVO mCertVO = gson.fromJson(marchantCert(5), PaypleMCertVO.class);
		PaymentVO pmVO = payment.selectAllFromOid(oid);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String payDate = format.format(pmVO.getPayDate());
		String[] splitDate = payDate.split("-");
		
		String param = "{\r\n" + 
				"  \"PCD_CST_ID\": \"" + mCertVO.getCst_id() + "\",\r\n" + 
				"  \"PCD_CUST_KEY\": \"" + mCertVO.getCustKey() + "\",\r\n" + 
				"  \"PCD_AUTH_KEY\": \"" + mCertVO.getAuthKey() + "\",  \r\n" + 
				"  \"PCD_REFUND_KEY\" : \"" + "0fc30d7b834d6200df4914d9250c644858e101dae8058a72165156c59c903308" + "\",\r\n" + 
				"  \"PCD_PAYCANCEL_FLAG\": \"Y\",\r\n" + 
				"  \"PCD_PAY_OID\": \"" + oid + "\",\r\n" + 
				"  \"PCD_PAY_YEAR\": " + splitDate[0] + ",\r\n" + 
				"  \"PCD_PAY_MONTH\": \"" + splitDate[1] + "\",\r\n" + 
				"  \"PCD_PAY_DATE\": " + payDate.replaceAll("-", "") + ",\r\n" + 
				"  \"PCD_REFUND_TOTAL\": " + pmVO.getTotalDisPrice() + "\r\n" + 
				"}";
		
		System.out.println(mCertVO.toString());
		
		PaypleCancelVO vo = gson.fromJson(httpRequest(param, mCertVO.getReturn_url(), "POST", 5), PaypleCancelVO.class);
		return vo;
	}
}