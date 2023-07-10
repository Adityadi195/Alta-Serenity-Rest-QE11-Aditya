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

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //REGISTER - SUCCESSFUL
    @Given("Create registration with complete body request")
    public void createRegistrationWithCompleteBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/RegisterSuccessful.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @When("Send a post indicating successful user register")
    public void sendAPostIndicatingSuccessfulUserRegister() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    //REGISTER - UNSUCCESSFUL
    @Given("Create registration with incomplete body request")
    public void createRegistrationWithIncompleteBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/RegisterUnsuccessful.json");
        reqresAPI.setUnuccessfulPostRegister(json);
    }

    @When("Send a post indicating unsuccessful user register")
    public void sendAPostIndicatingUnsuccessfulUserRegister() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_UNSUCCSESSFUL);
    }

    @And("Post register unsuccessful json schema")
    public void postRegisterUnsucessfulJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterSuccessfulJSONSchemaError.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post register user unsuccessful json schema validator")
    public void postRegisterUserUnsuccessfulJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterUnsuccessfulJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Create register user with empty email value")
    public void createRegisterUserUnsuccessfulWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY + "/RegisterEmptyEmail.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @When("Send request post register user successful")
    public void sendRequestPostRegisterUserSuccessful() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    @And("Response body will be contain {string}")
    public void responseBodyWillBeContain(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Create register user unsuccessful json schema validator empty email")
    public void createRegisterUserUnsuccessfulJsonSchemaValidatorEmptyEmail() {
        File json = new File(Constants.JSON_SCHEMA + "/RegisterUnsuccessfulJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Create register user")
    public void createRegisterUser() {
        File json = new File(Constants.REQ_BODY + "/RegisterSuccessful.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @And("Response body contain {string}")
    public void responseBodyContain(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Create register user unsuccessful json schema validator empty password")
    public void createRegisterUserUnsuccessfulJsonSchemaValidatorEmptyPassword() {
        File json = new File(Constants.JSON_SCHEMA + "/RegisterUnsuccessfulJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Create register user unsuccessful empty value")
    public void createRegisterUserUnsuccessfulEmptyValue() {
        File json = new File(Constants.REQ_BODY + "/RegisterEmptyValue.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @And("Response body will containing {}")
    public void responseBodyWillContaining(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Create register user unsuccessful json schema validator empty value")
    public void createRegisterUserUnsuccessfulJsonSchemaValidatorEmptyValue() {
        File json = new File(Constants.JSON_SCHEMA + "/RegisterUnsuccessfulJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int BR) {
        SerenityRest.then()
                .statusCode(BR);
    }

    @Given("Create register user with empty password")
    public void createRegisterUserWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY + "/RegisterEmptyPassword.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @And("Post register successful json schema")
    public void postRegisterSuccessfulJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterSuccessfulJSONSchema.json");
        SerenityRest.and().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
