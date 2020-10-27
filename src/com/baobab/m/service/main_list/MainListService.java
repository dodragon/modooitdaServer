package com.baobab.m.service.main_list;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.MainListTotalVO;

public interface MainListService {
	public List<MainListTotalVO> getMainList(HttpServletRequest request);
}
