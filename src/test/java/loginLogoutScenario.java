import common.propertiesData;
import org.testng.annotations.Parameters;
import toolsQAPage.toolsQA;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginLogoutScenario {

    WebDriver driver = null;
    driverFactory driverFactory;
    toolsQA toolsQA =null;
    propertiesData data =null;

    @Parameters("browser")
    @BeforeTest
    public void initDriver(String browser){
        driverFactory =new driverFactory();
        data = propertiesData.getPropertiesData();
        driver = driverFactory.getWebDriver(browser,driver);
        toolsQA = new toolsQA(driver);
        driver.get(toolsQAPage.toolsQA.TOOLS_QA_SCORE_URL);
    }


    @Test(priority=1)
    public void loginToApplication(){
            this.toolsQA
                    .clickBookStoreLoginButton()
                    .addCredentials()
                    .clickLoginButton()
                    .verifyUserHasLogin();
    }

    @Test(priority=2)
    public void logOutFromApplication(){
            this.toolsQA
                    .clickLogOutButton()
                    .verifyUserHasLogOut();
    }


    @AfterTest
    public void closeBrowser(){
        this.driverFactory.closeBrowser(driver);
    }

}
