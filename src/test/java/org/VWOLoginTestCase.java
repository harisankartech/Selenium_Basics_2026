package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class VWOLoginTestCase {

    @Test
    public void NegativeLogin(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement uname = driver.findElement(By.id("login-username"));
        uname.sendKeys("harisankarr2010@gmail.com");

        WebElement pwd = driver.findElement(By.id("login-password"));
        pwd.sendKeys("Express0000##");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedError = "Your email, password, IP address or location did not match";

        WebElement actualError = driver.findElement(By.id("js-notification-box-msg"));

        assertThat(actualError.isDisplayed());
        assertThat(actualError.getText().equals(expectedError));





    }
}
