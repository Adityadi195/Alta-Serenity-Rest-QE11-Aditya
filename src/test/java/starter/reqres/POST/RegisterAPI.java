package starter.reqres.POST;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class RegisterAPI {
    public static String POST_REGISTER_SUCCESSFUL = Constants.BASE_URL + "/api/register";
    public static String POST_REGISTER_UNSUCCSESSFUL = Constants.BASE_URL + "/api/register";

    @Step("Post register successful")
    public void setSuccessfulPostRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register unsuccessful")
    public void setUnuccessfulPostRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
