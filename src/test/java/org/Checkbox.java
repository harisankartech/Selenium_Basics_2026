package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Checkbox {

    @Test
    public void checkBox() throws InterruptedException {

        String url = "https://the-internet.herokuapp.com/checkboxes";
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        List<WebElement> checkbox = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.
                        visibilityOfAllElements(driver.
                                findElements(By.
                                        xpath("//form[@id='checkboxes']/child::input"))));

       for(int i=0;i<checkbox.size();i++){
           if(!checkbox.get(i).isSelected()){
               checkbox.get(i).click();
           }
       }
       Thread.sleep(1000);




    }
}
