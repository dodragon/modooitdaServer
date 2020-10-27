package com.baobab.m.vo;

import java.util.List;

public class StatisticsVO {
	private int aHit;
	private int bHit;
	private int aPoke;
	private int bPoke;
	private int aPay;
	private int bPay;
	private int aScan;
	private int bScan;
	private int aCancel;
	private int bCancel;
	private int aPush;
	private int bPush;
	private int aPushClick;
	private int bPushClick;
	private int allSales;
	private int useSales;
	private int cancelSales;
	
	private List<StatChartDataVO> lineChartHits;
	private List<StatChartDataVO> lineChartPoke;
	private List<StatChartDataVO> lineChartPaySuccess;
	private List<StatChartDataVO> lineChartScan;
	private List<StatChartDataVO> lineChartPayCancel;
	private List<StatChartDataVO> lineChartPush;
	private List<StatChartDataVO> lineChartPushClick;
	public StatisticsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsVO(int aHit, int bHit, int aPoke, int bPoke, int aPay, int bPay, int aScan, int bScan, int aCancel,
			int bCancel, int aPush, int bPush, int aPushClick, int bPushClick, int allSales, int useSales,
			int cancelSales, List<StatChartDataVO> lineChartHits, List<StatChartDataVO> lineChartPoke,
			List<StatChartDataVO> lineChartPaySuccess, List<StatChartDataVO> lineChartScan,
			List<StatChartDataVO> lineChartPayCancel, List<StatChartDataVO> lineChartPush,
			List<StatChartDataVO> lineChartPushClick) {
		super();
		this.aHit = aHit;
		this.bHit = bHit;
		this.aPoke = aPoke;
		this.bPoke = bPoke;
		this.aPay = aPay;
		this.bPay = bPay;
		this.aScan = aScan;
		this.bScan = bScan;
		this.aCancel = aCancel;
		this.bCancel = bCancel;
		this.aPush = aPush;
		this.bPush = bPush;
		this.aPushClick = aPushClick;
		this.bPushClick = bPushClick;
		this.allSales = allSales;
		this.useSales = useSales;
		this.cancelSales = cancelSales;
		this.lineChartHits = lineChartHits;
		this.lineChartPoke = lineChartPoke;
		this.lineChartPaySuccess = lineChartPaySuccess;
		this.lineChartScan = lineChartScan;
		this.lineChartPayCancel = lineChartPayCancel;
		this.lineChartPush = lineChartPush;
		this.lineChartPushClick = lineChartPushClick;
	}
	public int getaHit() {
		return aHit;
	}
	public void setaHit(int aHit) {
		this.aHit = aHit;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getaPoke() {
		return aPoke;
	}
	public void setaPoke(int aPoke) {
		this.aPoke = aPoke;
	}
	public int getbPoke() {
		return bPoke;
	}
	public void setbPoke(int bPoke) {
		this.bPoke = bPoke;
	}
	public int getaPay() {
		return aPay;
	}
	public void setaPay(int aPay) {
		this.aPay = aPay;
	}
	public int getbPay() {
		return bPay;
	}
	public void setbPay(int bPay) {
		this.bPay = bPay;
	}
	public int getaScan() {
		return aScan;
	}
	public void setaScan(int aScan) {
		this.aScan = aScan;
	}
	public int getbScan() {
		return bScan;
	}
	public void setbScan(int bScan) {
		this.bScan = bScan;
	}
	public int getaCancel() {
		return aCancel;
	}
	public void setaCancel(int aCancel) {
		this.aCancel = aCancel;
	}
	public int getbCancel() {
		return bCancel;
	}
	public void setbCancel(int bCancel) {
		this.bCancel = bCancel;
	}
	public int getaPush() {
		return aPush;
	}
	public void setaPush(int aPush) {
		this.aPush = aPush;
	}
	public int getbPush() {
		return bPush;
	}
	public void setbPush(int bPush) {
		this.bPush = bPush;
	}
	public int getaPushClick() {
		return aPushClick;
	}
	public void setaPushClick(int aPushClick) {
		this.aPushClick = aPushClick;
	}
	public int getbPushClick() {
		return bPushClick;
	}
	public void setbPushClick(int bPushClick) {
		this.bPushClick = bPushClick;
	}
	public int getAllSales() {
		return allSales;
	}
	public void setAllSales(int allSales) {
		this.allSales = allSales;
	}
	public int getUseSales() {
		return useSales;
	}
	public void setUseSales(int useSales) {
		this.useSales = useSales;
	}
	public int getCancelSales() {
		return cancelSales;
	}
	public void setCancelSales(int cancelSales) {
		this.cancelSales = cancelSales;
	}
	public List<StatChartDataVO> getLineChartHits() {
		return lineChartHits;
	}
	public void setLineChartHits(List<StatChartDataVO> lineChartHits) {
		this.lineChartHits = lineChartHits;
	}
	public List<StatChartDataVO> getLineChartPoke() {
		return lineChartPoke;
	}
	public void setLineChartPoke(List<StatChartDataVO> lineChartPoke) {
		this.lineChartPoke = lineChartPoke;
	}
	public List<StatChartDataVO> getLineChartPaySuccess() {
		return lineChartPaySuccess;
	}
	public void setLineChartPaySuccess(List<StatChartDataVO> lineChartPaySuccess) {
		this.lineChartPaySuccess = lineChartPaySuccess;
	}
	public List<StatChartDataVO> getLineChartScan() {
		return lineChartScan;
	}
	public void setLineChartScan(List<StatChartDataVO> lineChartScan) {
		this.lineChartScan = lineChartScan;
	}
	public List<StatChartDataVO> getLineChartPayCancel() {
		return lineChartPayCancel;
	}
	public void setLineChartPayCancel(List<StatChartDataVO> lineChartPayCancel) {
		this.lineChartPayCancel = lineChartPayCancel;
	}
	public List<StatChartDataVO> getLineChartPush() {
		return lineChartPush;
	}
	public void setLineChartPush(List<StatChartDataVO> lineChartPush) {
		this.lineChartPush = lineChartPush;
	}
	public List<StatChartDataVO> getLineChartPushClick() {
		return lineChartPushClick;
	}
	public void setLineChartPushClick(List<StatChartDataVO> lineChartPushClick) {
		this.lineChartPushClick = lineChartPushClick;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aCancel;
		result = prime * result + aHit;
		result = prime * result + aPay;
		result = prime * result + aPoke;
		result = prime * result + aPush;
		result = prime * result + aPushClick;
		result = prime * result + aScan;
		result = prime * result + allSales;
		result = prime * result + bCancel;
		result = prime * result + bHit;
		result = prime * result + bPay;
		result = prime * result + bPoke;
		result = prime * result + bPush;
		result = prime * result + bPushClick;
		result = prime * result + bScan;
		result = prime * result + cancelSales;
		result = prime * result + ((lineChartHits == null) ? 0 : lineChartHits.hashCode());
		result = prime * result + ((lineChartPayCancel == null) ? 0 : lineChartPayCancel.hashCode());
		result = prime * result + ((lineChartPaySuccess == null) ? 0 : lineChartPaySuccess.hashCode());
		result = prime * result + ((lineChartPoke == null) ? 0 : lineChartPoke.hashCode());
		result = prime * result + ((lineChartPush == null) ? 0 : lineChartPush.hashCode());
		result = prime * result + ((lineChartPushClick == null) ? 0 : lineChartPushClick.hashCode());
		result = prime * result + ((lineChartScan == null) ? 0 : lineChartScan.hashCode());
		result = prime * result + useSales;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatisticsVO other = (StatisticsVO) obj;
		if (aCancel != other.aCancel)
			return false;
		if (aHit != other.aHit)
			return false;
		if (aPay != other.aPay)
			return false;
		if (aPoke != other.aPoke)
			return false;
		if (aPush != other.aPush)
			return false;
		if (aPushClick != other.aPushClick)
			return false;
		if (aScan != other.aScan)
			return false;
		if (allSales != other.allSales)
			return false;
		if (bCancel != other.bCancel)
			return false;
		if (bHit != other.bHit)
			return false;
		if (bPay != other.bPay)
			return false;
		if (bPoke != other.bPoke)
			return false;
		if (bPush != other.bPush)
			return false;
		if (bPushClick != other.bPushClick)
			return false;
		if (bScan != other.bScan)
			return false;
		if (cancelSales != other.cancelSales)
			return false;
		if (lineChartHits == null) {
			if (other.lineChartHits != null)
				return false;
		} else if (!lineChartHits.equals(other.lineChartHits))
			return false;
		if (lineChartPayCancel == null) {
			if (other.lineChartPayCancel != null)
				return false;
		} else if (!lineChartPayCancel.equals(other.lineChartPayCancel))
			return false;
		if (lineChartPaySuccess == null) {
			if (other.lineChartPaySuccess != null)
				return false;
		} else if (!lineChartPaySuccess.equals(other.lineChartPaySuccess))
			return false;
		if (lineChartPoke == null) {
			if (other.lineChartPoke != null)
				return false;
		} else if (!lineChartPoke.equals(other.lineChartPoke))
			return false;
		if (lineChartPush == null) {
			if (other.lineChartPush != null)
				return false;
		} else if (!lineChartPush.equals(other.lineChartPush))
			return false;
		if (lineChartPushClick == null) {
			if (other.lineChartPushClick != null)
				return false;
		} else if (!lineChartPushClick.equals(other.lineChartPushClick))
			return false;
		if (lineChartScan == null) {
			if (other.lineChartScan != null)
				return false;
		} else if (!lineChartScan.equals(other.lineChartScan))
			return false;
		if (useSales != other.useSales)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatisticsVO [aHit=" + aHit + ", bHit=" + bHit + ", aPoke=" + aPoke + ", bPoke=" + bPoke + ", aPay="
				+ aPay + ", bPay=" + bPay + ", aScan=" + aScan + ", bScan=" + bScan + ", aCancel=" + aCancel
				+ ", bCancel=" + bCancel + ", aPush=" + aPush + ", bPush=" + bPush + ", aPushClick=" + aPushClick
				+ ", bPushClick=" + bPushClick + ", allSales=" + allSales + ", useSales=" + useSales + ", cancelSales="
				+ cancelSales + ", lineChartHits=" + lineChartHits + ", lineChartPoke=" + lineChartPoke
				+ ", lineChartPaySuccess=" + lineChartPaySuccess + ", lineChartScan=" + lineChartScan
				+ ", lineChartPayCancel=" + lineChartPayCancel + ", lineChartPush=" + lineChartPush
				+ ", lineChartPushClick=" + lineChartPushClick + "]";
	}
}
