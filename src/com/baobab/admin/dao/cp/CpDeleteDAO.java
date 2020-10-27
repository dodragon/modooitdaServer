package com.baobab.admin.dao.cp;

import java.util.List;

public interface CpDeleteDAO {
	int delStaff(int cpSeq);
	int delHits(int cpSeq);
	int delMainImg(int cpSeq);
	int delInfo(int cpSeq);
	int delCpUser(String email);
	int delMenu(int cpSeq);
	
	int upUserCode(String email);
	
	int delReview(int cpSeq);
	int delReviewImgs(String revCode);
	
	List<String> selRevCode(int cpSeq);
	
	int delEventMenu(String optionSerial);
	int delEventOption(String eventSerial);
	int delEvent(int cpSeq);
	
	List<String> selEventSerial(int cpSeq);
	List<String> selOptionSerial(String eventSerial);
	List<String> selMainImgUrl(int cpSeq);
	List<String> selMenuImg(int cpSeq);
	List<String> selRevImgUrl(String revCode);
}
