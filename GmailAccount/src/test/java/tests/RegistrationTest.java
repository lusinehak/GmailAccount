package tests;

import PageObjects.LoginPage;
import PageObjects.Registration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends Registration {
    private LoginPage lp;

    @BeforeClass(alwaysRun = true)
    public void init() {
        lp  =new LoginPage();

        System.setProperty("webdriver.chrome.driver", "/home/lusine/Downloads/chromedriver");

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        lp.clickOnMoreOptions();
        Thread.sleep(1000);
        lp.createAccount();
        setName("test", "usser");
        chooseUserName("AAAAAAAAtestemail1");
        chooseAndConfirmPasswd("testcase1");
        chooseBday("11", "1987");
        setMonth("July");
        setGender("Female");
        Thread.sleep(1000);
        submit();
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
