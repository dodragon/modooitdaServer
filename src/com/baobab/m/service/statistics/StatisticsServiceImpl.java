package com.baobab.m.service.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.payment.StatisticsDAO;
import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.EventOptionStatVO;
import com.baobab.m.vo.HitsVO;
import com.baobab.m.vo.MenuSpecListVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.SalesHistoryVO;
import com.baobab.m.vo.StatChartDataVO;
import com.baobab.m.vo.StatisticsVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	
	@Autowired
	StatisticsDAO dao;

	@Override
	public StatisticsVO makeVO(int cpSeq, String curDate, String statDiv) throws ParseException {
		StatisticsVO mainVO = new StatisticsVO();
		String before = yesterday(curDate, statDiv);
		
		HitsVO hitsVo = new HitsVO();
		hitsVo.setCpSeq(cpSeq);
		PokeVO pokeVo = new PokeVO();
		pokeVo.setCp_seq(cpSeq);
		PaymentVO paymentVo = new PaymentVO();
		paymentVo.setCpSeq(cpSeq);
		UserTicketHistoryVO userTicketHistoryVo = new UserTicketHistoryVO();
		userTicketHistoryVo.setCpSeq(cpSeq);
		CpPushVO cpPushVo = new CpPushVO();
		cpPushVo.setCpSeq(cpSeq);
		
		hitsVo.setHitDiv(curDate + "%");
		mainVO.setaHit(dao.hitSelect(hitsVo));
		mainVO.setaPushClick(dao.pushClickSelect(hitsVo));
		hitsVo.setHitDiv(before + "%");
		mainVO.setbHit(dao.hitSelect(hitsVo));
		mainVO.setbPushClick(dao.pushClickSelect(hitsVo));
		
		pokeVo.setDiv_code(curDate + "%");
		mainVO.setaPoke(dao.pokeSelect(pokeVo));
		pokeVo.setDiv_code(before + "%");
		mainVO.setbPoke(dao.pokeSelect(pokeVo));
		
		paymentVo.setUsed(curDate + "%");
		mainVO.setaPay(dao.paySuccessSelect(paymentVo));
		mainVO.setaCancel(dao.payCancelSelect(paymentVo));
		mainVO.setAllSales(dao.allSalesSelect(paymentVo));
		mainVO.setUseSales(dao.useSalesSelect(paymentVo));
		mainVO.setCancelSales(dao.cancelSalesSelect(paymentVo));
		paymentVo.setUsed(before + "%");
		mainVO.setbPay(dao.paySuccessSelect(paymentVo));
		mainVO.setbCancel(dao.payCancelSelect(paymentVo));
		
		userTicketHistoryVo.setTicketStatus(curDate + "%");
		mainVO.setaScan(dao.scanSelect(userTicketHistoryVo));
		userTicketHistoryVo.setTicketStatus(before + "%");
		mainVO.setbScan(dao.scanSelect(userTicketHistoryVo));
		
		cpPushVo.setTitle(curDate + "%");
		mainVO.setaPush(dao.pushSelect(cpPushVo));
		cpPushVo.setTitle(before + "%");
		mainVO.setbPush(dao.pushSelect(cpPushVo));
		
		if(statDiv.equals("월")) {
			StatChartDataVO chartData = new StatChartDataVO();
			chartData.setCpSeq(cpSeq);
			chartData.setDate(curDate + "%");
			
			mainVO.setLineChartHits(dao.lineChartHits(chartData));
			mainVO.setLineChartPayCancel(dao.lineChartPayCancel(chartData));
			mainVO.setLineChartPaySuccess(dao.lineChartPaySuccess(chartData));
			mainVO.setLineChartPoke(dao.lineChartPoke(chartData));
			mainVO.setLineChartPush(dao.lineChartPush(chartData));
			mainVO.setLineChartPushClick(dao.lineChartPushClick(chartData));
			mainVO.setLineChartScan(dao.lineChartScan(chartData));
		}
		
		return mainVO;
	}

	@Override
	public String yesterday(String curDate, String statDiv) throws ParseException {
		String formatStr = "";
		int dayOrMonth = 0;
		if(statDiv.equals("월")) {
			formatStr = "yyyy-MM";
			dayOrMonth = Calendar.MONTH;
		}else {
			formatStr = "yyyy-MM-dd";
			dayOrMonth = Calendar.DATE;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date curDay = format.parse(curDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDay);
		cal.add(dayOrMonth, -1);
		return format.format(cal.getTime());
	}

	@Override
	public List<EventOptionStatVO> eventDetailStat(HttpServletRequest request) {
		List<EventOptionStatVO> list = new ArrayList<>();
		SalesHistoryVO searchVo = new SalesHistoryVO();
		searchVo.setEventSerial(request.getParameter("eventSerial"));
		searchVo.setEventName(request.getParameter("start"));
		searchVo.setOrderNum(request.getParameter("end"));
		
		List<SalesHistoryVO> optionList = dao.optionInfoSelect(searchVo);
		
		for(int i=0;i<optionList.size();i++) {
			EventOptionStatVO vo = new EventOptionStatVO();
			vo.setOptionName(optionList.get(i).getOptionName());
			vo.setOptionSaleEa(optionList.get(i).getEa());
			vo.setOptionSales(optionList.get(i).getSalesPrice());
			
			List<MenuSpecListVO> menuSpecList = new ArrayList<>();
			searchVo.setOptionSerial(optionList.get(i).getOptionSerial());
			List<SalesHistoryVO> menuList = dao.menuInfoSelect(searchVo);
			for(int j=0;j<menuList.size();j++) {
				if(j == 0) {
					menuSpecList.add(firstSpecVoInsert(menuList.get(i)));
				}else {
					boolean sameName = false;
					int sameVo = 0;
					for(int k=0;k<menuSpecList.size();k++) {
						if(menuSpecList.get(k).getMenuName().equals(menuList.get(i).getMenuName())){
							sameName = true;
							sameVo = k;
							break;
						}else {
							sameName = false;
						}
					}
					if(sameName) {
						menuSpecList = secondSpecVoInsert(menuSpecList, menuList.get(i), sameVo);
					}else {
						menuSpecList.add(firstSpecVoInsert(menuList.get(i)));
					}
				}
			}
			vo.setMenuSpecs(menuSpecList);
			list.add(vo);
		}
		return list;
	}
	
	private MenuSpecListVO firstSpecVoInsert(SalesHistoryVO shVo) {
		MenuSpecListVO vo = new MenuSpecListVO();
		vo.setMenuName(shVo.getMenuName());
		vo.setAllPaid(shVo.getSalesPrice());
		if(shVo.getSalesStatus().equals("판매")) {
			vo.setPaidEa(vo.getPaidEa() + 1);
		}else if(shVo.getSalesStatus().equals("취소")) {
			vo.setCancelEa(vo.getCancelEa() + 1);
		}else {
			vo.setScanEa(vo.getScanEa() + 1);
		}
		return vo;
	}
	
	private List<MenuSpecListVO> secondSpecVoInsert(List<MenuSpecListVO> list, SalesHistoryVO shVo, int k) {
		list.get(k).setAllPaid(list.get(k).getAllPaid() + shVo.getSalesPrice());
		if(shVo.getSalesStatus().equals("판매")) {
			list.get(k).setPaidEa(list.get(k).getPaidEa() + 1);
		}else if(shVo.getSalesStatus().equals("취소")) {
			list.get(k).setCancelEa(list.get(k).getCancelEa() + 1);
		}else {
			list.get(k).setScanEa(list.get(k).getScanEa() + 1);
		}
		return list;
	}
}
