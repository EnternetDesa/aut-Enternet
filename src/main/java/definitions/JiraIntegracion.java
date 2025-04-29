package definitions;
//
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.classic.methods.CloseableHttpResponse;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.io.entity.StringEntity;
//
//import java.nio.charset.StandardCharsets;
//
//public class JiraIntegracion {
//    private static final String JIRA_URL = "https://tu-jira.atlassian.net/rest/api/2/issue";
//    private static final String USER_EMAIL = "tu-email@dominio.com";
//    private static final String API_TOKEN = "tu-token-de-api";
//
//    public static void crearBugEnJira(String summary, String description) {
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpPost request = new HttpPost(JIRA_URL);
//            request.setHeader("Content-Type", "application/json");
//            request.setHeader("Authorization", "Basic " +
//                    java.util.Base64.getEncoder().encodeToString((USER_EMAIL + ":" + API_TOKEN).getBytes(StandardCharsets.UTF_8))
//            );
//
//            String jsonBody = "{ \"fields\": { " +
//                    "\"project\": { \"key\": \"PROYECTO\" }, " +
//                    "\"summary\": \"" + summary + "\", " +
//                    "\"description\": \"" + description + "\", " +
//                    "\"issuetype\": { \"name\": \"Bug\" } } }";
//
//            request.setEntity(new StringEntity(jsonBody));
//
//            try (CloseableHttpResponse response = client.execute(request)) {
//                System.out.println("Respuesta de Jira: " + response.getCode());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


  /*  // Método para tomar una captura de pantalla y agregarla al PDF  ok
    public static void tomarCaptura(String nombreArchivo) throws InterruptedException {
        Thread.sleep(2000);
        try {
            // Inicializar el PDF si no está listo
            if (document == null || pdfDocument == null) {
                System.out.println("🛠 Iniciando PDF automáticamente...");
               // inicializarPDF();
            }

            File directorio = new File(RUTA_CAPTURAS);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Generar timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String nombreFinal = nombreArchivo + "_" + timestamp + ".png";
            String rutaArchivo = RUTA_CAPTURAS + nombreFinal;

            // Tomar captura
            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File(RUTA_CAPTURAS + nombreFinal);
            FileUtils.copyFile(captura, destino);

            if (destino.exists() && document != null) {
                Image imagen = new Image(ImageDataFactory.create(rutaArchivo)).scaleToFit(500, 350);
                document.add(new Paragraph("📌 Captura: " + nombreFinal));
                document.add(imagen);
                document.add(new Paragraph("\n"));
            } else {
                System.out.println("⚠️ La imagen no fue encontrada o el documento PDF no está inicializado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
