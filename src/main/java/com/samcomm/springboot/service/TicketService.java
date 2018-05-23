package com.samcomm.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samcomm.springboot.dao.TicketDao;
import com.samcomm.springboot.entities.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketdao;

	public Ticket createTicket(Ticket ticket) {
		return ticketdao.save(ticket);
	}

	public Ticket getTicketId(Integer ticketId) {
		return ticketdao.findOne(ticketId);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketdao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketdao.delete(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
	    Ticket ticketFromDb=ticketdao.findOne(ticketId);
	    ticketFromDb.setEmail(newEmail);
		return ticketdao.save(ticketFromDb);
	}

}
