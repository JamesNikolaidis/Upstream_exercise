package toolsQAPage;

import org.openqa.selenium.By;

public class toolsQAElements {

    public static final By LOGIN_BUTTON = By.id("login");

    //ToolsQA login form

    public static final By USERNAME_INPUT = By.id("userName");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_TO_APPLICATION_BUTTON = By.cssSelector("#userForm #login");


    //Tools QA elements after login

    public static final By LOGGED_IN_USERNAME_LABEL = By.id("userName-value");
    public static final By LOG_OUT_BUTTON = By.id("submit");




}
