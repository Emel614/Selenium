package turkce_dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Ornek2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void walmart(){
        driver.get("https://www.walmart.com/");
        //make the page refresh
        driver.navigate().refresh();
        //Verify the title contains "Save"
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains("Save"));
        //Verify the title is equal to "Walmart.com | Save Money.Live Better"
        String expected = "Walmart.com | Save Money.Live Better";
        Assert.assertEquals(expected,actual);
        //Verify the URL contains walmart.com
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("walmart.com"));



    }
}
