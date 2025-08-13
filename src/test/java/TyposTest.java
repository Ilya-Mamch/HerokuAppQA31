import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TyposTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkDropDown() {
        driver.get("https://the-internet.herokuapp.com/typos");
        SoftAssert softAssert = new SoftAssert();
        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        for (int i = 0; i <= 10; i++) {
            driver.navigate().refresh();
            WebElement getApostrophe = driver.findElements(By.tagName("p")).get(1);
            String actualText = getApostrophe.getText();
            softAssert.assertEquals(actualText, expectedText, "Ошибка " + i + " " + actualText);
        }
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}
