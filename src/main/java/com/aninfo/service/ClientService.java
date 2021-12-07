package com.aninfo.service;

import com.aninfo.model.client.Client;
import com.aninfo.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ClientService {

    private static final
    ClientRepository clientRepository = new ClientRepository();

    public Collection<Client> getClients() {
        return clientRepository.findAll();
    }
}
