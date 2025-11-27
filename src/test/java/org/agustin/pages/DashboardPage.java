package org.agustin.pages;

import org.agustin.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage {
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By titleLocator = By.xpath("//div[@class='app_logo']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getTitle() {
        logger.info("Retrieving dashboard title text.");
        return waitUtils.waitForVisibility(titleLocator).getText();
    }
}
