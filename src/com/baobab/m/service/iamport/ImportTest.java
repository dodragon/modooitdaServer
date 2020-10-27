package com.baobab.m.service.iamport;

import java.io.IOException;

import com.baobab.m.vo.ImportVO;
import com.google.gson.Gson;

public class ImportTest {
	
	private static String accessToken = null;

	public static void main(String[] args) throws IOException {
		ImportServiceImpl imp = new ImportServiceImpl();
		Gson gson = new Gson();
		
		if(accessToken == null) {
			ImportVO tokenVo = gson.fromJson(imp.getAccessToken(), ImportVO.class);
			accessToken = tokenVo.getResponse().getAccess_token();
		}
		
		System.out.println(imp.getAccountHolder(accessToken, "½ÅÇÑ", "110267122289"));
	}
}
