import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu"); // открываем ссылку
        WebElement element = driver.findElement(By.id("hot-spot")); // ищем элемент
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform(); // делаем правый клик
        Alert alert = driver.switchTo().alert(); // переключаемся на alert
        String alertMessage = alert.getText();
        assertEquals(alertMessage, "You selected a context menu"); // проверяем текст alert
        alert.accept(); // закрываем alert
    }
}
