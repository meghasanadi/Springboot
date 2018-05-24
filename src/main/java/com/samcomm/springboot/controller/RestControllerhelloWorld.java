package com.samcomm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samcomm.springboot.entities.Ticket;
import com.samcomm.springboot.service.TicketService;

@RestController
@RequestMapping(value="/api/tickets")
public class RestControllerhelloWorld {
	
	@RequestMapping(value="/")
	public String hello() {
		return "Hello world";
	}
	@GetMapping(value="/hi")
	public String helloWorld() {
		return "Hello world hi";
	}
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
		
	}
	
	/*@PostMapping(value="/create/again")
	public Ticket createTicketanother(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
		
	}*/
	
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId) {
		
		return ticketService.getTicketId(ticketId);
		
	}
	
	@GetMapping(value="/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTickets(){
		return ticketService.getAllBookedTickets();
		
	}
	
	@DeleteMapping(value="delticket//{ticketId}")
	public void deletTicket(@PathVariable("ticketId")Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
	
	@RequestMapping(value="ticket/{ticketId}/{newEmail:.+}", method = RequestMethod.POST)
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail")String newEmail) {
		return ticketService.updateTicket(ticketId,newEmail);	
	}

}
