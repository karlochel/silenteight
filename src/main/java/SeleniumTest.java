import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.Console;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\WebDrivers\\geckodriver.exe");
        WebDriver testWebDriver = new FirefoxDriver();
        WebDriverWait webWait = new WebDriverWait(testWebDriver, 40);

        // Create a new instance of the Edge driver
        //System.setProperty("webdriver.edge.driver", "C:\\Tools\\WebDrivers\\MicrosoftWebDriver.exe");
        //WebDriver driver = new EdgeDriver();


        //Launch the Online Store Website
        testWebDriver.get("https://sens.silenteight.com");
        //testWebDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

        WebElement usernameText=webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='username']")));
        usernameText.sendKeys("tester@silenteight.com");
        WebElement passwordText=webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
        passwordText.sendKeys("cS4aVcEfNP");
        WebElement loginButton=webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='submit-button']")));
        loginButton.click();


        //Wait for 5 Sec
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the driver
        testWebDriver.quit();
    }

}
