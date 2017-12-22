package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration extends Main {

    public static void setName(String firstName, String lastName) {
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
    }

    public static void chooseUserName(String userName) {

        driver.findElement(By.id("GmailAddress")).sendKeys(userName);
    }

    public static void chooseAndConfirmPasswd(String passdw) {
        driver.findElement(By.id("Passwd")).sendKeys(passdw);
        driver.findElement(By.name("PasswdAgain")).sendKeys(passdw);
    }

    public static void chooseBday(String day, String year) {
        driver.findElement(By.id("BirthDay")).sendKeys(day);
        driver.findElement(By.name("BirthYear")).sendKeys(year);
    }

    public static void setMonth(String month) {
        driver.findElement(By.xpath("//span[@id='BirthMonth']/div")).click();
        driver.findElement(By.xpath("//*[text()='" + month + "']")).click();
    }

    public static void setGender(String gender) {
        driver.findElement(By.xpath("//div[@id=':d']")).click();
        driver.findElement(By.xpath("//*[text()='" + gender + "']")).click();
    }

    public static void submit() {

        driver.findElement(By.id("submitbutton")).click();
    }
}
