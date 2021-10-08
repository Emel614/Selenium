package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void dropdownTest(){
        driver.get("https://www.amazon.com");
        WebElement dropdownBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownBox);
        String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);
        Assert.assertEquals("All Departments",firstOption);
        select.selectByIndex(3);
        String baby = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Baby",baby);
        List<WebElement> allOptions = select.getOptions();
        for(WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());
        }
        System.out.println("Total number of options = "+ allOptions.size());
        List<String> optionsWithText = new ArrayList<>();
        for(WebElement eachOption : allOptions){
            optionsWithText.add(eachOption.getText());
        }
        if(optionsWithText.contains("Appliances")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        List<String> alphabeticalOrder = new ArrayList<>(optionsWithText);
        Collections.sort(alphabeticalOrder);
        if(optionsWithText.equals(alphabeticalOrder)){
            System.out.println("Dropdown is in alphabetical order");
        }else{
            System.out.println("Dropdown is not in alphabetical order");
        }

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
