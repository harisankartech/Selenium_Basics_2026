package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ebay {

    @Test
    public void printTitleAndPrice(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//div[@id='gh-ac-wrap']/child::input"));
        search.sendKeys("macmini");

        WebElement button = driver.findElement(By.xpath("//div[@class='gh-search-button__wrap visual-search-enabled']/child::button"));
        button.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> title = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/descendant::div[@class='s-card__title']"));

        List<WebElement>price = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/descendant::div[@class='s-card__attribute-row']/child::span[starts-with(text(),'$')]"));

        for(WebElement l:title){
            for(WebElement i:price){
                System.out.println("The price for"+l.getText()+" is "+i.getText());
            }
        }

    }
}
