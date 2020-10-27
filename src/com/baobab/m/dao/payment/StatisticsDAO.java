package com.baobab.m.dao.payment;

import java.util.List;

import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.HitsVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.SalesHistoryVO;
import com.baobab.m.vo.StatChartDataVO;
import com.baobab.m.vo.UserTicketHistoryVO;

public interface StatisticsDAO {
	int hitSelect(HitsVO vo);
	int pokeSelect(PokeVO vo);
	int paySuccessSelect(PaymentVO vo);
	int scanSelect(UserTicketHistoryVO vo);
	int payCancelSelect(PaymentVO vo);
	int pushSelect(CpPushVO vo);
	int pushClickSelect(HitsVO vo);
	int allSalesSelect(PaymentVO vo);
	int useSalesSelect(PaymentVO vo);
	int cancelSalesSelect(PaymentVO vo);
	
	List<StatChartDataVO> lineChartHits(StatChartDataVO vo);
	List<StatChartDataVO> lineChartPoke(StatChartDataVO vo);
	List<StatChartDataVO> lineChartPaySuccess(StatChartDataVO vo);
	List<StatChartDataVO> lineChartScan(StatChartDataVO vo);
	List<StatChartDataVO> lineChartPayCancel(StatChartDataVO vo);
	List<StatChartDataVO> lineChartPush(StatChartDataVO vo);
	List<StatChartDataVO> lineChartPushClick(StatChartDataVO vo);
	
	List<SalesHistoryVO> optionInfoSelect(SalesHistoryVO vo);
	List<SalesHistoryVO> menuInfoSelect(SalesHistoryVO vo);
}
