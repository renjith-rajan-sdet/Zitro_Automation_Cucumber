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


public class LogedIn_homeScreen {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public LogedIn_homeScreen(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }

//    String LoggedIn_homeScreen_CloseAdwheel = "//a[@class='c-wheel__btn-close']";
    @FindBy(how = How.XPATH,   xpath = "//a[@class='c-wheel__btn-close']")
    WebElement LoggedIn_homeScreen_CloseAdwheel;
    @FindBy(how = How.XPATH,   xpath = "//a[contains(text(),'Collect')]")
    WebElement LoggedIn_homeScreen_CollectAllButton;
    @FindBy(how = How.XPATH,   xpath = "//div[@class='c-bar-status__username']")
    WebElement LoggedIn_homeScreen_userName;
    @FindBy(how = How.XPATH,   xpath = "//a[contains(text(),'Personal data')]")
    WebElement LoggedIn_homeScreen_userName_PersonalData;
    @FindBy(how = How.XPATH,   xpath = "//div[contains(text(),'Newsletter & Promotions')]")
    WebElement LoggedIn_homeScreen_NewsLetterAndPromotions_Header;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='receiveEmail' and @value='false']")
    WebElement LoggedIn_homeScreen_NewsLetterAndPromotions_recieveEmail_NO;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='marketingConsent' and @value='false']")
    WebElement LoggedIn_homeScreen_NewsLetterAndPromotions_marketingConsent_NO;
    @FindBy(how = How.XPATH,   xpath = "//button[text()='Confirm']")
    WebElement LoggedIn_homeScreen_NewsLetterAndPromotions_ConfirmButton;

    @Step("validate that the login is successful")
    public void validate_LoggedInScreen_loaded()
    {
        Assert.assertTrue("Login failed..!",
                generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_userName,driver));
//        generalUtilities.waitUntilObjectLoads(driver,LoggedIn_homeScreen_CloseAdwheel,
//                4,"ad wheel");
        while(generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_CollectAllButton,driver)
        ||generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_CloseAdwheel,driver)
        ||generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_NewsLetterAndPromotions_Header,driver))
        {
            handle_Ads_Prompts();
        }

    }

    private void handle_Ads_Prompts()
    {
        if(generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_CollectAllButton,driver))
        {
            generalUtilities.actionsClick(LoggedIn_homeScreen_CollectAllButton,driver,"ad wheel");
        }
        if(generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_CloseAdwheel,driver))
        {
            generalUtilities.actionsClick(LoggedIn_homeScreen_CloseAdwheel,driver,"ad wheel");
        }
        if(generalUtilities.verifyObjectIsDisplayed(LoggedIn_homeScreen_NewsLetterAndPromotions_Header,driver))
        {
            generalUtilities.clickElement(driver,LoggedIn_homeScreen_NewsLetterAndPromotions_recieveEmail_NO,
                    "Receive email -> No");
            generalUtilities.clickElement(driver,LoggedIn_homeScreen_NewsLetterAndPromotions_marketingConsent_NO,
                    "Marketing consent -> No");
            generalUtilities.clickElement(driver,LoggedIn_homeScreen_NewsLetterAndPromotions_ConfirmButton,
                    "News letter consent and promotions -> confirm button");
        }
    }

}
