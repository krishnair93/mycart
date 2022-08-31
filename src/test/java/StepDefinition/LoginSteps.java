package StepDefinition;

import cucumber.api.java.en.Given;
import driverfactory.DriverFactory;

public class LoginSteps {

    @Given("^I have navigated to application$")
    public void iHaveNavigatedToApplication() {
        DriverFactory.getDriver().get("https://qalegend.com/billing/public/login");

    }

}
