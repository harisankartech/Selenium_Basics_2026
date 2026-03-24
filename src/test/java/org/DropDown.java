package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

    @Test
    public void dropDown(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement drop = driver.findElement(By.id("dropdown"));
        drop.click();
        Select select = new Select(drop);

        select.selectByIndex(1);
        select.selectByVisibleText("Option 2");
    }
}
