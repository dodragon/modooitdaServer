package com.baobab.m.dao.adminfunction;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
public interface QRCodeDAO {
	List<CPInfoVO> searchQRCode(String searchWord);
}
