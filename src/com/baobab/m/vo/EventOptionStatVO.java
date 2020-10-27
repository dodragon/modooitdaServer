package com.baobab.m.vo;

import java.util.List;

public class EventOptionStatVO {
	String optionName;
	int optionSaleEa;
	int optionSales;
	List<MenuSpecListVO> menuSpecs;
	
	public EventOptionStatVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventOptionStatVO(String optionName, int optionSaleEa, int optionSales, List<MenuSpecListVO> menuSpecs) {
		super();
		this.optionName = optionName;
		this.optionSaleEa = optionSaleEa;
		this.optionSales = optionSales;
		this.menuSpecs = menuSpecs;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getOptionSaleEa() {
		return optionSaleEa;
	}
	public void setOptionSaleEa(int optionSaleEa) {
		this.optionSaleEa = optionSaleEa;
	}
	public int getOptionSales() {
		return optionSales;
	}
	public void setOptionSales(int optionSales) {
		this.optionSales = optionSales;
	}
	public List<MenuSpecListVO> getMenuSpecs() {
		return menuSpecs;
	}
	public void setMenuSpecs(List<MenuSpecListVO> menuSpecs) {
		this.menuSpecs = menuSpecs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuSpecs == null) ? 0 : menuSpecs.hashCode());
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
		result = prime * result + optionSaleEa;
		result = prime * result + optionSales;
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
		EventOptionStatVO other = (EventOptionStatVO) obj;
		if (menuSpecs == null) {
			if (other.menuSpecs != null)
				return false;
		} else if (!menuSpecs.equals(other.menuSpecs))
			return false;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		if (optionSaleEa != other.optionSaleEa)
			return false;
		if (optionSales != other.optionSales)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EventOptionStatVO [optionName=" + optionName + ", optionSaleEa=" + optionSaleEa + ", optionSales="
				+ optionSales + ", menuSpecs=" + menuSpecs + "]";
	}
}
