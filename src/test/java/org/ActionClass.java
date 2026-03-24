package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionClass {

    @Test
    public void moveToElement() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement from = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'From')]/following-sibling::div/child::input[@type='text']")));
        from.click();
        Thread.sleep(1000);

        Actions actions = new Actions(driver);

        List<WebElement> fromloc = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/descendant::div//div[@class='css-76zvg2 r-1xedbs3 r-ubezar']"));


        for(int i=0;i< fromloc.size();i++){
            if(fromloc.get(i).getText().equals("AGR")){
                actions.moveToElement(fromloc.get(i)).click().perform();
            }
        }
        Thread.sleep(1000);

    }
}
