package com.baobab.m.service.activity;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.AnterMainVO;

public interface AnterMain {
	AnterMainVO anterMain(HttpServletRequest request) throws ParseException;

}
