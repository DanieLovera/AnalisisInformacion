package com.aninfo.model.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "ticket_id")
    private Long ticketID;

    @Column(name = "client_id")
    private Long clientID;

    @Column(name = "employee_id")
    private Long employeeID;

    @Column(name = "task_id")
    private Long taskID;

    @Column(name = "product_id")
    private Long productID;

    //@Column(name = "product_version")
    //private Long productVersion;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Type type;

    @Column(name = "state")
    @JsonIgnore
    private State state;

    @Column(name = "severity")
    private Severity severity;

    @Column(name = "created_date")
    @JsonIgnore
    private LocalDate createdDate;

    @Column(name = "expected_date")
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    //@JsonSerialize(using = LocalDateSerializer.class)
    @JsonIgnore
    private LocalDate expectedDate;

    @JsonProperty
    public Long getTicketID() {
        return ticketID;
    }

    public Long getClientID() {
        return clientID;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public Long getTaskID() { return taskID; }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    @JsonProperty
    public State getState() {
        return state;
    }

    public Severity getSeverity() {
        return severity;
    }

    @JsonProperty
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @JsonProperty
    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    @JsonIgnore
    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public void setTaskID(Long taskID) { this.taskID = taskID; }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @JsonIgnore
    public void setState(State state) {
        this.state = state;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @JsonIgnore
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @JsonIgnore
    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
}
