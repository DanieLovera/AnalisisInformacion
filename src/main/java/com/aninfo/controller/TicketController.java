package com.aninfo.controller;

import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Collection<Ticket> getTickets(
            @RequestParam(value = "type", required = false) Type type,
            @RequestParam(value = "outOfTime", required = false) Boolean outOfTime,
            @RequestParam(value = "productID", required = false) Long productID,
            @RequestParam(value = "productVersion", required = false) String productVersion) {
        return ticketService.getTickets(type, outOfTime, productID, productVersion);
    }

    @PutMapping(path = "{id}/updateState")
    public Ticket updateState(@PathVariable("id") Long ticketID,
                              @RequestParam State state) {
        return ticketService.update(ticketID, state);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTicket(@PathVariable("id") Long ticketID) {
        ticketService.delete(ticketID);
    }
}
