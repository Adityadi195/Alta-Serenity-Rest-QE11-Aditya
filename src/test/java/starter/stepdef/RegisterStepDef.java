package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.reqres.RegisterAPI;
import starter.reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterStepDef {
    @Steps
    RegisterAPI registerAPI;


    @Given("Successfully posted registration with valid JSON")
    public void successfullyPostedRegistrationWithValidJSON() {
        File json = new File(RegisterAPI.JSON_REQ_BODY + "/RegisterSuccessful.json");
        registerAPI.setSuccessfulPostRegister(json);
    }

    @When("Send a post indicating successful user register")
    public void sendAPostIndicatingSuccessfulUserRegister() {
        SerenityRest.when().post(RegisterAPI.POST_REGISTER_SUCCESSFUL);
    }


    //unsucessful
    @Given("Unsuccessfully posted registration with valid JSON")
    public void unsuccessfullyPostedRegistrationWithValidJSON() {
        File json = new File(RegisterAPI.JSON_REQ_BODY + "/RegisterUnsuccessful.json");
        registerAPI.setUnuccessfulPostRegister(json);
    }

    @When("Send a post indicating unsuccessful user register")
    public void sendAPostIndicatingUnsuccessfulUserRegister() {
        SerenityRest.when().post(RegisterAPI.POST_REGISTER_UNSUCCSESSFUL);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BR) {
        SerenityRest.then().statusCode(BR);
    }
}
