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
import static org.hamcrest.Matchers.equalTo;

public class ListUserStepdef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with special character parameter {string}")
    public void getListUserWithSpecialCharacterParameter(String page) {
        reqresAPI.getListUsersInvalidParamPage(page);
    }

    @When("Send request get list user char")
    public void sendRequestGetListUserChar() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USER);
    }

    @And("Get list user user unsuccessful json schema validator spesial character")
    public void getListUserUserUnsuccessfulJsonSchemaValidatorSpesialCharacter() {
        File json = new File(Constants.JSON_SCHEMA+"ListUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
