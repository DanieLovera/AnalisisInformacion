package com.aninfo.model;

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

    @Override
    public String toString() {
        return "Cliente {" +
                "ID = " + clientId +
                ", Razon Social = " + razonSocial +
                ", CUIT = " + cuit +
                " }";
    }
}
