package definitions.loginDef;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import definitions.Commons.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportePDFv4 {
    public static void main(String[] args) {
        Instant inicioPrueba = Instant.now();
        String fechaHoraReporte = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        WebDriver driver = new ChromeDriver();
        driver.get("http://webapp.enternet.cl");

        List<String> screenshots = new ArrayList<>();
        List<Long> tiemposEspera = new ArrayList<>();
        By[] elementos = {By.name("_SRUT"),
                By.name("_PASSWDPLANO"),
                By.name("BOTPAS")};


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("_SRUT")));
        WebElement contrasenia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("_PASSWDPLANO")));
        WebElement btnContrasenia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("BOTPAS")));



        for (By elemento : elementos) {
            long tiempoEspera = medirTiempoEspera(driver, elemento);
            tiemposEspera.add(tiempoEspera);
            String screenshotPath = capturarPantallaElemento(driver, elemento, "captura_" + elemento.toString() + ".png");
            screenshots.add(screenshotPath);
        }

        Instant finPrueba = Instant.now();
        long tiempoTotal = Duration.between(inicioPrueba, finPrueba).toMillis();
        Utils.enmarcarElemento(driver, usuario);
        usuario.sendKeys("183475444");
        contrasenia.sendKeys("carito.123");
        btnContrasenia.click();
        generarPDF("Reporte de Prueba", fechaHoraReporte, screenshots, tiemposEspera, tiempoTotal);
        driver.quit();
    }

    public static long medirTiempoEspera(WebDriver driver, By locator) {
        Instant start = Instant.now();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    public static String capturarPantallaElemento(WebDriver driver, By locator, String fileName) {
        WebElement element = driver.findElement(locator);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destino = new File(fileName);

        try {
            Files.copy(screenshot.toPath(), destino.toPath());
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void generarPDF(String titulo, String fechaHora, List<String> capturas, List<Long> tiemposEspera, long tiempoTotal) {
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream("Reporte_Prueba.pdf"));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph(titulo).setBold().setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Fecha y Hora: " + fechaHora).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Tiempo total de ejecución: " + tiempoTotal + " ms").setTextAlignment(TextAlignment.CENTER));

            Table table = new Table(UnitValue.createPercentArray(new float[]{50, 50})).useAllAvailableWidth();
            table.addHeaderCell(new Cell().add(new Paragraph("Objeto"))).setBold().setTextAlignment(TextAlignment.LEFT);
            table.addHeaderCell(new Cell().add(new Paragraph("Tiempo de Espera (ms)"))).setBold().setTextAlignment(TextAlignment.LEFT);

            for (int i = 0; i < capturas.size(); i++) {
                table.addCell(new Cell().add(new Paragraph("Objeto " + (i + 1))));
                table.addCell(new Cell().add(new Paragraph(tiemposEspera.get(i) + " ms")));
            }
            document.add(table);

            for (String captura : capturas) {
                if (captura != null) {
                    ImageData imageData = ImageDataFactory.create(captura);
                    Image image = new Image(imageData);
                    image.scaleToFit(250, 200);

                    Table imageTable = new Table(1);
                    Cell imageCell = new Cell().add(image).setTextAlignment(TextAlignment.CENTER);
                    //imageCell.setBorder(Border.NO_BORDER);
                    imageTable.addCell(imageCell);
                    document.add(imageTable);
                }
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



