package com.baobab.m.service.inicis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.service.payple.PaypleService;
import com.baobab.m.service.rsa.Sha512;
import com.baobab.m.vo.PayCancelVO;
import com.baobab.m.vo.PaypleCancelVO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class PaycancelAPI {
	
	@Autowired
	PaymentDAO payment;
	@Autowired
	PaymentService pay;
	@Autowired
	PaypleService payple;
	
	public PayCancelVO cancelDiv(String oid) throws NoSuchAlgorithmException, IOException{
		String pg = payment.findPg(oid);
		if(pg.equals("inicis")) {
			return inicisCancel(oid);
		}else {
			return paypleCancel(oid);
		}
	}
	
	public PayCancelVO inicisCancel(String oid) throws NoSuchAlgorithmException, IOException{
		String tid = payment.findTid(oid);
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String param = "type=Refund&paymethod=Card&timestamp=" + timestamp + "&clientIp=183.111.138.210" +
				"&mid=baobab858c&tid=" + tid + "&msg=userCancel&hashData=" + new Sha512().encrypt("R9lwL2vb31qLetIbRefundCard" + timestamp + "183.111.138.210" + 
						"baobab858c" + tid);
		String urlStr = "https://iniapi.inicis.com/api/v1/refund";
		
		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("charset", "utf-8");
		
		con.setDoOutput(true);
		
		OutputStream os = con.getOutputStream();
		os.write(param.getBytes("UTF-8"));
		os.flush();
		os.close();
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending Push 'POST' request to URL : " + url);
		System.out.println("Post parameter : " + param);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String resultStr = response.toString();
		System.out.println(resultStr);
		
		Gson gson = new Gson();
		PayCancelVO vo = gson.fromJson(resultStr, PayCancelVO.class);
		
		if(vo.getResultCode().equals("00")) {
			pay.payCancel(oid);
		}
		
		return vo;
	}
	
	public PayCancelVO paypleCancel(String oid) throws JsonSyntaxException, IOException {
		PayCancelVO vo = new PayCancelVO();
		PaypleCancelVO ppcVO = payple.cancel(oid);
		
		
		if(ppcVO.getPCD_PAY_RST().equals("success")) {
			pay.payCancel(oid);
			
			vo.setResultCode("00");
		}else {
			vo.setResultCode("10");
		}
		
		vo.setResultMsg(ppcVO.getPCD_PAY_MSG());
		
		return vo;
	}
}
