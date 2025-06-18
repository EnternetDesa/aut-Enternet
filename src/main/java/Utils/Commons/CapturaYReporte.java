package Utils.Commons;

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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CapturaYReporte {

    public static WebDriver driver;
    public static final String RUTA_CAPTURAS = "C:/git/aut-Enternet/src/main/java/pdf/";
    public static final String RUTA_PDF = RUTA_CAPTURAS + "reporte_capturas.pdf";

    private static PdfDocument pdfDocument;
    private static Document document;

    public static void iniciarPDF() {
        try {
            File directorio = new File(RUTA_CAPTURAS);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            PdfWriter writer = new PdfWriter(RUTA_PDF);
            pdfDocument = new PdfDocument(writer);
            document = new Document(pdfDocument);

            System.out.println("📝 PDF inicializado: " + RUTA_PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void tomarCaptura(String nombreArchivo) throws InterruptedException {
        Thread.sleep(2000); // Espera opcional

        try {
            // Crear carpeta si no existe
            File directorio = new File(RUTA_CAPTURAS);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Generar nombre con timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String nombreFinal = nombreArchivo + "_" + timestamp + ".png";
            String rutaArchivo = RUTA_CAPTURAS + nombreFinal;

            // Capturar imagen
            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File(rutaArchivo);
            FileUtils.copyFile(captura, destino);
            System.out.println("✅ Captura guardada: " + destino.getAbsolutePath());

            // Validar si se guardó correctamente
            if (destino.exists()) {
                // Agregar al PDF si el documento está abierto
                if (document != null) {
                    Image imagen = new Image(ImageDataFactory.create(rutaArchivo)).scaleToFit(500, 350);
                    document.add(new Paragraph("🖼 Captura: " + nombreFinal));
                    document.add(imagen);
                    document.add(new Paragraph("\n"));
                } else {
                    System.err.println("❌ No se ha inicializado el documento PDF.");
                }
            } else {
                System.err.println("❌ La imagen no fue encontrada después de guardar.");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar o validar la captura", e);
        }
    }



}

