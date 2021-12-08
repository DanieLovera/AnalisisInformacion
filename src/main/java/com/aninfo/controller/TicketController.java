package com.aninfo.controller;

import com.aninfo.model.ticket.Severity;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService =  ticketService;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }

    @GetMapping
    public Collection<Ticket> getAll() {
        return ticketService.getTickets();
    }

    @GetMapping(path = "out_of_time")
    public Collection<Ticket> getAllOutOfTime() {
        return ticketService.getOutOfTimeTickets();
    }

    @GetMapping(path = "{type}")
    public Collection<Ticket> getAllByType(@PathVariable("type") Type type) {
        return ticketService.getTicketsByType(type);
    }

    @PutMapping(path = "{ticketID}")
    public Ticket update(@PathVariable("ticketID") Long ticketID,
                         @RequestBody State state) {
        return ticketService.update(ticketID, state);
    }

    @DeleteMapping(path = "{ticketID}")
    public void delete(@PathVariable("ticketID") Long ticketID) {
        ticketService.delete(ticketID);
    }
}
