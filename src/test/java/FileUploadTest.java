import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest{

    @Test
    public void testFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload"); // открываем ссылку
        File file = new File("src/test/resources/1234.txt"); // указываем путь к файлу
        String fileName = file.getName();
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath()); // загружаем файл
        driver.findElement(By.id("file-submit")).click(); // нажимаем загрузить
        WebElement uploadedName = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedName.getText(), fileName); // проверяем название файла
    }
}
