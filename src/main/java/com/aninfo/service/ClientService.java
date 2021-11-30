package com.aninfo.service;

import com.aninfo.model.Client;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String url = "https://anypoint.mulesoft.com/mocking/" +
                                      "api/v1/sources/exchange/assets/754f50e8" +
                                      "-20d8-4223-bbdc-56d50131d0ae/clientes-psa" +
                                      "/1.0.0/m/api/clientes";

    public Collection<Client> getClients() {
        Client[] clients = restTemplate.getForObject(url, Client[].class);
        return Arrays.asList(clients);
    }
}
