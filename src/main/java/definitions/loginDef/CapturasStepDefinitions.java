package definitions.loginDef;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static Utils.Commons.BaseTest.eliminarCapturas;

import static Utils.Commons.BaseTest.obtenerSiguienteNumero;

public class CapturasStepDefinitions {
    private WebDriver driver;
    private String pdfPath = "C:/git/aut-Enternet/src/main/java/pdf/"; // Ruta del PDF
    private PdfDocument pdfDoc;
    private Document document;
    private static final String RUTA_PDF = "C:/git/aut-Enternet/src/main/java/pdf/";
    private static final String RUTA_CAPTURAS = "C:/git/aut-Enternet/src/main/java/pdf/capturas/";

    @Given("el usuario abre Google")
    public void elUsuarioAbreGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:/git/aut-Enternet/src/main/java/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita
        driver.get("https://www.google.com");

        // Crear el directorio si no existe
        new File("C:/git/aut-Enternet/src/main/java/pdf/capturas/").mkdirs();

        // Iniciar el documento PDF
        try {
            int numeroPdf = obtenerSiguienteNumero(RUTA_PDF);
            String rutaPdf = RUTA_PDF + "Reporte_" + numeroPdf + ".pdf";
            pdfDoc = new PdfDocument(new PdfWriter(rutaPdf));
            document = new Document(pdfDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("el usuario toma capturas de pantalla con tiempos de carga")
    public void elUsuarioTomaCapturasConTiempos() throws IOException {
        tomarCaptura("Página de inicio de Google");
        medirTiempoDeCarga(By.name("q"), "Campo de búsqueda en Google");

        driver.get("https://www.wikipedia.org");
        tomarCaptura("Página de inicio de Wikipedia");

        driver.get("https://www.github.com");
        tomarCaptura("Página de inicio de GitHub");


    }

    @Then("se genera un PDF con todas las capturas y tiempos registrados")
    public void generarPDF() {
        try {
            document.close();
            pdfDoc.close();
            driver.quit();
            System.out.println("PDF generado con éxito en: " + pdfPath);
            eliminarCapturas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tomarCaptura(String descripcion) throws IOException {
        // Captura de pantalla
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:/git/aut-Enternet/src/main/java/pdf/screenshot" + descripcion.replace(" ", "_") + ".png";
        FileUtils.copyFile(screenshot, new File(screenshotPath));

        // Agregar al PDF
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        document.add(new Paragraph(descripcion + " - " + timestamp));

        ImageData imageData = ImageDataFactory.create(screenshotPath);
        Image image = new Image(imageData);
        image.scaleToFit(400, 300);  // Ajuste de tamaño
        document.add(image);
    }

    private void medirTiempoDeCarga(By locator, String descripcion) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            long endTime = System.currentTimeMillis();
            long tiempoCarga = endTime - startTime;
            document.add(new Paragraph("Tiempo de carga de " + descripcion + ": " + tiempoCarga + " ms"));
        } catch (TimeoutException e) {
            document.add(new Paragraph("Tiempo de carga de " + descripcion + ": No apareció en el tiempo esperado."));
        }
    }
}
