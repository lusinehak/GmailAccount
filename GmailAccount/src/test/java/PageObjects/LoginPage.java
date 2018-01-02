package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static PageObjects.Constants.driver;

public class LoginPage {

    public void clickOnMoreOptions() {
        driver.findElement(By.xpath("//*[@class='IMH1vc lUHSR Hj2jlf']")).click();
    }

    public void createAccount() {
        driver.findElement(By.className("jO7h3c")).click();
    }

    public void setUsername(String userName) {
        driver.findElement(By.id("identifierId")).sendKeys(userName);
    }

    public void setPassword(String passwd) {
        List<WebElement> element = driver.findElements(By.name("password"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(element));
        element.get(0).sendKeys(passwd);
    }
    public void clickonNext() {
        driver.findElement(By.id("identifierNext")).click();
    }

    public void clickonNextForLogin() {
        driver.findElement(By.id("passwordNext")).click();
    }
    public String verifyLogin() {
        return driver.findElement(By.className("paz5i")).getText();
    }

    public void goToMail() {
        driver.findElement(By.cssSelector(".WaidBe")).click();
    }
}
