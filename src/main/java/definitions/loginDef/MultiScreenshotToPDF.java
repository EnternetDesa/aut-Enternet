package definitions.loginDef;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiScreenshotToPDF {
    public static void main(String[] args) throws IOException {
        // Configurar WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\git\\aut-Enternet\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Seleccionar la ruta de guardado con FileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("C:\\git\\aut-Enternet\\src\\main\\java\\pdf\\Capturas.pdf"));

        if (fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("Operación cancelada por el usuario.");
            driver.quit();
            return;
        }
        String pdfPath = fileChooser.getSelectedFile().getAbsolutePath();

        // Crear el PDF
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(pdfPath));
        Document document = new Document(pdfDoc);

        try {
            driver.get("http://webapp.enternet.cl"); // Abrir página

            for (int i = 1; i <= 3; i++) { // Capturar 3 veces con diferentes descripciones
                Thread.sleep(2000); // Esperar 2 segundos entre capturas

                // Generar timestamp y nombre de archivo
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String screenshotPath = "screenshot_" + i + ".png";

                // Tomar captura de pantalla
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotPath));

                // Agregar descripción y timestamp
                document.add(new Paragraph("Captura " + i + " - " + timestamp));

                // Agregar imagen al PDF
                ImageData imageData = ImageDataFactory.create(screenshotPath);
                Image image = new Image(imageData);
                document.add(image);
            }

            System.out.println("PDF generado con éxito: " + pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
            driver.quit();
        }
    }
}
