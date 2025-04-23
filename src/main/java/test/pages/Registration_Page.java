package test.pages;

import com.Base.Utilities.GeneralUtilities;
import com.Runtime.utilities.PageObjectManager;
import com.Runtime.utilities.RuntimeEnvironment;
import com.Runtime.utilities.TempEmail;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Registration_Page {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;
    String registeredEmailId;


    public Registration_Page(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,   xpath = "//header//div[text()='Registration']")
    WebElement Registration_Page_Header;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='email']")
    WebElement Registration_Email;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='nickname']")
    WebElement Registration_nickName;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='password']")
    WebElement Registration_Password;
     @FindBy(how = How.XPATH,   xpath = "//select[@name='day']")
    WebElement Registration_DOB_Day;
    @FindBy(how = How.XPATH,   xpath = "//select[@name='month']")
    WebElement Registration_DOB_month;
    @FindBy(how = How.XPATH,   xpath = "//select[@name='year']")
    WebElement Registration_DOB_year;
    @FindBy(how = How.XPATH,   xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement Registration_Captcha_ImNotARobot;
    @FindBy(how = How.XPATH,   xpath = "//input[@id='termsAccept']")
    WebElement Registration_TermsAgreement_Checkbox;
    @FindBy(how = How.XPATH,   xpath = "//button[text()='Begin adventure']")
    WebElement Registration_Register_BeginAdventure_Button;
    TempEmail tempemail;


    @Step("Register new user")
    public void Register_user()
    {
        String nickname = RandomStringUtils.randomAlphabetic(10);
        this.tempemail = new TempEmail(runtime);
        tempemail.generateEmailId();
        generalUtilities.clickElement(driver,pages.getHomePage().Register_Button
                ,"Register button from Home screen");
        generalUtilities.waitUntilObjectLoads(driver,Registration_Page_Header,
                10,"Register new user screen");
        generalUtilities.waitForSeconds(5);
        generalUtilities.setText(Registration_Email,
                tempemail.get_EmailId_Registered(),driver,"Email id");
        generalUtilities.setText(Registration_nickName,
                nickname,driver,"Nick Name");
        generalUtilities.setText(Registration_Password,
                runtime.configurations.globalGetData("userGeneralPassword"),driver,"Password");
        generalUtilities.Select_dropdown_Value(Registration_DOB_Day,"1","DOB Day");
        generalUtilities.Select_dropdown_Text(Registration_DOB_month,"April","DOB Month");
        generalUtilities.Select_dropdown_Value(Registration_DOB_year,"1988","DOB Year");

//        generalUtilities.actionsClick(Registration_Captcha_ImNotARobot,driver,"Captcha");

        generalUtilities.waitForSeconds(10);
        generalUtilities.actionsClick(Registration_TermsAgreement_Checkbox,driver,"Agree to terms");
        generalUtilities.waitForSeconds(2);
        generalUtilities.takeScreenSnap_FullScroll("registration_UserDataFilled",scn,driver);
        generalUtilities.waitForSeconds(2);
        generalUtilities.actionsClick(Registration_Register_BeginAdventure_Button,driver,"Complete registration button");
        generalUtilities.waitUntilObjectLoads(driver,pages.getRegistrationConfirmationPage().Registration_Confirmation_Email_Header,
                10,"Registration confirmation screen");
        Assert.assertTrue("Registration confirmation screen is not loaded..!",
                generalUtilities.verifyObjectIsDisplayed(pages.getRegistrationConfirmationPage()
                        .Registration_Confirmation_Email_Header,driver));
        generalUtilities.takeScreenSnap("registration_Confirmation",scn,driver);
        registeredEmailId = tempemail.get_EmailId_Registered();
        runtime.configurations.update_EnvData("GameTwist_userName",registeredEmailId);
        runtime.configurations.update_EnvData("GameTwist_Nickname",nickname);
//        tempemail.Activate_the_User_fromEmail();
    }

    @Step("Activate the user created from the email sent from Game Twist")
    public void activate_TheCreatedUser()
    {
        tempemail.Activate_the_User_fromEmail();
    }

}
