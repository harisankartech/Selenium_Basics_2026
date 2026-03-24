package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class StaticWebTable {

    @Test
    public void staticWebTable(){

        String url = "https://awesomeqa.com/webtable.html";
        WebDriver driver = new EdgeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        List<WebElement>rows = driver.
                               findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        int rowCount = rows.size();

        List<WebElement> column = driver.
                                   findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));

        int columnCount = column.size();

        //table[@id='customers']/tbody/tr[
        // ]/td[
        // ]
        String start = "//table[@id='customers']/tbody/tr[";
        String middle = "]/td[";
        String end = "]";
        for(int i=2;i<=rowCount;i++){
            for(int j=1;j<=columnCount;j++){

                String dynamicPath=start+i+middle+j+end;
                String data= driver.findElement(By.xpath(dynamicPath)).getText();

                if(data.contains("Helen Bennett")){
                    String countryPath = dynamicPath+"/following-sibling::td";
                    String companyPath = dynamicPath+"/preceding-sibling::td";
                    String company = driver.findElement(By.xpath(companyPath)).getText();
                    String country = driver.findElement(By.xpath(countryPath)).getText();
                    System.out.println(company+" "+data+" "+country);
                }
            }
        }




    }
}
