package org.agustin.tests;

import org.agustin.webdriver.WebDriverSingleton;
import org.junit.jupiter.api.BeforeEach;

public class LoginTestFirefox extends LoginTest {
    @Override
    @BeforeEach
    public void setUpTest() {
        WebDriverSingleton.setBrowser("firefox");
        super.setUpTest();
    }
}
