Feature: Delete employee list

  @ScenarioDelete
  Scenario: Delete employee
    Given Tomas find inactive employee
    When he search an employee
    Then he could delete employee