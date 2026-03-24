package org;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSExecutor_shadowDom {

    @Test
    public void shadowDom(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scrollinto = driver.findElement(By.id("userName"));
        js.executeScript("arguments[0].scrollIntoView(true);",scrollinto);




        WebElement inputbox = (WebElement) js.executeScript("return document.querySelector('#userName').shadowRoot.querySelector('#app2').shadowRoot.querySelector('#pizza');");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        inputbox.sendKeys("farmhouse");
    }
}
