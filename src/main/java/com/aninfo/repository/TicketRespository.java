package com.aninfo.repository;

import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface TicketRespository extends CrudRepository<Ticket, Long> {

    Collection<Ticket> findByType(Type type);
}
