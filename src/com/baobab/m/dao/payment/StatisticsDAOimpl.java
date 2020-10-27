package com.baobab.m.dao.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.HitsVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.SalesHistoryVO;
import com.baobab.m.vo.StatChartDataVO;
import com.baobab.m.vo.UserTicketHistoryVO;

@Repository
public class StatisticsDAOimpl implements StatisticsDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate stat;

	@Override
	public int hitSelect(HitsVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.hitSelect", vo);
	}

	@Override
	public int pokeSelect(PokeVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.pokeSelect", vo);
	}

	@Override
	public int paySuccessSelect(PaymentVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.paySuccessSelect", vo);
	}

	@Override
	public int scanSelect(UserTicketHistoryVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.scanSelect", vo);
	}

	@Override
	public int payCancelSelect(PaymentVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.payCancelSelect", vo);
	}

	@Override
	public int pushSelect(CpPushVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.pushSelect", vo);
	}

	@Override
	public int pushClickSelect(HitsVO vo) {
		return stat.selectOne("com.baobab.m.dao.StatisticsMapper.pushClickSelect", vo);
	}

	@Override
	public int allSalesSelect(PaymentVO vo) {
		try {
			return stat.selectOne("com.baobab.m.dao.StatisticsMapper.allSalesSelect", vo);
		}catch(NullPointerException e) {
			return 0;
		}
	}

	@Override
	public int useSalesSelect(PaymentVO vo) {
		try {
			return stat.selectOne("com.baobab.m.dao.StatisticsMapper.useSalesSelect", vo);
		}catch(NullPointerException e) {
			return 0;
		}
	}

	@Override
	public int cancelSalesSelect(PaymentVO vo) {
		try {
			return stat.selectOne("com.baobab.m.dao.StatisticsMapper.cancelSalesSelect", vo);
		}catch(NullPointerException e) {
			return 0;
		}
	}

	@Override
	public List<StatChartDataVO> lineChartHits(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartHits", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartPoke(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartPoke", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartPaySuccess(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartPaySuccess", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartScan(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartScan", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartPayCancel(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartPayCancel", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartPush(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartPush", vo);
	}

	@Override
	public List<StatChartDataVO> lineChartPushClick(StatChartDataVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.lineChartPushClick", vo);
	}

	@Override
	public List<SalesHistoryVO> optionInfoSelect(SalesHistoryVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.optionInfoSelect", vo);
	}

	@Override
	public List<SalesHistoryVO> menuInfoSelect(SalesHistoryVO vo) {
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.menuInfoSelect", vo);
	}
}
