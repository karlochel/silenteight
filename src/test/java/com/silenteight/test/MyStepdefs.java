package com.silenteight.test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver testWebDriver;
    WebDriverWait webWait;

    private TestContext testContext;

    public MyStepdefs (TestContext testContext) {
        this.testContext=testContext;
    }

    @Given("^Logged to Silenteight application$")
    public void logged_to_silenteight_application () throws Throwable {
        try {
            testWebDriver=testContext.getDriver();
            webWait=testContext.getWebWait();
            testWebDriver.get("https://sens.silenteight.com");
            WebElement usernameText=webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='username']")));
            usernameText.sendKeys("tester@silenteight.com");
            WebElement passwordText=webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
            //testWebDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            passwordText.sendKeys("cS4aVcEfNP");
            WebElement loginButton=webWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submit-button']")));
            //testWebDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            loginButton.click();
        } catch (Exception ex) {
            throw ex;
        }

    }


    @Given("^Opened browser$")
    public void openedBrowser() throws Throwable {
        try {
            testWebDriver=testContext.getDriver();
        } catch (Exception ex) {
            throw ex;
        }
    }


    @When("^Create new decision tree$")
    public void createNewDecisionTree() throws Throwable {
        try{
            testWebDriver=testContext.getDriver();
            webWait=testContext.getWebWait();

            testWebDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

            WebElement addBlankDecisionButton=webWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-internal/app-decision-trees/main/perfect-scrollbar/div/div[1]/div/header/div/div/button")));
            addBlankDecisionButton.sendKeys(Keys.ENTER);

            WebElement decisionNameText=webWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-create-new-decision-tree/div/section[2]/perfect-scrollbar/div/div/section[1]/div/input")));
            decisionNameText.click();
            decisionNameText.sendKeys("AllBatches");

            WebElement elementSelect=webWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-create-new-decision-tree/div/section[2]/perfect-scrollbar/div/div/section[2]/div/select")));
            decisionNameText.click();

            //Select selElement = new Select(testWebDriver.findElement(By.xpath("//app-create-new-decision-tree/div/section[2]/perfect-scrollbar/div/div/section[2]/div/select")));
            //selElement.selectByIndex(0);

        } catch (Exception ex) {

        }

    // /html/body/app-root/app-internal/app-decision-trees/main/perfect-scrollbar/div/div[1]/div/header/div/div/button
    }
}