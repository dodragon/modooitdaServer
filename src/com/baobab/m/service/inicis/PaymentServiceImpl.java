package com.baobab.m.service.inicis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.dao.servefunction.PushDAO;
import com.baobab.m.dao.ticket.UserTicketDAO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.PayMenusVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PaypleInfoVO;
import com.baobab.m.vo.SalesHistoryVO;
import com.baobab.m.vo.UserTicketHistoryVO;
import com.baobab.m.vo.UserTicketVO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDAO pay;
	@Autowired
	UserTicketDAO ticket;
	@Autowired
	EventCpDAO event;
	@Autowired
	PushDAO push;

	@Override
	public int paySuccess(PaymentVO vo, List<EventCpMenuVO> list, String orderNum, String email, int cpSeq) {
		vo.setPayStatus("결제완료");
		vo.setUsed("미사용");
		
		int result = pay.paymentInsert(vo);
		int orderNumDivResult = 0;
		int makePaymenuListResult = 0;
		int ratingSettingResult = 0;
		int salesHistoryResult = 0;
		if(result > 0) {
			orderNumDivResult = orderNumDiv(vo);
			if(orderNumDivResult > 0) {
				makePaymenuListResult = payMenusInsert(makePaymenuList(list, orderNum, email, cpSeq));
				if(makePaymenuListResult > 0) {
					ratingSettingResult = ratingSetting(list);
					if(ratingSettingResult > 0) {
						salesHistoryResult = insertSalesHistory(list, orderNum, cpSeq);
					}
				}
			}
		}
		
		if(vo.getPg().equals("payple")) {
			if(pay.isIdCount(email, vo.getTid()) == 0) {
				PaypleInfoVO ppvo = new PaypleInfoVO();
				ppvo.setEmail(email);
				ppvo.setPayerId(vo.getOrderNum());
				pay.insertPayerId(ppvo);
			}
		}
		return result + orderNumDivResult + makePaymenuListResult + ratingSettingResult + salesHistoryResult;
	}

	@Override
	public int payMenusInsert(List<PayMenusVO> list) {
		int result = 0;
		for(PayMenusVO vo : list) {
			pay.paymenuInsert(vo);
			result++;
		}
		return result;
	}

	@Override
	public List<PayMenusVO> makePaymenuList(List<EventCpMenuVO> list, String orderNum, String email, int cpSeq) {
		List<PayMenusVO> newList = new ArrayList<PayMenusVO>();
		for(int i=0;i<list.size();i++) {
			PayMenusVO vo = new PayMenusVO();
			vo.setCpSeq(cpSeq);
			vo.setMenuName(list.get(i).getMenuName());
			vo.setMenuSeq(list.get(i).getSeqNum());
			vo.setOptionSerial(list.get(i).getOptionSerial());
			vo.setOrderNum(orderNum);
			vo.setPayEmail(email);
			vo.setPrice(list.get(i).getPrice() * list.get(i).getSelectedEa());
			vo.setDisPrice(list.get(i).getDisPrice() * list.get(i).getSelectedEa());
			vo.setEa(list.get(i).getSelectedEa());
			newList.add(vo);
		}
		return newList;
	}
	
	protected int orderNumDiv(PaymentVO vo) {
		int result = 0;
		if(vo.getOrderNum().startsWith("P")) {
			result = makeTicket(vo);
		}
		return result;
	}
	
	public int makeTicket(PaymentVO vo) {
		UserTicketVO newVo = new UserTicketVO();
		UserTicketHistoryVO hisVo = new UserTicketHistoryVO();
		String serial = makeTicketSerial(vo);
		
		newVo.setTicketTitle(vo.getGoods());
		newVo.setOrderNum(vo.getOrderNum());
		newVo.setEmail(vo.getEmail());
		newVo.setCpSeq(vo.getCpSeq());
		newVo.setCpName(vo.getCpName());
		newVo.setAmount(vo.getTotalDisPrice());
		newVo.setTicketSerial(serial);
		
		hisVo.setTicketTitle(vo.getGoods());
		hisVo.setOrderNum(vo.getOrderNum());
		hisVo.setEmail(vo.getEmail());
		hisVo.setTicketSerial(serial);
		hisVo.setAmount(vo.getTotalDisPrice());
		hisVo.setCpSeq(vo.getCpSeq());
		hisVo.setTicketStatus("미사용");
		
		return ticket.ticketInsert(newVo) + ticket.ticketHistoryInsert(hisVo);
	}
	
	public int ratingSetting(List<EventCpMenuVO> list) {
		int result = 0;
		for(int i=0;i<list.size();i++) {
			result += event.menuRateUp(list.get(i).getSeqNum());
			result += event.optionRateUp(list.get(i).getOptionSerial());
			result += event.eventRateUp(list.get(i).getOptionSerial());
		}
		return result;
	}
	
	private String makeTicketSerial(PaymentVO vo) {
		Date date = new Date();
		SimpleDateFormat formatY = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatM = new SimpleDateFormat("MM");
		SimpleDateFormat formatD = new SimpleDateFormat("dd");
		SimpleDateFormat formatH = new SimpleDateFormat("HH");
		SimpleDateFormat formatm = new SimpleDateFormat("mm");
		SimpleDateFormat formatS = new SimpleDateFormat("ss");
		
		String result = numberGen(3, 1) + formatY.format(date) + vo.getCpSeq() + formatM.format(date) + vo.getUserPhone().substring(4, 8) + formatD.format(date) + 
				vo.getOrderNum().substring(3, 7) + formatH.format(date) + numberGen(2, 1) + formatm.format(date) + numberGen(2, 1) + formatS.format(date);
		
		return "P"+result;
	}
	
	public String numberGen(int len, int dupCd) {
        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수

        for(int i=0;i<len;i++) {

            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));

            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }

	@Override
	public int payCancel(String orderNum) {
		int paymentResult = pay.changeStatus(orderNum);
		int ticketResult = ticket.ticketCancel(orderNum);
		int ticketHistory = ticket.ticketCancelHistory(orderNum);
		SalesHistoryVO vo = new SalesHistoryVO();
		vo.setSalesStatus("취소");
		vo.setOrderNum(orderNum);
		int salesHistory = event.updateSales(vo); 
		return paymentResult + ticketResult + ticketHistory + salesHistory;
	}

	@Override
	public int insertSalesHistory(List<EventCpMenuVO> eventList, String orderNum, int cpSeq) {
		int result = 0;
		for(int i=0;i<eventList.size();i++) {
			SalesHistoryVO vo = new SalesHistoryVO();
			vo.setCpSeq(cpSeq);
			vo.setOrderNum(orderNum);
			vo.setEa(eventList.get(i).getSelectedEa());
			vo.setOptionSerial(eventList.get(i).getOptionSerial());
			vo.setMenuName(eventList.get(i).getMenuName());
			vo.setSalesPrice(eventList.get(i).getDisPrice() * eventList.get(i).getSelectedEa());
			vo.setSalesStatus("판매");
			result += event.salesHistoryInsert(vo);
		}
		return result;
	}

	@Override
	public int pushPaySuccess(PaymentVO vo) {
		int plusEa = Integer.parseInt(vo.getGoods().replaceAll("푸시이용권", "").replaceAll(",", "").replaceAll("개", ""));
        String email = vo.getEmail();
		push.pushEaPlma(email, plusEa);
		return pay.paymentInsert(vo);
	}
}
