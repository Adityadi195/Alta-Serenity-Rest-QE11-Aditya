package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USER = Constants.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL + "/api/users/";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER_CHAR = Constants.BASE_URL + "/api/users/{character}";
    public static String POST_REGISTER_SUCCESSFUL = Constants.BASE_URL + "/api/register";
    public static String POST_REGISTER_UNSUCCSESSFUL = Constants.BASE_URL + "/api/register";
    public static String POST_LOGIN_SUCCESSFUL = Constants.BASE_URL + "/api/login";
    public static String POST_LOGIN_UNSUCCSESSFUL = Constants.BASE_URL + "/api/login";
    public static String GET_DELAYED = Constants.BASE_URL + "/api/users?delay={id}";
    public static String GET_DELAYED_CHAR = Constants.BASE_URL + "/api/users?delay={character}";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_SINGLE_USER_CHAR = Constants.BASE_URL + "/api/users/{character}";
    public static String GET_SINGLE_USER_NOT_FOUND = Constants.BASE_URL + "/api/users/{id}";

    @Step("Get list user")
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public static void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public static void putUpdateUserError(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch user data json")
    public void patchUserDataJson(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete user char")
    public void deleteUserChar(String character) {
        SerenityRest.given().pathParam("character", character);
    }

    @Step("Post register successful")
    public void setSuccessfulPostRegister(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful")
    public void setUnuccessfulPostRegister(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login successful")
    public void setSuccessfulLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login successful")
    public void setUnuccessfulLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get delayed Response")
    public void getDelayedResponse(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get delayed Response char")
    public void getDelayedResponseChar(String character) {
        SerenityRest.given().pathParam("character", character);
    }


    @Step("Get single resource")
    public void getSingleResource(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }
    @Step("Get single resource")
    public void getSingleResourceChar(String id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

    @Step("Get single users")
    public void setGetSingleUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single users char")
    public void setGetSingleUserChar(String character) {
        SerenityRest.given().pathParam("character", character);
    }

    @Step("Get single user not found")
    public void setGetSingleUserNotFound(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list users with invalid parameter page")
    public void getListUsersInvalidParamPage(String page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);
    }
}
