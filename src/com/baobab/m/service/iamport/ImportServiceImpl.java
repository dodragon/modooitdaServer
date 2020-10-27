package com.baobab.m.service.iamport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.baobab.m.vo.ImportVO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class ImportServiceImpl implements ImportServiceInterface {
	
	@Override
	public String accountCert(HttpServletRequest request) throws JsonSyntaxException, IOException {
		ImportServiceImpl imp = new ImportServiceImpl();
		Gson gson = new Gson();
		
		ImportVO tokenVo = gson.fromJson(getAccessToken(), ImportVO.class);
		String accessToken = tokenVo.getResponse().getAccess_token();
		
		String result = imp.getAccountHolder(accessToken, request.getParameter("bank"), request.getParameter("account"));
		
		if(result.equals("401")) {
			tokenVo = gson.fromJson(getAccessToken(), ImportVO.class);
			accessToken = tokenVo.getResponse().getAccess_token();
			result = imp.getAccountHolder(accessToken, request.getParameter("bank"), request.getParameter("account"));
		}
		
		System.out.println("�������� : " + result);
		return result;
	}

	@Override
	public String getAccessToken() throws IOException {
		URL url = new URL("https://api.iamport.kr/users/getToken");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		con.setDoOutput(true);
	
		String input = "{\"imp_key\" : \"3515083934031190\", \"imp_secret\" : \"sjAk171oGcWG0lFkNKHVUDXTIvZwfxQHQq2Ry3fffcVfyAzllhhgVe9DK9aZG0GxrIo0LEg1RbhqMQM7\"}";
		
		OutputStream os = con.getOutputStream();
		
		os.write(input.getBytes("UTF-8"));
		os.flush();
		os.close();
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending Push 'POST' request to URL : " + url);
		System.out.println("Post parameter : " + input);
		System.out.println("Response Code : " + responseCode);
		
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
	public String getAccountHolder(String token, String bank, String accountNum) {
		try {
			URL url = new URL("https://api.iamport.kr/vbanks/holder?bank_code=" + returnBankCode(bank) + "&bank_num=" + accountNum + "&_token=" + token);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", token);
			con.setRequestProperty("Content-Type", "application/json");
			
			con.setDoOutput(true);
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending Push 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			Gson gson = new Gson();
			ImportVO vo = gson.fromJson(response.toString(), ImportVO.class);
			
			if(responseCode == 200) {
				return vo.getResponse().getBank_holder();
			}else if(responseCode == 401) {
				return "401";
			}else {
				return "x";
			}
		}catch(IOException e) {
			return "x";
		}
	}
	
	public static String returnBankCode(String bank) {
		if(bank.contains("����")) {
			return "011";
		}else if(bank.contains("����")) {
			return "088";
		}else if(bank.contains("���")) {
			return "003";
		}else if(bank.contains("�츮")) {
			return "020";
		}else if(bank.contains("����")) {
			return "004";
		}else if(bank.contains("����")) {
			return "023";
		}else if(bank.contains("�뱸")) {
			return "031";
		}else if(bank.contains("�λ�")) {
			return "032";
		}else if(bank.contains("����")) {
			return "034";
		}else if(bank.contains("�泲")) {
			return "039";
		}else if(bank.contains("����")) {
			return "037";
		}else if(bank.contains("����")) {
			return "035";
		}else if(bank.contains("���")) {
			return "002";
		}else if(bank.contains("��ü��")) {
			return "071";
		}else if(bank.contains("����")) {
			return "048";
		}else if(bank.contains("����")) {
			return "007";
		}else if(bank.contains("�ѱ���Ƽ")) {
			return "027";
		}else if(bank.contains("���̹�ũ")) {
			return "089";
		}else if(bank.contains("�ϳ�")) {
			return "081";
		}else if(bank.contains("īī��")) {
			return "090";
		}else {
			return null;
		}
	}
}
