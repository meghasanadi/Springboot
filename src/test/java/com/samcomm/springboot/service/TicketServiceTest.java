package com.samcomm.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samcomm.springboot.dao.TicketDao;
import com.samcomm.springboot.entities.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {
	
	@Autowired
	private TicketService ticketservice;
	
	@MockBean
	private TicketDao ticketdao;
	
	@Test
	public void testCreateTicket() {
		
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("ggmm");
		ticket.setSourceStation("ggmm");
		ticket.setDestStation("ggmm");
		ticket.setBookingDate(new Date());
		ticket.setEmail("ggmm");
		
		Mockito.when(ticketdao.save(ticket)).thenReturn(ticket);
		
		assertThat(ticketservice.createTicket(ticket)).isEqualTo(ticket);
	}

	
	@Test
	public void testTicketsById() {
		
		Ticket ticket1=new Ticket();
		ticket1.setTicketId(2);
		ticket1.setPassengerName("megha");
		ticket1.setSourceStation("pune");
		ticket1.setDestStation("Hyderabad");
		ticket1.setBookingDate(new Date());
		ticket1.setEmail("megah@gmail.com");
		
		Mockito.when(ticketdao.findOne(2)).thenReturn(ticket1);
		assertThat(ticketservice.getTicketId(2)).isEqualTo(ticket1);
	}
	
	@Test
	public void DeleteTicketTest() {
		
		Ticket ticket2=new Ticket();
		ticket2.setTicketId(3);
		ticket2.setPassengerName("supiya");
		ticket2.setSourceStation("Delhi");
		ticket2.setDestStation("Hyderabad");
		ticket2.setBookingDate(new Date());
		ticket2.setEmail("supiya@gmail.com");
		
		Mockito.when(ticketdao.findOne(3)).thenReturn(ticket2);
		Mockito.when(ticketdao.exists(ticket2.getTicketId())).thenReturn(false);
	    assertFalse(ticketdao.exists(ticket2.getTicketId()));
	}
}
