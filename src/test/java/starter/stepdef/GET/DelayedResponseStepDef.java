package starter.stepdef.GET;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GET.DelayedResponseAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class DelayedResponseStepDef {
    @Steps
    DelayedResponseAPI delayedResponseAPI;

    //Delayed Response
    @Given("Get delayed response with parameter {int}")
    public void getDelayedResponseWithParameter(int id) {
        delayedResponseAPI.setGetDelayedResponse(id);
    }

    @When("Send get delayed response request")
    public void sendGetDelayedResponseRequest() {
        SerenityRest.when().get(DelayedResponseAPI.GET_DELAYED);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
}
