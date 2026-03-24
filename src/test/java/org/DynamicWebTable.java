package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable {

    @Test
    public void dynamicWebTable(){

        String url = "https://awesomeqa.com/webtable1.html";

        WebDriver driver=new EdgeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> row = driver.findElements(By.tagName("tr"));
        int rowCount = row.size();

        for(int i=0;i<rowCount;i++){
            List<WebElement> columns = row.get(i).findElements(By.tagName("td"));

            for(WebElement ele:columns){
                System.out.println(ele.getText());
            }
        }

        }
    }

