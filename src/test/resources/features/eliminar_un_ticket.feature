Feature: Eliminar un ticket
  Como empleado de soporte quiero eliminar un ticket para indicar que
  ya no interesa guardar un registro del mismo.

  Scenario Outline: Eliminacion de un ticket correcto
    Given Se creo un ticket con parametros: 2, "description", 1, 1, "1.1.2", "S1", "subject", <listOfTaskIDs>, "ERROR"
    When Quiero eliminar dicho ticket
    Then La eliminacion se realiza correctamente
    Examples:
      | listOfTaskIDs |
      | 1,2           |

  Scenario Outline: Eliminacion de un ticket no existente
    Given Se creo un ticket con parametros: 2, "description", 1, 1, "2.0.0", "S1", "subject", <listOfTaskIDs>, "ERROR"
    When Quiero eliminar el ticket con ID 99
    Then La eliminacion devuelve error
    Examples:
      | listOfTaskIDs |
      | 1             |
