package PageObjects;

import org.openqa.selenium.By;

public class LoginPage extends Main {
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

        driver.findElement(By.xpath("//*[@class='whsOnd zHQkBf']")).sendKeys(passwd);
    }
    public void clickonNext() {

        driver.findElement(By.id("identifierNext")).click();
    }
    public void clickonNextForLogin() {

        driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
    }
    public String verifyLogin() {

        return driver.findElement(By.className("paz5i")).getText();
    }

    public void goToMail() {

        driver.findElement(By.cssSelector(".WaidBe")).click();
    }
}
