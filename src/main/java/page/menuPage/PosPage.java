package page.menuPage;

import definitions.Commons.BaseTest;
import definitions.Commons.Utils;
import definitions.menuDef.PosDef;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import static definitions.Commons.BaseTest.*;
import static definitions.Commons.BaseTest.esperarElementoYMedirTiempo;
import static page.menuPage.PosPage.*;

public class PosPage {

    static WebDriver driver = BaseTest.getDriver();


    public static void visualizarVistaPos() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement txtVistaPos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header")));
        Utils.enmarcarElemento(driver, txtVistaPos );
        BaseTest.tomarCaptura("Vista Home POS");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header"), "Vista de Pos ");
        Utils.desenmarcarObjeto(driver, txtVistaPos);
    }
    public static void seleccionOpcioPOS(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[2]/div[2]/div/div/div/div/div[1]/div/header/span")));
        Utils.enmarcarElemento(driver, btnMenu );
        // BaseTest.tomarCaptura("Menu Configuracion");
        esperarElementoYMedirTiempo(By.xpath("/html/body/form/div[2]/div[2]/div/div/div/div/div[1]/div/header/span"), "");
        Utils.desenmarcarObjeto(driver, btnMenu);
        btnMenu.click();
    }

    public static void seleccionMenuPos(String menuP) throws InterruptedException {

        switch (menuP) {
            case "Configuracion":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnConfiguracion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[1]/a")));
                Utils.enmarcarElemento(driver, btnConfiguracion );
                BaseTest.tomarCaptura("Menu Configuracion");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[1]/a"), STR."El menu seleccionado es: \{menuP}");
                Utils.desenmarcarObjeto(driver, btnConfiguracion);
                btnConfiguracion.click();
                break;

            case "Gestion":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnGestion = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/a")));
                Utils.enmarcarElemento(driver, btnGestion );
                //takeScreenshot("screenshot_");
                BaseTest.tomarCaptura("Menu Gestion");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/a"), STR."El menu seleccionado es: \{menuP}");
                Utils.desenmarcarObjeto(driver, btnGestion);
                btnGestion.click();
                break;

            case "Definiciones":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnDefiniciones = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/a")));
                Utils.enmarcarElemento(driver, btnDefiniciones );
                BaseTest.tomarCaptura("Menu Definiciones");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/a"), STR."El menu seleccionado es: \{menuP}");
                Utils.desenmarcarObjeto(driver, btnDefiniciones);
                btnDefiniciones.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static void seleccionamosSubMenuPOS(String subMenuP) throws InterruptedException {
        Thread.sleep(3000);
        switch (subMenuP) {
            case "Usuarios":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkUsuarios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[1]/a")));
                Utils.enmarcarElemento(driver, linkUsuarios);
                BaseTest.tomarCaptura("Usuarios");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[1]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkUsuarios);
                linkUsuarios.click();
                break;

            case "Asignacion de Perfiles":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkAsigPerfiles = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[2]/a")));
                Utils.enmarcarElemento(driver, linkAsigPerfiles);
                //takeScreenshot("screenshot_");
                BaseTest.tomarCaptura("Asignacion de Perfiles");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[2]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkAsigPerfiles);
                linkAsigPerfiles.click();
                break;

            case "Enrolamiento De Equipos":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkEnrolamiento = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[3]/a")));
                Utils.enmarcarElemento(driver, linkEnrolamiento);
                BaseTest.tomarCaptura("Enrolamiento de Equipos");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[3]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkEnrolamiento);
                linkEnrolamiento.click();
                break;

            case "Clientes":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkCliente = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[4]/a")));
                Utils.enmarcarElemento(driver, linkCliente);
                BaseTest.tomarCaptura("Clientes");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[4]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkCliente);
                linkCliente.click();

            case "Productos":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkProductos = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[5]/a")));
                Utils.enmarcarElemento(driver, linkProductos);
                BaseTest.tomarCaptura("Productos");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[5]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkProductos);
                linkProductos.click();
                break;

            case "Balanzas":
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkBalanzas = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[6]/a")));
                Utils.enmarcarElemento(driver, linkBalanzas);
                BaseTest.tomarCaptura("Balanzas");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[6]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkBalanzas);
                linkBalanzas.click();
                break;

            case "Lista de Precios":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement LinkListaDePrecios = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[7]/a")));
                Utils.enmarcarElemento(driver, LinkListaDePrecios);
                BaseTest.tomarCaptura("Lista de Precios");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[7]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, LinkListaDePrecios);
                LinkListaDePrecios.click();
                break;

            case "Grupo Selector":
                WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkGrupoSelector = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[8]/a")));
                Utils.enmarcarElemento(driver, linkGrupoSelector);
                BaseTest.tomarCaptura("Grupo Selector");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[8]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkGrupoSelector);
                linkGrupoSelector.click();
                break;

            case "Categoria Precio":
                WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkCatPrecio = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[9]/a")));
                Utils.enmarcarElemento(driver, linkCatPrecio);
                BaseTest.tomarCaptura("Categoria Precio");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[9]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkCatPrecio);
                linkCatPrecio.click();
                break;

            case "Autoriza Este Terminal":
                WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement linkAutTerminal = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[10]/a")));
                Utils.enmarcarElemento(driver, linkAutTerminal);
                BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[10]/a"), STR."El submenu seleccionado es: \{subMenuP}");
                Utils.desenmarcarObjeto(driver, linkAutTerminal);
                linkAutTerminal.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static void visualizarVistaEnrolamientoTerminales() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtEnrolamiento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Grid1ContainerTbl\"]")));
        Utils.enmarcarElemento(driver, txtEnrolamiento);
        BaseTest.tomarCaptura("Vista Enrolamiento");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"Grid1ContainerTbl\"]"), "Vista Enrolamiento");
        Utils.desenmarcarObjeto(driver, txtEnrolamiento);
    }
    public static void seleccionQR() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkCodQR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vLINKACCESO_0014\"]")));
        Utils.enmarcarElemento(driver, linkCodQR);
        BaseTest.tomarCaptura("codigo QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vLINKACCESO_0014\"]"), "codigo QR" );
        Utils.desenmarcarObjeto(driver, linkCodQR);
        linkCodQR.click();
    }
    public static void seleccionBtnCopiar() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnCopiarQR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"COPIAR\"]")));
        Utils.enmarcarElemento(driver, btnCopiarQR);
        BaseTest.tomarCaptura("btn copiar QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"COPIAR\"]"), "btn copiar QR" );
        Utils.desenmarcarObjeto(driver, btnCopiarQR);
        btnCopiarQR.click();
        driver.switchTo().defaultContent();
    }
    public static void abrirnuevaPestania(){
        try {
            Thread.sleep(2000);
            // Usa Actions para abrir una nueva pestaña
            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();

            // Espera breve para que se abra la pestaña
            Thread.sleep(1000);

            // Cambia el foco a la nueva pestaña
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // Simula pegar una URL copiada (como si estuviera en el portapapeles)
            //String urlCopiada = "https://qa.enternet.cl/AndesPOS2407/servlet/com.andes.pos.contextoacceso.locallogininitenc?MjAyNS0wNS0yM0gxMS01Mb8V5RN%2F6%2FgURn4DfXhtm1iLWUpUBwvUNJyFRL%2BrUyN7HhEnwaDc8imqe%2FDFwvUoLpRB0UOs0lx1QJhKMmyVop8%3D";  // url caja 4
            String urlCopiada = "https://qa.enternet.cl/AndesPOS2407/servlet/com.andes.pos.contextoacceso.locallogininitenc?MjAyNS0wNS0yOEgxMi01Ml9vSGnwMD3ex27HP3yti0Kg0s%2BaASp0%2B0RFjiVydgeNaz2MTKA087lk6ghZPv%2Blqcym46uPmXQ%2B%2FdVFbSrW54I%3D";  // url caja 5
            driver.get(urlCopiada);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra el navegador después de unos segundos
            try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
        }

    }
    public static void clickBtnIrALogin() throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbTipoPerfil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IRALOGIN\"]")));
        Utils.enmarcarElemento(driver, chbTipoPerfil);
         BaseTest.tomarCaptura("Ir a Login");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IRALOGIN\"]"), "Ir a Login" );
        Utils.desenmarcarObjeto(driver, chbTipoPerfil);
        chbTipoPerfil.click();


    }
    public static void seleccionTipoPerfil() throws InterruptedException, AWTException {
        // Simular teclas con Robot
        Robot robot = new Robot();
        Thread.sleep(2000);
        // Presionar ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbTipoPerfil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vTIPODEPERFIL")));
        Utils.enmarcarElemento(driver, chbTipoPerfil);
        esperarElementoYMedirTiempo(By.id("vTIPODEPERFIL"), "Tipo De Perfil" );

        Select select = new Select(chbTipoPerfil);
        select.selectByIndex(3); //cajera admin
        Utils.desenmarcarObjeto(driver, chbTipoPerfil);

    }
    public static void seleccionarModuloIDL() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbModulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMODULOIDL\"]")));
        Utils.enmarcarElemento(driver, chbModulo);
        // BaseTest.tomarCaptura("codigo QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMODULOIDL\"]"), "Modulo IDL" );
        Thread.sleep(2000);
        Select select = new Select(chbModulo);
        select.selectByIndex(2);
        Utils.desenmarcarObjeto(driver, chbModulo);

    }
    public static void ingresarRut(){
        String rutPos = PosDef.datosPOS.get("userPOS");
        if (rutPos == null || rutPos.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'rutPos' no puede ser null o vacío");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vRUT\"]"), "Vista Enrolamiento");
        WebElement txtRut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vRUT\"]")));
        Utils.enmarcarElemento(driver, txtRut);
        Utils.desenmarcarObjeto(driver, txtRut);

        txtRut.clear();
        txtRut.sendKeys(rutPos);

    }
    public static void ingresarClave(){
        String clavePos = PosDef.datosPOS.get("clavePOS");
        if (clavePos == null || clavePos.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'clavePos' no puede ser null o vacío");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPASSWORD\"]"), "Vista Ingreso Clave");
        WebElement txtClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPASSWORD\"]")));
        Utils.enmarcarElemento(driver, txtClave);
        Utils.desenmarcarObjeto(driver, txtClave);
        txtClave.clear();
        txtClave.sendKeys(clavePos);
    }
    public static void seleccionarBtnIngresar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CONFIRMAR\"]"), "Ingresar" );
        WebElement btnIngresar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, btnIngresar);
        tomarCaptura("Ingresar");
        Utils.desenmarcarObjeto(driver, btnIngresar);
        btnIngresar.click();
        Thread.sleep(2000);
    }
//    public static void seleccionarCajaConNuestroNombre() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement linkCaja = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_CAJERONOMBRE_0004\"]")));
//        Utils.enmarcarElemento(driver, linkCaja);
//        tomarCaptura("Seleccion Caja");
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"span_CAJERONOMBRE_0004\"]"), "Seleccion Caja" );
//        Utils.desenmarcarObjeto(driver, linkCaja);
//        linkCaja.click();
//    }
public static void seleccionarCajaConNuestroNombre() throws InterruptedException {
    String nombreCajero = PosDef.datosPOS.get("cajeroPos");

    if (nombreCajero == null || nombreCajero.isEmpty()) {
        throw new IllegalArgumentException("❌ 'cajeroPos' no puede ser null o vacío");
    }
    System.out.println("🔍 Buscando el cajero con nombre: " + nombreCajero);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    // Busca cualquier elemento tipo <span> que contenga exactamente ese nombre
    String xpathDinamico = String.format("//span[contains(text(),'%s')]", nombreCajero);
    esperarElementoYMedirTiempo(By.xpath(xpathDinamico), "Seleccion Caja para: " + nombreCajero);
    WebElement caja = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDinamico)));
    Utils.enmarcarElemento(driver, caja);
    tomarCaptura("Seleccion Caja: " + nombreCajero);

    Utils.desenmarcarObjeto(driver, caja);
    caja.click();
}
    public static void clickBtnNuevaVenta() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnNuevaVenta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NUEVAVENTAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnNuevaVenta);
        BaseTest.tomarCaptura("+ Nueva Venta");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NUEVAVENTAContainer\"]/button"), "+ Nueva Venta" );
        Utils.desenmarcarObjeto(driver, btnNuevaVenta);
        btnNuevaVenta.click();
    }
    public static void ingresarRutcliente(){
        String rutClienteFiado = PosDef.datosPOS.get("rutClienteFiado");
        if (rutClienteFiado == null || rutClienteFiado.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'rutClienteFiado' no puede ser null o vacío");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPASSWORD\"]"), "Vista Ingreso Cliente");
        WebElement txtClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPASSWORD\"]")));
        Utils.enmarcarElemento(driver, txtClave);
        Utils.desenmarcarObjeto(driver, txtClave);
        txtClave.clear();
        txtClave.sendKeys(rutClienteFiado);
    }
    public static void clickBtnCliente() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SELECCIONACLIENTEContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnCliente);
       // BaseTest.tomarCaptura("+ Nueva Venta");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SELECCIONACLIENTEContainer\"]/button"), "Click boton Cliente" );
        Utils.desenmarcarObjeto(driver, btnCliente);
        btnCliente.click();
    }
    public static void seleccionCliente() throws InterruptedException {
        Thread.sleep(2000);

        driver.switchTo().frame(0);
        Thread.sleep(2000);
        // Nombre a buscar
        String nombreCliente = PosDef.datosPOS.get("nombreCliente");
        List<WebElement> nombres = driver.findElements(By.xpath("//td[7]"));
        // Recorre los nombres y hace clic cuando lo encuentre
        for (WebElement nombre : nombres) {
            if (nombre.getText().equalsIgnoreCase(nombreCliente)) {
                tomarCaptura("Seleccion Cliente");
                nombre.click();
                break;
            }
        }
        driver.switchTo().defaultContent();

    }
    public static void ingresarProductoPorDescripcion() throws InterruptedException {
//        Actions actions = new Actions(driver);
        String prodDesc =PosDef.datosPOS.get("descProd");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, txtDescripcion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Ingrese codigo o descripcion de producto..." );
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        txtDescripcion.sendKeys( prodDesc + Keys.ENTER);
        BaseTest.tomarCaptura("ingreso por descripcion");

    }
    public static void ingresarProductoPorCodigo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement txtCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, txtCodigo);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "ingreso por codigo" );
        Utils.desenmarcarObjeto(driver, txtCodigo);
        txtCodigo.sendKeys(datosPOS.get("codProd"));
        BaseTest.tomarCaptura("ingreso por codigo");
    }
    public static void clickBtnEnter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnEnter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNBUSCAPRODUCTOContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnEnter);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNBUSCAPRODUCTOContainer\"]/button"), "Click Enter" );
        Utils.desenmarcarObjeto(driver, btnEnter);
        btnEnter.click();
       // BaseTest.tomarCaptura("Click Enter");
    }
    public static  void ingresarCantidadDeProducto(){

    }
    public static void ingresarFormaDePago() throws InterruptedException {
        String formaPago = datosPOS.get("formaPago");
        switch (formaPago) {
            case "Efectivo":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnEfectivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnEfectivo);
                //BaseTest.tomarCaptura("Usuarios");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnEfectivo);
                btnEfectivo.click();
                break;
            case "Tarjeta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnTarjeta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnTarjeta);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnTarjeta);
                btnTarjeta.click();
                break;
            case "Credito":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnCredito = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCREDITO\"]")));
                Utils.enmarcarElemento(driver, btnCredito);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCREDITO\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnCredito);
                btnCredito.click();
                break;
            case "Convenio":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnConvenio = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCONVENIO\"]")));
                Utils.enmarcarElemento(driver, btnConvenio);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCONVENIO\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnConvenio);
                btnPagos.click();
                btnConvenio.click();
                break;
            case "Transferencia":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos2;
                btnPagos2 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnTransferencia = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]")));
                Utils.enmarcarElemento(driver, btnTransferencia);
                BaseTest.tomarCaptura(STR."Metodo de pago \{formaPago}");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnTransferencia);
                btnPagos2.click();
                btnTransferencia.click();
                break;
            case "Cheque":
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos3;
                btnPagos3 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnCheque = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCHEQUE\"]")));
                Utils.enmarcarElemento(driver, btnCheque);
                BaseTest.tomarCaptura(STR."Metodo de pago \{formaPago}");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCHEQUE\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnCheque);
                btnPagos3.click();
                btnCheque.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static void ingresarTipoDePago() throws InterruptedException {
       String tipoPago = datosPOS.get("tipoPago");
        switch (tipoPago) {
            case "Efectivo":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnEfectivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnEfectivo);
                //BaseTest.tomarCaptura("Usuarios");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnEfectivo);
                btnEfectivo.click();
                break;
            case "Tarjeta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnTarjeta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnTarjeta);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnTarjeta);
                btnTarjeta.click();
                break;
            case "Credito":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnCredito = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCREDITO\"]")));
                Utils.enmarcarElemento(driver, btnCredito);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCREDITO\"]"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnCredito);
                btnCredito.click();
                break;
            case "Convenio":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnConvenio = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCONVENIO\"]")));
                Utils.enmarcarElemento(driver, btnConvenio);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCONVENIO\"]"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnConvenio);
                btnPagos.click();
                btnConvenio.click();
                break;
            case "Transferencia":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos2;
                btnPagos2 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnTransferencia = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]")));
                Utils.enmarcarElemento(driver, btnTransferencia);
                BaseTest.tomarCaptura(STR."Metodo de pago \{tipoPago}");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnTransferencia);
                btnPagos2.click();
                btnTransferencia.click();
                break;
            case "Cheque":
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos3;
                btnPagos3 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnCheque = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCHEQUE\"]")));
                Utils.enmarcarElemento(driver, btnCheque);
                BaseTest.tomarCaptura(STR."Metodo de pago \{tipoPago}");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCHEQUE\"]"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnCheque);
                btnPagos3.click();
                btnCheque.click();
                break;
            case "Fiado":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPagos4;
                btnPagos4 = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                WebElement btnFiado = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCHEQUE\"]")));
                Utils.enmarcarElemento(driver, btnFiado);
                BaseTest.tomarCaptura(STR."Metodo de pago \{tipoPago}");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCHEQUE\"]"), STR."El metodo de pago escojido es: \{tipoPago}");
                Utils.desenmarcarObjeto(driver, btnFiado);
                btnPagos4.click();
                btnFiado.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static void ingresoDeDatosParaElPago() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtMontoPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vXNOTAVENTAPAGOMONTO\"]")));
        Utils.enmarcarElemento(driver, txtMontoPago);
        BaseTest.tomarCaptura("Datos del Pago");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vXNOTAVENTAPAGOMONTO\"]"), "Datos del Pago" );
        Utils.desenmarcarObjeto(driver, txtMontoPago);
        txtMontoPago.sendKeys(datosPOS.get("MontoPago"));
        driver.switchTo().defaultContent();
    }

    public static void seleccionTipoDeEmision(String tipoEmision){
        tipoEmision = datosPOS.get("tipoPago");
        switch (tipoEmision) {
            case "Factura":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFactura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRFACTURAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnFactura);
                //BaseTest.tomarCaptura("Usuarios");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRFACTURAContainer\"]/button"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnFactura);
                btnFactura.click();
                break;
            case "Boleta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnTarjeta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRBOLETAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnTarjeta);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRBOLETAContainer\"]/button"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnTarjeta);
                btnTarjeta.click();
                break;
            case "Ticket":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnEmitir = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUP1Container\"]/div/div[1]/span")));
                WebElement btnEmitirTicket = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRTICKET\"]")));
                Utils.enmarcarElemento(driver, btnEmitirTicket);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRTICKET\"]"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnEmitirTicket);
                btnEmitir.click();
                btnEmitirTicket.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static void seleccionarBtnGuardar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDAR\"]")));
        Utils.enmarcarElemento(driver, btnGuardar);
        //BaseTest.tomarCaptura("Autoriza Este Terminal");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDAR\"]"), "click btn Guardar");
        Utils.desenmarcarObjeto(driver, btnGuardar);
        btnGuardar.click();
    }
    public static void clickBtnVendedor(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnVendedor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SELECCIONAVENDEDORContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnVendedor);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SELECCIONAVENDEDORContainer\"]/button"), "click btn Vendedor");
        Utils.desenmarcarObjeto(driver, btnVendedor);
        btnVendedor.click();
    }
    public static void seleccionarVendedor(String nombreVendedor) throws InterruptedException {
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        // Nombre a buscar
        nombreVendedor = datosPOS.get("nombreVendedor");
        List<WebElement> nombres = driver.findElements(By.xpath("//td[4]"));
        // Recorre los nombres y hace clic cuando lo encuentre
        for (WebElement nombre : nombres) {
            if (nombre.getText().equalsIgnoreCase(nombreVendedor)) {
                BaseTest.tomarCaptura("Seleccion Vendedor");
                nombre.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
    }
    public static void clickBtnGlosa(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"EDITARGLOSAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnGlosa);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"EDITARGLOSAContainer\"]/button"), "click btn Glosa");
        Utils.desenmarcarObjeto(driver, btnGlosa);
        btnGlosa.click();
    }
    public static void escribirGlosa() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtEscribirGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vNOTAVENTAGLOSA\"]")));
        WebElement btnConfirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, txtEscribirGlosa);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vNOTAVENTAGLOSA\"]"), "Escribir Glosa" );
        Utils.desenmarcarObjeto(driver, txtEscribirGlosa);
        txtEscribirGlosa.sendKeys(datosPOS.get("glosa"));
        BaseTest.tomarCaptura("Escribir Glosa");
        btnConfirmar.click();
        driver.switchTo().defaultContent();
    }
    public static void visualizarInformacionDePago(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rowInfoPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164ATTRIBUTESCONTAINERTABLE_ATTRIBUTES1\"]")));
        Utils.enmarcarElemento(driver, rowInfoPago);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164ATTRIBUTESCONTAINERTABLE_ATTRIBUTES1\"]"), "Informacion de Pago");
        Utils.desenmarcarObjeto(driver, rowInfoPago);
       // btnVendedor.click();
    }
    public static void escribirProductoEnFiltroDespensa() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDespensa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164vCLASIFICADORACATCOD_0001\"]")));
        Utils.enmarcarElemento(driver, txtDespensa);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164vCLASIFICADORACATCOD_0001\"]"), "ingreso de producto por filtro" );
        Utils.desenmarcarObjeto(driver, txtDespensa);
        BaseTest.tomarCaptura("ingreso de producto por filtro");
        txtDespensa.sendKeys(datosPOS.get("catDespensa"));
    }
    public static void escribirProductoEnFiltroANNO() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCatAnno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0001\"]")));
        Utils.enmarcarElemento(driver, txtCatAnno);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0001\"]"), "ingreso de producto por filtro" );
        Utils.desenmarcarObjeto(driver, txtCatAnno);
        BaseTest.tomarCaptura("ingreso de producto por filtro");
        txtCatAnno.sendKeys(datosPOS.get("catANNO"));
    }
    public static void escribirProductoEnFiltroOtros() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCatOtros = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0002\"]")));
        Utils.enmarcarElemento(driver, txtCatOtros);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0002\"]"), "ingreso de producto por filtro" );
        Utils.desenmarcarObjeto(driver, txtCatOtros);
        BaseTest.tomarCaptura("ingreso de producto por filtro");
        txtCatOtros.sendKeys(datosPOS.get("catOtros"));
    }
    public static void clickBtnTransportista() throws InterruptedException {
        Thread.sleep(2500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //*[@id="DATOSTRANSPORTISTAContainer"]/button
        WebElement btnTransportista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DATOSTRANSPORTISTAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnTransportista);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"DATOSTRANSPORTISTAContainer\"]/button"), "click btn transportista");
        Utils.desenmarcarObjeto(driver, btnTransportista);
        btnTransportista.click();
    }
    public static void seleccionarMotivoDeTraslado() throws InterruptedException {Thread.sleep(2500);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));                                     //*[@id="vMOTIVOTRASLADO"]
        WebElement chbMTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMOTIVOTRASLADO\"]")));
        Utils.enmarcarElemento(driver, chbMTraslado);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMOTIVOTRASLADO\"]"), "Motivo de Traslado" );
        Thread.sleep(2000);
        Select select = new Select(chbMTraslado);
        select.selectByIndex(2);  //1 Operación Constituye Venta, 2 Venta Por Efectuar, 3 Consignaciones, 4 Entrega Gratuita
        Utils.desenmarcarObjeto(driver, chbMTraslado);
      driver.switchTo().defaultContent();
    }
    public static void seleccionarTipoDeTraslado() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbMTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vTIPOTRASLADO\"]")));
        Utils.enmarcarElemento(driver, chbMTraslado);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vTIPOTRASLADO\"]"), "Tipo de Traslado" );
        Thread.sleep(2000);
        Select select = new Select(chbMTraslado);
        select.selectByIndex(2);  //1 Despacho por Cuenta del Receptor, 2 Despacho por Cuenta de Emisor A Cliente, 3 Despacho por Cuenta del Emisor a Otras Instalaciones, 4 Sin Definir
        Utils.desenmarcarObjeto(driver, chbMTraslado);
        driver.switchTo().defaultContent();
    }
    public static void ingresarNombreChofer() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtNombreChofer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vNOMBRECHOFER\"]")));
        Utils.enmarcarElemento(driver, txtNombreChofer);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vNOMBRECHOFER\"]"), "Nombre de Chofer" );
        Utils.desenmarcarObjeto(driver, txtNombreChofer);
        txtNombreChofer.sendKeys(datosPOS.get("nombreChofer"));
        driver.switchTo().defaultContent();
    }
    public static void ingresarRutChofer(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtRutChofer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vRUTCHOFER\"]")));
        Utils.enmarcarElemento(driver, txtRutChofer);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vRUTCHOFER\"]"), "Rut de Chofer" );
        Utils.desenmarcarObjeto(driver, txtRutChofer);
        txtRutChofer.sendKeys(datosPOS.get("rutChofer"));
        driver.switchTo().defaultContent();
    }
    public static void ingresarPatente() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtPatente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPATENTE\"]")));
        WebElement btnConfirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, txtPatente);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPATENTE\"]"), "Nro Patente");
        Utils.desenmarcarObjeto(driver, txtPatente);
        txtPatente.sendKeys(datosPOS.get("patente"));
        BaseTest.tomarCaptura("Nro Patente");
        btnConfirmar.click();
        driver.switchTo().defaultContent();
        cerrarDriver();
    }
    public static void clickBtnBuscar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164BUSCAR\"]")));
        Utils.enmarcarElemento(driver, btnBuscar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164BUSCAR\"]"), "boton buscar" );
        Utils.desenmarcarObjeto(driver, btnBuscar);
        BaseTest.tomarCaptura("Boton Buscar ");
        btnBuscar.click();
    }
    public static void hacerClickEnProducto() throws InterruptedException {
        Thread.sleep(2000);
        // Texto que deseas buscar
        String textoBuscado = datosPOS.get("descProd") ;//"COMBUSTIBLE 95";
        // Obtiene todas las filas de la tabla
        List<WebElement> filas = driver.findElements(By.cssSelector("table tr"));

        // Recorre cada fila para buscar el texto
        for (WebElement fila : filas) {
            if (fila.getText().contains(textoBuscado)) {
                // Busca el botón de lupa en la fila encontrada y hace clic
                WebElement txtNombre = fila.findElement(By.xpath("//td[3]"));
                txtNombre.click();
                BaseTest.tomarCaptura("seleccion de producto ");
                break;
            }
        }
        cerrarDriver();
    }
    public static void visualizarInformacionDeProducto() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"COLUMN1\"]/div")));
        WebElement btnCerrar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CERRAR\"]")));
        Utils.enmarcarElemento(driver, txtDescripcion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPATENTE\"]"), "Nro Patente" );
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        BaseTest.tomarCaptura("Datos de Transportista ");
        btnCerrar.click();
        driver.switchTo().defaultContent();
    }
    public static void clickBtnCotizar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCotizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IMPRIMETICKETContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnCotizar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IMPRIMETICKETContainer\"]/button"), "click btn cotizar" );
        Utils.desenmarcarObjeto(driver, btnCotizar);
        btnCotizar.click();
    }
    public static void clickBtnCarta() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnCarta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNCARTAContainer\"]/button")));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNCARTAContainer\"]/button"), "btn Carta" );
        Utils.enmarcarElemento(driver, btnCarta);
        Utils.desenmarcarObjeto(driver, btnCarta);
        btnCarta.click();
    }
    public static void clickCategoria() throws InterruptedException {
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkCategoria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0166LINESEPARATORTITLE_LINESEPARATOR_0001\"]")));
        Utils.enmarcarElemento(driver, linkCategoria);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0166LINESEPARATORTITLE_LINESEPARATOR_0001\"]"), "click link cuidado capilar" );
        Utils.desenmarcarObjeto(driver, linkCategoria);
        linkCategoria.click();

    }
    public static void seleccionarProducto() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0166vPRODUCTODESCRIPCION_00010001\"]/a")));
        Utils.enmarcarElemento(driver, linkProducto);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"span_W0166vPRODUCTODESCRIPCION_00010001\"]/a"), "click lista de producto" );
        linkProducto.click();
        Utils.desenmarcarObjeto(driver, linkProducto);
        BaseTest.tomarCaptura("click lista de producto ");
    }

    public static void modificarPrecioProducto() throws InterruptedException {

//        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tblCarroCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]")));
        WebElement tdPrecio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0122vPRECIOPICTURE_0001\"]")));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, tblCarroCompra);
        Utils.desenmarcarObjeto(driver, tblCarroCompra);
        Utils.enmarcarElemento(driver, tdPrecio);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Se modifica precio producto" );
        Utils.desenmarcarObjeto(driver, tdPrecio);
        txtDescripcion.sendKeys(datosPOS.get("precio") + Keys.ENTER);
        BaseTest.tomarCaptura("Se modifica precio producto");
//        driver.switchTo().defaultContent();

    }
    public static void modificarCantidadProducto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tblCarroCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]")));
        WebElement tdCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0122vCANTIDADPICTURE_0001\"]")));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, tblCarroCompra);
        Utils.desenmarcarObjeto(driver, tblCarroCompra);
        Utils.enmarcarElemento(driver, tdCantidad);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Se modifica cantidad producto" );
        Utils.desenmarcarObjeto(driver, tdCantidad);
        txtDescripcion.sendKeys(datosPOS.get("cantProdC") + Keys.ENTER);
        BaseTest.tomarCaptura("Se modifica cantidad producto");
        cerrarDriver();
    }
    public static void clickBtnCrearProdLibre() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCrearProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CREARPRODUCTOLIBRE\"]")));
        Utils.enmarcarElemento(driver, btnCrearProducto);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CREARPRODUCTOLIBRE\"]"), "Click btn Crar Prod Libre" );
        Utils.desenmarcarObjeto(driver, btnCrearProducto);
        btnCrearProducto.click();
    }

    public static void ingresarCodigoProductoLibre(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCodigoPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECODIGO\"]")));
        Utils.enmarcarElemento(driver, txtCodigoPL);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECODIGO\"]"), "ingreso de codigo" );
        Utils.desenmarcarObjeto(driver, txtCodigoPL);
        txtCodigoPL.sendKeys(datosPOS.get("codProd"));
        // BaseTest.tomarCaptura("Se modifica precio producto");
        driver.switchTo().defaultContent();
    }
    public static void ingresarDescripcionCPL(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCodigoPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCRIPCION\"]")));
        Utils.enmarcarElemento(driver, txtCodigoPL);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCRIPCION\"]"), "ingreso de descripcion" );
        Utils.desenmarcarObjeto(driver, txtCodigoPL);
        txtCodigoPL.sendKeys(datosPOS.get("descProd"));
        // BaseTest.tomarCaptura("Se modifica precio producto");
        driver.switchTo().defaultContent();
    }
    public static void seleccionarUnidadDeMedida() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbUniMedida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA\"]"), "Unidad de Medida" );
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida);
        select.selectByValue(datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida);
        driver.switchTo().defaultContent();
    }
    public static void seleccionarUnidadDeMedida2() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbUniMedida2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA2A\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida2);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA2A\"]"), "Unidad de Medida2" );
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida2);
        select.selectByValue(datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida2);
        driver.switchTo().defaultContent();
    }
    public static void seleccionTratamientoTributario() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lblTraTributario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRETRATAMIENTOTRIBUTARIO\"] ")));
        Utils.enmarcarElemento(driver, lblTraTributario);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRETRATAMIENTOTRIBUTARIO\"]"), "Tratamiento Tributario" );
        Thread.sleep(2000);
        Select select = new Select(lblTraTributario);
        select.selectByValue(datosPOS.get("traTributario"));  //Afecto, Exento, NoFacturab, NoFacSinMo
        Utils.desenmarcarObjeto(driver, lblTraTributario);
        driver.switchTo().defaultContent();
    }
    public static void seleccionCodigoEspecial() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lblCodEspecial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREIMPUESTOESPECIALCODIGO\"]")));
        Utils.enmarcarElemento(driver, lblCodEspecial);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREIMPUESTOESPECIALCODIGO\"]"), "Codigo Especial" );
        Thread.sleep(2000);
        Select select = new Select(lblCodEspecial);
        select.selectByIndex(3);  // ANALCOHOL, CERVEZAS, COMB93, COMB95, COMB97, VINO , 23, LICORES, COMBDIESEL, PruebaImp
        Utils.desenmarcarObjeto(driver, lblCodEspecial);
        driver.switchTo().defaultContent();
    }
    public static void ingresarCantidad() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]")));
        Utils.enmarcarElemento(driver, txtCantidad);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]"), "cantidad");
        Thread.sleep(2000);
        txtCantidad.clear();
        txtCantidad.sendKeys(datosPOS.get("cantProdC"));  //
        Utils.desenmarcarObjeto(driver, txtCantidad);
        driver.switchTo().defaultContent();
    }
    public static void ingresarPrecio() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtPrecio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREPRECIO\"]")));
        Utils.enmarcarElemento(driver, txtPrecio);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREPRECIO\"]"), "Ingreso Precio" );
        Thread.sleep(2000);
        txtPrecio.clear();
        txtPrecio.sendKeys(datosPOS.get("precio"));  //
        Utils.desenmarcarObjeto(driver, txtPrecio);
        driver.switchTo().defaultContent();
    }
    public static void ingresoDescuento() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDescuento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCUENTO\"]")));
        Utils.enmarcarElemento(driver, txtDescuento);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCUENTO\"]"), "Ingreso Descuento" );
        Thread.sleep(2000);
        txtDescuento.clear();
        txtDescuento.sendKeys(datosPOS.get("descuento"));  //
        Utils.desenmarcarObjeto(driver, txtDescuento);
        driver.switchTo().defaultContent();
    }
    public static void ingresoDimensiones() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chbUniMedida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDIMENSIONES\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida);
        esperarElementoYMedirTiempo(By.xpath(""), "Ingreso Dimensiones" );
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida);
        select.selectByValue(datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida);
        driver.switchTo().defaultContent();
    }
    public static void ingresarEstadoDeEntrega() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtEstadoEntrega = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREESTADOENTREGA\"]")));
        Utils.enmarcarElemento(driver, txtEstadoEntrega);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREESTADOENTREGA\"]"), "Estado de Entrega" );
        Thread.sleep(2000);
        txtEstadoEntrega.sendKeys(datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, txtEstadoEntrega);
        driver.switchTo().defaultContent();
    }
    public static void ingresarGlosa() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREGLOSACONTENIDO\"]")));
        Utils.enmarcarElemento(driver, txtGlosa);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREGLOSACONTENIDO\"]"), "Glosa" );
        Thread.sleep(2000);
        txtGlosa.sendKeys(datosPOS.get("glosa"));  //
        Utils.desenmarcarObjeto(driver, txtGlosa);
        driver.switchTo().defaultContent();
    }
    public static void clickBtnConfirmarVistaProdLibre() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnConfirmarPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ENTER\"]")));
        Utils.enmarcarElemento(driver, btnConfirmarPL);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"ENTER\"]"), "Formulario Crear Prod Libre" );
        Thread.sleep(2000);
        Utils.desenmarcarObjeto(driver, btnConfirmarPL);
        BaseTest.tomarCaptura("Formulario Crear Prod Libre");
        btnConfirmarPL.click();
        driver.switchTo().defaultContent();
    }
    public static void visualizarProductoAgreadoCarroCompras() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement trCarroCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]")));
        Utils.enmarcarElemento(driver, trCarroCompra);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]"), "Producto agregado en Carro" );
        Thread.sleep(2000);
        Utils.desenmarcarObjeto(driver, trCarroCompra);
        BaseTest.tomarCaptura("Producto agregado en Carro");
        cerrarDriver();
    }
    public static void buscarClienteYSeleccionarPorRut() throws InterruptedException {
            String rutBusqueda = PosDef.datosPOS.get("rutClienteFiado");

            if (rutBusqueda == null || rutBusqueda.isEmpty()) {
                throw new IllegalArgumentException("❌ 'rutClienteFiado' no puede ser null o vacío");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Buscar el input de búsqueda
            WebElement inputBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Buscar...']")));
            Utils.enmarcarElemento(driver, inputBuscar);
            esperarElementoYMedirTiempo(By.xpath("//input[@placeholder='Buscar...']"), "Campo búsqueda de RUT");
            inputBuscar.clear();
            inputBuscar.sendKeys(rutBusqueda);
            Utils.desenmarcarObjeto(driver, inputBuscar);

            // Esperar que se actualicen los resultados
            Thread.sleep(1000); // Puede reemplazarse con un wait dinámico si hay un AJAX loader

            // XPath dinámico para encontrar la fila con ese RUT y luego el botón "play" (ícono de acción)
            String xpathBotonPlay = String.format("//td[contains(text(), '%s')]/following-sibling::td//button[contains(@class, 'btn') or contains(@class, 'gx-image')] | //td[contains(text(), '%s')]/following-sibling::td//i[contains(@class,'fa-play') or contains(@class,'icon')]", rutBusqueda, rutBusqueda);

            WebElement botonPlay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBotonPlay)));
            Utils.enmarcarElemento(driver, botonPlay);
            tomarCaptura("Seleccion cliente por RUT");
            botonPlay.click();
            System.out.println("✅ Cliente seleccionado con RUT: " + rutBusqueda);
        }

    }





