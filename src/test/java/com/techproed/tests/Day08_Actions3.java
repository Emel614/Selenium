package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions3 extends TestBase {
   /* WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }*/
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT).//press the shift
                sendKeys("iPhone X prices").//type
                keyUp(searchBox,Keys.SHIFT).//unpress on shift button
                sendKeys(" too expensive"+Keys.ENTER).
                perform();
    }
   /* @After
    public void tearDown(){
        driver.close();
    }*/
}
