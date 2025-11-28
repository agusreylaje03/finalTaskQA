package org.agustin.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverSingleton {
    private static final Logger log = LoggerFactory.getLogger(WebDriverSingleton.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> browser = new ThreadLocal<>();

    private WebDriverSingleton() {}

    public static void setBrowser(String browserName) {
        log.info("setBrowser llamado con: {} en Thread: {}", browserName, Thread.currentThread().getName());
        browser.set(browserName);
    }

    public static String getBrowserThreadLocal() {
        return browser.get();
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browserName = browser.get();
            if (browserName == null) {
                browserName = System.getProperty("browser", "firefox");
                log.warn("browserThreadLocal era null, usando default: {}", browserName);
            }

            log.info("Initializing WebDriver for browser: {} in Thread: {}", browserName, Thread.currentThread().getName());

            switch (browserName.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.edge.driver", "C:\\Program Files\\_webdrivers\\msedgedriver.exe");
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    //WebDriverManager.edgedriver().setup();
                    System.setProperty("webdriver.edge.driver", "C:\\Program Files\\_webdrivers\\msedgedriver.exe");
                    driver.set(new EdgeDriver());
                    break;
                default:
                    log.warn("Browser {} no soportado, usando Firefox", browserName);
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
            }

            driver.get().manage().window().maximize();
            log.info("WebDriver initialized: {} in Thread: {}", driver.get().getClass().getSimpleName(), Thread.currentThread().getName());
        }
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            log.info("Cerrando WebDriver en Thread: {}", Thread.currentThread().getName());
            try {
                currentDriver.quit();
            } catch (Exception e) {
                log.error("Error al cerrar WebDriver: {}", e.getMessage());
            }
            driver.remove();
            browser.remove();
            log.info("WebDriver cerrado correctamente");
        } else {
            log.info("Se intentó cerrar WebDriver, pero no había instancia");
        }
    }
}
