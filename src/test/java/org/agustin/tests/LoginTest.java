package org.agustin.tests;

import org.agustin.base.BaseTest;
import org.agustin.pages.DashboardPage;
import org.agustin.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class LoginTest extends BaseTest {

    @ParameterizedTest(name = "{0}: {4}")
    @MethodSource("org.agustin.data.LoginDataProvider#loginData")
    public void testLoginScenarios(String uc, String username, String password,
                                   String expectedResult, String description) {
        logger.info("Ejecutando " + uc + ": " + description + " en Thread: " + Thread.currentThread().getName());

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

                String usernameError = loginPage.getErrorMessage();
                assertThat("Error message should indicate username is required or invalid credentials",
                        usernameError,
                        anyOf(
                                containsString("Epic sadface: Username is required"),
                                containsString("Epic sadface: Username and password do not match any user in this service")
                        ));
                break;

            case "PASSWORD_REQUIRED":
                loginPage.enterUsername(username);
                loginPage.enterPassword("dummy_pass");
                loginPage.clearPassword();
                loginPage.clickLoginButton();

                String passwordError = loginPage.getErrorMessage();
                assertThat("Error message should indicate password is required or invalid credentials",
                        passwordError,
                        anyOf(
                                containsString("Epic sadface: Password is required"),
                                containsString("Epic sadface: Username and password do not match any user in this service")
                        ));
                break;
        }
    }
}
