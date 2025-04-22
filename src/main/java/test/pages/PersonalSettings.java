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


public class PersonalSettings {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public PersonalSettings(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH,   xpath = "//h1[text()='Personal settings']")
    WebElement PersonalSettings_Header;
    @FindBy(how = How.XPATH,   xpath = "//button[text()='Change security question']")
    WebElement PersonalSettings_ChangeSecurityQuestion_Button;
    @FindBy(how = How.XPATH,   xpath = "//button[@class='c-btn c-btn--secondary c-btn--sm c-btn--block o-ellipsis js-newsletterModalBtn']")
    WebElement PersonalSettings_ChangeNewsLetterConsent_Button;
    @FindBy(how = How.XPATH,   xpath = "//td[text()='Newsletter']/following-sibling::td")
    WebElement PersonalSettings_ChangeNewsLetterConsent_Status;

}
