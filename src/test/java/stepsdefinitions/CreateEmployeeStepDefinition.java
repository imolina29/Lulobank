package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.ResponseCode;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class CreateEmployeeStepDefinition {

    private Actor actor = Actor.named("Pedro");

    @Given("Pedro create a new employee")
    public void pedro_create_a_new_employee() {
        String DataUser = "{\n" +
                "\"name\":\"Pedro\",\n" +
                "\"salary\":\"21000\",\n" +
                "\"age\":\"25\"\n" +
                "}";
        given()
                .accept("application/json")
                .contentType("application/json")
                .body(DataUser);
    }
    @When("he assign a new employee")
    public void he_assign_a_new_employee() {
        when()
                .post("http://dummy.restapiexample.com/api/v1/create");
    }
    @Then("he must see the new user employee")
    public void he_must_see_the_new_user_employee() {
        actor.should((GivenWhenThen.seeThat( ResponseCode.was(), equalTo(200))));
    }

}
