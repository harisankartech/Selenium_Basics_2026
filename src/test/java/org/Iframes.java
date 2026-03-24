package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes {

    @Test
    public void iFrames() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        WebElement singleFrame = driver.findElement(By.xpath("//*[contains(text(),'Single Iframe ')]"));
        singleFrame.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement frame = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(frame);

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Hello");
        Thread.sleep(1000);
    }

    @Test
    public void iFrames2(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.manage().window().maximize();

        WebElement iframe = driver.findElement(By.xpath("//h3[contains(text(),'Frame1')]/parent::div/child::iframe[@id='frm1']"));
        driver.switchTo().frame(iframe);

        WebElement drop = driver.findElement(By.id("selectnav1"));

        Select select = new Select(drop);
        select.selectByValue("https://www.hyrtutorials.com/search/label/Java");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}

