package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IframeExample {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @Test
    public void numberOfIframe(){
        //1.way
        List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));
        int iframeSize = iframeElements.size();
        System.out.println(iframeSize);
        //2.way
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
    }
    @After
    public void tearDown(){

        driver.close();
    }
}
