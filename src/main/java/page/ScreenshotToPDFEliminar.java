package page;

import com.itextpdf.kernel.geom.PageSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;




public class ScreenshotToPDFEliminar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "ruta/a/chromedriver");

        WebDriver driver = new ChromeDriver();
        try {
            // Abrir una página web
            driver.get("https://www.ejemplo.com");

            // Esperar que cargue completamente
            Thread.sleep(2000);

            // Captura de pantalla de toda la pantalla (no solo navegador)
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            File imageFile = new File("captura_temp.png");
            ImageIO.write(capture, "png", imageFile);

            // Crear PDF con la imagen
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream("captura_final.pdf"));
//            document.open();
//            Image image = Image.getInstance("captura_temp.png");
//            image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
//            image.setAlignment(Element.ALIGN_CENTER);
//            document.add(image);
//            document.close();

            // Eliminar la imagen temporal
            if (imageFile.exists()) {
                imageFile.delete();
            }

            System.out.println("PDF generado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}

