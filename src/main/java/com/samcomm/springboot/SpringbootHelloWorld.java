package com.samcomm.springboot;


import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.samcomm.springboot.entities.Ticket;
import com.samcomm.springboot.service.TicketService;


@SpringBootApplication
public class SpringbootHelloWorld {
	
	public static void main(String[] args) {
	  SpringApplication.run(SpringbootHelloWorld.class, args);
		/*ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringbootHelloWorld.class, args);
		TicketService ticketService =applicationContext.getBean("ticketService",TicketService.class);
		
		Ticket ticket1=new Ticket();
		ticket1.setBookingDate(new Date());
		ticket1.setDestStation("Mumbai");
		ticket1.setSourceStation("pune");
		ticket1.setPassengerName("mm");
		ticket1.setEmail("meghakf@yahoo.com");
		
		ticketService.createTicket(ticket1);
		
		Ticket ticket2=new Ticket();
		ticket2.setBookingDate(new Date());
		ticket2.setDestStation("Delhi");
		ticket2.setSourceStation("pune");
		ticket2.setPassengerName("uu");
		ticket2.setEmail("haha@yahoo.com");
		
		ticketService.createTicket(ticket2);*/
	}

}
