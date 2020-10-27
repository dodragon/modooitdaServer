package com.baobab.m.dao.advertisement;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AdImagesVO;
@Repository
public class AdImagesDAOimpl implements AdImagesDAO {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ad;
	@Override
	public List<AdImagesVO> selAdImages() {
		return ad.selectList("com.baobab.m.dao.AdImagesMapper.selAdImages");
	}

}
