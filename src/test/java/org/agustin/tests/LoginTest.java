package org.agustin.tests;

import org.agustin.base.BaseTest;
import org.agustin.data.LoginDataProvider;
import org.agustin.pages.DashboardPage;
import org.agustin.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        super.setUp();
        logger.info("========================================");
        logger.info("Thread ID: {}", Thread.currentThread().getId());  // ← NUEVO
        logger.info("Thread Name: {}", Thread.currentThread().getName());  // ← NUEVO
        logger.info("Browser: {}", System.getProperty("browser", "firefox"));
        logger.info("========================================");
    }

    @ParameterizedTest(name = "{0}: {4}")
    @MethodSource("org.agustin.data.LoginDataProvider#loginData")
    public void testLoginScenarios(String uc, String username, String password,
                                   String expectedResult, String description) {
        logger.info("Ejecutando " + uc + ": " + description + " en Thread: " + Thread.currentThread().getName());  // ← NUEVO

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        switch (expectedResult) {
            case "SUCCESS":
                loginPage.performLogin(username, password);
                DashboardPage dashboard = new DashboardPage(driver);
                assertThat("Login should be successful and show 'Swag Labs' title",
                        dashboard.getTitle(), is("Swag Labs"));
                break;

            case "USERNAME_REQUIRED":
                loginPage.enterUsername("dummy_user");
                loginPage.enterPassword("dummy_pass");
                loginPage.clearUsername();
                loginPage.clearPassword();
                loginPage.clickLoginButton();
                assertThat("Error message should be 'Username is required'",
                        loginPage.getErrorMessage(), containsString("Username is required"));
                break;

            case "PASSWORD_REQUIRED":
                loginPage.enterUsername(username);
                loginPage.enterPassword("dummy_pass");
                loginPage.clearPassword();
                loginPage.clickLoginButton();
                assertThat("Error message should be 'Password is required'",
                        loginPage.getErrorMessage(), containsString("Password is required"));
                break;
        }
    }
}
