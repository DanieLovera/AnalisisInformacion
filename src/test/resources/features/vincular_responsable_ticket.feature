Feature: Vincular responsable del ticket
  Como usuario quiero asignar un operario de soporte responsable del ticket
  para que lo pueda realizar.

  Scenario: Asignacion de un responsable del ticket
    Given Existe un ticket creado
    When Asigno como operario al empleado con ID 1
    Then El ticket se modifica correctamente y ahora el id del operario asignado es 1
