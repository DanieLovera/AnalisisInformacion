package com.aninfo.service;

import com.aninfo.model.Ticket;
import com.aninfo.repository.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class TicketService {

        @Autowired
        private TicketRespository ticketRespository;

        public Collection<Ticket> getTickets() {
            ArrayList<Ticket> clients = new ArrayList<>();
            ticketRespository.findAll().forEach(clients::add);
            return clients;
        }

}
