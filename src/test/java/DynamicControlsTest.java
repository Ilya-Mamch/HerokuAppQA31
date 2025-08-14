import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //устанавливаем явное ожидание 10 сек
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))); //ждем пока появится сообщение
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[type=checkbox]"))); //ждем пока
        //пропадет
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/button")); //находим
        // input
        wait.until(ExpectedConditions.attributeToBe(input, "disabled", "true")); //проверяем что disabled
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click(); // ищем и нажимаем
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))); //ждем появления сообщения
        wait.until(ExpectedConditions.elementToBeClickable(input)); //проверяем что ввод стал активным
    }
}
