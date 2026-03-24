package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StaticWebTables {

    @Test
    public void staticWebTables(){
        String url = "https://testautomationpractice.blogspot.com/";

        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        driver.get(url);
        


        WebElement table = driver.findElement(By.name("BookTable"));

        String row = "//table[@name=\"BookTable\"]/tbody/tr";
        List<WebElement> rows = driver.findElements(By.xpath(row));

        int rowSize = rows.size();

        List<WebElement> cl = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr[2]/td"));
        int colSize = cl.size();


        for(int i=2;i<=rowSize;i++){
            for(int j=1;j<=colSize;j++){
                WebElement cell= driver.findElement
                                       (By.xpath("//table[@name=\"BookTable\"]/tbody/tr["+i+
                                               "]" +
                                               "/td[" +
                                               j+"]"));


                System.out.println(cell.getText());
            }
        }









    }
}
