package page;


import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;


public class prueba1 {
    private static final String RUTA_PDF = "C:/git/aut-Enternet/src/main/java/pdf/";
    private static final String RUTA_CAPTURAS = "C:/git/aut-Enternet/src/main/java/pdf/capturas/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");

            // Asegurar que las carpetas existen
            new File(RUTA_CAPTURAS).mkdirs();

            // Tomar múltiples capturas
            tomarCaptura(driver, "Google_Home");
            driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
            tomarCaptura(driver, "Busqueda_Selenium");

            // Crear el PDF con capturas
            int numeroPdf = obtenerSiguienteNumero(RUTA_PDF);
            String rutaPdf = RUTA_PDF + "Reporte_" + numeroPdf + ".pdf";
            generarPDFConCapturas(rutaPdf);
            System.out.println("PDF generado: " + rutaPdf);
            Thread.sleep(2000);
            // Eliminar capturas después de finalizar
            eliminarCapturas();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Método para obtener el siguiente número consecutivo para el PDF
    public static int obtenerSiguienteNumero(String carpeta) {
        File dir = new File(carpeta);
        if (!dir.exists()) {
            dir.mkdirs();
            return 1;
        }

        File[] archivos = dir.listFiles((d, name) -> name.endsWith(".pdf"));
        if (archivos == null || archivos.length == 0) {
            return 1;
        }

        return Arrays.stream(archivos)
                .map(File::getName)
                .map(name -> name.replaceAll("\\D+", ""))
                .filter(num -> !num.isEmpty())
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0) + 1;
    }

    // Método para tomar una captura de pantalla
//    public static void tomarCaptura(WebDriver driver, String nombre) {
//        try {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File destino = new File(RUTA_CAPTURAS + nombre + ".png");
//            FileUtils.copyFile(scrFile, destino);
//            System.out.println("Captura guardada: " + destino.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (java.io.IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    // Método para tomar una captura de pantalla
    public static void tomarCaptura(WebDriver driver, String nombreArchivo) {
        try {
            // Crear directorio si no existe
            File directorio = new File(RUTA_CAPTURAS);
            if (!directorio.exists()) {
                directorio.mkdirs(); // Crea la carpeta si no existe
            }

            // Tomar la captura de pantalla
            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Guardar la imagen en la ruta especificada
            File destino = new File(RUTA_CAPTURAS + nombreArchivo + ".png");
            Files.copy(captura.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Captura guardada: " + destino.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Método para eliminar las capturas de pantalla después de generar el PDF
//    public static void eliminarCapturas() {
//        try {
//            Files.walk(Paths.get(RUTA_CAPTURAS))
//                    .map(Path::toFile)
//                    .sorted(Comparator.reverseOrder()) // Elimina en orden inverso
//                    .forEach(File::delete);
//            System.out.println("Capturas eliminadas.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (java.io.IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void eliminarCapturas() {
        try {
            Files.list(Paths.get(RUTA_CAPTURAS)) // 🔹 Solo lista archivos, sin incluir la carpeta
                    .map(Path::toFile)
                    .filter(File::isFile) // 🔹 Filtra solo archivos (evita borrar la carpeta)
                    .forEach(File::delete);

            System.out.println("Capturas eliminadas correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generarPDFConCapturas(String rutaPdf) {
        try {
            // Crear PdfWriter y PdfDocument
            PdfWriter writer = new PdfWriter(new FileOutputStream(rutaPdf));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf); // ✅ Ya no hay error

            // Agregar título y fecha
            document.add(new Paragraph("Reporte de pruebas Selenium").setBold().setFontSize(16));
            document.add(new Paragraph("Fecha: " + new Date()).setFontSize(12));
            document.add(new Paragraph("\n"));

            // Obtener capturas de pantalla
            File dir = new File(RUTA_CAPTURAS);
            File[] capturas = dir.listFiles((dpdf, name) -> name.endsWith(".png"));
           // if (capturas != null && capturas.length > 0)
                if (capturas != null || capturas.length == 0){
                for (File captura : capturas) {
                    document.add(new Paragraph("Captura: " + captura.getName()).setFontSize(12));

                    // Agregar imagen al PDF
                    ImageData imageData = ImageDataFactory.create(captura.getAbsolutePath());
                    Image image = new Image(imageData);
                    image.scaleToFit(400, 300);  // Ajuste de tamaño
                    document.add(image);

                    document.add(new Paragraph("\n"));
                    System.out.println("Agregando al PDF: " + captura.getName());
                }
            } else {
                document.add(new Paragraph("No se encontraron capturas de pantalla."));
            }


            if (capturas == null || capturas.length == 0) {
                System.out.println("No se encontraron capturas de pantalla.");
            } else {
                for (File captura : capturas) {
                    System.out.println("Agregando al PDF: " + captura.getName());
                }
            }


            // Cerrar correctamente
            document.close();
            System.out.println("PDF generado correctamente: " + rutaPdf);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

