package com.aninfo.repository;

import com.aninfo.model.client.Client;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collection;

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
}
