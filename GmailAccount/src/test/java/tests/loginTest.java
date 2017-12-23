package tests;

import PageObjects.LoginPage;
import PageObjects.MailActions;
import PageObjects.Main;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTest extends Main{

    private LoginPage lp;
    private MailActions ma;

    @BeforeClass(alwaysRun = true)
    public void init() {
        lp = new LoginPage();
        ma = new MailActions();

        System.setProperty("webdriver.chrome.driver", "/home/lusine/Downloads/chromedriver");

        lp.driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        lp.setUsername(USERNAME);
        lp.clickonNext();
        Thread.sleep(1000);
        lp.setPassword(PASSWORD);
        lp.clickonNextForLogin();
        Assert.assertEquals(lp.verifyLogin(), "My Account");
    }

    @Test(dependsOnMethods = "login")
    public void composeMail() {
        lp.goToMail();
        ma.compose();
        ma.setAddress(RECEIVER);
        ma.setSubject(SUBJECT);
        ma.setContent(CONTENT);
        ma.closeItem();
        ma.goToFolder("Drafts");
        Assert.assertTrue(ma.getItem("test email"));
    }

    @Test(dependsOnMethods = "composeMail")
    public void checkFields() {
        ma.clockOnDraftEmail(SUBJECT);
        Assert.assertEquals( ma.getAddress(RECEIVER), RECEIVER, "Invalid receiver");
        Assert.assertEquals( ma.getSubject(SUBJECT), SUBJECT, "Invalid subject");
        Assert.assertEquals( ma.getContent(), CONTENT,"Invalid content");
    }

    @Test(dependsOnMethods = "checkFields")
    public void send() throws InterruptedException {
        ma.send();
        ma.goToFolder("Sent Mail");
        Assert.assertTrue(ma.getItem(SUBJECT));
    }

    @Test(dependsOnMethods = "send")
    public void checkDraft() throws InterruptedException {
        Thread.sleep(10000);
        ma.goToFolder("Drafts");
        Assert.assertFalse(ma.getItem(SUBJECT));
    }

    @AfterClass
    public void quit() {
        ma.logout();
        driver.quit();
    }
}
