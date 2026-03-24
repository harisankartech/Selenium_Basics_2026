package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waits {

    @Test
    public void implicitWait(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.close();
    }

    @Test
    public void explicitWait(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/");

        driver.findElement(By.cssSelector("input#login-username")).sendKeys("harisankar");
        driver.findElement(By.cssSelector("input#login-password")).sendKeys("Express0000##");
        driver.findElement(By.id("js-login-btn")).click();

        WebElement errorMessage = new WebDriverWait(driver,Duration.ofSeconds(10)).
                                  until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));


        String expected = "Your email, password, IP address or location did not match";
        assertThat(errorMessage.getText().equals(expected));

    }

    @Test
    public void FluentWait(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/");

        driver.findElement(By.cssSelector("input#login-username")).sendKeys("harisankar");
        driver.findElement(By.cssSelector("input#login-password")).sendKeys("Express0000##");
        driver.findElement(By.id("js-login-btn")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver).
                                   withTimeout(Duration.ofSeconds(10)).
                                   pollingEvery(Duration.ofSeconds(2)).
                                   ignoring(NoSuchElementException.class);

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

        String expected = "Your email, password, IP address or location did not match";
        assertThat(errorMessage.getText().equals(expected));
    }
}
