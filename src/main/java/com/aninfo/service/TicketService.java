package com.aninfo.service;

import com.aninfo.model.exceptions.ResourceNotFoundException;
import com.aninfo.model.ticket.FilterParams;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {

        @Autowired
        private TicketRespository ticketRespository;

        public Ticket create(Ticket ticket) {
            int severityDays = 0;
            LocalDate currentDate = LocalDate.now();
            if (ticket.getSeverity() != null){
                severityDays = ticket.getSeverity().getValue();
                ticket.setExpectedDate(currentDate.plusDays(severityDays));
            }
            ticket.setCreatedDate(currentDate);
            ticket.setState(State.OPEN);
            return ticketRespository.save(ticket);
        }

        public Collection<Ticket> getTickets(FilterParams filterParams) {
            // Crear mas especificaciones si hay mas filtros
            Specification<Ticket> spec = Specification.where(new ByType(filterParams.getType()))
                    .and(new ByExpectedDateBefore(filterParams.getOutOfTime()))
                    .and(new ByProductID(filterParams.getProductID()))
                    .and(new ByProductVersion(filterParams.getProductVersion()));
            return ticketRespository.findAll(spec);
        }

        public ResponseEntity<Ticket> getTicket(Long ticketID) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            if (!oticket.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.of(oticket);
        }

        /*public Ticket update(Long ticketID, State state) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            Ticket ticket = oticket.get();
            ticket.setState(state);
            return ticketRespository.save(ticket);
        }*/

        public ResponseEntity<Object> update(Long ticketID, Ticket ticket) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            if (!oticket.isPresent())
                return ResponseEntity.notFound().build();

            ticket.setTicketID(ticketID);
            ticket.setCreatedDate(oticket.get().getCreatedDate());
            ticket.setExpectedDate(oticket.get().getExpectedDate());

            ticketRespository.save(ticket);
            return ResponseEntity.noContent().build();
        }

        public void delete(Long ticketID) {
            if (!ticketRespository.existsById(ticketID)) {
                throw new ResourceNotFoundException("The given ID does not exists.");
            }
            ticketRespository.deleteById(ticketID);
        }
}
