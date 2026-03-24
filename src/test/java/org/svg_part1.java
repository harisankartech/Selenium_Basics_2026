package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class svg_part1 {

    @Test
    public void mapSvg(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement search = driver.findElement(By.xpath("//div[@class='XDyW0e' and @role='button']//*[local-name()='svg']"));
        search.click();

    }

    @Test
    public void magSvg2(){


        WebDriver driver = new EdgeDriver();
        driver.get("https://simplemaps.com/resources/svg-maps");
        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> countries = driver.findElements(By.xpath(
                "//div[@id='map_inner']/*[local-name()='svg']/*[local-name()='path']"));

        for(WebElement country:countries){
            System.out.println(country.getAttribute("class"));
            if(country.getAttribute("class")!=null&&country.getAttribute("class").contains("sm_state sm_state_IN")){
                country.click();
            }
        }
    }
}

