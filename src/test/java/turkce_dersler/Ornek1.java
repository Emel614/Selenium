package turkce_dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ornek1 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void amazon(){
        driver.get("https://www.amazon.com/");
        //Locate the search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //Search with "Samsung headphones"
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);
        //bulunan sonuc yazisini yazdir
        WebElement searchText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchText.getText());
        //click the first product
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();
        //print all headers on the page
        driver.navigate().back();
        List<WebElement> productList = driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])"));
        System.out.println(productList.size());;
        for(WebElement each : productList){
            System.out.println(each.getText());
        }


    }
}
