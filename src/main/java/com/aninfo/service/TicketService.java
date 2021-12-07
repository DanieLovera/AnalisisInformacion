package com.aninfo.service;

import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.repository.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {

        private TicketRespository ticketRespository;

        @Autowired
        public TicketService(TicketRespository ticketRespository) {
            this.ticketRespository = ticketRespository;
        }

        public Ticket create(Ticket ticket) {
            int severityDays = ticket.getSeverity().getValue();
            LocalDate currentDate = LocalDate.now();
            ticket.setCreatedDate(currentDate);
            ticket.setExpectedDate(currentDate.plusDays(severityDays));
            ticket.setState(State.OPEN);
            return ticketRespository.save(ticket);
        }

        public Collection<Ticket> getTickets() {
            ArrayList<Ticket> tickets = new ArrayList<>();
            ticketRespository.findAll().forEach(tickets::add);
            return tickets;
        }

        public Ticket update(Long ticketID, State state) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            Ticket ticket = oticket.get();
            ticket.setState(state);
            return ticketRespository.save(ticket);
        }

        public void delete(Long ticketID) {
            ticketRespository.deleteById(ticketID);
        }
}
