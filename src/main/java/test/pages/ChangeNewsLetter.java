package test.pages;

import com.Base.Utilities.Browser;
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


public class ChangeNewsLetter {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public ChangeNewsLetter(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH,   xpath = "//div[contains(text(),'Change newsletter settings')]")
    WebElement ChangeNewsLetterSettings_Header;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='receiveEmail' and @value='true']")
    WebElement ChangeNewsLetter_enable;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='receiveEmail' and @value='false']")
    WebElement ChangeNewsLetter_disable;
    @FindBy(how = How.XPATH,   xpath = "//button[contains(text(),'Confirm')]")
    WebElement ChangeNewsLetter_ConfirmButton;
    @FindBy(how = How.XPATH,   xpath = " //i[@class='o-titled-icon__icon o-titled-icon_" +
            "_icon--start c-icon c-icon--38 c-icon--cross-red']")
    WebElement NotSubscribedIndicator;

    @Step("change news letter consent and save")
    public void change_NewsLetterConsent()
    {
        if(generalUtilities.verifyObjectIsDisplayed(NotSubscribedIndicator,driver))
        {
            generalUtilities.clickElement(driver,ChangeNewsLetter_enable,
                    "enable news letter icon");
            Browser.getLogger().info("news letters are enabled..!");
        }
        else {
            generalUtilities.clickElement(driver,ChangeNewsLetter_disable,
                    "disable news letter icon");
            Browser.getLogger().info("news letters are disabled..!");
        }
        generalUtilities.takeScreenSnap("changed_NewsLetter_Settings",scn,driver);
        generalUtilities.clickElement(driver,ChangeNewsLetter_ConfirmButton,"confirm button");
        Browser.getLogger().info("News letter consent change confirmed by clicking on the button..!");
        generalUtilities.waitForSeconds(3);
    }

    @Step("Navigate to Personal Settings -> News Letter consent")
    public void navigate_to_newsLetterConsent()
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
        generalUtilities.clickElement(driver,
                pages.getpersonalSettings().PersonalSettings_ChangeNewsLetterConsent_Button,
                "Change news letter consent button");
        Assert.assertTrue("Change news letter screen is not displayed..!",
                generalUtilities.verifyObjectIsDisplayed(ChangeNewsLetterSettings_Header,driver));
        generalUtilities.takeScreenSnap("NewsLetterConsent_Screen",scn,driver);


    }

    public void newsLetterConsentUpdateSuccess_Validation()
    {
        Assert.assertFalse("Change news letter is not successful. The screen not closed.",
                generalUtilities.verifyObjectIsDisplayed(ChangeNewsLetterSettings_Header, driver));
    }


}
