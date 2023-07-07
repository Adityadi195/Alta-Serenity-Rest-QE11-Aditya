package starter.stepdef.GET;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GET.SingleResourceAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class SingleResourceStepDef {

    @Steps
    SingleResourceAPI singleResourceAPI;

    //SINGLE <RESOURCE>
    @Given("Get single resource with valid id {int}")
    public void getSingleResourceWithValidId(int id) {
        singleResourceAPI.getSingleResource(id);
    }

    @When("Send request for a single resource")
    public void sendRequestForASingleResource() {
        SerenityRest.when().get(SingleResourceAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int statusCodeOk) {
        SerenityRest.then().statusCode(statusCodeOk);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id));
    }

    //SINGLE <RESOURCE> NOT FOUND
    @Given("Get single resource with invalid id {int}")
    public void getSingleResourceWithInvalidId(int id) {
        singleResourceAPI.getSingleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(SingleResourceAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
