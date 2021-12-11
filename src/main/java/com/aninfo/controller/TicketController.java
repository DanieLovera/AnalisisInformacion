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
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping(path = "outOfTime")
    public Collection<Ticket> getAllOutOfTime() {
        return ticketService.getOutOfTimeTickets();
    }

    /*@GetMapping(path = "{type}")
    public Collection<Ticket> getAllByType(@PathVariable("type") Type type) {
        return ticketService.getTicketsByType(type);
    }*/

    @GetMapping(path = "/types")
    public Collection<Ticket> getAllByType(@RequestParam Type type) {
        return ticketService.getTicketsByType(type);
    }

    @PutMapping(path = "{id}/updateState")
    public Ticket updateState(@PathVariable("id") Long ticketID,
                              @RequestParam State state) {
        return ticketService.update(ticketID, state);
    } // @RequestBody

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long ticketID) {
        ticketService.delete(ticketID);
    }
}
