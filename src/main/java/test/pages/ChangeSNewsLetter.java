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


public class ChangeSNewsLetter {
    private WebDriver driver;
    private PageObjectManager pages;
    private GeneralUtilities generalUtilities;
    Scenario scn;
    RuntimeEnvironment runtime;


    public ChangeSNewsLetter(RuntimeEnvironment runtime) {
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
    WebElement ChangeNews_ConfirmButton;

    String NotSubscribedIndicator = "//i[@class='o-titled-icon__icon o-titled-icon_" +
            "_icon--start c-icon c-icon--38 c-icon--cross-red']";



}
