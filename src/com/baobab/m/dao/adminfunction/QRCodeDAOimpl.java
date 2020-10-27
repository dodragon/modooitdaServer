package com.baobab.m.dao.adminfunction;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
@Repository
public class QRCodeDAOimpl implements QRCodeDAO {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate qr;
	@Override
	public List<CPInfoVO> searchQRCode(String searchWord) {
		
		return qr.selectList("com.baobab.m.dao.QRCodeMapper.searchQRCode", "%" + searchWord + "%");
	}

}
