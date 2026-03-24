package org;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTableOrangeHrm {

    @Test
    public void orangehrm() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement admin = (WebElement) js.executeScript("return document.querySelector('a[class=\\'oxd-main-menu-item toggle\\']').querySelector('span')");
        admin.click();

        Thread.sleep(1000);

        //div[@class='card-center']
    }
}
