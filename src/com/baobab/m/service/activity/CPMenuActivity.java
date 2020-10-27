package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPMenuActivityVO;

public interface CPMenuActivity {

	CPMenuActivityVO cpMenu(HttpServletRequest request);
}
