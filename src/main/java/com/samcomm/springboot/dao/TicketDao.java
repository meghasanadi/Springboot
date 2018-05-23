package com.samcomm.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samcomm.springboot.entities.Ticket;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer> {


}
