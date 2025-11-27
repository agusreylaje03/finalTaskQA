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
<<<<<<< HEAD
        logger.info("Ejecutando " + uc + ": " + description + " en Thread: " + Thread.currentThread().getName());
=======
        logger.info("Ejecutando " + uc + ": " + description + " en Thread: " + Thread.currentThread().getName());  // ← NUEVO
>>>>>>> e1e481bf313fc39e1877e1bc20b6da47566d1aa9

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
<<<<<<< HEAD

                String usernameError = loginPage.getErrorMessage();
                assertThat("Error message should indicate username is required or invalid credentials",
                        usernameError,
                        anyOf(
                                containsString("Epic sadface: Username is required"),
                                containsString("Epic sadface: Username and password do not match any user in this service")
                        ));
=======
                assertThat("Error message should be 'Username is required'",
                        loginPage.getErrorMessage(), containsString("Username is required"));
>>>>>>> e1e481bf313fc39e1877e1bc20b6da47566d1aa9
                break;

            case "PASSWORD_REQUIRED":
                loginPage.enterUsername(username);
                loginPage.enterPassword("dummy_pass");
                loginPage.clearPassword();
                loginPage.clickLoginButton();
<<<<<<< HEAD

                String passwordError = loginPage.getErrorMessage();
                assertThat("Error message should indicate password is required or invalid credentials",
                        passwordError,
                        anyOf(
                                containsString("Epic sadface: Password is required"),
                                containsString("Epic sadface: Username and password do not match any user in this service")
                        ));
                break;

=======
                assertThat("Error message should be 'Password is required'",
                        loginPage.getErrorMessage(), containsString("Password is required"));
                break;
>>>>>>> e1e481bf313fc39e1877e1bc20b6da47566d1aa9
        }
    }
}
