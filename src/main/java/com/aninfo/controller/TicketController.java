package com.aninfo.controller;

import com.aninfo.model.ticket.FilterParams;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "tickets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService =  ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }

    @GetMapping
    public Collection<Ticket> getTickets(FilterParams filterParams) {
        return ticketService.getTickets(filterParams);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") Long ticketID) {
        return ticketService.getTicket(ticketID);
    }

    /*@PutMapping(path = "{id}/updateState")
    public Ticket updateState(@PathVariable("id") Long ticketID,
                              @RequestParam State state) {
        return ticketService.update(ticketID, state);
    }*/

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long ticketID,
                                         @RequestBody Ticket ticket) {
        return ticketService.update(ticketID, ticket);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTicket(@PathVariable("id") Long ticketID) {
        ticketService.delete(ticketID);
    }
}
