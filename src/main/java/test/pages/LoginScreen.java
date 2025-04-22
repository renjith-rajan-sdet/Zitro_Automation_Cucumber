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


public class LoginScreen {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public LoginScreen(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,   xpath = "//header/div/div/div[contains(text(),'Login')]")
    WebElement Login_Header;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='username']")
    WebElement Login_Username;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='password']")
    WebElement Login_Password;
    @FindBy(how = How.XPATH,   xpath = "//button[contains(text(),'Log in')]")
    WebElement Login_Button;


    @Step("login to Game twist using vaid credentials")
    public void loginToGameTwist()
    {
        generalUtilities.clickElement(driver,pages.getHomePage().Login_Button,
                "GameTwist -> Login Button");
        generalUtilities.waitUntilObjectLoads(driver,Login_Header,4,"Login screen");
        Assert.assertTrue("Login page is not loaded..!",
                generalUtilities.verifyObjectIsDisplayed(Login_Header,driver));
        generalUtilities.setText(Login_Username,
                runtime.configurations.envGetData("GameTwist_Nickname")
        ,driver,"Login -> username");
        generalUtilities.setText(Login_Password,
                runtime.configurations.globalGetData("userGeneralPassword")
                ,driver,"Login -> password");
        generalUtilities.clickElement(driver,Login_Button,"login button");
        
    }
}
