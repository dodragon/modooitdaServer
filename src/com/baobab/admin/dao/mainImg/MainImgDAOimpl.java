package com.baobab.admin.dao.mainImg;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.rsa.RandomNumber;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;

@Repository
public class MainImgDAOimpl implements MainImgDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate mi;

	@Override
	public List<CPmainImgVO> getImgs(int cpSeq) {
		List<CPmainImgVO> list = mi.selectList("com.baobab.admin.dao.AdminMainImgMapper.getImgs", cpSeq);
		for(int i=0;i<list.size();i++) {
			RandomNumber rn = new RandomNumber(6, 1);
			String rnStr = rn.numberGen();
			list.get(i).setImg_url(list.get(i).getImg_url() + "?rn=" + rnStr);
		}
		return list;
	}

	@Override
	public int insertImg(CPmainImgVO vo) {
		return mi.insert("com.baobab.admin.dao.AdminMainImgMapper.insertImg", vo);
	}

	@Override
	public int deleteImg(int cpSeq, String url) throws Exception {
		CPmainImgVO vo = new CPmainImgVO();
		vo.setCp_seq(cpSeq);
		vo.setImg_url(url);
		
		FtpClient ftp = new FtpClient();
		ftp.deleteFile("/baobabMainImg/", url.split("/")[url.split("/").length - 1]);
		
		return mi.delete("com.baobab.admin.dao.AdminMainImgMapper.deleteImg", vo);
	}

	@Override
	public int logoUpdate(CPInfoVO vo) {
		return mi.delete("com.baobab.admin.dao.AdminCPDetailMapper.logoUpdate", vo);
	}

}
