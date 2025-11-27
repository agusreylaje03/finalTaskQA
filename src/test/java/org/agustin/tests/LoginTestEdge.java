package org.agustin.tests;

import org.agustin.webdriver.WebDriverSingleton;
import org.junit.jupiter.api.BeforeEach;

public class LoginTestEdge extends LoginTest {
    @Override
    @BeforeEach
    public void setUpTest() {
        WebDriverSingleton.setBrowser("edge");
        super.setUpTest();
    }
}
