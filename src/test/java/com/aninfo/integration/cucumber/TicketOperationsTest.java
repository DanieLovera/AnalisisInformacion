package com.aninfo.integration.cucumber;

import com.aninfo.model.ticket.Severity;
import com.aninfo.model.ticket.State;
import com.aninfo.model.ticket.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.minidev.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TicketOperationsTest {

    private Ticket ticket;
    private final String apiServiceUrl = "https://soporte-fiuba.herokuapp.com/";
    private HttpResponse<String> response;
    private Long ticketID;

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

    @When("^Asigno como operario al empleado con ID (\\d+)")
    public void set_ticket_employee(Long employeeID){ticket.setEmployeeID(employeeID);}

    @Then("^El ticket se modifica correctamente y ahora el id del operario asignado es (\\d+)")
    public void check_ticket_employee(Long employeeID){assertEquals(ticket.getEmployeeID(), employeeID);}

    @Given("^Se creo un ticket con parametros: (\\d+), \"([^\"]*)\", (\\d+), (\\d+), \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+), \"([^\"]*)\"$")
    public void create_ticket_through_api(Long clientID, String description, Long employeeID, Long productID,
                                          String productVersion, String severity, String subject, Long taskID, String type)
            throws URISyntaxException, IOException, InterruptedException {


        JSONObject ticketRequest = new JSONObject();
        ticketRequest.put("clientID", clientID);
        ticketRequest.put("description", description);
        ticketRequest.put("employeeID", employeeID);
        ticketRequest.put("productID", productID);
        ticketRequest.put("productVersion", productVersion);
        ticketRequest.put("severity", severity);
        ticketRequest.put("subject", subject);
        ticketRequest.put("taskID", taskID);
        ticketRequest.put("type", type);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(new URI(apiServiceUrl + "/tickets"))
                .POST(HttpRequest.BodyPublishers.ofString(ticketRequest.toString()))
                .header("Content-Type", "application/json")
                .build();

        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Map map = new ObjectMapper().readValue(this.response.body(), Map.class);
        ticketID = Long.valueOf(map.get("ticketID").toString());
    }

    @When("Quiero eliminar dicho ticket")
    public void delete_created_ticket()
            throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(new URI(apiServiceUrl + "/tickets/" + this.ticketID))
                .DELETE()
                .build();

        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Then("La eliminacion se realiza correctamente")
    public void check_deleted_ticket() {
        assertEquals(this.response.statusCode(), 200);
        //TODO un get del ticketID debería dar 404
    }

    @When("Quiero eliminar el ticket con ID (\\d+)")
    public void delete_invalid_ticket(Long ticketID)
            throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(new URI(apiServiceUrl + "/tickets/" + ticketID))
                .DELETE()
                .build();

        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Then("La eliminacion devuelve error")
    public void check_invalid_deleted_ticket() {
        assertEquals(404, this.response.statusCode());
    }
}