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



public class HomePage {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public HomePage(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,   xpath = "//a[text()='Login']")
    WebElement Login_Button;
    @FindBy(how = How.XPATH,   xpath = "//a[text()='Register']")
    WebElement Register_Button;
    @FindBy(how = How.XPATH,   xpath = "//a/img[@title='GameTwist Online Casino']")
    WebElement GameTwist_logo;
    @FindBy(how = How.XPATH,   xpath = "//button[contains(text(),'Accept All Cookies')]")
    WebElement GameTwist_AcceptAllCookies;

    @Step("validate that the Game Twist home screen is loaded...!")
    public void validate_HomeScreen_loaded()
    {
        Assert.assertTrue("Failed to load the home page of Game Twist",
                generalUtilities.verifyObjectIsDisplayed(GameTwist_logo,driver));
        generalUtilities.takeScreenSnap("GameTwist_HomeScreen",scn,driver);
        scn.log("Home screen loaded successfully");
        if(generalUtilities.verifyObjectIsDisplayed(GameTwist_AcceptAllCookies,driver))
        {
            generalUtilities.clickElement(driver,GameTwist_AcceptAllCookies,"Accept all cookies");
            generalUtilities.waitForSeconds(5);
        }
    }

}
