package com.aninfo.repository;

import com.aninfo.model.client.Client;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class ClientRepository {

    private static final
    RestTemplate restTemplate = new RestTemplate();
    private static final String url = "https://anypoint.mulesoft.com/mocking/" +
                                      "api/v1/sources/exchange/assets/754f50e8" +
                                      "-20d8-4223-bbdc-56d50131d0ae/clientes-psa" +
                                      "/1.0.0/m/api/clientes";

    public Collection<Client> findAll() {
        Client[] clients = restTemplate.getForObject(url, Client[].class);
        return Arrays.asList(clients);
    }

    public Optional<Client> findById(Long clientID) {
        Client[] clients = restTemplate.getForObject(url, Client[].class);
        Client clientFiltered = Arrays.stream(clients).filter(client -> clientID.equals(client.getClientId()))
                .findAny()
                .orElse(null);
        return Optional.of(clientFiltered);
    }
}
