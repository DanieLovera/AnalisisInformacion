package com.aninfo.integration.cucumber;

import com.aninfo.model.ticket.Severity;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicketOperationsTest {

    private Ticket ticket;

    @Given("Existe un ticket creado")
    public void any_ticket()  {ticket = new Ticket();}

    @When("^Cambio su estado a \"([^\"]*)\"$")
    public void set_ticket_state(State ticketState){ticket.setState(ticketState);}

    @Then("^El ticket se modifica correctamente a estado \"([^\"]*)\"$")
    public void check_ticket_state(State ticketState){assertEquals(ticket.getState(), ticketState);}

    @When("^Cambio su severidad a \"([^\"]*)\"$")
    public void set_ticket_state(Severity ticketSeverity){ticket.setSeverity(ticketSeverity);}

    @Then("^El ticket se modifica correctamente a severidad \"([^\"]*)\"$")
    public void check_ticket_state(Severity ticketSeverity){assertEquals(ticket.getSeverity(), ticketSeverity);}

}