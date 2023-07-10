package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //GET LIST USER
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then()
                .statusCode(ok);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBe(int page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(page));
    }


    //POST CREATE
    @Given("Create new user with complete body request")
    public void createNewUserWithCompleteBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/User.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send a post indicating successful create new user")
    public void sendAPostIndicatingSuccessfulCreateNewUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("Response body name was {string} an job was {string}")
    public void responseBodyNameWasAnJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    //PUT UPDATE
    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUser.json");
        ReqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    //DELETE
    @Given("Delete user with valid id parameter {int}")
    public void deleteUserWithValidIdParameter(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} no content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then()
                .statusCode(noContent);
    }
}
