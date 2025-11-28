package org.agustin.base;

import org.agustin.webdriver.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final long INTER_TEST_PAUSE_MS = 3000;

    // Ya NO tiene @BeforeEach
    protected void setUpTest() {
        driver = WebDriverSingleton.getDriver();
        logger.info("========================================");
        logger.info("Thread ID: {}", Thread.currentThread().getId());
        logger.info("Thread Name: {}", Thread.currentThread().getName());
        logger.info("Browser: {}", WebDriverSingleton.getBrowserThreadLocal());
        logger.info("========================================");
    }

    @AfterEach
    public void tearDown() {
        if (INTER_TEST_PAUSE_MS > 0) {
            logger.info("Esperando {} ms antes del siguiente test...", INTER_TEST_PAUSE_MS);
            try {
                Thread.sleep(INTER_TEST_PAUSE_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn("Pausa interrumpida: {}", e.getMessage());
            }
        }

        WebDriverSingleton.quitDriver();
        logger.info("WebDriver cerrado");
    }
}
