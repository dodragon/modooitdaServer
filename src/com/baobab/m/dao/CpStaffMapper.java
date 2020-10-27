package com.baobab.m.dao;
import java.util.List;

import com.baobab.m.vo.CouponCpVO;
import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CouponUserVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.SearchVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;
import com.baobab.m.vo.UserLocationVO;
@Mapper
public interface CpStaffMapper {
	List<UserAllVO> staffSearch(SearchVO vo);
	List<CpStaffVO> getStaffs(int cpSeq);
	void updateStaff(CpStaffVO vo);
	void staffInfoInsert(CpStaffVO vo);
	void staffHistoryJoin(UserHistoryVO vo);
	void userChangeToStaff(UserAllVO vo);
	List<CpStaffVO> scanCoupon(CpStaffVO vo);
	List<CouponHistoryVO> scanCouponHistory(CouponHistoryVO vo);
	void couHistoryStatusChange(String serial_num);
	void cpCouponScan(CouponCpVO vo);
	void userCouponScan(CouponUserVO vo);
	List<UserLocationVO> userLocationEmail(String user);
	void staffCancel(CpStaffVO vo);
	void staffCancelHistory(UserHistoryVO vo);
	List<CouponHistoryVO> usedCoupon(CouponHistoryVO vo);
	List<UserLocationVO> scanCouponPush(int cpSeq);
	int getMySeq(String email);
}
