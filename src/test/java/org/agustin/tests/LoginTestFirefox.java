package org.agustin.tests;

import org.agustin.webdriver.WebDriverSingleton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LoginTestFirefox extends LoginTest {

    @BeforeEach
    public void setUpBrowser() {
        WebDriverSingleton.setBrowser("firefox");
        super.setUpTest();
    }
}
