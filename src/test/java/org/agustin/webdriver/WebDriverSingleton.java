package org.agustin.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
<<<<<<< HEAD
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
=======

public class WebDriverSingleton {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver(){
        if (driverThreadLocal.get() == null) {
            String browser = System.getProperty("browser", "edge").toLowerCase();
            WebDriver driver;

            switch (browser) {
                case "edge":
                    WebDriverManager.edgedriver()
                            .avoidBrowserDetection()
                            .clearDriverCache()
                            .setup();
>>>>>>> e1e481bf313fc39e1877e1bc20b6da47566d1aa9
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
<<<<<<< HEAD
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            logger.info("Cerrando WebDriver en Thread: {}", Thread.currentThread().getName());
            driver.quit();
            driverThreadLocal.remove();
            browserThreadLocal.remove();
=======
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
>>>>>>> e1e481bf313fc39e1877e1bc20b6da47566d1aa9
        }
    }
}
