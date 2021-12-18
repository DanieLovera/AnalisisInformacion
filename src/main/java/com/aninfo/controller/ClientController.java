package com.aninfo.controller;

import com.aninfo.model.client.Client;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public Collection<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long ticketID) {
        return clientService.getClient(ticketID);
    }
}
