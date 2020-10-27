package com.baobab.m.service.fcm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.dao.ticket.UserTicketDAO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserLocationVO;
import com.google.gson.Gson;

@Service
public class FCMDiv {
	
	@Autowired
	SendFCM fcm;
	@Autowired
	PaymentDAO pay;
	@Autowired
	UserTicketDAO ut;
	
	public int send(HttpServletRequest request) throws Exception {
		String div = request.getParameter("div");
		List<UserLocationVO> list = new ArrayList<>();
		if(div.equals("����(�����)")) {
			Gson gson = new Gson();
			PaymentVO vo = gson.fromJson(request.getParameter("json"), PaymentVO.class);
			list.add(pay.cpLocationInfo(vo.getCpSeq()));
			System.out.println("���̸�Ʈ VO === " + vo.toString());
			System.out.println("����Ʈ === " + list.toString());
			return fcm.send(request, list);
		}else if(div.equals("����(�����)")) {
			Gson gson = new Gson();
			PaymentVO vo = gson.fromJson(request.getParameter("json"), PaymentVO.class);
			list.add(pay.userLocationInfo(vo.getEmail()));
			return fcm.send(request, list);
		}else if(div.equals("����(������)")) {
			list.addAll(pay.findAdmin());
			return fcm.send(request, list);
		}else if(div.equals("Ƽ��(�����)") | div.equals("Ƽ�Ͻ���")){
			String serial = request.getParameter("json").split(",")[0];
			String phone = request.getParameter("json").split(",")[1];
			if(phone.contains("\\+" + "82")) {
				phone = phone.replaceAll("\\+" + "82", "0");
			}
			UserLocationVO serialVO = ut.userPush(serial);
			list.add(serialVO);
			list.add(ut.cpPush(serial));
			if(phone != null && !isUser(serialVO, phone)) {
				list.add(ut.localUserPush(phone));
			}
			return fcm.send(request, list);
		}else if(div.equals("Ƽ��(�����)")){
			String email = request.getParameter("json").split(",")[1];
			
			UserLocationVO cpVo = ut.cpPushSelect(email);
			list.add(cpVo);
			return fcm.send(request, list);
		}else if(div.contains("�������")){
			if(div.contains("�����")) {
				list.add(pay.cpCancelLocationInfo(request.getParameter("json")));
				return fcm.send(request, list);
			}else {
				list.add(pay.userCancelLocationInfo(request.getParameter("json")));
				return fcm.send(request, list);
			}
		}else {
			return 0;
		}
	}
	
	public boolean isUser(UserLocationVO vo, String phone) {
		return vo.getUser().equals(phone);
	}
}
