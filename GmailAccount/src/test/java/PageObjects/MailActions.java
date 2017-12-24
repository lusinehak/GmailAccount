package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MailActions extends Main {
    WebElement element;

    public void compose() {
        try {
            element = driver.findElement(By.xpath("//*[contains(@class, 'T-I-KE')]"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void setAddress(String addr) {
        try {
            element = driver.findElement(By.name("to"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.sendKeys(addr);
    }

    public void setSubject(String subject) {
        try {
            element = driver.findElement(By.name("subjectbox"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.sendKeys(subject);
    }

    public void setContent(String content) {
        try {
            element = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.sendKeys(content);
    }

    public void goToFolder(String name) {
        try {
            element = driver.findElement(By.xpath("//a[contains(@title, '" + name + "')]"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public boolean getItem(String name) {
        try {
            element = driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element.isDisplayed();
    }

    public void clockOnDraftEmail(String name) {
        try {
            element = driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void send() {
        try {
            element = driver.findElement(By.xpath("//div[text()='Send']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public String getAddress(String mail){
        try {
            element = driver.findElement(By.xpath("//span[contains(text(),'" + mail + "')]"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element.getText();
    }

    public String getSubject(String text) {
        try {
            element = driver.findElement(By.xpath("//input[@name='subject']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element.getAttribute("value").toString();
    }

    public String getContent() {
        try {
            element = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element.getText();
    }

    public void closeItem() {
        try {
            element = driver.findElement(By.xpath("//img[@aria-label='Save & Close']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void logout() {
        driver.findElement(By.xpath("//span[@class='gb_ab gbii']")).click();
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
    }
}
