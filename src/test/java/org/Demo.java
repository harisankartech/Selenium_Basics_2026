package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Demo {

    @Test
    public void loadBrowser(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.manoramaonline.com/");
    }
}
