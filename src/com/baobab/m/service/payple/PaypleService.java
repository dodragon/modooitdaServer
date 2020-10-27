package com.baobab.m.service.payple;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.AccountAndroidVO;
import com.baobab.m.vo.PaypleCancelVO;
import com.google.gson.JsonSyntaxException;

public interface PaypleService {
	String httpRequest(String param, String url, String method, int work) throws IOException;
	String marchantCert(int reciptCheck) throws IOException;
	List<AccountAndroidVO> regAccountSelect(String email, List<String> payerId) throws IOException;
	String regAccountDelete(HttpServletRequest request) throws IOException;
	PaypleCancelVO cancel(String oid) throws JsonSyntaxException, IOException;
}
