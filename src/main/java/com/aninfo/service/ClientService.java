package com.aninfo.service;

import com.aninfo.model.Client;
import com.aninfo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Collection<Client> getClients() {
        Collection<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }
}
