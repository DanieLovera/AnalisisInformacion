package com.aninfo.controller;

import com.aninfo.model.Client;
import com.aninfo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public Collection<Client> getClients() {
        return clientService.getClients();
    }
}
