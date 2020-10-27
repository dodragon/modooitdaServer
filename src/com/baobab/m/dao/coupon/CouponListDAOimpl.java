package com.baobab.m.dao.coupon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponListVO;
import com.baobab.m.vo.CouponSampleVO;
import com.baobab.m.vo.CouponTypeVO;
@Repository
public class CouponListDAOimpl implements CouponListDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;
	
	@Override
	public void couponInfoInsert(HttpServletRequest request) {
		CouponListVO vo = new CouponListVO();
		vo.setCouponName(request.getParameter("couponName"));
		vo.setCouponPrice(Integer.parseInt(request.getParameter("couponPrice")));
		vo.setCouponDiscountPrice(Integer.parseInt(request.getParameter("couponDiscountPrice")));
		vo.setEa(Integer.parseInt(request.getParameter("ea")));
		
		coupon.insert("com.baobab.m.dao.CouponListMapper.couponInfoInsert", vo);
	}

	@Override
	public List<CouponListVO> couponListSelect() {
		CouponListVO vo = new CouponListVO();
		return coupon.selectList("com.baobab.m.dao.CouponListMapper.couponListSelect",vo);
	}

	@Override
	public List<CouponSampleVO> couponEX() {
		
		return coupon.selectList("com.baobab.m.dao.CouponListMapper.couponEX");
	}

	@Override
	public List<CouponTypeVO> couponSpecial() {
		return coupon.selectList("com.baobab.m.dao.CouponListMapper.couponSpecial");
	}

}
