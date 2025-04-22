package com.Runtime.utilities;

import com.Base.Utilities.Browser;
import com.Base.Utilities.GeneralUtilities;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TempEmail {

    private RuntimeEnvironment runtime;
    private String tempemailUrl = "https://temp-mail.org/en/";
    private GeneralUtilities genUtilities;
    private String emailId;

    public TempEmail(RuntimeEnvironment runtime)
    {
        this.runtime = runtime;
        this.genUtilities = new GeneralUtilities(runtime);
        PageFactory.initElements(runtime.driver, this);
    }

    @FindBy(how = How.XPATH,   xpath = "//input[@data-original-title='Your Temporary Email Address']")
    private WebElement TemperoryEmailAddress;
    @FindBy(how = How.XPATH,   xpath = "//span[@class='inboxSubject subject-title']/a[contains(text(),'GameTwist')]")
    private WebElement TemperoryEmail_MessageSubjectLoaded;
    @FindBy(how = How.XPATH,   xpath = "(//a[contains(text(),'Complete  registration')]/../../../../../../following-sibling::tr/td/a)[1]")
    private WebElement TemperoryEmail_ActivationURL;
    private String originalWindow;
    private String emailGenerationWindow;

    public void generateEmailId()
    {
        emailId = null;
        originalWindow = runtime.driver.getWindowHandle();
        runtime.driver.switchTo().newWindow(WindowType.TAB);
        runtime.driver.get(tempemailUrl);

        genUtilities.waitUntilObjectLoads(runtime.driver,TemperoryEmailAddress,
                10,"Temperory Email address generated for registration");

        genUtilities.waitForSeconds(20);
        emailId = TemperoryEmailAddress.getAttribute("value");
        Browser.getLogger().info("Email id generated : " + emailId);
        emailGenerationWindow = runtime.driver.getWindowHandle();
        runtime.driver.switchTo().window(originalWindow);
    }

    public void Activate_the_User_fromEmail()
    {
        runtime.driver.switchTo().window(emailGenerationWindow);
        genUtilities.waitUntilObjectLoads(runtime.driver,TemperoryEmail_MessageSubjectLoaded,
                20,"Registration confirmation email");
        genUtilities.waitForSeconds(20);
        genUtilities.actionsClick(TemperoryEmail_MessageSubjectLoaded,runtime.driver,
                "Activation email after registration");
        genUtilities.waitUntilObjectLoads(runtime.driver,TemperoryEmail_ActivationURL,
                20,"Registration confirmation email content");
        genUtilities.waitForSeconds(20);
        String activationUrl = TemperoryEmail_ActivationURL.getDomAttribute("href");
        if(activationUrl == null)
        {
            Assert.fail("Activation url not found in the email.");
        }
        genUtilities.takeScreenSnap_FullScroll("emailVerification",runtime.scn, runtime.driver);
        runtime.driver.switchTo().newWindow(WindowType.TAB);
        runtime.driver.get(activationUrl);
        genUtilities.waitForSeconds(10);
        genUtilities.takeScreenSnap_FullScroll("activation_Confirmation",runtime.scn, runtime.driver);
        runtime.driver.close();
        runtime.driver.switchTo().window(originalWindow);
    }

    public void flush_Email()
    {
        runtime.driver.switchTo().window(emailGenerationWindow);
        runtime.driver.close();
        runtime.driver.switchTo().window(originalWindow);
    }
    public String get_EmailId_Registered()
    {
        return emailId;
    }
}
