package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MedirTiempoConWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://webapp.enternet.cl");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        long startTime = System.nanoTime(); // Inicio de medición

        try {
            WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TabFld\"]/input")));
            long endTime = System.nanoTime(); // Fin de medición

            long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
            System.out.println("⏳ Tiempo de espera hasta que el elemento esté visible: " + duration + " ms");

        } catch (Exception e) {
            System.out.println("❌ Elemento no encontrado dentro del tiempo de espera.");
        }

        driver.quit();
    }
}

