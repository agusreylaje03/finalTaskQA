package org.agustin.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverSingleton {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverSingleton.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> browserThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {}

    public static void setBrowser(String browser) {
        browserThreadLocal.set(browser);
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String browser = browserThreadLocal.get();
            if (browser == null) {
                browser = System.getProperty("browser", "firefox").toLowerCase();
            }

            logger.info("Creando WebDriver para browser: {} en Thread: {}", browser, Thread.currentThread().getName());

            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Program Files\\_webdrivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }

            driver.manage().window().maximize();
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            logger.info("Cerrando WebDriver en Thread: {}", Thread.currentThread().getName());
            driver.quit();
            driverThreadLocal.remove();
            browserThreadLocal.remove();
        }
    }
}
