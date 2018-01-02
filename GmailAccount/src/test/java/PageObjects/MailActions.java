package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static PageObjects.Constants.driver;

public class MailActions {

    public void compose() {
        driver.findElement(By.xpath("//*[contains(@class, 'T-I-KE')]")).click();
    }

    public void setAddress(String addr) {
        driver.findElement(By.name("to")).sendKeys(addr);
    }

    public void setSubject(String subject) {
        driver.findElement(By.name("subjectbox")).sendKeys(subject);
    }

    public void setContent(String content) {
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(content);
    }

    public void goToFolder(String name) {
        List<WebElement> element = driver.findElements(By.xpath("//a[contains(@title, '" + name + "')]"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(element));
        element.get(0).click();
    }

    public boolean getItem(String name) {
        return driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]")).isDisplayed();
    }

    public void clickOnDraftEmail(String name) {
        List<WebElement> element = driver.findElements(By.xpath("//span[contains(text(), '" + name + "')]"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(element));
        element.get(0).click();
    }

    public void send() {
        driver.findElement(By.xpath("//div[text()='Send']")).click();
    }

    public String getAddress(String mail){
       return driver.findElement(By.xpath("//span[contains(text(),'" + mail + "')]")).getText();
    }

    public String getSubject(String text) {
        return driver.findElement(By.xpath("//input[@name='subject']")).getAttribute("value").toString();
    }

    public String getContent() {
        return driver.findElement(By.xpath("//div[@aria-label='Message Body']")).getText();
    }

    public void closeItem() {
        driver.findElement(By.xpath("//img[@aria-label='Save & Close']")).click();
    }

    public void waitForElement() {
        List<WebElement> element = driver.findElements(By.xpath("//div[@class='nH Hd']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public boolean isDraftEmpty() {
        return driver.findElement(By.xpath("//td[@class='TC']")).isDisplayed();
    }
    public void logout() {
        driver.findElement(By.xpath("//span[@class='gb_ab gbii']")).click();
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
    }
}
