package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class RegisterAPI {

    public static String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/Json/ReqBody";
    public static String POST_REGISTER_SUCCESSFUL = URL + "/api/register";
    public static String POST_REGISTER_UNSUCCSESSFUL = URL + "/api/register";

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
