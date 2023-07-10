package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with special character parameter {}")
    public void deleteUserWithSpecialCharacterParameter(String chara) {
        reqresAPI.deleteUserChar(chara);
    }
    @When("Send request delete user with char")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_DELAYED_CHAR);
    }

}
