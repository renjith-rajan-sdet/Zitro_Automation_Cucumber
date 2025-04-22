package test.pages;

import com.Base.Utilities.GeneralUtilities;
import com.Runtime.utilities.PageObjectManager;
import com.Runtime.utilities.RuntimeEnvironment;
import io.cucumber.java.Scenario;
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


}
