package com.aninfo.service;

import com.aninfo.model.exceptions.ResourceNotFoundException;
import com.aninfo.model.ticket.TicketParams;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.repository.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

        public Collection<Ticket> getTickets(TicketParams ticketParams) {
            ArrayList<Ticket> tickets = new ArrayList<>();
            Iterable<Ticket> itTicket = null;

            /*if (ticketParams.getType() == null && ticketParams.getOutOfTime() == null) {
                itTicket = ticketRespository.findAll();
            } else if (ticketParams.getType() != null && ticketParams.getOutOfTime() == null) {
                itTicket = ticketRespository.findByType(ticketParams.getType());
            } else if (ticketParams.getOutOfTime() != null && ticketParams.getType() == null) {
                itTicket = ticketRespository.findByExpectedDateBefore(LocalDate.now());
            }*/

            if (ticketParams.getType() != null && ticketParams.getOutOfTime() == false) {
                itTicket = ticketRespository.findByType(ticketParams.getType());
            } else if (ticketParams.getOutOfTime() == true && ticketParams.getType() == null) {
                itTicket = ticketRespository.findByExpectedDateBefore(LocalDate.now());
            } else {
                itTicket = ticketRespository.findAll();
            }

            // TODO: FALTAN TALVEZ CORROBORAR OTROS CASOS O REFACTORIZARLO ...
            itTicket.forEach(tickets::add);
            return tickets;
        }

        public Ticket update(Long ticketID, State state) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            Ticket ticket = oticket.get();
            ticket.setState(state);
            return ticketRespository.save(ticket);
        }

        public void delete(Long ticketID) {
            System.out.println("Estoy acá");
            if (!ticketRespository.existsById(ticketID)) {
                throw new ResourceNotFoundException("The given ID does not exists.");
            }
            ticketRespository.deleteById(ticketID);
        }
}
