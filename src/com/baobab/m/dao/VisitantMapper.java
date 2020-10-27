package com.baobab.m.dao;

import com.baobab.m.vo.VisitUserVO;

@Mapper
public interface VisitantMapper {
	void visit(VisitUserVO vo);
}
