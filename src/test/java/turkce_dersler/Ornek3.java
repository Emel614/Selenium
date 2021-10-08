package turkce_dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Ornek3 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void zero(){
        driver.get("http://zero.webappsecurity.com");
        //click sing in
        driver.findElement(By.id("signin_button")).click();
        //write "username" on the login
        driver.findElement(By.id("user_login")).sendKeys("username");
        //write "password" on the password
        driver.findElement(By.id("user_password")).sendKeys("password");
        //click the sing in button
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.get("http://zero.webappsecurity.com");
        //click "Online Banking"
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        //click "Pay Bills"
        driver.findElement(By.id("pay_bills_link")).click();
        //write the amount of the money
        driver.findElement(By.id("sp_amount")).sendKeys("10");
        //write the date "2020-09-10"
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //click the pay button
        driver.findElement(By.id("pay_saved_payees")).click();
        //check the massage which is "The payment was successfully submitted."
        String actual = driver.findElement(By.id("alert_content")).getText();
        Assert.assertEquals("The payment was successfully submitted.",actual);


    }
}
