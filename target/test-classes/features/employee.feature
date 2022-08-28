Feature: Get employee list

  @ScenarioMethodGET
  Scenario: Search employee
    Given Ivan search an employee list
    When he make a query on list
    Then he must see a list of active employees