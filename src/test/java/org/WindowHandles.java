package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandles {

    @Test
    public void windowHandles(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String windowHandle = driver.getWindowHandle();

        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        Set<String>handles = driver.getWindowHandles();

        for(String h:handles){
            driver.switchTo().window(h);

            if(!driver.getWindowHandle().equals(windowHandle)){
                Assert.assertTrue(driver.getPageSource().contains("New Window"));
            }
        }
        driver.switchTo().defaultContent();





    }
}
