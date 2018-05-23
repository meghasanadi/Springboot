package com.samcomm.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samcomm.springboot.entities.Ticket;
import com.samcomm.springboot.service.TicketService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RestControllerhelloWorld.class)
public class TicketControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketService ticketservice;
	
	@Test
	public void testCreateTicket() throws Exception{
		
		Ticket mockTicket=new Ticket();
		mockTicket.setTicketId(1);
		mockTicket.setPassengerName("martin luther");
		mockTicket.setSourceStation("kolkata");
		mockTicket.setDestStation("Kerala");
		mockTicket.setEmail("martin@gmail.com");
		mockTicket.setBookingDate(new Date());
		
		String inputInJson = this.mapToJson(mockTicket);
		
		String URI="/api/tickets/create";
		
		Mockito.when(ticketservice.createTicket(Mockito.any(Ticket.class))).thenReturn(mockTicket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String outputInJson=response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
	}

	private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}
