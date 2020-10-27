package com.baobab.m.vo;

import java.util.List;

public class AdminPayDetailVO {
	PaymentVO payment;
	List<PayMenusVO> paymenus;
	List<UserTicketHistoryVO> ticket;
	
	public AdminPayDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminPayDetailVO(PaymentVO payment, List<PayMenusVO> paymenus, List<UserTicketHistoryVO> ticket) {
		super();
		this.payment = payment;
		this.paymenus = paymenus;
		this.ticket = ticket;
	}
	public PaymentVO getPayment() {
		return payment;
	}
	public void setPayment(PaymentVO payment) {
		this.payment = payment;
	}
	public List<PayMenusVO> getPaymenus() {
		return paymenus;
	}
	public void setPaymenus(List<PayMenusVO> paymenus) {
		this.paymenus = paymenus;
	}
	public List<UserTicketHistoryVO> getTicket() {
		return ticket;
	}
	public void setTicket(List<UserTicketHistoryVO> ticket) {
		this.ticket = ticket;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((paymenus == null) ? 0 : paymenus.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		AdminPayDetailVO other = (AdminPayDetailVO) obj;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (paymenus == null) {
			if (other.paymenus != null)
				return false;
		} else if (!paymenus.equals(other.paymenus))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminPayDetailVO [payment=" + payment + ", paymenus=" + paymenus + ", ticket=" + ticket + "]";
	}
}
