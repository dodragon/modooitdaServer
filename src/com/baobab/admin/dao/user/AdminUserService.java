package com.baobab.admin.dao.user;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.service.rsa.AESUtil;
import com.baobab.m.vo.AdminUserDetailVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;

@Service
public class AdminUserService {
	
	@Autowired
	AdminUserDAO dao;
	
	public AdminUserDetailVO userInfo(String email) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		AdminUserDetailVO vo = new AdminUserDetailVO();
		AESUtil aes = new AESUtil();
		
		vo.setDefaultInfo(dao.defaultInfo(email));
		vo.setUserLocation(aes.decrypt(dao.loctaionInfo(email)));
		List<PaymentVO> payList = dao.payInfo(email);
		
		List<List<PayMenusVO>> paymenuInfos = new ArrayList<>();
		for(int i=0;i<payList.size();i++) {
			paymenuInfos.add(dao.paymenuInfo(payList.get(i).getOrderNum()));
		}
		vo.setPaymenuInfo(paymenuInfos);
		
		vo.setPayList(settingGoods(payList, paymenuInfos));
		
		vo.setTicketList(dao.ticketInfo(email));
		vo.setRevList(dao.revInfo(email));
		vo.setPokeList(dao.pokeInfo(email));
		
		return vo;
	}
	
	private List<PaymentVO> settingGoods(List<PaymentVO> payList, List<List<PayMenusVO>> paymenus){
		for(int i=0;i<payList.size();i++) {
			String goods = "";
			for(int j=0;j<paymenus.get(i).size();j++) {
				goods += paymenus.get(i).get(j).getMenuName();
				if(j != (paymenus.get(i).size() - 1)) {
					goods += ", ";
				}
			}
			payList.get(i).setGoods(goods);
		}
		
		return payList;
	}
}
