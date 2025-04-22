package StepDefinitions;

import com.Runtime.utilities.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameTwist_Steps{

    private final BaseSteps baseSteps;

    public GameTwist_Steps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @When("GameTwist home screen is loaded")
    public void gametwistHomeScreenIsLoaded() {
        baseSteps.runtime.pages.getHomePage().validate_HomeScreen_loaded();
    }

    @Then("Register a new user and record the user credentials")
    public void registerANewUserAndRecordTheUserCredentials() {
        baseSteps.runtime.pages.getRegistrationPage().Register_user();
    }

    @And("activate the user from the email received")
    public void activateTheUserFromTheEmailreceived() {

        baseSteps.runtime.pages.getRegistrationPage().activate_TheCreatedUser();

    }

    @Then("login using the created credentials")
    public void loginUsingTheCreatedCredentials() {
        
    }

    @And("navigate to personal data -> security question")
    public void navigateToPersonalDataSecurityQuestion() {
        
    }

    @Then("update the security question and answer -> save the changes")
    public void updateTheSecurityQuestionAndAnswerSaveTheChanges() {
        
    }

    @And("validate that the security question change is successful")
    public void validateThatTheSecurityQuestionChangeIsSuccessful() {
        
    }

    @And("navigate to personal data -> newsletter consent")
    public void navigateToPersonalDataNewsletterConsent() {
        
    }

    @Then("update the newsletter consent and answer -> save the changes")
    public void updateTheNewsletterConsentAndAnswerSaveTheChanges() {
        
    }

    @And("validate that the newsletter consent change is successful")
    public void validateThatTheNewsletterConsentChangeIsSuccessful() {
    }
}
