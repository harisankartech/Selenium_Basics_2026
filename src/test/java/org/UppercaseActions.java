package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UppercaseActions {

    @Test
    public void uppercase() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement text = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions.moveToElement(text).click().perform();

        actions.keyDown(Keys.SHIFT).sendKeys("harisankar").keyUp(Keys.SHIFT).perform();

        Thread.sleep(1000);
    }
}
