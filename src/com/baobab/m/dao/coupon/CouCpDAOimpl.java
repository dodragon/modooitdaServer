package com.baobab.m.dao.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponCpVO;

@Repository
public class CouCpDAOimpl implements CouCpDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;

	@Override
	public List<CouponCpVO> getCpCouList(int cp_seq) {
		CouponCpVO vo = new CouponCpVO();
		vo.setCp_seq(cp_seq);
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.getCpCouList", vo);
	}

	@Override
	public int couCpInfoInsert(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setSerial_num(request.getParameter("serial_num"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		vo.setCp_name(request.getParameter("cp_name"));
		vo.setCou_title(request.getParameter("cou_title"));
		vo.setCou_intro(request.getParameter("cou_intro"));
		vo.setCou_kind(request.getParameter("cou_kind"));
		vo.setBuy_ea(Integer.parseInt(request.getParameter("buy_ea")));
		vo.setDl_user_ea(Integer.parseInt(request.getParameter("dl_user_ea")));
		vo.setStatus("off");
		vo.setOrderNum(request.getParameter("orderNum"));
		vo.setCouType(request.getParameter("couType"));
		int couponEa = allCouponSelect(Integer.parseInt(request.getParameter("cp_seq"))).size();
		if(couponEa > 0) {
			vo.setMainCoupon("N");
			return coupon.insert("com.baobab.m.dao.CouCpMapper.couCpInfoInsert", vo);
		}else {
			vo.setMainCoupon("Y");
			return coupon.insert("com.baobab.m.dao.CouCpMapper.couCpInfoInsert", vo);
		}
	}

	@Override
	public int couponCpUse(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setStatus(request.getParameter("status"));
		vo.setSerial_num(request.getParameter("serial_num"));
		return coupon.update("com.baobab.m.dao.CouCpMapper.couponCpUse", vo);
	}

	@Override
	public List<CouponCpVO> couponCpPeriod(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.couponCpPeriod", vo);
	}

	@Override
	public List<CouponCpVO> couPayDetail(String orderNum) {
		return coupon.selectOne("com.baobab.m.dao.CouCpMapper.couPayDetail", orderNum);
	}

	@Override
	public List<CouponCpVO> getCouponMenu(int cp_seq) {
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.getCouponMenu", cp_seq);
	}

	@Override
	public void cpCouponExpiry() {
		coupon.delete("com.baobab.m.dao.CouCpMapper.cpCouponExpiry");
		
		List<CouponCpVO> list = expirySelect();
		List<CouponCpVO> yList = new ArrayList<CouponCpVO>();
		List<CouponCpVO> nList = new ArrayList<CouponCpVO>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMainCoupon().equals("Y")) {
				yList.add(list.get(i));
			}
		}
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<yList.size();j++) {
				if(list.get(i).getCp_seq() != yList.get(i).getCp_seq()) {
					nList.add(list.get(i));
				}
			}
		}
		
		ArrayList<Integer> seqList = new ArrayList<Integer>();
		for(int i=0;i<nList.size();i++) {
			if(!seqList.contains(nList.get(i).getCp_seq())) {
				seqList.add(nList.get(i).getCp_seq());
			}
		}
		
		for(int i=0;i<seqList.size();i++) {
			randomMainSet(seqList.get(i));
		}
	}

	@Override
	public int couponUpdate(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setSerial_num(request.getParameter("serialNum"));
		vo.setCou_title(request.getParameter("title"));
		vo.setCou_intro(request.getParameter("option"));
		vo.setCouType(request.getParameter("couType"));
		vo.setMainCoupon(request.getParameter("mainCoupon"));
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		String mainStatus = request.getParameter("mainStatus");
		
		if(mainStatus.equals("nothing")) {
			return coupon.update("com.baobab.m.dao.CouCpMapper.couponUpdate", vo);
		}else if(mainStatus.equals("NtoY")){
			mainCouponSet("N", cpSeq);
			return coupon.update("com.baobab.m.dao.CouCpMapper.couponUpdate", vo);
		}else {
			int rtnResult = coupon.update("com.baobab.m.dao.CouCpMapper.couponUpdate", vo);
			randomMainSet(cpSeq);
			return rtnResult;
		}
	}

	@Override
	public int deleteCoupon(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setSerial_num(request.getParameter("serialNum"));
		int deleteResult = coupon.delete("com.baobab.m.dao.CouCpMapper.deleteCoupon", vo);
		randomMainSet(Integer.parseInt(request.getParameter("cpSeq")));
		return deleteResult;
	}

	@Override
	public List<CouponCpVO> allCouponSelect(int cpSeq) {
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.allCouponSelect", cpSeq);
	}

	@Override
	public void randomMainSet(int cpSeq) {
		coupon.update("com.baobab.m.dao.CouCpMapper.randomMainSet", cpSeq);
	}

	@Override
	public List<CouponCpVO> expirySelect() {
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.expirySelect");
	}

	@Override
	public void mainCouponSet(String mainCoupon, int cpSeq) {
		CouponCpVO vo = new CouponCpVO();
		vo.setMainCoupon(mainCoupon);
		vo.setCp_seq(cpSeq);
		coupon.update("com.baobab.m.dao.CouCpMapper.mainCouponSet",vo);
		
	}
}
