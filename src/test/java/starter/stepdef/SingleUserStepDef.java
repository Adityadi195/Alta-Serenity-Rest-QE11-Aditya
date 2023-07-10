package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;


public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //SINGLE USER
    @Given("Get a single user with a valid ID {int}")
    public void getASingleUserWithAValidID(int id) {
        reqresAPI.setGetSingleUser(id);
    }

    @When("Send a get request for a single user")
    public void sendAGetRequestForASingleUser() {
        SerenityRest.when()
                .get(reqresAPI.GET_SINGLE_USER);
    }

    //SINGLE USER NOT FOUND
    @Given("Get a single user using an invalid id {int}")
    public void getASingleUserUsingAnInvalidId(int id) {
        reqresAPI.setGetSingleUser(id);
    }

    @When("Send a request to get a single user")
    public void sendARequestToGetASingleUser() {
        SerenityRest.when()
                .get(reqresAPI.GET_SINGLE_USER);
    }

    @Given("Get single user with id was not found {int}")
    public void getSingleUserWithIdWasNotFound(int id) {
        reqresAPI.setGetSingleUserNotFound(id);
    }

    @When("Send get single user not found request")
    public void sendGetSingleUserNotFoundRequest() {
        SerenityRest.when()
                .get(reqresAPI.GET_SINGLE_USER_NOT_FOUND);
    }

    @Given("Get single user with special character {}")
    public void getSingleUserWithSpecialCharacter(String character) {
        reqresAPI.setGetSingleUserChar(character);
    }

    @When("Send request get single user special character")
    public void sendRequestGetSingleUserSpecialCharacter() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER_CHAR);
    }
}
