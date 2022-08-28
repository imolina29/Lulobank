package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

public class InfoEmployeeStepDefinition {

    @Given("Luis consults the list of new employee income")
    public void luis_consults_the_list_of_new_employee_income() {
        given()
                .accept("application/json")
                .contentType("application/json");
    }
    @When("he generate de query")
    public void he_generate_de_query() {
        when()
                .get("https://dummy.restapiexample.com/api/v1/employee/1");
    }
    @Then("he gets the list of new hires")
    public void he_gets_the_list_of_new_hires() {
        then()
                .assertThat().statusCode(200)
                .and()
                .body(containsString("Tiger Nixon"))
                .log().all();
    }
}
