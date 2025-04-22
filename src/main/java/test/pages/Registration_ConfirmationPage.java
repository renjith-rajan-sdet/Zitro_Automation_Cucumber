package test.pages;

import com.Base.Utilities.GeneralUtilities;
import com.Runtime.utilities.PageObjectManager;
import com.Runtime.utilities.RuntimeEnvironment;
import io.cucumber.java.Scenario;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Registration_ConfirmationPage {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public Registration_ConfirmationPage(RuntimeEnvironment runtime) {
        this.driver = runtime.driver;
        this.scn = runtime.scn;
        this.pages = runtime.getPage(runtime);
        this.runtime = runtime;
        this.generalUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,   xpath = "//header/div[text()='Confirm your e-mail address']")
    WebElement Registration_Confirmation_Email_Header;
    @FindBy(how = How.XPATH,   xpath = "//input[@name='email']")
    WebElement Registration_Confirmation_Email_Id;

    @FindBy(how = How.XPATH,   xpath = "//div[contains(text(),'Your e-mail address has been confirmed." +
            " You can log in now.')]")
    WebElement Registration_EmailConfirmation_Dialog;



}
