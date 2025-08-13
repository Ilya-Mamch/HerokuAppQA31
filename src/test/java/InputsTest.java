import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InputsTest {
    WebDriver driver;

    /*
    Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP
    И Keys.ARROW_DOWN
     */

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("1");
        input.sendKeys(Keys.ARROW_UP);
        String valueUp = input.getAttribute("value");
        Assert.assertEquals(valueUp, "2");
        input.clear();
        input.sendKeys("10");
        input.sendKeys(Keys.ARROW_DOWN);
        String valueDown = input.getAttribute("value");
        Assert.assertEquals(valueDown, "9");
        input.clear();
        input.sendKeys("b");
        input.sendKeys(Keys.ARROW_UP);
        String nonDigitalUp = input.getAttribute("value");
        Assert.assertEquals(nonDigitalUp, "1");
        input.clear();
        input.sendKeys("c");
        input.sendKeys(Keys.ARROW_DOWN);
        String nonDigitalDown = input.getAttribute("value");
        Assert.assertEquals(nonDigitalDown, "-1");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
