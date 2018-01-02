package tests;

import PageObjects.LoginPage;
import PageObjects.MailActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObjects.Constants.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginAndSendTest {

        private LoginPage loginPage;
        private MailActions mailActions;

        @BeforeClass(alwaysRun = true)
        public void init() {
            loginPage = new LoginPage();
            mailActions = new MailActions();

            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            driver = new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
        }

        @Test
        public void login() {
            loginPage.setUsername(USERNAME);
            loginPage.clickonNext();
            loginPage.setPassword(PASSWORD);
            loginPage.clickonNextForLogin();
            Assert.assertEquals(loginPage.verifyLogin(), "My Account");
        }

        @Test(dependsOnMethods = "login")
        public void composeMail() {
            loginPage.goToMail();
            mailActions.compose();
            mailActions.setAddress(RECEIVER);
            mailActions.setSubject(SUBJECT);
            mailActions.setContent(CONTENT);
            mailActions.closeItem();
            mailActions.goToFolder("Drafts");
            Assert.assertTrue(mailActions.getItem("test email"));
        }

        @Test(dependsOnMethods = "composeMail")
        public void checkFields() {
            mailActions.clickOnDraftEmail(SUBJECT);
            mailActions.waitForElement();
            Assert.assertEquals( mailActions.getAddress(RECEIVER), RECEIVER, "Invalid receiver");
            Assert.assertEquals( mailActions.getSubject(SUBJECT), SUBJECT, "Invalid subject");
            Assert.assertEquals( mailActions.getContent(), CONTENT,"Invalid content");
        }

        @Test(dependsOnMethods = "checkFields")
        public void send()  {
            mailActions.send();
            mailActions.goToFolder("Sent Mail");
            Assert.assertTrue(mailActions.getItem(SUBJECT));
        }

        @Test(dependsOnMethods = "send")
        public void checkDraft() {
            mailActions.goToFolder("Drafts");
            Assert.assertTrue(mailActions.isDraftEmpty());
        }

        @AfterClass
        public void quit() {
            mailActions.logout();
            driver.quit();
        }
}
