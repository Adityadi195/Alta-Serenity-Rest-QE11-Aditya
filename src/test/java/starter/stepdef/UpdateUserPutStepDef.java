package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserPutStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with invalid key body request {int}")
    public void putUpdateUserWithInvalidKeyBodyRequest(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUserError.json");
        ReqresAPI.putUpdateUserError(id, json);
    }

    @And("Response body name {string} and job {string}")
    public void responseBodyNameAndJob(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Put updated json schema validator")
    public void putUpdatedJsonSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA + "/PutUpdatedJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
