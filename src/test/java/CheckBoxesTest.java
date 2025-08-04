import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxesTest {
    WebDriver driver;

    /*
    + проверить, что первый чекбокс unchecked
    + отметить первый чекбокс
    + проверить что он checked
    + Проверить, что второй чекбокс checked
    + сделать unheck
    + проверить, что он unchecked
    Локатор: By.cssSelector("[type=checkbox]”)
     */

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkboxOne = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        Assert.assertFalse(checkboxOne.isSelected());
        checkboxOne.click();
        Assert.assertTrue(checkboxOne.isSelected());
        WebElement checkboxTwo = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        Assert.assertTrue(checkboxTwo.isSelected());
        checkboxTwo.click();
        Assert.assertFalse(checkboxTwo.isSelected());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
