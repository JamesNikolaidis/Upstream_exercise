package common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class commonActions {

    WebDriver driver;
    Actions actions;
    wait wait;

    public commonActions(WebDriver driver){
        this.driver = driver;
        actions =new Actions(this.driver);
        wait = new wait(driver);
    }

    public List<WebElement> findElements(By by){
        return this.driver.findElements(by);
    }

    public void clickElement(By by){
        this.wait.waitForElement(by);
        this.driver.findElement(by).click();
    }

    public void fillElement(By by,String text){
        this.wait.waitForElement(by);
        this.driver.findElement(by).sendKeys(text);
    }

    public String getText(By by){
        this.wait.waitForElement(by);
        return this.driver.findElement(by).getText();
    }

}
