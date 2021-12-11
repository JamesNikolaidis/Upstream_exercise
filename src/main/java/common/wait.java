package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class wait {

    WebDriver driver;
    WebDriverWait wait;

    public wait(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5000);
    }

    public void waitFor(Integer millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(By by){
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPageToLoad(){
        wait.pollingEvery(500,TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ot-sdk-row")));
    }


}
