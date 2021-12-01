package com.aninfo.controller;

import com.aninfo.model.Ticket;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket create(Ticket ticket) {
        return ticketService.create(ticket);
    }

    @GetMapping("/tickets")
    public Collection<Ticket> getAll() {
        return ticketService.getTickets();
    }

    @PutMapping("/tickets/{ticketID}")
    public Ticket update(Long ticketID, String state) {
        return ticketService.update(ticketID, state);
    }

    @DeleteMapping("/tickets/{ticketID}")
    public void delete(Long ticketID) {
        ticketService.delete(ticketID);
    }
}
