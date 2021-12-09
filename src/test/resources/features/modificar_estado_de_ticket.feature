Feature: Modificar estado de un ticket
  Como empleado de soporte quiero poder modificar el estado actual del ticket
  asignada a un ticket para poder realizar el seguimiento del mismo correctamente.

  Scenario: Modificacion de un ticket a estado OPEN
    Given Existe un ticket creado
    When Cambio su estado a "OPEN"
    Then El ticket se modifica correctamente a estado "OPEN"

  Scenario: Modificacion de un ticket a estado IN_PROGRESS
    Given Existe un ticket creado
    When Cambio su estado a "IN_PROGRESS"
    Then El ticket se modifica correctamente a estado "IN_PROGRESS"

  Scenario: Modificacion de un ticket a estado WAITING_DEVELOPMENT
    Given Existe un ticket creado
    When Cambio su estado a "WAITING_DEVELOPMENT"
    Then El ticket se modifica correctamente a estado "WAITING_DEVELOPMENT"

  Scenario: Modificacion de un ticket a estado WAITING_CLIENT
    Given Existe un ticket creado
    When Cambio su estado a "WAITING_CLIENT"
    Then El ticket se modifica correctamente a estado "WAITING_CLIENT"

  Scenario: Modificacion de un ticket a estado CLOSED
    Given Existe un ticket creado
    When Cambio su estado a "CLOSED"
    Then El ticket se modifica correctamente a estado "CLOSED"

