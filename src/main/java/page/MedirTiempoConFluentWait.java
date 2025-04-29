package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class MedirTiempoConFluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://webapp.enternet.cl");

        long startTime = System.nanoTime(); // Inicio de medición

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))  // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Revisar cada 500ms
                .ignoring(Exception.class);

        try {
            WebElement elemento = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath("//*[@id=\"TabFld\"]/input"));
                }
            });

            long endTime = System.nanoTime(); // Fin de medición
            long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
            System.out.println("⏳ Tiempo hasta encontrar el elemento: " + duration + " ms");

        } catch (Exception e) {
            System.out.println("❌ Elemento no encontrado en el tiempo límite.");
        }

        driver.quit();
    }
}

