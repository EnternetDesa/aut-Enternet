package definitions.Commons;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public class Utils {
    private WebDriver driver;
    public static Scenario publicScenario;
    // Constructor
    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // Método que espera hasta que un elemento esté presente en el DOM y visible
    public boolean esperarElementoVisible(By locator, int tiempoEsperaSegundos) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaSegundos));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("✅ Elemento encontrado: " + locator);
            return true;
        } catch (TimeoutException e) {
            System.out.println("⏳ Tiempo de espera agotado. Elemento NO encontrado: " + locator);
            return false;
        }
    }

    /**
     * Espera hasta que un elemento esté presente en el DOM y/o visible en la página.
     * @param locator - Localizador del elemento (By.id, By.xpath, etc.)
     * @param tiempoEsperaSegundos - Tiempo máximo de espera en segundos.
     * @param debeSerVisible - true para esperar visibilidad, false solo existencia en el DOM.
     * @return WebElement si se encuentra, null si no se encuentra.
     */
    public WebElement esperarElemento(By locator, int tiempoEsperaSegundos, boolean debeSerVisible) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaSegundos));
            if (debeSerVisible) {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } else {
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }
        } catch (TimeoutException e) {
            System.out.println("⏳ Elemento no encontrado dentro del tiempo especificado: " + locator);
            return null;
        }
    }

    public WebElement waitForElement(By locator, int timeout, String condition) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

            switch (condition.toLowerCase()) {
                case "visible":
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

                case "clickable":
                    return wait.until(ExpectedConditions.elementToBeClickable(locator));

                case "present":
                    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                default:
                    throw new IllegalArgumentException("❌ Invalid condition: Use 'visible', 'clickable', or 'present'");
            }
        } catch (TimeoutException e) {
            System.out.println("⏳ Timeout: Element not found -> " + locator);
            return null;
        }
    }

    public static void esperar(WebDriver driver, WebElement elemento, int tiempoSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoSegundos));
        //wait.until(ExpectedConditions.visibilityOf(elemento));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public static void enmarcarElemento(WebDriver driver, WebElement elemento) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        // Guardar el estilo original del elemento
//        String estiloOriginal = elemento.getAttribute("style");
//
//        // Aplicar un borde verde alrededor del elemento
//        js.executeScript("arguments[0].style.border='4px solid green'", elemento);
//
//        // Esperar un poco para que el usuario lo vea (opcional)
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Restaurar el estilo original
//        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", elemento, estiloOriginal);
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 3; ++i) {
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[]{elemento, "border: 5px solid LimeGreen;"});
                Thread.sleep(100L);
            }
        } catch (InterruptedException var3) {
        }
    }
    public static void desenmarcarObjeto(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 3; ++i) {
                Thread.sleep(100L);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[]{element, ""});
            }
        } catch (InterruptedException var3) {
        }
    }


    public void beforeStep(Scenario scenario){
        publicScenario = scenario;
    }
    public static Scenario getPublicScenario(){
        return publicScenario;
    }
    public void medirTiempoConFluentWait(){
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
    }

    public void medirTiempoConWait(){
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
    }

    public void medirTiempoConElemento(){
        long startTime = System.nanoTime();  // Captura el tiempo antes de la búsqueda

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

    /**
     * Metodo para medir el tiempo de espera de un elemento
     */
    public static long medirTiempoEspera(WebDriver driver, By locator) {
        Instant start = Instant.now();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /**
     * Metodo para capturar la pantalla de un elemento
     */
    public static String capturarPantallaElemento(WebDriver driver, By locator, String fileName) {
        WebElement element = driver.findElement(locator);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destino = new File(fileName);

        try {
            Files.copy(screenshot.toPath(), destino.toPath());
            System.out.println("📸 Captura guardada: " + fileName);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para generar un PDF con formato en imágenes
     */
    public static void generarPDF(List<Long> tiemposEspera, long tiempoTotal, List<String> capturas) {
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream("Reporte_Prueba.pdf"));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("📌 Reporte de Prueba Selenium")
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("⏱️ Tiempo total de ejecución: " + tiempoTotal + " ms")
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER));

            for (int i = 0; i < capturas.size(); i++) {
                document.add(new Paragraph("⏳ Tiempo de espera del objeto " + (i + 1) + ": " + tiemposEspera.get(i) + " ms")
                        .setTextAlignment(TextAlignment.CENTER));

                if (capturas.get(i) != null) {
                    ImageData imageData = ImageDataFactory.create(capturas.get(i));
                    Image image = new Image(imageData);

                    // Ajustar tamaño de la imagen y centrarla
//                    image.scaleToFit(200, 150);
                    image.scaleToFit(336, 280);
                    image.setHorizontalAlignment(HorizontalAlignment.CENTER);

                    document.add(new Paragraph("📸 Captura de pantalla del objeto " + (i + 1) + ":")
                            .setTextAlignment(TextAlignment.CENTER));
                    document.add(image);
                }
            }

            document.close();
            System.out.println("📄 Reporte PDF generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public class LeerArchivoTxt {
        public static String leerArchivo(String rutaArchivo) {
            try {
                return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }



}