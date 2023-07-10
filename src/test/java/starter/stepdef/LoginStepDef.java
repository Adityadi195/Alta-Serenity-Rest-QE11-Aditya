package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //LOGIN - SUCCESSFUL
    @Given("Successfully login with valid JSON")
    public void successfullyLoginWithValidJSON() {
        File json = new File(Constants.REQ_BODY+ "/LoginSuccessful.json");
        reqresAPI.setSuccessfulLogin(json);
    }

    @When("Send request login")
    public void sendRequestLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESSFUL);
    }

    //LOGIN - UNSUCCESSFUL
    @Given("Unsuccessfully login with invalid JSON")
    public void unsuccessfullyLoginWithInvalidJSON() {
        File json = new File(Constants.REQ_BODY+"/LoginUnsucessful.json");
        reqresAPI.setUnuccessfulLogin(json);
    }

    @When("Send request login unsuccessful")
    public void sendRequestLoginUnsuccessful() {
        SerenityRest.when()
                .post(reqresAPI.POST_LOGIN_UNSUCCSESSFUL);
    }

    @Then("Login status code should be {int} not found unsuccessfull")
    public void statusCodeShouldBeNotFoundUnsuccessfull(int NotFound) {
        SerenityRest.then()
                .statusCode(NotFound);
    }

    @And("Login user successful json schema")
    public void loginUserSuccessful() {
        File json = new File(Constants.JSON_SCHEMA+"/LoginJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Login user unsuccessful json schema validator")
    public void loginUserUnsuccessfulJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA+"/LoginUnsuccessfulJSONSchema.json");
        SerenityRest.and().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user with empty email on body request")
    public void loginUserWithEmptyEmailOnBodyRequest() {
        File json = new File(Constants.REQ_BODY+"/LoginEmptyEmail.json");
        reqresAPI.setUnuccessfulLogin(json);
    }

    @And("Post login unsuccessful json schema")
    public void postLoginUnsuccessfulJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/LoginUnsuccessfulJSONSchema.json");
        SerenityRest.then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user with empty password on body request")
    public void loginUserWithEmptyPasswordOnBodyRequest() {
        File json = new File(Constants.REQ_BODY+"/LoginEmptyPassword.json");
        reqresAPI.setUnuccessfulLogin(json);
    }

    @And("Response body will be contains {string}")
    public void responseBodyWillBeContains(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR_PASSWORD, equalTo(error));
    }

    @Given("Login user unsuccessful with empty value on body request")
    public void loginUserUnsuccessfulWithEmptyValueOnBodyRequest() {
        File json = new File(Constants.REQ_BODY+"/LoginEmptyValue.json");
        reqresAPI.setUnuccessfulLogin(json);
    }

    @Given("Login user unsuccessful with invalid email format")
    public void loginUserUnsuccessfulWithInvalidEmailFormat() {
        File json = new File(Constants.REQ_BODY+"/LoginInvalidFormat.json");
        reqresAPI.setUnuccessfulLogin(json);
    }
}
