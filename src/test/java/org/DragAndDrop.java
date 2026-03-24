package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://practice.expandtesting.com/drag-and-drop");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        Thread.sleep(500);
        WebElement to = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(from,to).perform();

        Thread.sleep(1000);


    }

    @Test
    public void dragAndDropUsingMouseAction() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://practice.expandtesting.com/drag-and-drop");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        Thread.sleep(500);
        WebElement to = driver.findElement(By.id("column-b"));

        actions.clickAndHold(from).moveToElement(to).release().perform();

         Thread.sleep(1000);

    }
}
