package definitions.Commons;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class BaseTest {
    // Lista que solo contiene las capturas de la ejecución en curso
    private static ThreadLocal<List<String>> capturasPendientes = ThreadLocal.withInitial(ArrayList::new);
   // public static List<String> capturasPendientes = new ArrayList<>();
    protected static WebDriver driver;
    public static Map<String, String> datos;
    public static Map<String, String> datosPOS;
    public static final String RUTA_PDF = "C:/git/aut-Enternet/reportes/";
    private static final String RUTA_CAPTURAS = "C:/git/aut-Enternet/reportes/";
    public static List<String> mensajes = new ArrayList<>();
    public static PdfDocument pdfDocument;
    public static Document document;
    static String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    public static String nombreFeature;
    public static String estadoEjecucion = "Passed";


    @Given("que cargo los datos desde el archivo {string}")
    public void queCargoLosDatosDesdeElArchivo(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
            try {
                datos = objectMapper.readValue(new File("C:/git/aut-Enternet/src/main/resources/datos.json"), Map.class);

                System.out.println("✅ Datos cargados desde JSON: " + datos);
            } catch (IOException e) {
                e.printStackTrace();
                estadoEjecucion = "Failed";
            }
    }


    @Given("que estoy ejecutando el feature {string}")
    public void ejecutarFeature(String featureName) {
        setNombreFeature(featureName);
    }

    public static WebDriver iniciarDriver() {
        if (driver == null) { // Evita abrir múltiples navegadores
            System.setProperty("webdriver.chrome.driver", "C:/git/aut-Enternet/src/main/java/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://webapp.enternet.cl");
            driver.manage().window().maximize();

            inicializarPDF();
        }
        return driver;
    }

    public static void cerrarDriver() {
        // Finalizar prueba
        if (driver != null) {
            driver.quit();
            // ✅ Ahora SÍ es momento de generar el PDF con las capturas tomadas
            generarPDFConCapturas(RUTA_PDF, timestamp, nombreFeature, estadoEjecucion);
            cerrarPDF();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            iniciarDriver();  // Asegura que el driver no sea null antes de retornarlo
        }
        return driver;
    }

    // Método para ingresar datos y validar si los elementos existen o están ocultos
    public static void validarIngreso(WebDriver driver, String dato, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Esperar hasta que el elemento sea visible
            WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            campo.sendKeys(dato);
            System.out.println("✅ Se ingresó '" + dato + "' en el campo: " + locator);
        } catch (Exception e) {
            System.out.println("⚠️ El campo " + locator + " no está visible. Se omite este paso.");
        }
    }

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


  public static void tomarCaptura(String nombreArchivo) throws InterruptedException {
      Thread.sleep(2000);
      try {
          // Inicializar el PDF si no está listo
          if (document == null || pdfDocument == null) {
              System.out.println("🛠 Iniciando PDF automáticamente...");
          }

          File directorio = new File(RUTA_CAPTURAS);
          if (!directorio.exists()) {
              directorio.mkdirs();
          }

          String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
          String nombreFinal = nombreArchivo + "_" + timestamp + ".png";
          String rutaArchivo = RUTA_CAPTURAS + nombreFinal;

          File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          File destino = new File(RUTA_CAPTURAS + nombreFinal);
          FileUtils.copyFile(captura, destino);

          if (destino.exists() && document != null)  {
              capturasPendientes.get().add(rutaArchivo); // 👉 Se guarda para agregar después al PDF
              System.out.println("✅ Captura almacenada: " + rutaArchivo);
          } else {
              System.out.println("⚠️ No se pudo guardar la captura.");
              estadoEjecucion = "Failed";
          }

      } catch (Exception e) {
          System.out.println("❌ Error al tomar captura: " + e.getMessage());
          estadoEjecucion = "Failed";
      }
  }

    public static void generarPDFConCapturas(String rutaPdf, String fechaHora, String nombreFeature, String status) {
        try {
            document.add(new Paragraph("📄 Reporte de pruebas Selenium").setBold().setFontSize(16));
            document.add(new Paragraph("🟢 Estado: " + status));

            // Aquí se agrega el nombre del feature al reporte
            if (nombreFeature != null && !nombreFeature.isEmpty()) {
                document.add(new Paragraph("🧪 Feature: " + nombreFeature).setFontSize(12f));
            } else {
                document.add(new Paragraph("🧪 Feature: No disponible").setFontSize(12f));
            }
            document.add(new Paragraph("🕒 Fecha: " + fechaHora).setTextAlignment(TextAlignment.LEFT));

            if (!capturasPendientes.get().isEmpty()) {
                for (String rutaCaptura : capturasPendientes.get()) {
                    File captura = new File(rutaCaptura);
                    if (captura.exists()) {
                        ImageData imageData = ImageDataFactory.create(rutaCaptura);
                        Image image = new Image(imageData).scaleToFit(500, 350);
                        document.add(new Paragraph("📸 Captura: " + captura.getName()));
                        document.add(image);
                        document.add(new Paragraph("\n"));
                    }
                }
            } else {
                document.add(new Paragraph("⚠️ No hay capturas disponibles."));
            }
            // ✅ Limpieza final
         //   capturasPendientes.clear();
            System.out.println("✅ PDF generado correctamente: " + rutaPdf);

        } catch (Exception e) {
            System.out.println("❌ Error al generar el PDF: " + e.getMessage());
            estadoEjecucion = "Failed";
        }
    }

    // Método para cerrar el PDF después de la prueba
    public static void cerrarPDF() {
        if (document != null) {
            document.close();
            System.out.println("✅ Documento PDF cerrado correctamente.");
        }
    }

    // Método para inicializar el PDF antes de comenzar a agregar capturas
    public static void inicializarPDF() {
        try {
            int numero = obtenerNumeroConsecutivo(RUTA_PDF);
            String ruta = RUTA_PDF + "Reporte_" + numero + ".pdf";

            PdfWriter writer = new PdfWriter(ruta);
            pdfDocument = new PdfDocument(writer);
            document = new Document(pdfDocument);

            System.out.println("📄 Documento PDF inicializado: " + ruta);
        } catch (Exception e) {
            System.out.println("❌ No se pudo inicializar el PDF: " + e.getMessage());
            estadoEjecucion = "Failed";
        }
    }
    public static String esperarElementoYMedirTiempo( By locator, String descripcion) {

        long inicio = System.currentTimeMillis();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            long fin = System.currentTimeMillis();
            String mensaje = descripcion + " apareció en " + (fin - inicio) + " ms";
            mensajes.add(mensaje);
            return mensaje;
        } catch (TimeoutException e) {
            String mensaje = "⚠️ No apareció " + descripcion;
            mensajes.add(mensaje);
            return mensaje;
        }
    }
    // Método para eliminar las capturas de pantalla después de generar el PDF
    public static void eliminarCapturas() {
        try {
            Files.list(Paths.get(RUTA_CAPTURAS)) // Solo lista archivos, sin incluir la carpeta
                    .map(Path::toFile)
                    .filter(File::isFile) // Filtra solo archivos
                    .forEach(File::delete);

            System.out.println("Capturas eliminadas correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setNombreFeature(String featureName) {
        nombreFeature = featureName;
    }

    /*metodos de putty*/
    // 🔹 Método para convertir la primera letra a mayúscula
    public static String capitalizarPrimeraLetra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    // 🔹 Método para escribir texto con caracteres especiales y primera letra en mayúscula
    public static void escribirTextoEspecial(Robot robot, String texto) {
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (i == 0 && Character.isLetter(c)) { // Primera letra en mayúscula
                presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(c)));
            } else {
                switch (c) {
                    case '@': presionarTeclas(robot, KeyEvent.VK_ALT_GRAPH, KeyEvent.VK_2); break;
                    case '!': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
                    case '$': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_4); break;
                    case '*': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_8); break;
                    case '?': escribirCaracterPregunta(robot); break; // 🔹 Nuevo método para "?"
                    default: escribirTexto(robot, String.valueOf(c));
                }
            }
        }
    }

    // 🔹 Método para escribir texto normal
    public static void escribirTexto(Robot robot, String texto) {
        for (char c : texto.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("No se puede escribir: " + c);
            }
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }

    // 🔹 Método especial para escribir "?" en teclado español latinoamericano
    public static void escribirCaracterPregunta(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_QUOTE); // 🔹 Para "?" en teclado LATAM
        robot.keyRelease(KeyEvent.VK_QUOTE);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    // 🔹 Método para presionar teclas combinadas
    public static void presionarTeclas(Robot robot, int tecla1, int tecla2) {
        robot.keyPress(tecla1);
        robot.keyPress(tecla2);
        robot.keyRelease(tecla2);
        robot.keyRelease(tecla1);
    }

    // Función para presionar ENTER
    public static void presionarEnter(Robot robot) {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    // Función para escribir " (comillas dobles)
    private static void presionarComillasDobles(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_QUOTE);
        robot.keyRelease(KeyEvent.VK_QUOTE);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    // Función para escribir ' (comillas simples)
    private static void presionarComillaSimple(Robot robot) {
        robot.keyPress(KeyEvent.VK_QUOTE);
        robot.keyRelease(KeyEvent.VK_QUOTE);
    }
    public static String readFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return String.join("\n", lines); // Une todas las líneas en un solo String
    }

    //verificar archivo
    public static boolean existeArchivo(String rutaArchivo, int i) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
    public static boolean esperarArchivoDescarga(String rutaArchivo, int tiempoMaximoSegundos) {
        File archivo = new File(rutaArchivo);
        int tiempoEsperado = 0;

        while (tiempoEsperado < tiempoMaximoSegundos) {
            if (archivo.exists()) {
                System.out.println("✅ Archivo encontrado: " + rutaArchivo);
                return true;
            }
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de volver a verificar
                tiempoEsperado++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("⏳ Tiempo de espera agotado. No se encontró el archivo.");
        return false;
    }



}


