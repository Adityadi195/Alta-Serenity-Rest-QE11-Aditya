package starter.reqres.POST;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class LoginAPI {
    public static String POST_LOGIN_SUCCESSFUL = Constants.BASE_URL + "/api/login";
    public static String POST_LOGIN_UNSUCCSESSFUL = Constants.BASE_URL + "/api/login";

    @Step("Post login successful")
    public void setSuccessfulLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login successful")
    public void setUnuccessfulLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
