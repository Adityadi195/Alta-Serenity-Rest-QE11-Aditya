package starter.stepdef.POST;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.POST.LoginAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {

    @Steps
    LoginAPI loginAPI;

    //LOGIN - SUCCESSFUL
    @Given("Successfully login with valid JSON")
    public void successfullyLoginWithValidJSON() {
        File json = new File(Constants.REQ_BODY+ "/LoginSuccessful.json");
        loginAPI.setSuccessfulLogin(json);
    }

    @When("Send a post login successful")
    public void sendAPostLoginSuccessful() {
        SerenityRest.when().post(LoginAPI.POST_LOGIN_SUCCESSFUL);
    }

    //LOGIN - UNSUCCESSFUL
    @Given("Unsuccessfully login with invalid JSON")
    public void unsuccessfullyLoginWithInvalidJSON() {
        File json = new File(Constants.REQ_BODY+"/LoginUnsucessful.json");
        loginAPI.setUnuccessfulLogin(json);
    }

    @When("Send a post login unsuccessful")
    public void sendAPostLoginUnsuccessful() {
        SerenityRest.when().post(LoginAPI.POST_LOGIN_UNSUCCSESSFUL);
    }

    @Then("Login status code should be {int} not found unsuccessfull")
    public void statusCodeShouldBeNotFoundUnsuccessfull(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}
