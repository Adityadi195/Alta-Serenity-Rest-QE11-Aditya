package starter.reqres.GET;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

public class SingleResourceAPI {
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";

    @Step("Get single resource")
    public void getSingleResource(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }
}
