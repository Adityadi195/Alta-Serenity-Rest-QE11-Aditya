package starter.stepdef.GET;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GET.SingleUserAPI;


public class SingleUserStepDef {
    @Steps
    SingleUserAPI singleUserAPI;

    //SINGLE USER
    @Given("Get a single user with a valid ID {int}")
    public void getASingleUserWithAValidID(int id) {
        singleUserAPI.setGetSingleUser(id);
    }

    @When("Send a get request for a single user")
    public void sendAGetRequestForASingleUser() {
        SerenityRest.when().get(SingleUserAPI.GET_SINGLE_USER);
    }

    //SINGLE USER NOT FOUND
    @Given("Get a single user using an invalid id {int}")
    public void getASingleUserUsingAnInvalidId(int id) {
        singleUserAPI.setGetSingleUser(id);
    }

    @When("Send a request to get a single user")
    public void sendARequestToGetASingleUser() {
        SerenityRest.when().get(SingleUserAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @Given("Get single user with id was not found {int}")
    public void getSingleUserWithIdWasNotFound(int id) {
        singleUserAPI.setGetSingleUserNotFound(id);
    }

    @When("Send get single user not found request")
    public void sendGetSingleUserNotFoundRequest() {
        SerenityRest.when().get(SingleUserAPI.GET_SINGLE_USER_NOT_FOUND);
    }
}
