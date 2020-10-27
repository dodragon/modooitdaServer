package com.baobab.m.service.activity;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PageVO;

public interface PageActivity {

	PageVO Page(HttpServletRequest request);
}
