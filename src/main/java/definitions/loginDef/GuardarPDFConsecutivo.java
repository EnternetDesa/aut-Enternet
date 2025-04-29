package definitions.loginDef;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static definitions.CapturaYReporte.driver;


public class GuardarPDFConsecutivo {
    public static void main(String[] args) {

        // Ruta donde se guardarán los PDFs
        String rutaCarpeta = "C:/git/aut-Enternet/src/main/java/pdf/";
        int screenshotCounter = 1; // Contador de capturas
        // Obtener el próximo número consecutivo
        int numeroArchivo = obtenerNumeroConsecutivo(rutaCarpeta);


        // Nombre del archivo con número consecutivo
        String nombreArchivo = "Reporte_" + numeroArchivo + ".pdf";

        // Ruta completa del archivo
        String rutaCompleta = rutaCarpeta + nombreArchivo;

        // Generar el PDF
        //generarPDF(rutaCompleta);

        System.out.println("✅ PDF guardado como: " + rutaCompleta);



        // Generar el PDF con las imágenes
       //createPDF("capturas_prueba.pdf", screenshots);

    }

    // Método para obtener el próximo número consecutivo
    public static int obtenerNumeroConsecutivo(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crea la carpeta si no existe
        }

        // Obtener la lista de archivos en la carpeta
        File[] archivos = carpeta.listFiles((dir, name) -> name.startsWith("Reporte_") && name.endsWith(".pdf"));

        int maxNumero = 0;
        if (archivos != null) {
            for (File archivo : archivos) {
                // Extraer el número del nombre del archivo
                String nombre = archivo.getName().replace("Reporte_", "").replace(".pdf", "");
                try {
                    int numero = Integer.parseInt(nombre);
                    if (numero > maxNumero) {
                        maxNumero = numero;
                    }
                } catch (NumberFormatException e) {
                    // Ignorar archivos con nombres incorrectos
                }
            }
        }

        return maxNumero + 1; // Siguiente número disponible
    }
    public static String takeScreenshot(String prefix) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        int screenshotCounter = 0;
        String fileName = "C:/git/aut-Enternet/src/main/java/pdf/Captura_" + prefix + screenshotCounter + ".png";
        File destFile = new File(fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Captura guardada: " + fileName);
            screenshotCounter++;
            return fileName; // Devolver el nombre del archivo
        } catch (IOException e) {
            System.out.println("Error al guardar la captura: " + e.getMessage());
            return null;
        }
    }
//    public static void createPDF(String pdfFileName, List<String> imagePaths) {
//        Document document = new Document();
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
//            document.open();
//            for (String imagePath : imagePaths) {
//                if (imagePath != null) {
//                    Image image = Image.getInstance(imagePath);
//                    image.scaleToFit(500, 400); // Ajustar tamaño de imagen
//                    document.add(image);
//                    document.add(new Paragraph("Captura: " + imagePath)); // Agregar descripción
//                }
//            }
//            System.out.println("PDF creado: " + pdfFileName);
//        } catch (Exception e) {
//            System.out.println("Error al crear PDF: " + e.getMessage());
//        } finally {
//            document.close();
//        }
//    }


}