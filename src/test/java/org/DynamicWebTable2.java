package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable2 {

    @Test
    public void dynamicDemo2(){
        String url = "https://practice.expandtesting.com/dynamic-table";

        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        String table = "//table[@class='table table-striped']";

        List<WebElement> row = driver.findElements(By.tagName("tr"));
        int rowSize = row.size();

        for(int i=0;i<rowSize;i++){
            List<WebElement>head = driver.findElements(By.tagName("th"));
            List<WebElement>col = row.get(i).findElements(By.tagName("td"));

            for(WebElement ele:col){
                {
                    System.out.println(ele.getText());
                }

            }
        }
    }
}
