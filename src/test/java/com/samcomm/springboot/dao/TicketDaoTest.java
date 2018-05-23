package com.samcomm.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.samcomm.springboot.entities.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketDaoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TicketDao ticketdao;
	
	@Test
	public void testSaveTicket() {
		
		Ticket ticket=getTicket();
		Ticket savedDb=entityManager.persist(ticket);
		Ticket getFromdb=ticketdao.findOne(savedDb.getTicketId());
	    Ticket savedInDb=entityManager.persist(ticket);
	    System.out.println(getFromdb.equals(savedInDb));
	    assertThat(getFromdb).isEqualTo(savedDb);
		
	}

	private Ticket getTicket() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("mm");
		ticket.setSourceStation("mm");
		ticket.setDestStation("mm");
		ticket.setBookingDate(new Date());
		ticket.setEmail("mm");
		return ticket;
	}

	
	@Test
	public void testGetTicketById() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("maya");
		ticket.setSourceStation("new delhi");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(new Date());
		ticket.setEmail("kfmegh89@gmail.com");
		
		Ticket ticketSavedInDb=entityManager.persist(ticket);
	    Ticket ticketFromInDb=ticketdao.findOne(ticketSavedInDb.getTicketId());
	 
	    assertThat(ticketSavedInDb).isEqualTo(ticketFromInDb);	
	}
	
	@Test
	public void testUpdateTicket() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("dayaya");
		ticket.setSourceStation("new delhi");
		ticket.setDestStation("chennai");
		ticket.setBookingDate(new Date());
		ticket.setEmail("kaira@gmail.com");
		
		Ticket ticketSavedInDb=entityManager.persist(ticket);
		String email1=ticketSavedInDb.getEmail();
	    Ticket ticketFromInDb=ticketdao.findOne(ticketSavedInDb.getTicketId());
 
	    ticketFromInDb.setEmail("ohj@hmail.com");
	    entityManager.persist(ticketFromInDb);
		String email2=ticketFromInDb.getEmail();

	    assertThat(email1).isNotEqualTo(email2);
	    
	}
	
	@Test
	public void testDeleteTicket() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("aya");
		ticket.setSourceStation("new delhi");
		ticket.setDestStation("chennai");
		ticket.setBookingDate(new Date());
		ticket.setEmail("raaya@gmail.com");
		entityManager.persist(ticket);
		
		Ticket ticket1=new Ticket();
		ticket1.setPassengerName("nvayat");
		ticket1.setSourceStation("new delhi");
		ticket1.setDestStation("chennai");
		ticket1.setBookingDate(new Date());
		ticket1.setEmail("naaayat@gmail.com");
		
		entityManager.persist(ticket1);
		
		entityManager.remove(ticket);
		
		Iterable<Ticket> allTickets=ticketdao.findAll();
	    List<Ticket> ticketlist= new ArrayList<Ticket>();
	    
	    for(Ticket tickets: allTickets) {
	    	ticketlist.add(tickets);
	    }
	    
	    assertThat(ticketlist.size()).isNotEqualTo(2);
	}
}