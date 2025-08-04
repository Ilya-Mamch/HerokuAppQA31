import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class SortableDataTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkDropDown() {
        driver.get("https://the-internet.herokuapp.com/tables");
        SoftAssert softAssert = new SoftAssert();
        String lastNameOne = driver.findElement(By.xpath
                ("//*[@id=\"table1\"]/tbody/tr[1]/td[1]")).getText();
        softAssert.assertEquals(lastNameOne, "Smith");
        String firstNameOne = driver.findElement(By.xpath
                ("//*[@id=\"table1\"]/tbody/tr[1]/td[2]")).getText();
        softAssert.assertEquals(firstNameOne, "John");
        String emailOne = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[3]"))
                .getText();
        softAssert.assertEquals(emailOne, "jsmith@gmail.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

