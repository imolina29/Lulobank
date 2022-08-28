package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.ResponseCode;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;


public class EmployeeStepdefinition {

    private Actor actor = Actor.named("Ivan");

    @Given("Ivan search an employee list")
    public void ivan_search_an_employee_list() {
        given()
                .accept("application/json")
                .contentType("application/json");
    }
    @When("he make a query on list")
    public void he_make_a_query_on_list() {
        when()
                .get("http://dummy.restapiexample.com/api/v1/employees");
    }
    @Then("he must see a list of active employees")
    public void he_must_see_a_list_of_active_employees() {
        actor.should((GivenWhenThen.seeThat( ResponseCode.was(), equalTo(200))));
    }


}
