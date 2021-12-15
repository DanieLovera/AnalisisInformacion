package com.aninfo.service;

import com.aninfo.model.exceptions.ResourceNotFoundException;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import com.aninfo.model.ticket.filters.ByExpectedDateBefore;
import com.aninfo.model.ticket.filters.ByProductID;
import com.aninfo.model.ticket.filters.ByProductVersion;
import com.aninfo.model.ticket.filters.ByType;
import com.aninfo.repository.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {

        @Autowired
        private TicketRespository ticketRespository;

        public Ticket create(Ticket ticket) {
            int severityDays = ticket.getSeverity().getValue();
            LocalDate currentDate = LocalDate.now();
            ticket.setCreatedDate(currentDate);
            ticket.setExpectedDate(currentDate.plusDays(severityDays));
            ticket.setState(State.OPEN);
            return ticketRespository.save(ticket);
        }

        public Collection<Ticket> getTickets(Type type, Boolean outOfTime,
                                             Long productID, String productVersion) {
            // Crear mas especificaciones si hay mas filtros
            Specification<Ticket> spec = Specification.where(new ByType(type))
                    .and(new ByExpectedDateBefore(outOfTime))
                    .and(new ByProductID(productID))
                    .and(new ByProductVersion(productVersion));
            return ticketRespository.findAll(spec);
        }

        public Ticket update(Long ticketID, State state) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            Ticket ticket = oticket.get();
            ticket.setState(state);
            return ticketRespository.save(ticket);
        }

        public void delete(Long ticketID) {
            if (!ticketRespository.existsById(ticketID)) {
                throw new ResourceNotFoundException("The given ID does not exists.");
            }
            ticketRespository.deleteById(ticketID);
        }
}
