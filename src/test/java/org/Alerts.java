package org;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {

    @Test
    public void alerts() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //WebElement alertid = driver.findElement(By.xpath("//ul/descendant::button[contains(text(),'Click for JS Alert')]"));

//        String alert2="//button[contains(text(),'Click for JS Confirm')]";
//        WebElement confirm = driver.findElement(By.xpath(alert2));
        String alert3="//button[contains(text(),'Click for JS Confirm')]/parent::li/following-sibling::li/button";
        WebElement type = driver.findElement(By.xpath(alert3));

        Thread.sleep(3000);
        type.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();


    }
}
