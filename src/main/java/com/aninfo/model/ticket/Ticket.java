package com.aninfo.model.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "ticket_id")
    private Long ticketID;

    @Column(name = "client_id", nullable = false)
    private Long clientID;

    @Column(name = "employee_id")
    private Long employeeID;

    @ElementCollection
    private List<Long> taskIDs;

    // DUDA EN ID Y VERSION PARECEN UN
    // PAR NECESARIO PARA DEFINIR EL PRODUCTO COMPLETO
    @Column(name = "product_id", nullable = false)
    private Long productID;

    @Column(name = "product_version", nullable = false)
    private String productVersion;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "state", nullable = false)
    private State state;

    @Column(name = "severity", nullable = false)
    private Severity severity;

    @Column(name = "created_date", nullable = false)
    @JsonIgnore
    private LocalDate createdDate;

    @Column(name = "expected_date", nullable = false)
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

    public List<Long> getTaskIDs() { return taskIDs; }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

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

    public void setTaskIDs(List<Long> taskIDs) { this.taskIDs = taskIDs; }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }
}
