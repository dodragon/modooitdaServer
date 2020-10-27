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
		if(div.equals("결제(사장님)")) {
			Gson gson = new Gson();
			PaymentVO vo = gson.fromJson(request.getParameter("json"), PaymentVO.class);
			list.add(pay.cpLocationInfo(vo.getCpSeq()));
			System.out.println("페이먼트 VO === " + vo.toString());
			System.out.println("리스트 === " + list.toString());
			return fcm.send(request, list);
		}else if(div.equals("결제(사용자)")) {
			Gson gson = new Gson();
			PaymentVO vo = gson.fromJson(request.getParameter("json"), PaymentVO.class);
			list.add(pay.userLocationInfo(vo.getEmail()));
			return fcm.send(request, list);
		}else if(div.equals("결제(관리자)")) {
			list.addAll(pay.findAdmin());
			return fcm.send(request, list);
		}else if(div.equals("티켓(사용자)") | div.equals("티켓실패")){
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
		}else if(div.equals("티켓(사장님)")){
			String email = request.getParameter("json").split(",")[1];
			
			UserLocationVO cpVo = ut.cpPushSelect(email);
			list.add(cpVo);
			return fcm.send(request, list);
		}else if(div.contains("결제취소")){
			if(div.contains("사장님")) {
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
