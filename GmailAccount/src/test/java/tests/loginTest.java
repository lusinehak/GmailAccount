package tests;

import PageObjects.LoginPage;
import PageObjects.MailActions;
import PageObjects.Main;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class loginTest extends Main{

    private LoginPage lp;
    private MailActions ma;

    @BeforeClass(alwaysRun = true)
    public void init() {
        lp = new LoginPage();
        ma = new MailActions();

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        lp.driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Test
    public void login() {
        lp.setUsername(USERNAME);
        lp.clickonNext();
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
    public void send()  {
        ma.send();
        ma.goToFolder("Sent Mail");
        Assert.assertTrue(ma.getItem(SUBJECT));
    }

    @Test(dependsOnMethods = "send")
    public void checkDraft() throws InterruptedException {
        /*Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                String name = "Drafts";
                WebElement element = driver.findElement(By.xpath("//a[contains(@title, '" + name + "')]"));
                return  element;
            }
        });*/
        Thread.sleep(1000);
        ma.goToFolder("Drafts");
        Assert.assertFalse(ma.getItem(SUBJECT));
    }

    @AfterClass
    public void quit() {
        ma.logout();
        driver.quit();
    }
}
