package com.baobab.m.service.join;

import javax.servlet.http.HttpServletRequest;

public interface JoinService {
	public int cpJoining(HttpServletRequest request);
	public int duplicateCheck(HttpServletRequest request);
}
