import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Locale;
import java.util.logging.Logger;

public class driverFactory {



    public driverFactory(){

    }

    public WebDriver getWebDriver (String browser,WebDriver driver){
        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome":
                return (driver==null) ? this.getChromeDriver() : driver;
            case "firefox":
                return (driver==null) ? this.getFirefoxDriver() : driver;
            case "edge":
                return (driver==null) ? this.getEdgeDriver() : driver;
            default:
                Logger.getLogger(this.getClass().getName()).warning("The selected browser "+browser.toLowerCase(Locale.ROOT)+
                        "is not supported.\n Starting Chrome Browser");
                return (driver==null) ? this.getChromeDriver() : driver;
        }
    }

    public void closeBrowser(WebDriver driver){
        if(driver!=null){
            driver.quit();
        }
    }



    private WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-start-maximized");
        return new ChromeDriver(options);

    }

    private WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-start-maximized");
        return new FirefoxDriver();
    }

    private WebDriver getEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

}
