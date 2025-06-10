package definitions.loginDef;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import Utils.Commons.BaseTest;
import Utils.Commons.DatosGlobales;
import Utils.Commons.ReporteUtils;
import Utils.Commons.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import static Utils.Commons.BaseTest.esperarElementoYMedirTiempo;
import static Utils.Commons.BaseTest.tomarCaptura;
import static Utils.Commons.DatosGlobales.datos;


public class LoginDef {
    public LoginDef() {
        // Constructor vacío obligatorio
    }

   WebDriver driver = BaseTest.getDriver();

   private String pdfPath = "C:/git/aut-Enternet/pdf/Captura/Captura_.pdf"; // Ruta del PDF
    private PdfDocument pdfDoc;
    /*********/
    private static Document document;
    /**********/


// login y seleccion de rol
    @And("Ingreso con el tipo de {string}")
    public void ingresoConElTipoDe(String us)  {

        long startTime = System.currentTimeMillis();

        // Usamos el mapa activo cargado dinámicamente
        Map<String, String> datos = DatosGlobales.datosActuales;

        if (datos == null || !datos.containsKey("user")) {
            throw new IllegalArgumentException("El archivo cargado no contiene el campo 'user'");
        }

        By element = By.xpath("//input[@name='_SRUT']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Utils.enmarcarElemento(driver, elemento);
        elemento.sendKeys(datos.get("user"));
        Utils.desenmarcarObjeto(driver, elemento);
        esperarElementoYMedirTiempo(By.name("BOTPAS"), "Usuario");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        ReporteUtils.tiemposDeCarga.add("Ingreso con el tipo de " + us + " (Tiempo: " + duration + " ms)");
    }

    @And("ingreso la contrasenia {string}")
    public void ingresoLaContrasenia(String clave) {

        Map<String, String> datos = DatosGlobales.datosActuales;

        if (datos == null || !datos.containsKey("clave")) {
            throw new IllegalArgumentException("El archivo cargado no contiene el campo 'clave'");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement inputClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='_PASSWDPLANO']")));
        Utils.enmarcarElemento(driver, inputClave);
        inputClave.sendKeys(datos.get("clave"));
        Utils.desenmarcarObjeto(driver, inputClave);

    }

    @And("luego presiono el boton continuar")
    public void luegoPresionoElBotonContinuar() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("BOTPAS")));
        Utils.enmarcarElemento(driver, elemento);
        tomarCaptura("Ingreso Enternet");
        Utils.desenmarcarObjeto(driver, elemento);
        esperarElementoYMedirTiempo(By.name("BOTPAS"),"Ingreso Enternet");
        elemento.click();

    }

    @And("visualizo la vista de seleccion de rol")
    public void visualizoLaVistaDeSeleccionDeRol() {

    }

//    @And("selecciono la opcion {string}")
//    public void seleccionoLaOpcion(String rol) throws InterruptedException, IOException {
//
//        rol = datos.get("rol");
//        switch (rol) {
//            case "Inventario":
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement btnInventario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TabLab\"]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/table/tbody/tr/td")));
//                Utils.enmarcarElemento(driver, btnInventario);
//                tomarCaptura("Inventario");
//                Utils.desenmarcarObjeto(driver, btnInventario);
//                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"TabLab\"]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/table/tbody/tr/td"), "Seleccion de Rol: " +rol+ "");
//                btnInventario.click();
//
//                break;
//
//            case "Punto de ventas Enternet":
//                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement btnPuntoVentas = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("_APPICO_00020002")));
//                Utils.enmarcarElemento(driver, btnPuntoVentas);
//                tomarCaptura("POS Administrador Certificador");
//                Utils.desenmarcarObjeto(driver, btnPuntoVentas);
//                esperarElementoYMedirTiempo(By.id("_APPICO_00020002"), "Seleccion rol: " +rol );
//                btnPuntoVentas.click();
//
//                break;
//            case "Promociones":
//                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement btnPromociones = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("_APPICO_00050001")));
//                Utils.enmarcarElemento(driver, btnPromociones);
//                tomarCaptura("Administrador Promociones");
//                Utils.desenmarcarObjeto(driver, btnPromociones);
//                esperarElementoYMedirTiempo(By.id("_APPICO_00050001"), "Seleccion rol: " +rol );
//                btnPromociones.click();
//
//                break;
//            default:
//                System.out.println("Opción no válida");
//        }
//
//    }
@And("selecciono la opcion {string}")
public void seleccionoLaOpcion(String rol) throws InterruptedException, IOException {
    Map<String, String> datos = DatosGlobales.datosActuales;

    if (datos == null || !datos.containsKey("rol")) {
        throw new IllegalArgumentException("El archivo cargado no contiene el campo 'rol'");
    }

    // Sobrescribimos el parámetro con el valor real desde el JSON
    rol = datos.get("rol");

    switch (rol) {
        case "Inventario":
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnInventario = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"TabLab\"]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/table/tbody/tr/td")
            ));
            Utils.enmarcarElemento(driver, btnInventario);
            tomarCaptura("Inventario");
            Utils.desenmarcarObjeto(driver, btnInventario);
            esperarElementoYMedirTiempo(
                    By.xpath("//*[@id=\"TabLab\"]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/table/tbody/tr/td"),
                    "Seleccion de Rol: " + rol
            );
            btnInventario.click();
            break;

        case "Punto de ventas Enternet":
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnPuntoVentas = wait2.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("_APPICO_00020002")));
            Utils.enmarcarElemento(driver, btnPuntoVentas);
            tomarCaptura("POS Administrador Certificador");
            Utils.desenmarcarObjeto(driver, btnPuntoVentas);
            esperarElementoYMedirTiempo(
                    By.id("_APPICO_00020002"),"Seleccion rol: " + rol
            );
            btnPuntoVentas.click();
            break;

        case "Promociones":
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnPromociones = wait3.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("_APPICO_00050001")));
            Utils.enmarcarElemento(driver, btnPromociones);
            tomarCaptura("Administrador Promociones");
            Utils.desenmarcarObjeto(driver, btnPromociones);
            esperarElementoYMedirTiempo(
                    By.id("_APPICO_00050001"),"Seleccion rol: " + rol);
            btnPromociones.click();
            break;

        default:
            throw new IllegalArgumentException("Opción de rol no válida: " + rol);
    }
}


    @And("en la vista del warning selecciono enviar de todas formas")
    public void enLaVistaDelWarningSeleccionoEnviarDeTodasFormas() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btnEnviar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceed-button\"]")));
        Utils.enmarcarElemento(driver, btnEnviar );
        tomarCaptura("Msj Alerta");
        Utils.desenmarcarObjeto(driver, btnEnviar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"proceed-button\"]"),"Msj Alerta: Estás a punto de enviar una información no segura");
        driver.findElement(By.xpath("//*[@id=\"proceed-button\"]")).click();

    }

    @And("debe de mostrar la vista de stock")
    public void debeDeMostrarLaVistaDeStock() {
    }
    @Given("estoy en home de stock")
    public void estoyEnHomeDeStock() {
        // ----------------------Menu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        long startTime = System.nanoTime(); // Inicio de medición
        WebElement btnMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header/div[1]/i")));
        esperarElementoYMedirTiempo(By.name("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header/div[1]/i"),"Home stock");
//        long endTime = System.nanoTime(); // Fin de medición
        Utils.enmarcarElemento(driver, btnMenu );
        btnMenu.click();
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que vista Stock esté visible: " + duration + " ms");
        Utils.desenmarcarObjeto(driver, btnMenu);

    }

    @And("selecciono el menu de {string}")
    public void seleccionoElMenuDe(String menu) throws InterruptedException, IOException {

        menu = datos.get("menu");
        switch (menu) {
            case "Movimientos":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnMovimientos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/a")));
                Utils.enmarcarElemento(driver, btnMovimientos );
                tomarCaptura("Menu Movimientos");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[1]/a"), "El menu seleccionado es: "+menu+"");
                Utils.desenmarcarObjeto(driver, btnMovimientos);
                btnMovimientos.click();
                break;

            case "Procesos":

                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnProcesos = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/a")));
                Utils.enmarcarElemento(driver, btnProcesos );
                //takeScreenshot("screenshot_");
                tomarCaptura("Menu Procesos");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/a"),"El menu seleccionado es: "+menu+"");
                Utils.desenmarcarObjeto(driver, btnProcesos);
                btnProcesos.click();
                break;

            case "Reportes":

                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnReportes = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/a")));
                Utils.enmarcarElemento(driver, btnReportes );
               // takeScreenshot("screenshot_");
                tomarCaptura("Menu Reportes");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/a"),"El menu seleccionado es: "+menu+"");
                Utils.desenmarcarObjeto(driver, btnReportes);
                btnReportes.click();
                break;
            case "Definiciones":

                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnDefiniciones = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/a")));
                Utils.enmarcarElemento(driver, btnDefiniciones );
                //takeScreenshot("screenshot_");
                tomarCaptura("Menu Definiciones");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/a"),"El menu seleccionado es: "+menu+"");
                Utils.desenmarcarObjeto(driver, btnDefiniciones);
                btnDefiniciones.click();
                break;

            case "Configuracion":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnConfiguraciones = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/a")));
                Utils.enmarcarElemento(driver, btnConfiguraciones );
                tomarCaptura("Menu Configuracion");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/a"),"El menu seleccionado es: "+menu+"");
                Utils.desenmarcarObjeto(driver, btnConfiguraciones);
                btnConfiguraciones.click();
                break;
            default:
                System.out.println("Opción no válida");
        }

    }

    @And("luego el submenu de {string}")
    public void luegoElSubmenuDe(String subMenuD) throws InterruptedException, IOException {

        //aqui ---
        subMenuD = datos.get("subMenu");
        switch (subMenuD) {
            //movimientos
            case "Ingresar recepcion":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnIngresarRecepcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[1]/a")));
                Utils.enmarcarElemento(driver, btnIngresarRecepcion );
                tomarCaptura("Ingreso Recepcion");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[1]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.desenmarcarObjeto(driver, btnIngresarRecepcion);
                btnIngresarRecepcion.click();
                break;

            case "Salidas de Inventario":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnSalidaInventario = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a")));
                Utils.enmarcarElemento(driver, btnSalidaInventario );
                tomarCaptura("Salidas de Inventario");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.desenmarcarObjeto(driver, btnSalidaInventario);
                btnSalidaInventario.click();
                break;

            case "Mermas Altas y Traslados":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnMermas = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[3]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[]/ul/li[3]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnMermas );
                tomarCaptura("Mermas Altas y Traslados");
                Utils.desenmarcarObjeto(driver, btnMermas);
                btnMermas.click();
                break;

            case "Listar Movimientos":

                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnListarMov = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[4]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[4]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnListarMov );
                tomarCaptura("Listar Movimientos");
                Utils.desenmarcarObjeto(driver, btnListarMov);
                btnListarMov.click();
                break;

            //Procesos
            case "Transformaciones Aplicadas":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTransfAplicadas = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[1]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[1]/a"),"El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTransfAplicadas );
                tomarCaptura("Transformaciones Aplicadas");
                Utils.desenmarcarObjeto(driver, btnTransfAplicadas);
                btnTransfAplicadas.click();
                break;

            case "Toma de Inventario":

                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTomaInventario = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[2]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[2]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTomaInventario);
                tomarCaptura("Toma de Inventario");
                Utils.desenmarcarObjeto(driver, btnTomaInventario);
                btnTomaInventario.click();
                break;
            case "Toma Simplificada":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTomaSimplificada = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[3]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[3]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTomaSimplificada );
//                takeScreenshot("screenshot_");
                tomarCaptura("Toma Simplificada");
                Utils.desenmarcarObjeto(driver, btnTomaSimplificada);
                btnTomaSimplificada.click();
                break;

            //Reportes
            case "Reporte de Margen":
                WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnReporteMargen = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/ul/li/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/ul/li/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnReporteMargen );
                tomarCaptura("Reporte de Margen");
                Utils.desenmarcarObjeto(driver, btnReporteMargen);
                btnReporteMargen.click();
                break;

            //Definiciones
            case "Items":
                WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnItems = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[1]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[1]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnItems );
                tomarCaptura("Items");
                Utils.desenmarcarObjeto(driver, btnItems);
                btnItems.click();
                break;

            case "Proveedores":
                WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnProveedores = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[2]/a")));
                Utils.enmarcarElemento(driver, btnProveedores );
                tomarCaptura("Proveedores");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[2]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.desenmarcarObjeto(driver, btnProveedores);
                btnProveedores.click();
                break;

            case "Transformaciones":
                WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTransformaciones = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[3]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[3]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTransformaciones );
                tomarCaptura("Transformaciones");
                Utils.desenmarcarObjeto(driver, btnTransformaciones);
                btnTransformaciones.click();
                break;

            case "Lotes":
                WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnLotes = wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[4]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[4]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnLotes );
                tomarCaptura("Lotes");
                Utils.desenmarcarObjeto(driver, btnLotes);
                btnLotes.click();
                break;

            case "Reglas de stock critico":
                WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnStockCritico = wait13.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[5]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[5]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnStockCritico );
                tomarCaptura("Reglas de stock critico");
                Utils.desenmarcarObjeto(driver, btnStockCritico);
                btnStockCritico.click();
                break;

            //Configuraciones
            case "Ubicaciones":
                WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnUbicaciones = wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[1]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[1]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnUbicaciones );
                tomarCaptura("Ubicaciones");
                Utils.desenmarcarObjeto(driver, btnUbicaciones);
                btnUbicaciones.click();
                break;

            case "Categorias":
                WebDriverWait wait15 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnCategorias = wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[2]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[2]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnCategorias );
                tomarCaptura("Categorias");
                Utils.desenmarcarObjeto(driver, btnCategorias);
                btnCategorias.click();
                break;

            case "Tipos de Documentos":
                WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTipoDocumento = wait16.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[3]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[3]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTipoDocumento );
                tomarCaptura("Tipos de Documentos");
                Utils.desenmarcarObjeto(driver, btnTipoDocumento);
                btnTipoDocumento.click();
                break;

            case "Tipos de Codigo Inventario":
                WebDriverWait wait17 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnTipoCodigoInv = wait17.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[4]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[4]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnTipoCodigoInv );
                tomarCaptura("Tipos de Codigo Inventario");
                Utils.desenmarcarObjeto(driver, btnTipoCodigoInv);
                btnTipoCodigoInv.click();
                break;

            case "Procesos Administrador":
                WebDriverWait wait18 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement btnProcesosAdmin = wait18.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[5]/a")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[5]/a"), "El sub-menu seleccionado es: "+subMenuD+"");
                Utils.enmarcarElemento(driver, btnProcesosAdmin );
                tomarCaptura("Procesos Administrador");
                Utils.desenmarcarObjeto(driver, btnProcesosAdmin);
                btnProcesosAdmin.click();
                break;

            default:
                System.out.println("Opción no válida");
        }

    }

    @When("este en recepcion y haga click en digitar documento")
    public void esteEnRecepcionYHagaClickEnDigitarDocumento() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnDigitarDoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CREARRECEPCION\"]")));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CREARRECEPCION\"]"), "Recepcion");
        Utils.enmarcarElemento(driver, btnDigitarDoc );
        tomarCaptura("Vista Recepcion");
        Utils.desenmarcarObjeto(driver, btnDigitarDoc);
        btnDigitarDoc.click();

    }

    @And("aparece la vista de formulario")
    public void apareceLaVistaDeFormulario() throws InterruptedException {
        Thread.sleep(2000);
    }
    @And("ingresamos los datos de tipo documento {string}")
    public void ingresamosLosDatosDeTipoDocumento(String arg0) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement factura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCTIP\"]/option[2]")));
        Utils.enmarcarElemento(driver, factura );
        tomarCaptura("Vista Recepcion");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCTIP\"]/option[2]"), "Factura");
        Utils.desenmarcarObjeto(driver, factura);
        factura.click();

    }

    @And("ingresamos los datos de folio {string}")
    public void ingresamosLosDatosDeFolio(String arg0) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nroFolio1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0012DOCFOL")));
        nroFolio1.click();
        nroFolio1.clear();
        Utils.enmarcarElemento(driver, nroFolio1 );
        nroFolio1.sendKeys(datos.get("folio"));
        tomarCaptura("Vista Recepcion");
        esperarElementoYMedirTiempo(By.id("W0012DOCFOL"), "Factura");
        Utils.desenmarcarObjeto(driver, nroFolio1);

    }

    @And("ingresamos los datos de rut emisor {string}")
    public void ingresamosLosDatosDeRutEmisor(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement rutEmisor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0012DOCRUTEMI")));
//        long endTime = System.nanoTime(); // Fin de medición
//        rutEmisor.click();
//        Utils.enmarcarElemento(driver, rutEmisor );
//        rutEmisor.sendKeys(datos.get("rutEmisor"));
//        Utils.desenmarcarObjeto(driver, rutEmisor);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Rut Empisor' esté visible: " + duration + " ms");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rutEmisor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0012DOCRUTEMI")));
        rutEmisor.click();
        Utils.enmarcarElemento(driver, rutEmisor );
        rutEmisor.sendKeys(datos.get("rutEmisor"));
        esperarElementoYMedirTiempo(By.id("W0012DOCRUTEMI"), "rut Emisor");
        Utils.desenmarcarObjeto(driver, rutEmisor);

    }

    @And("ingresamos los datos de total neto {string}")
    public void ingresamosLosDatosDeTotalNeto(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement totalNeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCTOTNET\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        totalNeto.clear();
//        Utils.enmarcarElemento(driver, totalNeto );
//        totalNeto.sendKeys(datos.get("totalNeto"));
//        Utils.desenmarcarObjeto(driver, totalNeto);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Total Neto' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalNeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCTOTNET\"]")));
        totalNeto.clear();
        Utils.enmarcarElemento(driver, totalNeto );
        totalNeto.sendKeys(datos.get("totalNeto"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCTOTNET\"]"), "Total Neto");
        Utils.desenmarcarObjeto(driver, totalNeto);

    }

    @And("ingresamos los datos de total bruto {string}")
    public void ingresamosLosDatosDeTotalBruto(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement totalBruto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCTOTBRU\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        totalBruto.clear();
//        Utils.enmarcarElemento(driver, totalBruto );
//        totalBruto.sendKeys(datos.get("totalBruto"));
//        Utils.desenmarcarObjeto(driver, totalBruto);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Total Bruto' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalBruto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCTOTBRU\"]")));
        totalBruto.clear();
        Utils.enmarcarElemento(driver, totalBruto );
        totalBruto.sendKeys(datos.get("totalBruto"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCTOTBRU\"]"), "Total Bruto");
        Utils.desenmarcarObjeto(driver, totalBruto);

    }
    @And("ingresamos los datos de codigoP {string}")
    public void ingresamosLosDatosDeCodigoP(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement nroCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETCOD_0001\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        nroCodigo.clear();
//        Utils.enmarcarElemento(driver, nroCodigo );
//        nroCodigo.sendKeys(datos.get("codigo"));
//        Utils.desenmarcarObjeto(driver, nroCodigo);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Nro Codigo' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nroCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETCOD_0001\"]")));
        nroCodigo.clear();
        Utils.enmarcarElemento(driver, nroCodigo );
        nroCodigo.sendKeys(datos.get("codigo"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCDETCOD_0001\"]"), "Número Codigo");
        Utils.desenmarcarObjeto(driver, nroCodigo);
    }
    @And("ingresamos los datos de nombreP {string}")
    public void ingresamosLosDatosDeNombreP(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement nombreP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETCNT_0001\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        nombreP.clear();
//        Utils.enmarcarElemento(driver, nombreP );
//        nombreP.sendKeys(datos.get("nombreProd"));
//        Utils.desenmarcarObjeto(driver, nombreP);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'nombre Producto' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nombreP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETCNT_0001\"]")));
        nombreP.clear();
        Utils.enmarcarElemento(driver, nombreP );
        nombreP.sendKeys(datos.get("nombreProd"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCDETCOD_0001\"]"), "Nombre Producto");
        Utils.desenmarcarObjeto(driver, nombreP);
    }

    @And("ingresamos los datos de cantidadP {string}")
    public void ingresamosLosDatosDeCantidadP(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement cantidadP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/form/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/fieldset/div/div/div/div/div/div/div/div/table/tbody/tr/td[6]/input")));
//        long endTime = System.nanoTime(); // Fin de medición
//        cantidadP.clear();
//        Utils.enmarcarElemento(driver, cantidadP );
//        cantidadP.sendKeys(datos.get("cantidadP"));
//        Utils.desenmarcarObjeto(driver, cantidadP);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Cantidad' esté visible: " + duration + " ms");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cantidadP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/form/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/fieldset/div/div/div/div/div/div/div/div/table/tbody/tr/td[6]/input")));
        cantidadP.clear();
        Utils.enmarcarElemento(driver, cantidadP );
        cantidadP.sendKeys(datos.get("cantidadP"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCDETCOD_0001\"]"), "Nombre Producto");
        Utils.desenmarcarObjeto(driver, cantidadP);

    }

    @And("ingresamos los datos de precio neto {string}")
    public void ingresamosLosDatosDePrecioNeto(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement precioNeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETPRC_0001\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        precioNeto.clear();
//        Utils.enmarcarElemento(driver, precioNeto );
//        precioNeto.sendKeys(datos.get("precioNeto"));
//        Utils.desenmarcarObjeto(driver, precioNeto);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Precio Neto' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement precioNeto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETPRC_0001\"]")));
        precioNeto.clear();
        Utils.enmarcarElemento(driver, precioNeto );
        precioNeto.sendKeys(datos.get("precioNeto"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCDETPRC_0001\"]"), "Precio neto");
        Utils.desenmarcarObjeto(driver, precioNeto);

    }

    @And("ingresamos los datos de total {string}")
    public void ingresamosLosDatosDeTotal(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETTOT_0001\"]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        total.clear();
//        Utils.enmarcarElemento(driver, total );
//        total.sendKeys(datos.get("total"));
//        Utils.desenmarcarObjeto(driver, total);
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Precio Total' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012DOCDETTOT_0001\"]")));
        total.clear();
        Utils.enmarcarElemento(driver, total );
        total.sendKeys(datos.get("total"));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012DOCDETTOT_0001\"]"), "Precio neto");
        Utils.desenmarcarObjeto(driver, total);
    }

    @And("seleccionamos confirmar")
    public void seleccionamosConfirmar() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0012ENTER\"]")));
        Utils.enmarcarElemento(driver, confirmar );
        tomarCaptura("Formulario");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0012ENTER\"]"), "Se ingresan datos de formulario");
        Utils.desenmarcarObjeto(driver, confirmar);
        confirmar.click();

    }

    @And("luego guardar y registrar")
    public void luegoGuardarYRegistrar() throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement guardarReg = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDARREGISTRAR\"]")));
        Utils.enmarcarElemento(driver, guardarReg );
        tomarCaptura("Msj Alerta Pop-up");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDARREGISTRAR\"]"), "Mensaje de Alerta Pop-up");
        Utils.desenmarcarObjeto(driver, guardarReg);
        guardarReg.click();
        driver.switchTo().defaultContent();
    }

    @And("luego seleccionamos registrar mercaderia")
    public void luegoSeleccionamosRegistrarMercaderia() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regMerc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vREGISTRARMERCADERIA_ACTION_0001\"]")));
        Utils.enmarcarElemento(driver, regMerc );
        tomarCaptura("Seleccion Registro de Mercaderia");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vREGISTRARMERCADERIA_ACTION_0001\"]"), "Seleccion Registro de Mercaderia");
        Utils.desenmarcarObjeto(driver, regMerc);
        regMerc.click();
    }

    @And("seleccionamos {string}")
    public void seleccionamos(String arg0) throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        long startTime = System.nanoTime(); // Inicio de medición
//        WebElement ubi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vUBICOD\"]/option[2]")));
//        long endTime = System.nanoTime(); // Fin de medición
//        Utils.enmarcarElemento(driver, ubi );
//        Utils.desenmarcarObjeto(driver, ubi);
//        ubi.click();
//        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
//        System.out.println("⏳ Tiempo de espera hasta que el elemento 'Ubicacion' esté visible: " + duration + " ms");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ubi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vUBICOD\"]/option[2]")));
        Utils.enmarcarElemento(driver, ubi );
        Utils.desenmarcarObjeto(driver, ubi);
      //  BaseTest.tomarCaptura("Seleccion Registro de Mercaderia");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vREGISTRARMERCADERIA_ACTION_0001\"]"), "Seleccion Registro de Mercaderia");
        ubi.click();

    }
    @And("ingresamos los datos de codigo {string}")
    public void ingresamosLosDatosDeCodigo(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement ingCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOCANTIDADINGRESADO\"]")));
        Utils.enmarcarElemento(driver, ingCodigo );
        ingCodigo.sendKeys(datos.get("codigo"));
        Utils.desenmarcarObjeto(driver, ingCodigo);
        actions.sendKeys(ingCodigo, Keys.RETURN).perform();
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOCANTIDADINGRESADO\"]"), "Ingrese codigo");

    }
    @And("ingresamos los datos de cantidad {string}")
    public void ingresamosLosDatosDeCantidad(String arg0) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement cantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOCANTIDADINGRESADO\"]")));
        Utils.enmarcarElemento(driver, cantidad );
        cantidad.sendKeys(datos.get("cantidad"));
        Utils.desenmarcarObjeto(driver, cantidad);
        actions.sendKeys(cantidad, Keys.RETURN).perform();
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOCANTIDADINGRESADO\"]"), "cantidad de items");
    }

    @And("seleccionamos guardar y conciliar")
    public void seleccionamosGuardarYConciliar() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement guardYConciliar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDARCONCILIAR\"]")));
        Utils.enmarcarElemento(driver, guardYConciliar );
        tomarCaptura("Msj Alerta Pop-up");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDARCONCILIAR\"]"), "Mensaje de Alerta Pop-up");
        Utils.desenmarcarObjeto(driver, guardYConciliar);
        guardYConciliar.click();
    }

    @And("aceptamos el popup emergente")
    public void aceptamosElPopupEmergente() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/form/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/input[1]")));
        Utils.enmarcarElemento(driver, popup1 );
        tomarCaptura("Msj Alerta Pop-up");
        esperarElementoYMedirTiempo(By.xpath("//html/body/form/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/input[1]"), "Mensaje de Alerta Pop-up");
        Utils.desenmarcarObjeto(driver, popup1);
        popup1.click();
    }

    @And("seleccionamos el criterio de distribucion")
    public void seleccionamosElCriterioDeDistribucion() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement crit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vDOCCRICOST\"]")));
        Utils.enmarcarElemento(driver, crit1 );
        Utils.desenmarcarObjeto(driver, crit1);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vDOCCRICOST\"]"), "criterio de Distribucion");
        crit1.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement crit2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vDOCCRICOST\"]/option[2]")));
        Utils.enmarcarElemento(driver, crit2 );
        Utils.desenmarcarObjeto(driver, crit2);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vDOCCRICOST\"]/option[2]"), "criterio de Distribucion 2");
        crit2.click();

    }

    @And("seleccionamos el picking")
    public void seleccionamosElPicking() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement picking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridpickingContainerRow_0001\"]")));
        WebElement pickingClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridpickingContainerRow_0001\"]/td[5]/p")));
        Utils.enmarcarElemento(driver, picking );
        Utils.desenmarcarObjeto(driver, picking);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GridpickingContainerRow_0001\"]"), "seleccion picking");
        pickingClick.click();

    }

    @And("seleccionamos conciliacion")
    public void seleccionamosConciliacion() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement conciliacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridconciliacionsdtContainerRow_0001\"]")));
        WebElement conciliacionClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridconciliacionsdtContainerRow_0001\"]/td[3]")));
        Utils.enmarcarElemento(driver, conciliacion );
        Utils.desenmarcarObjeto(driver, conciliacion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GridconciliacionsdtContainerRow_0001\"]"), "seleccion conciliancion");
        conciliacionClick.click();

    }

    @And("luego seleccionamos asociar")
    public void luegoSeleccionamosAsociar() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement asociar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ASOCIAR\"]")));
        Utils.enmarcarElemento(driver, asociar );
        Utils.desenmarcarObjeto(driver, asociar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"ASOCIAR\"]"), "Seleccion Asociar");
        asociar.click();
    }

    @And("confirmamos la conciliacion")
    public void confirmamosLaConciliacion() throws InterruptedException, IOException {
        //popUP: Ítem ya asociado. Confirme si desea asociar nuevamente el ítem Arroz Miraflores Grado 1 – 1 Kg./
        // Ítem ya asociado. Confirme si desea asociar nuevamente el ítem Arroz Miraflores Grado 1 – 1 Kg.
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ASOCIAR\"]")));
        Utils.enmarcarElemento(driver, popup );
        tomarCaptura("Msj Alerta pop-up");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"ASOCIAR\"]"), "Mensaje de Alerta Pop-up");
        Utils.desenmarcarObjeto(driver, popup);
        popup.click();
        driver.switchTo().defaultContent();
    }

    @And("luego seleccionamos conciliar")
    public void luegoSeleccionamosConciliar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement conciliar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDAR\"]")));
        Utils.enmarcarElemento(driver, conciliar );
        Utils.desenmarcarObjeto(driver, conciliar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDAR\"]"), "seleccion conciliar");
        conciliar.click();
    }

    @And("aceptamos el pop-up")
    public void aceptamosElPopUp() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]")));
        Utils.enmarcarElemento(driver, confirmar );
        tomarCaptura("Msj Alerta pop-up Confirmar");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]"), "Mensaje de Alerta Pop-up");
        Utils.desenmarcarObjeto(driver, confirmar);
        confirmar.click();
    }

    @Then("debe de mostras la vista del documento de factura")
    public void debeDeMostrasLaVistaDelDocumentoDeFactura() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement documentoFactura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gxp0_b\"]")));
        WebElement cerrarFactura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gxp0_cls\"]")));
        Utils.enmarcarElemento(driver, documentoFactura );
        Thread.sleep(3000);
        tomarCaptura("Documento Factura");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"gxp0_cls\"]"), "Documento Factura");
        Utils.desenmarcarObjeto(driver, documentoFactura);
        cerrarFactura.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement volver = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VOLVER\"]")));
        Utils.enmarcarElemento(driver, volver );
        tomarCaptura("");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"VOLVER\"]"), "");
        Utils.desenmarcarObjeto(driver, volver);
        volver.click();

        //vista recepcion
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tablaRecepcion = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GriddocumentoContainerTbl\"]")));
        Utils.enmarcarElemento(driver, tablaRecepcion );
        tomarCaptura("Vista Recepcion");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GriddocumentoContainerTbl\"]"), "Vista Recepcion");
        Utils.desenmarcarObjeto(driver, tablaRecepcion);
        Thread.sleep(3000);

        // Finalizar prueba
        try {
            document.close();
            pdfDoc.close();
            driver.quit();
            System.out.println("PDF generado con éxito en: " + pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  driver.quit();

    }
    public boolean esperarElementoVisible(By locator, int tiempoEsperaSegundos) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaSegundos));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("✅ Elemento encontrado: " + locator);
            System.out.println("✅ Se demoro: " + wait + "en encontrar el objeto");
            return true;
        } catch (TimeoutException e) {
            System.out.println("⏳ Tiempo de espera agotado. Elemento NO encontrado: " + locator);
            return false;
        }
    }

}
