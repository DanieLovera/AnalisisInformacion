package com.aninfo.repository;

import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.Collection;

@RepositoryRestResource
public interface TicketRespository extends CrudRepository<Ticket, Long> {

    Collection<Ticket> findByType(Type type);

    //@Query(value = "select * from ticket where ticket.expected_date < :currentDate", nativeQuery = true)
    //Collection<Ticket> findByExpectedDateBefore(@Param("currentDate")LocalDate currentDate);
    Collection<Ticket> findByExpectedDateBefore(LocalDate currentDate);
}
