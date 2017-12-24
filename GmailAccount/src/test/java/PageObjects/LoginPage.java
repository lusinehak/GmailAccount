package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends Main {
    WebElement element;
    public void clickOnMoreOptions() {
        try {
            element = driver.findElement(By.xpath("//*[@class='IMH1vc lUHSR Hj2jlf']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void createAccount() {
        try {
            element = driver.findElement(By.className("jO7h3c"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void setUsername(String userName) {
        try {
            element = driver.findElement(By.id("identifierId"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.sendKeys(userName);
    }

    public void setPassword(String passwd) {
        try {
            element = driver.findElement(By.name("password"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.sendKeys(passwd);
    }
    public void clickonNext() {
        try {
            element = driver.findElement(By.id("identifierNext"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void clickonNextForLogin() {
        try {
            element = driver.findElement(By.id("passwordNext"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }
    public String verifyLogin() {
        try {
            element = driver.findElement(By.className("paz5i"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element.getText();
    }

    public void goToMail() {
        try {
            element = driver.findElement(By.cssSelector(".WaidBe"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }
}
