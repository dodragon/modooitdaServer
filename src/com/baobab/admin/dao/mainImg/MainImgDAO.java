package com.baobab.admin.dao.mainImg;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;

public interface MainImgDAO {
	List<CPmainImgVO> getImgs(int cpSeq);
	int insertImg(CPmainImgVO vo);
	int deleteImg(int cpSeq, String url) throws Exception;
	int logoUpdate(CPInfoVO vo);
}
