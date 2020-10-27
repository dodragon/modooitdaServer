package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.AdImagesVO;

@Mapper
public interface AdImagesMapper {
	List<AdImagesVO> selAdImages();
}
