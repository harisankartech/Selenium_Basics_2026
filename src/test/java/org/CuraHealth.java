package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CuraHealth {

    @Test
    public void VerifyPageSource() throws Exception {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        System.out.println(driver.getPageSource());
        String expectedTitle = "CURA Healthcare Service";

        String actTitle=driver.getTitle();
        Assert.assertEquals(actTitle,expectedTitle);
        assertThat(driver.getTitle().equals(expectedTitle)).isNotNull(); //assertj

       // Assert.assertTrue(driver.getPageSource().contains("We Care About Your Health"));
        assertThat(driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/"));

        if(driver.getPageSource().contains("We Care About Your Health")){
            Assert.assertTrue(true);
        }else{
            throw new Exception("Failed");
        }


        driver.close();

    }
}
