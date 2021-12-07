package com.aninfo.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    @JsonProperty("id")
    private Long clientId;
    @JsonProperty("razon social")
    private String razonSocial;
    @JsonProperty("CUIT")
    private String cuit;
}
