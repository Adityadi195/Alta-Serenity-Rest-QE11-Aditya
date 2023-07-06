package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.junit.SerenityJUnitTestCase;

public class SingleUserAPI {
    public static String URL = "https://reqres.in";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND = URL +"/api/users/{id}";

    @Step("Get single users")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single user not found")
    public void setGetSingleUserNotFound(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
