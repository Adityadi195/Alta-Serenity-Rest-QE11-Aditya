package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class DelayedResponseStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Delayed Response
    @Given("Get delayed response with parameter {int}")
    public void getDelayedResponseWithParameter(int id) {
        reqresAPI.getDelayedResponse(id);
    }

    @When("Send get delayed response request")
    public void sendGetDelayedResponseRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_DELAYED);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE, equalTo(page));
    }


    @Given("Get delayed responses with special character parameter {}")
    public void getDelayedResponsesWithSpecialCharacterParameter(String id) {
        reqresAPI.getDelayedResponseChar(id);
    }

    @And("Responses body page should be {}")
    public void responsesBodyPageShouldBe(String page) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE, equalTo(page));
    }

    @When("Send get delayed responses request")
    public void sendGetDelayedResponsesRequest() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER_CHAR);
    }
}
