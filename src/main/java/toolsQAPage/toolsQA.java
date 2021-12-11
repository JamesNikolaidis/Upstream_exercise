package toolsQAPage;

import common.commonActions;
import common.propertiesData;
import common.wait;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import java.util.logging.Logger;

public class toolsQA {

    public static final String TOOLS_QA_SCORE_URL = "https://demoqa.com/books";

    commonActions commonActions;
    wait wait;
    Logger logger;
    propertiesData data;
    SoftAssert softAssert;

    public toolsQA(WebDriver driver){
        commonActions =new commonActions(driver);
        wait = new wait(driver);
        logger = Logger.getLogger(this.getClass().getName());
        data = propertiesData.getPropertiesData();
        softAssert = new SoftAssert();
    }

    public toolsQA clickBookStoreLoginButton(){
        this.commonActions.clickElement(toolsQAElements.LOGIN_BUTTON);
        return this;
    }

    public toolsQA addCredentials() {
        this.commonActions.fillElement(toolsQAElements.USERNAME_INPUT,this.data.getLoginUsername());
        this.commonActions.fillElement(toolsQAElements.PASSWORD_INPUT,this.data.getLoginPassword());
        return this;
    }

    public toolsQA clickLoginButton() {
        this.commonActions.clickElement(toolsQAElements.LOGIN_TO_APPLICATION_BUTTON);
        return this;
    }

    public toolsQA clickLogOutButton(){
        this.commonActions.clickElement(toolsQAElements.LOG_OUT_BUTTON);
        return this;
    }


    public void verifyUserHasLogin() {
        String loggedInUser = this.commonActions.getText(toolsQAElements.LOGGED_IN_USERNAME_LABEL);
        this.softAssert.assertEquals(loggedInUser,this.data.getLoginUsername());
        this.softAssert.assertAll("The username in the application doesn't match" );
    }

    public void verifyUserHasLogOut(){
        //Check if the element that displays the username of the logged-in user is visible
        this.softAssert.assertTrue(this.commonActions.findElements(toolsQAElements.LOGGED_IN_USERNAME_LABEL).size()==0);
        //Check that the Log-out button is not visible
        this.softAssert.assertTrue(this.commonActions.findElements(toolsQAElements.LOG_OUT_BUTTON).size()==0);
        //Check that the login button is visible and also the elements of the login form
        this.softAssert.assertTrue(this.commonActions.findElements(toolsQAElements.LOGIN_TO_APPLICATION_BUTTON).size()>0);
        this.softAssert.assertTrue(this.commonActions.findElements(toolsQAElements.USERNAME_INPUT).size()>0);
        this.softAssert.assertTrue(this.commonActions.findElements(toolsQAElements.PASSWORD_INPUT).size()>0);

        this.softAssert.assertAll();
    }
}
