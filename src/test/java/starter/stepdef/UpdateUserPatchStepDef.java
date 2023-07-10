package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class UpdateUserPatchStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch user data json")
    public void patchUserDataJson() {
        File json = new File(Constants.REQ_BODY + "/PatchUserData.json");
        reqresAPI.patchUserDataJson(json);
    }

    @When("Send request patch user data")
    public void sendRequestPatchUserData() {
        SerenityRest.when()
                .patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("response body will contain {} and {}")
    public void responseBodyWillContainAdityaAndDwi(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Patch updated successful json schema")
    public void patchUpdatedJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/PatchUpdatedJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Patch user data with empty name on body request")
    public void patchUserDataWithEmptyNameOnBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/PatchUserEmptyName.json");
        reqresAPI.patchUserDataJson(json);
    }

    @When("Send request patch user update data")
    public void sendRequestPatchUserUpdateData() {
        SerenityRest.when()
                .patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @Given("Patch user data with empty job on body request")
    public void patchUserDataWithEmptyJobOnBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/PatchUserEmptyJob.json");
        reqresAPI.patchUserDataJson(json);
    }

    @Given("Patch user data with empty value on body request")
    public void patchUserDataWithEmptyValueOnBodyRequest() {
        File json = new File(Constants.REQ_BODY + "/PatchUserEmptyValue.json");
        reqresAPI.patchUserDataJson(json);
    }
}
