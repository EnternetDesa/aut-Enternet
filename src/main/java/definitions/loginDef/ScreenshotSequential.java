package definitions.loginDef;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static definitions.Commons.BaseTest.obtenerNumeroConsecutivo;

public class ScreenshotSequential {
    static WebDriver driver;
    static int screenshotCounter = obtenerNumeroConsecutivo("C:/git/aut-Enternet/src/main/java/pdf/Captura/"); ; // Inicia el contador

    public void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/git/aut-Enternet/src/main/java/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://webapp.enternet.cl");// URL de prueba

        // Tomar varias capturas de pantalla
        for (int i = 0; i < 1; i++) {
            takeScreenshot("screenshot_");
        }

        driver.quit();
    }

    public void takeScreenshot(String prefix) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = prefix + screenshotCounter + ".png"; // Nombre con número consecutivo
        File destFile = new File("C:/git/aut-Enternet/src/main/java/pdf/PRUEBA/" + fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Captura guardada: " + fileName);
            screenshotCounter++; // Incrementar el contador
        } catch (IOException e) {
            System.out.println("Error al guardar la captura: " + e.getMessage());
        }
    }
}

