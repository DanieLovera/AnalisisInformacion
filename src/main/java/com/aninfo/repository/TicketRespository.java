package com.aninfo.repository;

import com.aninfo.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRespository extends CrudRepository<Ticket, Long> { }
