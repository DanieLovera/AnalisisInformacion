package com.aninfo.controller;

import com.aninfo.model.Ticket;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public Collection<Ticket> getTickets() {
        return ticketService.getTickets();
    }
}
