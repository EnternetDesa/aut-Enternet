package resources;

//public java.sql.Connection conexion() {
//    if (conexion == null) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conexion= DriverManager.getConnection("jdbc:mysql://"+host+"/"+bd, usuario, contrasena);
//            System.out.println("exito");
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("error");
//        }
//
//    }
//    return conexion;
//}
//
//public void main() {
//}

//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class ScrollExample {
//    public static void main(String[] args) {
//        // Inicializar WebDriver Manager para obtener el driver adecuado
//        WebDriverManager.chromedriver().setup();
//
//        // Configurar opciones de Chrome (puedes añadir más configuraciones si lo deseas)
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");  // Iniciar el navegador maximizado
//
//        // Crear una nueva instancia del navegador Chrome
//        WebDriver driver = new ChromeDriver(options);
//
//        try {
//            // Abrir la página
//            driver.get("https://www.example.com");
//
//            // Realizar un desplazamiento hacia abajo (por ejemplo, 1000 píxeles)
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//            jsExecutor.executeScript("window.scrollBy(0, 1000);");
//
//            // Esperar unos segundos para observar el desplazamiento (opcional)
//            Thread.sleep(2000);
//
//            // Realizar un desplazamiento hasta el final de la página
//            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//            // Esperar unos segundos antes de cerrar el navegador
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            // Cerrar el navegador
//            driver.quit();
//        }
//    }
//}
