Feature: Modificar severidad de un ticket
  Como empleado de soporte quiero poder modificar la severidad
  asignada a un ticket para poder priorizar el ticket correctamente

  Scenario: Modificacion de un ticket a severidad S1
    Given Existe un ticket creado
    When Cambio su severidad a "S1"
    Then El ticket se modifica correctamente a severidad "S1"

  Scenario: Modificacion de un ticket a severidad S2
    Given Existe un ticket creado
    When Cambio su severidad a "S2"
    Then El ticket se modifica correctamente a severidad "S2"

  Scenario: Modificacion de un ticket a severidad S3
    Given Existe un ticket creado
    When Cambio su severidad a "S3"
    Then El ticket se modifica correctamente a severidad "S3"

  Scenario: Modificacion de un ticket a severidad S4
    Given Existe un ticket creado
    When Cambio su severidad a "S4"
    Then El ticket se modifica correctamente a severidad "S4"


