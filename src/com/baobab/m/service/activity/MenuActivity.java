package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.MenuActivityVO;

public interface MenuActivity {

	MenuActivityVO MenuAct(HttpServletRequest request);
}
