package com.aninfo.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticketID;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "state")
    private String state;

    public Ticket() {
        title = "titulo de prueba";
        message = "mensaje de prueba";
        state = "inactivo";
    }

    public void setState(String state) {
        this.state = state;
    }
}
