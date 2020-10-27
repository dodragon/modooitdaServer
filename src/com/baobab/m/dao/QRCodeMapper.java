package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;

@Mapper
public interface QRCodeMapper {
	List<CPInfoVO>searchQRCode(String searchWord);
	void updateCpPw(CPUseVO vo);
}
