import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void testFrames() {
        driver.get("https://the-internet.herokuapp.com/frames"); // открываем ссылку
        driver.findElement(By.linkText("iFrame")).click(); // переходим на страницу frame
        driver.switchTo().frame("mce_0_ifr"); // переключаемся во фрейм
        String paragraphText = driver.findElement(By.id("tinymce")).getText();
        assertEquals(paragraphText, "Your content goes here."); // проверяем текст
        driver.switchTo().defaultContent(); // выходим из фрейма
    }
}
