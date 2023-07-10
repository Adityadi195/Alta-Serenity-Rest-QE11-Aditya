package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Create new user with empty name")
    public void createNewUserWithEmptyName() {
        File json = new File(Constants.REQ_BODY + "/CreateUserEmptyName.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send a post indicating unsuccessful create new user")
    public void sendAPostIndicatingUnsuccessfulCreateNewUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Post create user unsuccessful json schema validator")
    public void postCreateUserUnsuccessfulJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA+"/CreateJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create user with empty job")
    public void postCreateUserWithEmptyJob() {
        File json = new File(Constants.REQ_BODY + "/CreateUserEmptyJob.json");
        reqresAPI.setSuccessfulPostRegister(json);
    }

    @Given("Post create user with empty body request")
    public void postCreateUserWithEmptyBodyRequest() {
        File json = new File(Constants.REQ_BODY+"/CreateUserEmptyBody.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create user with invalid body request")
    public void postCreateUserWithInvalidBodyRequest() {
        File json = new File(Constants.REQ_BODY+"/CreateUserInvalidValue.json");
        reqresAPI.postCreateUser(json);
    }
}
