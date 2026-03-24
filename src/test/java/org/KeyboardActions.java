package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;
import java.security.KeyStore;

public class KeyboardActions {

    @Test
    public void Keyboard() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.programiz.com/java-programming/online-compiler/");
        driver.manage().window().maximize();

        WebElement editor = driver.findElement(By.id("editor"));
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.DELETE).keyUp(Keys.DELETE).perform();

        Thread.sleep(1000);
    }
}
