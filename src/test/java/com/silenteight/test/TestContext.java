package com.silenteight.test;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {

    private static boolean initialized = false;

    private WebDriver testWebDriver;
    private WebDriverWait webWait;

    @Before
    public void setUp() throws Exception {
        if (!initialized) {
            // initialize the driver
            //System.setProperty("webdriver.gecko.driver", "C:\\Tools\\WebDrivers\\geckodriver.exe");
            //testWebDriver = new FirefoxDriver();

            System.setProperty("webdriver.chrome.driver", "C:\\Tools\\WebDrivers\\chromedriver.exe");
            testWebDriver = new ChromeDriver();

            webWait = new WebDriverWait(testWebDriver, 60);
            initialized = true;
        }
    }

    public WebDriver getDriver() {
        return testWebDriver;
    }

    public WebDriverWait getWebWait() {
        return webWait;
    }
}
