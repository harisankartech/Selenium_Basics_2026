package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {

    @Test
    public void Upload() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement upload = driver.findElement(By.id("fileToUpload"));

        upload.sendKeys("E:\\Hari\\Java_Advanced_Workspace_intellij\\Selenium_Fresh_Basics\\Resources\\WIN_20250312_12_28_15_Pro.jpg");

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

        Thread.sleep(1000);
    }
}
