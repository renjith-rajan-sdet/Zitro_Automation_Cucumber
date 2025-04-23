package test.pages;

import com.Base.Utilities.GeneralUtilities;
import com.Runtime.utilities.PageObjectManager;
import com.Runtime.utilities.RuntimeEnvironment;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ChangeSecurityQuestion {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public ChangeSecurityQuestion(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH,   xpath = "//div[contains(text(),'Change security question')]")
    WebElement ChangeSecurityQuestion_Header;
    @FindBy(how = How.XPATH,   xpath = "//select[@name='security-question']")
    WebElement SecutiryQuestion_dropDown;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='security-answer']")
    WebElement SecutiryAnswer;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='new-password']")
    WebElement password;
    @FindBy(how = How.XPATH,   xpath = "//button[text()='Save changes']")
    WebElement SaveChanges_Button;
    @FindBy(how = How.XPATH,   xpath = "//div[text()='The security question and answer have been changed.']")
    WebElement saveConfirmation;

    @Step("Navigate to Personal Settings -> change security question")
    public void navigate_to_changeSecurityQuestion()
    {
        generalUtilities.clickElement(driver,
                pages.getloggedInScreenPage().LoggedIn_homeScreen_userName,
                "User name icon on top right corner");
        generalUtilities.clickElement(driver,
                pages.getloggedInScreenPage().LoggedIn_homeScreen_userName_PersonalData,
                "Personal Data icon");
        Assert.assertTrue("Personal Settings screen is not opened...!",
                generalUtilities.verifyObjectIsDisplayed(
                        pages.getpersonalSettings().PersonalSettings_Header,driver));

        generalUtilities.clickElement(driver,pages.getpersonalSettings().
                PersonalSettings_ChangeSecurityQuestion_Button,
                "change security question button");
        Assert.assertTrue("Change security question screen is not loaded..!",
                generalUtilities.verifyObjectIsDisplayed(ChangeSecurityQuestion_Header,driver));

    }

    @Step("change security question and save changes")
    public void change_SecurityQuestionAndSaveChanges()
    {
        Assert.assertTrue("Change security question screen is not loaded..!",
                generalUtilities.verifyObjectIsDisplayed(ChangeSecurityQuestion_Header,driver));

        generalUtilities.Select_dropdown_Text(SecutiryQuestion_dropDown,
                "What is the make of your first car?",
                "Security question selection drop down");
        generalUtilities.setText(SecutiryAnswer,"Suzuki",driver,
                "security answer");
        generalUtilities.setText(password,runtime.configurations.
                globalGetData("userGeneralPassword"),driver,
                "Password to update security question");
        generalUtilities.clickElement(driver,SaveChanges_Button,"Save changes button");


    }

    public void validate_Security_QuestionChangeSuccessful()
    {
        Assert.assertTrue("Security question saved confirmation message not displayed..!",
                generalUtilities.verifyObjectIsDisplayed(saveConfirmation,driver));
        generalUtilities.takeScreenSnap("saveConfirmation",scn,driver);
    }
}
