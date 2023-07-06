package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class SingleUserAPI {
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND = Constants.BASE_URL + "/api/users/{id}";

    @Step("Get single users")
    public void setGetSingleUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user not found")
    public void setGetSingleUserNotFound(int id) {
        SerenityRest.given().pathParam("id", id);
    }
}
