package org.agustin.pages;

import org.agustin.utils.Config;
import org.agustin.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void navigateToLoginPage() {
        logger.info("Navigating to login page: {}", Config.BASE_URL);
        driver.get(Config.BASE_URL);
    }

    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        WebElement usernameInput = waitUtils.waitForVisibility(usernameField);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password.");
        WebElement passwordInput = waitUtils.waitForVisibility(passwordField);
        passwordInput.sendKeys(password);
    }

    public void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void clearUsername() {
        logger.info("Clearing username input field.");
        waitUtils.waitForVisibility(usernameField).clear();
    }

    public void clearPassword() {
        logger.info("Clearing password input field.");
        waitUtils.waitForVisibility(passwordField).clear();
    }

    public void clickLoginButton() {
        logger.info("Clicking login button.");
        waitUtils.waitForClickable(loginButton).click();
    }

    public String getErrorMessage() {
        logger.info("Retrieving error message.");
        return waitUtils.waitForVisibility(errorMessage).getText();
    }
}
