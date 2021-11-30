package com.aninfo.service;

import com.aninfo.model.Ticket;
import com.aninfo.repository.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {

        @Autowired
        private TicketRespository ticketRespository;

        public Ticket create(Ticket ticket) {
            //Ticket ti = new Ticket();
            return ticketRespository.save(ticket);
        }

        public Collection<Ticket> getTickets() {
            ArrayList<Ticket> tickets = new ArrayList<>();
            ticketRespository.findAll().forEach(tickets::add);
            return tickets;
        }

        public Ticket update(Long ticketID, String state) {
            Optional<Ticket> oticket = ticketRespository.findById(ticketID);
            Ticket ticket = oticket.get();
            ticket.setState(state);
            return ticketRespository.save(ticket);
        }

        public void delete(Long ticketID) {
            ticketRespository.deleteById(ticketID);
        }
}
