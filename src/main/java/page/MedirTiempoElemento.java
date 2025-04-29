package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MedirTiempoElemento {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("http://webapp.enternet.cl");

            // Medir el tiempo con System.nanoTime()
            long startTime = System.nanoTime();  // Captura el tiempo antes de la búsqueda
           Thread.sleep(3000);
            try {
                WebElement elemento = driver.findElement(By.xpath("//*[@id=\"TabFld\"]/input"));
                long endTime = System.nanoTime();  // Captura el tiempo después de encontrar el elemento

                long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
                System.out.println("⏱️ Tiempo para encontrar el elemento: " + duration + " ms");

            } catch (Exception e) {
                System.out.println("❌ Elemento no encontrado.");
            }

            driver.quit();
        }
    }


