package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    private String razonSocial;
    private String cuit;

    protected Client() {

    }

    public Client(String razonSocial, String cuit){
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }
}
