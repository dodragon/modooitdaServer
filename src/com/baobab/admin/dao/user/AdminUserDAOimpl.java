package com.baobab.admin.dao.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewsVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Repository
public class AdminUserDAOimpl implements AdminUserDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate us;

	@Override
	public List<UserAllVO> selectUser() {
		List<UserAllVO> list = us.selectList("com.baobab.admin.dao.AdminUserMapper.selectUser");
		for(int i=0;i<list.size();i++) {
			list.get(i).setDiv_code(divCodeFillter(list.get(i).getDiv_code()));
		}
		return list;
	}

	@Override
	public UserAllVO defaultInfo(String email) {
		UserAllVO vo = us.selectOne("com.baobab.admin.dao.AdminUserMapper.defaultInfo", email);
		vo.setDiv_code(divCodeFillter(vo.getDiv_code()));
		StringBuffer phoneSb = new StringBuffer(vo.getPhon_num());
		phoneSb.insert(3, "-");
		phoneSb.insert(phoneSb.length() - 4, "-");
		vo.setPhon_num(phoneSb.toString());
		StringBuffer birthSb = new StringBuffer(vo.getBirth());
		birthSb.insert(4, "�� ");
		birthSb.insert(8, "�� ");
		vo.setBirth(birthSb.toString() + "��");
		return vo;
	}


	@Override
	public String loctaionInfo(String email) {
		return us.selectOne("com.baobab.admin.dao.AdminUserMapper.loctaionInfo", email);
	}


	@Override
	public List<PaymentVO> payInfo(String email) {
		return us.selectList("com.baobab.admin.dao.AdminUserMapper.payInfo", email);
	}


	@Override
	public List<PayMenusVO> paymenuInfo(String orderNum) {
		return us.selectList("com.baobab.admin.dao.AdminUserMapper.paymenuInfo", orderNum);
	}


	@Override
	public List<UserTicketHistoryVO> ticketInfo(String email) {
		return us.selectList("com.baobab.admin.dao.AdminUserMapper.ticketInfo", email);
	}


	@Override
	public List<ReviewsVO> revInfo(String email) {
		return us.selectList("com.baobab.admin.dao.AdminUserMapper.revInfo", email);
	}


	@Override
	public List<PokeVO> pokeInfo(String email) {
		return us.selectList("com.baobab.admin.dao.AdminUserMapper.pokeInfo", email);
	}
	
	private String divCodeFillter(String divCode) {
		if(divCode.startsWith("a")) {
			return "�ٿ��� ������";
		}else if(divCode.equals("u-01-01")) {
			return "�Ϲ�ȸ��";
		}else if(divCode.equals("u-01-02")) {
			return "Ż��ȸ��";
		}else if(divCode.equals("c-01-01")) {
			return "�����";
		}else if(divCode.equals("c-02-02")) {
			return "��ü �Ŵ���";
		}else if(divCode.equals("c-02-03")) {
			return "��ü ����";
		}else {
			return "��Ÿ";
		}
	}

	@Override
	public int insertAdmin(HttpServletRequest request) {
		AdminAccountVO vo = new AdminAccountVO();
		
		vo.setId(request.getParameter("email"));
		vo.setPassword(request.getParameter("pw"));
		vo.setName(request.getParameter("userName"));
		vo.setJob_class(request.getParameter("jobClass"));
		vo.setDepartment(request.getParameter("department"));
		
		return us.insert("com.baobab.admin.dao.AdminUserMapper.insertAdmin", vo);
	}
}
