package definitions.Commons;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;


public class BaseTest {
    // Lista que solo contiene las capturas de la ejecución en curso
    private static ThreadLocal<List<String>> capturasPendientes = ThreadLocal.withInitial(ArrayList::new);
    protected static WebDriver driver;
    public static Map<String, String> datos;
    public static Map<String, String> datosPOS;
    public static Map<String , Object> datosPromociones;
    public static Map<String , Object> datosFiado;
    public static final String RUTA_PDF = "C:/git/aut-Enternet/reportes/";
    private static final String RUTA_CAPTURAS = "C:/git/aut-Enternet/reportes/capturas/";
    public static List<String> tiemposDeCarga = new ArrayList<>();
    public static PdfDocument pdfDocument;
    public static Document document;
    static String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    public static String nombreFeature;
    public static String estadoEjecucion = "Passed";



    static {
        cargarDatosPromociones();
    }
    public static void cargarDatosPromociones() {
        try {
            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosPromociones.json");
            if (is == null) {
                throw new RuntimeException("❌ Archivo datosPromociones.json no encontrado en resources.");
            }
            ObjectMapper mapper = new ObjectMapper();
            datosPromociones = mapper.readValue(is, new TypeReference<>() {});
            System.out.println("✅ datosPromociones cargado correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar datosPromociones: " + e.getMessage());
            datosPromociones = null; // evitar estado inconsistente
        }
    }
    public class JsonUtils {
        public static Map<String, String> leerJsonComoMapa(String ruta) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(new File(ruta), new TypeReference<Map<String, String>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
        }
    }

    @Given("que ingreso los datos desde el archivo datosFiado {string}")
    public void queIngresoLosDatosDesdeElArchivoDatosFiado(String arg0) {

        try {
            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosFiado.json");
            if (is == null) {
                throw new RuntimeException("❌ Archivo datosFiado.json no encontrado en resources.");
            }
            ObjectMapper mapper = new ObjectMapper();
            datosFiado = mapper.readValue(is, new TypeReference<>() {});
            System.out.println("✅ datosFiado cargado correctamente.");
        } catch (Exception e) {
            System.err.println(STR."❌ Error al cargar datosFiado: \{e.getMessage()}");
            datosFiado = null; // evitar estado inconsistente
        }
    }
    public static <T> T cargarJsonDesdeResource(String nombreArchivo, TypeReference<T> tipo) {
        try (InputStream is = BaseTest.class.getClassLoader().getResourceAsStream(nombreArchivo)) {
            if (is == null) throw new RuntimeException("❌ Archivo " + nombreArchivo + " no encontrado.");
            return new ObjectMapper().readValue(is, tipo);
        } catch (IOException e) {
            System.err.println("❌ Error al cargar " + nombreArchivo + ": " + e.getMessage());
            return null;
        }
    }

    @Given("que cargo los datos desde el archivo {string}")
    public void queCargoLosDatosDesdeElArchivo(String archivo) {
        try {
            DatosGlobales.datos = cargarJsonComoMapa(archivo);
            System.out.println("✅ Datos cargados desde: " + archivo);
        } catch (IOException e) {
            throw new RuntimeException("❌ Error al cargar datos desde: " + archivo, e);
        }

        //System.out.println("ℹDatos actuales disponibles: " + DatosGlobales.datosActuales);
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
            eliminarCapturas();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            iniciarDriver();  // Asegura que el driver no sea null antes de retornarlo
        }
        return driver;
    }

    // Metodo para ingresar datos y validar si los elementos existen o están ocultos
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

    public static String esperarElementoYMedirTiempo( By locator, String descripcion) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        long inicio = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            long fin = System.currentTimeMillis();
            long tiempoCarga = fin - inicio;

            tiemposDeCarga.add("⏱ Tiempo de carga de "+ descripcion+ ":" +tiempoCarga+ "ms");
        } catch (TimeoutException e) {

            tiemposDeCarga.add("⏱ Tiempo de carga de "+ descripcion+ ": No apareció en el tiempo esperado.");

        }
        return descripcion;
    }

    public static void generarPDFConCapturas(String rutaPdf, String fechaHora, String nombreFeature, String status) {
        try {
            document.add(new Paragraph("Reporte de pruebas Selenium").setBold().setFontSize(16));
            document.add(new Paragraph("Estado: " + status));

            // nombre del feature
            if (nombreFeature != null && !nombreFeature.isEmpty()) {
                document.add(new Paragraph("Feature: " + nombreFeature).setFontSize(12f));
            } else {
                document.add(new Paragraph("Feature: No disponible").setFontSize(12f));
            }
            document.add(new Paragraph("Fecha: " + fechaHora).setTextAlignment(TextAlignment.LEFT));


            if (!capturasPendientes.get().isEmpty()) {
                for (String rutaCaptura : capturasPendientes.get()) {
                    File captura = new File(rutaCaptura);
                    if (captura.exists()) {
                        ImageData imageData = ImageDataFactory.create(rutaCaptura);
                        Image image = new Image(imageData).scaleToFit(500, 350);

                        String nombreCaptura = captura.getName();
                        String descripcion = nombreCaptura.replaceAll("_[0-9]{8}_[0-9]+\\.png", "");

                        document.add(new Paragraph("📸 Captura: " + nombreCaptura));
                        document.add(image);

                        // Buscar y mostrar el tiempo correspondiente a la descripción
                        for (String tiempo : tiemposDeCarga) {
                            if (tiempo.contains(descripcion)) {
                                document.add(new Paragraph("🕒 " + tiempo));
                                break;
                            }
                        }

                        document.add(new Paragraph("\n"));
                    }
                }
            } else {
                document.add(new Paragraph("No hay capturas disponibles."));
            }

            // Agregar el tiempo total al final del reporte (si hay tiempos registrados)
            if (!tiemposDeCarga.isEmpty()) {
                document.add(new Paragraph("Resumen de tiempos de ejecución:"));
                for (String tiempo : tiemposDeCarga) {
                    document.add(new Paragraph(tiempo));
                }
            }
            System.out.println("✅ PDF generado correctamente: " + rutaPdf);
            // ✅ Limpieza automática de listas para evitar acumulación
            tiemposDeCarga.clear();
            capturasPendientes.get().clear();
        } catch (Exception e) {
            System.out.println("❌ Error al generar el PDF: " + e.getMessage());
            estadoEjecucion = "Failed";
        }
    }

    // Metodo para cerrar el PDF después de la prueba
    public static void cerrarPDF() {
        if (document != null) {
            document.close();
            System.out.println("✅ Documento PDF cerrado correctamente.");
        }
    }

    // Metodo para inicializar el PDF antes de comenzar a agregar capturas
    public static void inicializarPDF() {
        try {
            int numero = obtenerNumeroConsecutivo(RUTA_PDF);
            String ruta = RUTA_PDF + "Reporte_" + numero + ".pdf";

            PdfWriter writer = new PdfWriter(ruta);
            pdfDocument = new PdfDocument(writer);
            document = new Document(pdfDocument);

            System.out.println("Documento PDF inicializado: " + ruta);
        } catch (Exception e) {
            System.out.println("❌ No se pudo inicializar el PDF: " + e.getMessage());
            estadoEjecucion = "Failed";
        }
    }

    // Metodo para eliminar las capturas de pantalla después de generar el PDF
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
    // 🔹 Metodo para convertir la primera letra a mayúscula
    public static String capitalizarPrimeraLetra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    // 🔹 Metodo para escribir texto con caracteres especiales y primera letra en mayúscula
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

    // 🔹 Metodo para escribir texto normal
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

    // 🔹 Metodo especial para escribir "?" en teclado español latinoamericano
    public static void escribirCaracterPregunta(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_QUOTE); // 🔹 Para "?" en teclado LATAM
        robot.keyRelease(KeyEvent.VK_QUOTE);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    // 🔹 Metodo para presionar teclas combinadas
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



    public static Map<String, String> cargarJsonComoMapa(String nombreArchivo) throws IOException {

//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File("C:/git/aut-Enternet/src/main/resources/" + nombreArchivo);
//        return mapper.readValue(file, new TypeReference<Map<String, String>>() {});
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = new File("C:/git/aut-Enternet/src/main/resources/" +nombreArchivo);

        if (!archivoJson.exists()) {
            throw new FileNotFoundException("❌ No se encontró el archivo JSON en: " + nombreArchivo);
        }

        return mapper.readValue(archivoJson, new TypeReference<Map<String, String>>() {});

    }
    public static Map<String, String> leerDatosDesdeJSON(String nombreArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(
                    new File("src/test/resources/datos/" + nombreArchivo),
                    new TypeReference<Map<String, String>>() {}
            );
        } catch (Exception e) {
            System.err.println("❌ Error leyendo el archivo JSON: " + e.getMessage());
            return null;
        }
    }





}


