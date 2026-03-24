package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.io.File;

public class Adblock {

    @Test
    public void addExtension(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--incognito");
        options.addArguments("load-extension=E:\\Hari\\Softwares\\adblock");
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://marunadanmalayalee.com/");

      /* navigation commands */

        //        driver.navigate().refresh();
        //        driver.navigate().forward();
        //        driver.navigate().back();


        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.close();



    }
}
