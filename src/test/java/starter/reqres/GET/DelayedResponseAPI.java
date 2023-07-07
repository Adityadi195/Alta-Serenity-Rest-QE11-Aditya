package starter.reqres.GET;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DelayedResponseAPI {
    public static String GET_DELAYED = Constants.BASE_URL + "/api/users?delay={id}";

    @Step("Get delayed Response")
    public void setGetDelayedResponse(int id) {
        SerenityRest.given().pathParam("id", id);
    }
}
