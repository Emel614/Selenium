package homework;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization2 extends TestBase {
    /*
    Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
.isEnabled(); is used to check if an element is enabled
     */
    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(enabledText.getText().equals("It's enabled!"));
        Assert.assertTrue(enabledText.isEnabled());
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement disabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(disabledText.getText().equals("It's disabled!"));
        Assert.assertTrue(disabledText.isDisplayed());
    }
}
