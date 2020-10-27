package com.baobab.admin.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.baobab.m.vo.AdminLoginHistoryVO;

@Repository
public class AdminMainDAOimpl implements AdminMainDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate main;

	@Override
	public int userAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.userAll").size();
	}

	@Override
	public int cpAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.cpAll").size();
	}

	@Override
	public int menuAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.menuAll").size();
	}

	@Override
	public int visitantAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.visitantAll").size();
	}

	@Override
	public int paymentAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.paymentAll").size();
	}

	@Override
	public int pushAll() {
		return main.selectList("com.baobab.admin.dao.AdminMainMapper.pushAll").size();
	}

	@Override
	public List<String> loginHistory(HttpSession session) {
		List<AdminLoginHistoryVO> adList = main.selectList("com.baobab.admin.dao.AdminMainMapper.loginHistory", session.getAttribute("id"));
		System.out.println(adList.toString());
		List<String> strList = new ArrayList<String>();
		if(adList.isEmpty()) {
			strList.add("�ֱ� ���� ����� �����ϴ�.");
			return strList;
		}else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd�� HH:mm:ss");
			for(int i=0;i<adList.size();i++) {
				strList.add(format.format(adList.get(i).getLogin_date()));
			}
			System.out.println(strList.toString());
			return strList;
		}
	}
	
	@Override
	public String makeMainPage(Model model, HttpSession session) {
		model.addAttribute("userCount", userAll());
		model.addAttribute("cpCount", cpAll());
		model.addAttribute("menuCount", menuAll());
		model.addAttribute("visitantCount", visitantAll());
		model.addAttribute("paymentCount", paymentAll());
		model.addAttribute("pushCount", pushAll());
		model.addAttribute("loginHistory", loginHistory(session));
		return "admin/main";
	}
}
