package com.baobab.m.service.iamport;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonSyntaxException;

public interface ImportServiceInterface {
	String accountCert(HttpServletRequest request) throws JsonSyntaxException, IOException;
	String getAccessToken() throws IOException;
	String getAccountHolder(String token, String bank, String accountNum);
}