package com.aninfo.service;

import com.aninfo.model.client.Client;
import com.aninfo.model.ticket.Ticket;
import com.aninfo.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

@Service
public class ClientService {

    private static final
    ClientRepository clientRepository = new ClientRepository();

    public Collection<Client> getClients() {
        return clientRepository.findAll();
    }

    public ResponseEntity<Client> getClient(Long clientID) {
        Optional<Client> oclient = clientRepository.findById(clientID);
        if (!oclient.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(oclient);
    }
}
