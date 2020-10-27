package com.baobab.m.service.ticket;

import javax.servlet.http.HttpServletRequest;

public interface UserTicketService {
	public int ticketUsed(HttpServletRequest request);
	public int ticketDelete(HttpServletRequest request);
}
