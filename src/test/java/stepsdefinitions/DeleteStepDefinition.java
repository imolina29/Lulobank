package stepsdefinitions;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.bouncycastle.asn1.cms.CMSAttributes.contentType;
import static org.hamcrest.Matchers.equalTo;

public class DeleteStepDefinition {


    @Given("Tomas find inactive employee")
    public void tomas_find_inactive_employee() {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }
    @When("he search an employee")
    public void he_search_an_employee() {
       when()
               .delete("http://dummy.restapiexample.com/public/api/v1/delete/2");
    }
    @Then("he could delete employee")
    public void he_could_delete_employee() {
        then()
                .assertThat().statusCode(200)
                .and()
                .body("message", equalTo("Successfully! Record has been deleted"))
                .log().all();
    }

}
