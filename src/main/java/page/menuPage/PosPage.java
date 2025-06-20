package page.menuPage;

import Utils.Commons.BaseTest;
import Utils.Commons.DatosGlobales;
import Utils.Commons.ReporteUtils;
import Utils.Commons.Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.record.TableRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.Commons.BaseTest.*;
import static page.menuPage.PromocionesPage.capturarMensajePantalla;

public class PosPage {

    static WebDriver driver = BaseTest.getDriver();


    public static void visualizarVistaPos() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtVistaPos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header")));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/header"), "Vista de Pos ");
        Utils.enmarcarElemento(driver, txtVistaPos);
        tomarCaptura("Vista Home POS");
        Utils.desenmarcarObjeto(driver, txtVistaPos);
    }

    public static void seleccionOpcioPOS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[2]/div[2]/div/div/div/div/div[1]/div/header/span")));
        Utils.enmarcarElemento(driver, btnMenu);
        // BaseTest.tomarCaptura("Menu Configuracion");
        esperarElementoYMedirTiempo(By.xpath("/html/body/form/div[2]/div[2]/div/div/div/div/div[1]/div/header/span"), "");
        Utils.desenmarcarObjeto(driver, btnMenu);
        btnMenu.click();
    }

    public static void seleccionMenuPos(String menuP) throws InterruptedException {
        Map<String, Integer> menuIndices = Map.of(
                "Configuracion", 1,
                "Gestion", 2,
                "Definiciones", 3
        );

        Integer index = menuIndices.get(menuP);
        if (index == null) {
            System.out.println("❌ Opción de menú no válida: " + menuP);
            return;
        }

        String xpath = String.format("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[%d]/a", index);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement botonMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        Utils.enmarcarElemento(driver, botonMenu);
        tomarCaptura("Menu " + menuP);
        esperarElementoYMedirTiempo(By.xpath(xpath), "El menú seleccionado es: " + menuP);
        Utils.desenmarcarObjeto(driver, botonMenu);
        botonMenu.click();
    }

    public static void seleccionamosSubMenuPOS(String subMenuP) throws InterruptedException {
        Thread.sleep(3000);

        Map<String, Integer> subMenus = Map.of(
                "Usuarios", 1,
                "Asignacion de Perfiles", 2,
                "Enrolamiento De Equipos", 3,
                "Clientes", 4,
                "Productos", 5,
                "Balanzas", 6,
                "Lista de Precios", 7,
                "Grupo Selector", 8,
                "Categoria Precio", 9,
                "Autoriza Este Terminal", 10
        );

        Integer index = subMenus.get(subMenuP);
        if (index == null) {
            System.out.println("❌ Submenú no válido: " + subMenuP);
            return;
        }

        String xpath = STR."//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[\{index}]/a";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement linkSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        Utils.enmarcarElemento(driver, linkSubMenu);
        tomarCaptura(subMenuP);
        esperarElementoYMedirTiempo(By.xpath(xpath), STR."El submenú seleccionado es: \{subMenuP}");
        Utils.desenmarcarObjeto(driver, linkSubMenu);
        linkSubMenu.click();
    }

    public static void visualizarVistaEnrolamientoTerminales() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtEnrolamiento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Grid1ContainerTbl\"]")));
        Utils.enmarcarElemento(driver, txtEnrolamiento);
        tomarCaptura("Vista Enrolamiento");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"Grid1ContainerTbl\"]"), "Vista Enrolamiento");
        Utils.desenmarcarObjeto(driver, txtEnrolamiento);
    }

    public static void seleccionQR() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement linkCodQR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vLINKACCESO_0014\"]")));
        Utils.enmarcarElemento(driver, linkCodQR);
        tomarCaptura("codigo QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vLINKACCESO_0014\"]"), "codigo QR");
        Utils.desenmarcarObjeto(driver, linkCodQR);
        linkCodQR.click();
    }

    public static void seleccionBtnCopiar() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnCopiarQR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"COPIAR\"]")));
        Utils.enmarcarElemento(driver, btnCopiarQR);
        tomarCaptura("btn copiar QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"COPIAR\"]"), "btn copiar QR");
        Utils.desenmarcarObjeto(driver, btnCopiarQR);
        btnCopiarQR.click();
        driver.switchTo().defaultContent();
    }

    public static void abrirnuevaPestania() {
        try {
            Thread.sleep(3000);
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
            String urlCopiada = "http://qa.enternet.cl/AndesPOS2407/servlet/com.andes.pos.contextoacceso.locallogininitenc?MjAyNS0wNi0wOUgxNS00Msb6imZBSBZ4YYfU02rWfjGILqX0ApNuvuGYGt%2BH7THX558amv9mo1Od32sUQmIDXb18JwFd4OtimS4sPZ%2B60Cw%3D";
            driver.get(urlCopiada);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra el navegador después de unos segundos
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {
            }
        }

    }

    public static void clickBtnIrALogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IRALOGIN\"]"), "Ir a Login");
        WebElement chbTipoPerfil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IRALOGIN\"]")));
        Utils.enmarcarElemento(driver, chbTipoPerfil);
        tomarCaptura("Ir a Login");
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
        esperarElementoYMedirTiempo(By.id("vTIPODEPERFIL"), "Tipo De Perfil");

        Select select = new Select(chbTipoPerfil);
        select.selectByIndex(3); //cajera admin
        Utils.desenmarcarObjeto(driver, chbTipoPerfil);

    }

    public static void seleccionarModuloIDL() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbModulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMODULOIDL\"]")));
        Utils.enmarcarElemento(driver, chbModulo);
        // BaseTest.tomarCaptura("codigo QR");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMODULOIDL\"]"), "Modulo IDL");
        Thread.sleep(2000);
        Select select = new Select(chbModulo);
        select.selectByIndex(2);
        Utils.desenmarcarObjeto(driver, chbModulo);

    }

    public static void ingresarRut() {
        String rutPos = DatosGlobales.datosActuales.getOrDefault("userPOS", DatosGlobales.datosActuales.get("rutCliente"));

        if (rutPos == null || rutPos.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'rutPos' no puede ser null o vacío (ni 'rutCliente')");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vRUT\"]"), "Vista Enrolamiento");
        WebElement txtRut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vRUT\"]")));
        Utils.enmarcarElemento(driver, txtRut);
        Utils.desenmarcarObjeto(driver, txtRut);
        txtRut.clear();
        txtRut.sendKeys(rutPos);

    }

    public static void ingresarClave() {

        String clavePos = DatosGlobales.datosActuales.getOrDefault("clave", DatosGlobales.datosActuales.get("password"));

        if (clavePos == null || clavePos.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ La clave no puede ser null o vacía (ni 'clave' ni 'password')");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPASSWORD\"]"), "Vista Ingreso Clave");
        WebElement txtClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPASSWORD\"]")));
        Utils.enmarcarElemento(driver, txtClave);
        Utils.desenmarcarObjeto(driver, txtClave);
        txtClave.clear();
        txtClave.sendKeys(clavePos + Keys.ENTER);
    }



    public static void seleccionarBtnIngresar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CONFIRMAR\"]"), "Ingresar");
        WebElement btnIngresar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, btnIngresar);
        tomarCaptura("Ingresar");
        Utils.desenmarcarObjeto(driver, btnIngresar);
        Thread.sleep(2000);
        btnIngresar.click();

    }

    public static void seleccionarCajaConNuestroNombre() throws InterruptedException {
        String nombreCajero = DatosGlobales.datosActuales.get("cajeroPos");

        if (nombreCajero == null || nombreCajero.isEmpty()) {
            throw new IllegalArgumentException("❌ 'cajeroPos' no puede ser null o vacío");
        }
        System.out.println("🔍 Buscando el cajero con nombre: " + nombreCajero);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Busca cualquier elemento tipo <span> que contenga exactamente ese nombre
        String xpathDinamico = String.format("//span[contains(text(),'%s')]", nombreCajero);
        esperarElementoYMedirTiempo(By.xpath(xpathDinamico), "Seleccion Caja para: " + nombreCajero);
        WebElement caja = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDinamico)));
        Utils.enmarcarElemento(driver, caja);
        tomarCaptura("Seleccion Cajero");
        Utils.desenmarcarObjeto(driver, caja);
        caja.click();
    }

    public static void clickBtnNuevaVenta() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnNuevaVenta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NUEVAVENTAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnNuevaVenta);
        tomarCaptura("+ Nueva Venta");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NUEVAVENTAContainer\"]/button"), "+ Nueva Venta");
        Utils.desenmarcarObjeto(driver, btnNuevaVenta);
        btnNuevaVenta.click();
    }

    public static void ingresarRutcliente() {
        driver.switchTo().frame(0);
        String rutClienteFiado = DatosGlobales.datosPOS.get("rutClienteFiado");
        if (rutClienteFiado == null || rutClienteFiado.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'rutClienteFiado' no puede ser null o vacío");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vGENERICFILTER_GRIDCLIENTE\"]"), "Seleccion de Cliente para iniciar venta");
        WebElement txtCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vGENERICFILTER_GRIDCLIENTE\"]")));
        Utils.enmarcarElemento(driver, txtCliente);
        Utils.desenmarcarObjeto(driver, txtCliente);
        txtCliente.clear();
        txtCliente.sendKeys(rutClienteFiado);
        driver.switchTo().defaultContent();
    }

    public static void clickBtnCliente() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SELECCIONACLIENTEContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnCliente);
        // BaseTest.tomarCaptura("+ Nueva Venta");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SELECCIONACLIENTEContainer\"]/button"), "Click boton Cliente");
        Utils.desenmarcarObjeto(driver, btnCliente);
        btnCliente.click();
    }

    public static void seleccionCliente() throws InterruptedException {
        Thread.sleep(2000);

        driver.switchTo().frame(0);
        Thread.sleep(2000);
        // Nombre a buscar
        String nombreCliente = DatosGlobales.datosPOS.get("nombreCliente");
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
        String prodDesc = DatosGlobales.datosActuales.get("descProd");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, txtDescripcion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Ingrese codigo o descripcion de producto...");
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        Thread.sleep(2000);
        txtDescripcion.click(); // asegurarse del foco
        txtDescripcion.sendKeys(prodDesc);
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        tomarCaptura("ingreso por descripcion");

    }

    public static void seleccionarNombreProducto() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String nombreProducto = DatosGlobales.datosActuales.get("descProd");

        // Asegurarse que nombreProducto no sea null ni vacío
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'descProd' no puede ser nulo o vacío");
        }

        String xpathBotonProducto = String.format("//a[text()='%s']", nombreProducto);
        WebElement botonProducto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBotonProducto)));
        Utils.enmarcarElemento(driver, botonProducto);
        botonProducto.click();
        Utils.desenmarcarObjeto(driver, botonProducto);
    }

    public static void ingresarProductoPorCodigo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtCodigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, txtCodigo);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "ingreso por codigo");
        Utils.desenmarcarObjeto(driver, txtCodigo);
        txtCodigo.sendKeys(datosPOS.get("codProd"));
        tomarCaptura("ingreso por codigo");
    }

    public static void clickBtnEnter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnEnter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNBUSCAPRODUCTOContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnEnter);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNBUSCAPRODUCTOContainer\"]/button"), "Click Enter");
        Utils.desenmarcarObjeto(driver, btnEnter);
        btnEnter.click();
        // BaseTest.tomarCaptura("Click Enter");
    }

    public static void ingresarCantidadDeProducto() throws InterruptedException {
        String cantProdC = DatosGlobales.datosActuales.get("cantProdC");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "cantidad producto ");
        Utils.enmarcarElemento(driver, txtDescripcion);
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        Thread.sleep(2000);
        txtDescripcion.click(); // asegurarse del foco
        txtDescripcion.sendKeys(cantProdC);
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public static void ingresarFormaDePago() throws InterruptedException {
        Thread.sleep(2000);
        String formaPago = DatosGlobales.datosActuales.get("formaDePago");
        switch (formaPago) {
            case "Efectivo":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnEfectivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOEFECTIVOContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnEfectivo);
                //BaseTest.tomarCaptura("Usuarios");
                Utils.desenmarcarObjeto(driver, btnEfectivo);
                btnEfectivo.click();

                break;
            case "Tarjeta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnTarjeta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTARJETAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnTarjeta);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                Utils.desenmarcarObjeto(driver, btnTarjeta);
                btnTarjeta.click();
                break;
            case "Credito":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCREDITO\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnCredito = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCREDITO\"]")));
                Utils.enmarcarElemento(driver, btnCredito);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                Utils.desenmarcarObjeto(driver, btnCredito);
                btnCredito.click();
                break;
            case "Convenio":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnPagos = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCONVENIO\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnConvenio = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCONVENIO\"]")));
                Utils.enmarcarElemento(driver, btnConvenio);
                //BaseTest.tomarCaptura("Autoriza Este Terminal");
                Utils.desenmarcarObjeto(driver, btnConvenio);
                btnPagos.click();
                btnConvenio.click();
                break;
            case "Transferencia":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnPagos2;
                btnPagos2 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnTransferencia = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOTRANSFERENCIA\"]")));
                Utils.enmarcarElemento(driver, btnTransferencia);
                tomarCaptura(STR."Metodo de pago:" + formaPago);
                Utils.desenmarcarObjeto(driver, btnTransferencia);
                btnPagos2.click();
                btnTransferencia.click();
                break;
            case "Cheque":
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnPagos3;
                btnPagos3 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUPContainer\"]/div/div[1]/span")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PAGOCHEQUE\"]"), STR."El metodo de pago escojido es: \{formaPago}");
                WebElement btnCheque = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PAGOCHEQUE\"]")));
                Utils.enmarcarElemento(driver, btnCheque);
                tomarCaptura(STR."Metodo de pago \{formaPago}");
                Utils.desenmarcarObjeto(driver, btnCheque);
                btnPagos3.click();
                btnCheque.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void listarInputsTextoVisibles() {
        List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='text']"));
        System.out.println("🔍 Inputs tipo 'text' visibles encontrados:");
        for (WebElement input : inputs) {
            try {
                if (input.isDisplayed()) {
                    String id = input.getAttribute("id");
                    String name = input.getAttribute("name");
                    String value = input.getAttribute("value");
                    System.out.println("🟦 ID: " + id + " | name: " + name + " | value: " + value);
                }
            } catch (Exception e) {
                // Ignorar excepciones si el input desaparece o es inaccesible
            }
        }
    }
    public static void ingresoMontoEfectivo() throws InterruptedException {
//        Thread.sleep(3000);
//        String precioTotalRaw = capturarMensajePantalla("//*[normalize-space(text())='Total']/following-sibling::*[1]");
//        if (precioTotalRaw == null) throw new RuntimeException("❌ No se pudo capturar el total para pago en efectivo.");
//
//        String precioTotal = precioTotalRaw.replaceAll("[^\\d]", ""); // Solo dígitos enteros
//        driver.switchTo().frame(0);
//        listarInputsTextoVisibles();
//        // Buscar campo de Monto de Pago por su proximidad visual
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        WebElement campoMonto = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[normalize-space(text())='Monto de Pago']/following::input[1]")
//        ));
//        campoMonto.clear();
//        campoMonto.sendKeys(precioTotal);
//        System.out.println("💵 Monto ingresado: " + precioTotal);
//        driver.switchTo().defaultContent();

        Thread.sleep(3000);
        String precioTotalRaw = capturarMensajePantalla("//*[normalize-space(text())='Total']/following-sibling::*[1]");
        if (precioTotalRaw == null) throw new RuntimeException("❌ No se pudo capturar el total para pago en efectivo.");

        String soloDigitos = precioTotalRaw.replaceAll("[^\\d]", "");
        if (soloDigitos.isBlank()) throw new RuntimeException("❌ No se pudo extraer número del total bruto.");

        int monto = Integer.parseInt(soloDigitos);
        int montoRedondeado = ((int) Math.ceil(monto / 100.0)) * 100;

        String precioTotal = String.valueOf(montoRedondeado);

        driver.switchTo().frame(0);
        listarInputsTextoVisibles();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement campoMonto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[normalize-space(text())='Monto de Pago']/following::input[1]")
        ));

        campoMonto.clear();
        campoMonto.sendKeys(precioTotal);
        System.out.println("💵 Monto ingresado (redondeado): " + precioTotal);
        driver.switchTo().defaultContent();
    }

    public static void ingresarTipoDePago() throws InterruptedException {
        String tipoPago = DatosGlobales.datosActuales.get("tipoDePago");

        if (tipoPago == null || tipoPago.trim().isEmpty()) {
            System.out.println("❌ El tipo de pago no está definido en el JSON");
            return;
        }

        List<String> opcionesValidas = List.of(
                "TransBank",
                "Fiado",
                "Casa de Moneda",
                "Sodexo Cheq. Res.",
                "Pedido ya",
                "Nota de Credito",
                "Credito fecha libre",
                "BCI",
                "Banco Santander",
                "Banco de Chile"
        );

        if (!opcionesValidas.contains(tipoPago)) {
            System.out.println("❌ Opción de tipo de pago NO válida: " + tipoPago);
            return; // O lanza excepción, según prefieras
        }

        Thread.sleep(3000);
        driver.switchTo().frame(0);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbTipoPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAUXNOTAVENTAPAGOINSTITUCION\"]")));

        Utils.enmarcarElemento(driver, chbTipoPago);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAUXNOTAVENTAPAGOINSTITUCION\"]"), "Tipo de pago");

        Select select = new Select(chbTipoPago);

        try {
            select.selectByVisibleText(tipoPago);
        } catch (Exception e) {
            System.out.println("❌ No se pudo seleccionar la opción: " + tipoPago);
        }

        Utils.desenmarcarObjeto(driver, chbTipoPago);
        driver.switchTo().defaultContent();

    }


    public static void ingresoDeDatosParaElPago() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtMontoPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vXNOTAVENTAPAGOMONTO\"]")));
        Utils.enmarcarElemento(driver, txtMontoPago);
        tomarCaptura("Datos del Pago");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vXNOTAVENTAPAGOMONTO\"]"), "Datos del Pago");
        Utils.desenmarcarObjeto(driver, txtMontoPago);
        txtMontoPago.sendKeys(DatosGlobales.datosPOS.get("MontoPago"));
        driver.switchTo().defaultContent();
    }

    public static void seleccionarBtnImprimir() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IMPRIMIR\"]"), "btn Imprimir");
        WebElement btnImprimir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IMPRIMIR\"]")));
        Utils.enmarcarElemento(driver, btnImprimir);
        tomarCaptura("btn Imprimir");
        btnImprimir.click();
        Utils.desenmarcarObjeto(driver, btnImprimir);
        driver.switchTo().defaultContent();
    }
    public static void visualizarBotones() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IMPRIMIR\"]"), "Firmar Boleta o Factura");
        WebElement btnImprimir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IMPRIMIR\"]")));
        Utils.enmarcarElemento(driver, btnImprimir);
        tomarCaptura("btn Forma de pago");
        btnImprimir.click();
        Utils.desenmarcarObjeto(driver, btnImprimir);
        driver.switchTo().defaultContent();
    }

    public static void seleccionTipoDeEmision() throws InterruptedException {
        String tipoEmision = DatosGlobales.datosActuales.get("tipoEmision");
        switch (tipoEmision) {
            case "Factura":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnFactura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRFACTURAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnFactura);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRFACTURAContainer\"]/button"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnFactura);
                btnFactura.click();
                Thread.sleep(3000);
                break;

            case "Boleta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnTarjeta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRBOLETAContainer\"]/button")));
                Utils.enmarcarElemento(driver, btnTarjeta);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRBOLETAContainer\"]/button"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnTarjeta);
                btnTarjeta.click();
                Thread.sleep(3000);
                break;

            case "Ticket":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement btnEmitir = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ACTIONGROUPUC_ACTIONGROUP1Container\"]/div/div[1]/span")));
                WebElement btnEmitirTicket = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNEMITIRTICKET\"]")));
                Utils.enmarcarElemento(driver, btnEmitirTicket);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNEMITIRTICKET\"]"), STR."El tipo de emision es: \{tipoEmision}");
                Utils.desenmarcarObjeto(driver, btnEmitirTicket);
                btnEmitir.click();
                btnEmitirTicket.click();
                break;

            default:
                System.out.println("❌ Opción no válida: " + tipoEmision);
        }
    }

    public static void seleccionarBtnGuardar() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));                                  //*[@id="GUARDAR"]
        WebElement btnGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDAR\"]")));
        Utils.enmarcarElemento(driver, btnGuardar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDAR\"]"), "click btn Guardar");
        Utils.desenmarcarObjeto(driver, btnGuardar);
        tomarCaptura("Forma de Pago");
        btnGuardar.click();
        driver.switchTo().defaultContent();
    }

    public static void clickBtnVendedor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnVendedor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SELECCIONAVENDEDORContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnVendedor);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SELECCIONAVENDEDORContainer\"]/button"), "click btn Vendedor");
        Utils.desenmarcarObjeto(driver, btnVendedor);
        btnVendedor.click();
    }

    public static void seleccionarVendedor(String nombreVendedor) throws InterruptedException {
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        // Nombre a buscar
        nombreVendedor = DatosGlobales.datosPOS.get("nombreVendedor");
        List<WebElement> nombres = driver.findElements(By.xpath("//td[4]"));
        // Recorre los nombres y hace clic cuando lo encuentre
        for (WebElement nombre : nombres) {
            if (nombre.getText().equalsIgnoreCase(nombreVendedor)) {
                tomarCaptura("Seleccion Vendedor");
                nombre.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
    }

    public static void clickBtnGlosa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"EDITARGLOSAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnGlosa);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"EDITARGLOSAContainer\"]/button"), "click btn Glosa");
        Utils.desenmarcarObjeto(driver, btnGlosa);
        btnGlosa.click();
    }

    public static void escribirGlosa() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtEscribirGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vNOTAVENTAGLOSA\"]")));
        WebElement btnConfirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, txtEscribirGlosa);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vNOTAVENTAGLOSA\"]"), "Escribir Glosa");
        Utils.desenmarcarObjeto(driver, txtEscribirGlosa);
        txtEscribirGlosa.sendKeys(DatosGlobales.datosPOS.get("glosa"));
        tomarCaptura("Escribir Glosa");
        btnConfirmar.click();
        driver.switchTo().defaultContent();
    }

    public static void visualizarInformacionDePago() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement rowInfoPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164ATTRIBUTESCONTAINERTABLE_ATTRIBUTES1\"]")));
        Utils.enmarcarElemento(driver, rowInfoPago);
        //BaseTest.tomarCaptura("click btn Vendedor");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164ATTRIBUTESCONTAINERTABLE_ATTRIBUTES1\"]"), "Informacion de Pago");
        Utils.desenmarcarObjeto(driver, rowInfoPago);
        // btnVendedor.click();
    }

    public static void escribirProductoEnFiltroDespensa() throws InterruptedException {
        String catDespensa = DatosGlobales.datosPOS.get("catDespensa");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By locatorInput = By.xpath("//*[@id=\"W0166vCLASIFICADORACATCOD_0001\"]");

        WebElement txtDespensa = wait.until(ExpectedConditions.elementToBeClickable(locatorInput));
        Utils.enmarcarElemento(driver, txtDespensa);
        esperarElementoYMedirTiempo(locatorInput, "Ingrese código o descripción de producto...");
        Utils.desenmarcarObjeto(driver, txtDespensa);

        txtDespensa.click(); // Asegura el foco
        txtDespensa.clear(); // Limpia el campo
        Thread.sleep(5000);
        txtDespensa.sendKeys(catDespensa);
        Thread.sleep(500); // Espera leve tras escribir

        // Opcional: presiona ENTER si el filtro requiere activación
        txtDespensa.sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }

    public static void escribirProductoEnFiltroANNO() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtCatAnno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0001\"]")));
//        Utils.enmarcarElemento(driver, txtCatAnno);
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0001\"]"), "ingreso de producto por filtro");
//        Utils.desenmarcarObjeto(driver, txtCatAnno);
//        tomarCaptura("ingreso de producto por filtro");
//        txtCatAnno.sendKeys(DatosGlobales.datosPOS.get("catANNO"));
        String catANIO = DatosGlobales.datosPOS.get("catANNO");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By locatorInput = By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0001\"]");

        WebElement txtAnio = wait.until(ExpectedConditions.elementToBeClickable(locatorInput));
        Utils.enmarcarElemento(driver, txtAnio);
        esperarElementoYMedirTiempo(locatorInput, "Ingrese código o descripción de producto...");
        Utils.desenmarcarObjeto(driver, txtAnio);

        txtAnio.click(); // Asegura el foco
        txtAnio.clear(); // Limpia el campo
        Thread.sleep(5000);
        txtAnio.sendKeys(catANIO);
        Thread.sleep(500); // Espera leve tras escribir

        // Opcional: presiona ENTER si el filtro requiere activación
        txtAnio.sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }

    public static void escribirProductoEnFiltroOtros() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtCatOtros = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0002\"]")));
//        Utils.enmarcarElemento(driver, txtCatOtros);
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0002\"]"), "ingreso de producto por filtro");
//        Utils.desenmarcarObjeto(driver, txtCatOtros);
//        tomarCaptura("ingreso de producto por filtro");
//        txtCatOtros.sendKeys(DatosGlobales.datosPOS.get("catOtros"));
        String catOtros = DatosGlobales.datosPOS.get("catOtros");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By locatorInput = By.xpath("//*[@id=\"W0164vBUSCADORACATCOD_0002\"]");

        WebElement txtCatOtros = wait.until(ExpectedConditions.elementToBeClickable(locatorInput));
        Utils.enmarcarElemento(driver, txtCatOtros);
        esperarElementoYMedirTiempo(locatorInput, "Ingrese código o descripción de producto...");
        Utils.desenmarcarObjeto(driver, txtCatOtros);

        txtCatOtros.click(); // Asegura el foco
        txtCatOtros.clear(); // Limpia el campo
        Thread.sleep(5000);
        txtCatOtros.sendKeys(catOtros);
        Thread.sleep(500); // Espera leve tras escribir

        // Opcional: presiona ENTER si el filtro requiere activación
        txtCatOtros.sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }

    public static void clickBtnTransportista() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //*[@id="DATOSTRANSPORTISTAContainer"]/button
        WebElement btnTransportista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DATOSTRANSPORTISTAContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnTransportista);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"DATOSTRANSPORTISTAContainer\"]/button"), "click btn transportista");
        Utils.desenmarcarObjeto(driver, btnTransportista);
        btnTransportista.click();
    }

    public static void seleccionarMotivoDeTraslado() throws InterruptedException {
        Thread.sleep(2500);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));                                     //*[@id="vMOTIVOTRASLADO"]
        WebElement chbMTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMOTIVOTRASLADO\"]")));
        Utils.enmarcarElemento(driver, chbMTraslado);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMOTIVOTRASLADO\"]"), "Motivo de Traslado");
        Thread.sleep(2000);
        Select select = new Select(chbMTraslado);
        select.selectByIndex(2);  //1 Operación Constituye Venta, 2 Venta Por Efectuar, 3 Consignaciones, 4 Entrega Gratuita
        Utils.desenmarcarObjeto(driver, chbMTraslado);
        driver.switchTo().defaultContent();
    }

    public static void seleccionarTipoDeTraslado() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbMTraslado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vTIPOTRASLADO\"]")));
        Utils.enmarcarElemento(driver, chbMTraslado);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vTIPOTRASLADO\"]"), "Tipo de Traslado");
        Thread.sleep(2000);
        Select select = new Select(chbMTraslado);
        select.selectByIndex(2);  //1 Despacho por Cuenta del Receptor, 2 Despacho por Cuenta de Emisor A Cliente, 3 Despacho por Cuenta del Emisor a Otras Instalaciones, 4 Sin Definir
        Utils.desenmarcarObjeto(driver, chbMTraslado);
        driver.switchTo().defaultContent();
    }

    public static void ingresarNombreChofer() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtNombreChofer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vNOMBRECHOFER\"]")));
        Utils.enmarcarElemento(driver, txtNombreChofer);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vNOMBRECHOFER\"]"), "Nombre de Chofer");
        Utils.desenmarcarObjeto(driver, txtNombreChofer);
        txtNombreChofer.sendKeys(DatosGlobales.datosPOS.get("nombreChofer"));
        driver.switchTo().defaultContent();
    }

    public static void ingresarRutChofer() {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtRutChofer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vRUTCHOFER\"]")));
        Utils.enmarcarElemento(driver, txtRutChofer);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vRUTCHOFER\"]"), "Rut de Chofer");
        Utils.desenmarcarObjeto(driver, txtRutChofer);
        txtRutChofer.sendKeys(DatosGlobales.datosPOS.get("rutChofer"));
        driver.switchTo().defaultContent();
    }

    public static void ingresarPatente() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtPatente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPATENTE\"]")));
        WebElement btnConfirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, txtPatente);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPATENTE\"]"), "Nro Patente");
        Utils.desenmarcarObjeto(driver, txtPatente);
        txtPatente.sendKeys(DatosGlobales.datosPOS.get("patente"));
        Utils.enmarcarElemento(driver, btnConfirmar);
        tomarCaptura("Transportista");
        Utils.desenmarcarObjeto(driver, btnConfirmar);
        btnConfirmar.click();
        driver.switchTo().defaultContent();
    }

    public static void clickBtnBuscar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0166BUSCAR\"]")));
        Utils.enmarcarElemento(driver, btnBuscar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0166BUSCAR\"]"), "boton buscar");
        Utils.desenmarcarObjeto(driver, btnBuscar);
        tomarCaptura("Boton Buscar ");
        btnBuscar.click();
    }

    public static void hacerClickEnProducto() throws InterruptedException {
               Thread.sleep(3000);
        String textoBuscado = DatosGlobales.datosPOS.get("prodCatDespensa"); //"Biosal Light Lobos 850 Gr"; nombre buscado por filtro de categoria

        // Obtiene todas las filas de la tabla
        List<WebElement> filas = driver.findElements(By.cssSelector("table tr"));

        for (WebElement fila : filas) {
            if (fila.getText().contains(textoBuscado)) {
                try {
                    // Buscar el 3er <td> dentro de esta fila
                    List<WebElement> celdas = fila.findElements(By.tagName("td"));
                    if (celdas.size() >= 3) {
                        WebElement celdaNombre = celdas.get(2); // Índice 2 para el 3er td
                        Utils.enmarcarElemento(driver, celdaNombre);
                        celdaNombre.click();
                        tomarCaptura("selección de producto");
                        Utils.desenmarcarObjeto(driver, celdaNombre);
                    }
                } catch (Exception e) {
                    System.out.println("❌ No se pudo hacer clic en el producto: " + e.getMessage());
                }
                break;
            }
        }
      //  cerrarDriver();
    }

    public static void visualizarInformacionDeProducto() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"COLUMN1\"]/div")));
        WebElement btnCerrar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CERRAR\"]")));
        Utils.enmarcarElemento(driver, txtDescripcion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPATENTE\"]"), "Nro Patente");
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        tomarCaptura("Datos de Transportista ");
        btnCerrar.click();
        driver.switchTo().defaultContent();
    }

    public static void clickBtnCotizar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnCotizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IMPRIMETICKETContainer\"]/button")));
        Utils.enmarcarElemento(driver, btnCotizar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IMPRIMETICKETContainer\"]/button"), "click btn cotizar");
        Utils.desenmarcarObjeto(driver, btnCotizar);
        btnCotizar.click();
    }

    public static void clickBtnCarta() throws InterruptedException {
//        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement btnCarta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BTNCARTAContainer\"]/button")));
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BTNCARTAContainer\"]/button"), "btn Carta");
//        Utils.enmarcarElemento(driver, btnCarta);
//        Utils.desenmarcarObjeto(driver, btnCarta);
//        btnCarta.click();
        Thread.sleep(3000); // Considera reemplazar esto con espera explícita si es posible

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By locatorBtnCarta = By.xpath("//*[@id=\"BTNCARTAContainer\"]/button");

        try {
            WebElement btnCarta = wait.until(ExpectedConditions.elementToBeClickable(locatorBtnCarta));

            esperarElementoYMedirTiempo(locatorBtnCarta, "btn Carta");
            Utils.enmarcarElemento(driver, btnCarta);
            btnCarta.click();
            Utils.desenmarcarObjeto(driver, btnCarta);

            System.out.println("✅ Se hizo clic en el botón 'Carta' correctamente.");

        } catch (Exception e) {
            System.err.println("❌ No se pudo hacer clic en el botón 'Carta': " + e.getMessage());
            throw e; // Re-lanzar si necesitas fallar la prueba
        }

    }

    public static void clickCategoria() throws InterruptedException {
        String prodCatCarta = DatosGlobales.datosPOS.get("categoriaCarta"); // Ej: "Cuidado capilar", "Especiales"
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Combinar <a> y <span> como posibles categorías
        List<WebElement> categorias = new ArrayList<>();
        categorias.addAll(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//a")
        )));
        categorias.addAll(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//span[contains(@id,'LINESEPARATORTITLE_LINESEPARATOR')]")
        )));

        boolean encontrado = false;
        String textoBuscado = normalizarTexto(prodCatCarta);

        for (WebElement categoria : categorias) {
            if (!categoria.isDisplayed()) continue; // ignorar elementos no visibles

            String texto = categoria.getText().trim();
            if (texto.isEmpty()) continue; // ignorar vacíos

            String textoNormalizado = normalizarTexto(texto);

            if (textoNormalizado.equals(textoBuscado)) {
                Utils.enmarcarElemento(driver, categoria);
                esperarElementoYMedirTiempo(By.xpath(BaseTest.getXPath(categoria)), "click categoría: " + texto);
                categoria.click();
                Utils.desenmarcarObjeto(driver, categoria);
                System.out.println("✅ Se hizo clic en la categoría: " + texto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            throw new RuntimeException("❌ No se encontró la categoría: " + prodCatCarta);
        }
    }

    // Utilidad para normalizar texto
    private static String normalizarTexto(String texto) {
        return texto.toLowerCase().replaceAll("\\s+", " ").trim();
    }

    public static void seleccionarProducto() throws InterruptedException {
//        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement linkProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0166vPRODUCTODESCRIPCION_00010001\"]/a")));
//        Utils.enmarcarElemento(driver, linkProducto);       //*[@id="span_W0166vPRODUCTODESCRIPCION_00010002"]/a
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"span_W0166vPRODUCTODESCRIPCION_00010001\"]/a"), "click lista de producto");
//        linkProducto.click();
//        Utils.desenmarcarObjeto(driver, linkProducto);
//        tomarCaptura("click lista de producto ");
        //-----------------------
        String prodCatCarta = DatosGlobales.datosPOS.get("prodCatCarta"); //
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Combinar <a> y <span> como posibles categorías
        List<WebElement> categorias = new ArrayList<>();
        categorias.addAll(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//a")
        )));
        categorias.addAll(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//span[contains(@id,'PRODUCTODESCRIPCION')]")
        )));

        boolean encontrado = false;
        String textoBuscado = normalizarTexto(prodCatCarta);

        for (WebElement categoria : categorias) {
            if (!categoria.isDisplayed()) continue; // ignorar elementos no visibles

            String texto = categoria.getText().trim();
            if (texto.isEmpty()) continue; // ignorar vacíos

            String textoNormalizado = normalizarTexto(texto);

            if (textoNormalizado.equals(textoBuscado)) {
                Utils.enmarcarElemento(driver, categoria);
                esperarElementoYMedirTiempo(By.xpath(BaseTest.getXPath(categoria)), "click Producto: " + texto);
                categoria.click();
                Utils.desenmarcarObjeto(driver, categoria);
                System.out.println("✅ Se hizo clic en El producto: " + texto);
                encontrado = true;
                tomarCaptura("click lista de producto ");
                break;
            }
        }

        if (!encontrado) {
            throw new RuntimeException("❌ No se encontró el producto: " + prodCatCarta);
        }
    }

    public static void modificarPrecioProducto() throws InterruptedException {
        String precio = DatosGlobales.datosPOS.get("precio");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Se modifica precio producto ");
        Utils.enmarcarElemento(driver, txtDescripcion);
        Utils.desenmarcarObjeto(driver, txtDescripcion);
        Thread.sleep(2000);
        txtDescripcion.click(); // asegurarse del foco
        txtDescripcion.sendKeys(precio);
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

    }

    public static void modificarCantidadProducto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement tblCarroCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]")));
        WebElement tdCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0122vCANTIDADPICTURE_0001\"]")));
        WebElement txtDescripcion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vOMNIBOX\"]")));
        Utils.enmarcarElemento(driver, tblCarroCompra);
        Utils.desenmarcarObjeto(driver, tblCarroCompra);
        Utils.enmarcarElemento(driver, tdCantidad);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vOMNIBOX\"]"), "Se modifica cantidad producto");
        Utils.desenmarcarObjeto(driver, tdCantidad);
        txtDescripcion.sendKeys(DatosGlobales.datosPOS.get("cantProdC") + Keys.ENTER);
        tomarCaptura("Se modifica cantidad producto");
        cerrarDriver();
    }

    public static void clickBtnCrearProdLibre() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnCrearProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CREARPRODUCTOLIBRE\"]")));
        Utils.enmarcarElemento(driver, btnCrearProducto);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CREARPRODUCTOLIBRE\"]"), "Click btn Crar Prod Libre");
        Utils.desenmarcarObjeto(driver, btnCrearProducto);
        btnCrearProducto.click();
    }

    public static void crearEIngresarProductoLibre() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Paso 1: Click en botón Crear Producto Libre
            Thread.sleep(3000);
            WebElement btnCrearProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CREARPRODUCTOLIBRE")));
            Utils.enmarcarElemento(driver, btnCrearProducto);
            esperarElementoYMedirTiempo(By.id("CREARPRODUCTOLIBRE"), "Click btn Crear Prod Libre");
            Utils.desenmarcarObjeto(driver, btnCrearProducto);
            btnCrearProducto.click();
            System.out.println("✅ Click en 'Crear Producto Libre' realizado.");
            tomarCaptura("Click_Crear_Producto_Libre");
            Thread.sleep(2000);

            // Paso 2: Cambiar a iframe si existe
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            System.out.println("🔍 Iframes encontrados: " + iframes.size());
            for (WebElement iframe : iframes) {
                System.out.println("🧾 iframe id: " + iframe.getAttribute("id") + ", name: " + iframe.getAttribute("name"));
            }
            if (!iframes.isEmpty()) {
                driver.switchTo().frame(iframes.get(0));
                System.out.println("✅ Cambiado al primer iframe.");
            }

            // Paso 3: Ingresar datos fijos
            ingresarTextoFijo("NOTAVENTAITEMLIBRECODIGO", DatosGlobales.datosPOS.get("codProd"));
            ingresarTextoFijo("NOTAVENTAITEMLIBREDESCRIPCION", DatosGlobales.datosPOS.get("descProd"));
            //ingresarTextoFijo("NOTAVENTAITEMLIBREUNIDAD", "UnaUnidadDeMedida");

            // Paso 4: Salir del iframe si se usó
            if (!iframes.isEmpty()) {
                driver.switchTo().defaultContent();
                System.out.println("🔁 Regresado al contenido principal.");
            }

        } catch (Exception e) {
            tomarCaptura("Error_Crear_Producto_Libre");
            System.out.println("⚠ Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void ingresarTextoFijo(String idCampo, String valor) throws InterruptedException {
        try {
            WebElement campo = esperarElementoSeguro(idCampo, 20);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", campo);
            Utils.enmarcarElemento(driver, campo);
            campo.clear();
            campo.sendKeys(valor);
            Utils.desenmarcarObjeto(driver, campo);
            System.out.println("✅ Ingresado '" + valor + "' en campo: " + idCampo);
        } catch (Exception ex) {
            System.out.println("❌ Error al ingresar valor fijo '" + valor + "' en campo " + idCampo + ": " + ex.getMessage());
            tomarCaptura("Error_ingresando_" + idCampo);
        }
    }

    public static WebElement esperarElementoSeguro(String idParcial, int timeoutSegundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSegundos));

        // Opción 1: ID exacto
        String xpathExacto = "//*[@id='" + idParcial + "']";

        // Opción 2: ID parcial
        String xpathFlexible = "//*[contains(@id,'" + idParcial + "')]";

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExacto)));
        } catch (TimeoutException e1) {
            System.out.println("⚠ No se encontró por ID exacto, intentando por ID parcial...");
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFlexible)));
            } catch (TimeoutException e2) {
                System.out.println("❌ No se encontró el elemento con id parcial: " + idParcial);
                throw e2;
            }
        }
    }





//    public static void ingresarCodigoProductoLibre() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        try {
//            System.out.println("⏳ Esperando sección de producto libre...");
//            wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//*[contains(@id, 'NOTAVENTAITEMLIBRECODIGO')]")
//            ));
//
//            System.out.println("✅ Sección visible. Buscando campo de código...");
//            WebElement txtCodigoPL = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NOTAVENTAITEMLIBRECODIGO")));
//
//            if (!txtCodigoPL.isDisplayed()) {
//                tomarCaptura("⚠ Campo producto libre oculto");
//                throw new IllegalStateException("⚠ El campo 'NOTAVENTAITEMLIBRECODIGO' está en el DOM pero no visible.");
//            }
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtCodigoPL);
//            Utils.enmarcarElemento(driver, txtCodigoPL);
//            esperarElementoYMedirTiempo(By.id("NOTAVENTAITEMLIBRECODIGO"), "Ingreso de código");
//
//            String codigo = DatosGlobales.datosPOS.get("codProd");
//            if (codigo == null || codigo.isBlank()) {
//                throw new IllegalArgumentException("❌ codProd no está definido o está vacío en el JSON cargado.");
//            }
//
//            txtCodigoPL.clear();
//            txtCodigoPL.sendKeys(codigo);
//            Utils.desenmarcarObjeto(driver, txtCodigoPL);
//
//        } catch (Exception e) {
//            tomarCaptura("❌ Error al ingresar código producto libre");
//            System.out.println("⚠ Ocurrió un error: " + e.getMessage());
//            e.printStackTrace();
//            System.out.println("📄 HTML actual:");
//            System.out.println(driver.getPageSource());
//        }
//    }


    public static void ingresarDescripcionCPL() {
    //    driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtCodigoPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCRIPCION\"]")));
//        Utils.enmarcarElemento(driver, txtCodigoPL);
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCRIPCION\"]"), "ingreso de descripcion");
//        Utils.desenmarcarObjeto(driver, txtCodigoPL);
//        txtCodigoPL.sendKeys(DatosGlobales.datosPOS.get("descProd"));
        // BaseTest.tomarCaptura("Se modifica precio producto");
      //  driver.switchTo().defaultContent();

        // Paso 2: Detectar y cambiar a iframe si existe
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("🔍 Iframes encontrados después del clic: " + iframes.size());
        for (WebElement iframe : iframes) {
            System.out.println("📋 iframe id: " + iframe.getAttribute("id") + ", name: " + iframe.getAttribute("name"));
        }

        if (!iframes.isEmpty()) {
            driver.switchTo().frame(iframes.get(0));
            System.out.println("✅ Cambiado al primer iframe.");
        }
//
//        // Paso 3: Revisar campos con ID 'LIBRE'
//        List<WebElement> inputs = driver.findElements(By.xpath("//*[contains(@id,'LIBRE')]"));
//        System.out.println("📊 Inputs con 'LIBRE' encontrados: " + inputs.size());
//        for (WebElement input : inputs) {
//            System.out.println("🧾 ID real encontrado: " + input.getAttribute("id"));
//        }

        // Paso 4: Esperar campo del código y escribir el valor desde JSON
        WebElement txtDescripcionPL = esperarElementoSeguro("NOTAVENTAITEMLIBREDESCRIPCION", 30);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtDescripcionPL);
        Utils.enmarcarElemento(driver, txtDescripcionPL);
        esperarElementoYMedirTiempo(By.xpath("//*[contains(@id,'NOTAVENTAITEMLIBREDESCRIPCION')]"), "Ingreso de descripcion");

        String descripcion = DatosGlobales.datosPOS.get("descProd");
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("❌ descProd no está definido o está vacío en el JSON cargado.");
        }

        txtDescripcionPL.clear();
        txtDescripcionPL.sendKeys(descripcion);
        Utils.desenmarcarObjeto(driver, txtDescripcionPL);
        System.out.println("✅ Código ingresado: " + descripcion);

        if (!iframes.isEmpty()) {
            driver.switchTo().defaultContent();
            System.out.println("🔁 Regresado al contenido principal.");
        }

    }

    public static void seleccionarUnidadDeMedida() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbUniMedida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA\"]"), "Unidad de Medida");
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida);
        select.selectByValue(DatosGlobales.datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida);
        driver.switchTo().defaultContent();
    }

    public static void seleccionarUnidadDeMedida2() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbUniMedida2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA2A\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida2);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREUNIDADMEDIDA2A\"]"), "Unidad de Medida2");
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida2);
        select.selectByValue(DatosGlobales.datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida2);
        driver.switchTo().defaultContent();
    }

    public static void seleccionTratamientoTributario() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lblTraTributario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRETRATAMIENTOTRIBUTARIO\"] ")));
        Utils.enmarcarElemento(driver, lblTraTributario);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRETRATAMIENTOTRIBUTARIO\"]"), "Tratamiento Tributario");
        Thread.sleep(2000);
        Select select = new Select(lblTraTributario);
        select.selectByValue(DatosGlobales.datosPOS.get("traTributario"));  //Afecto, Exento, NoFacturab, NoFacSinMo
        Utils.desenmarcarObjeto(driver, lblTraTributario);
        driver.switchTo().defaultContent();
    }

    public static void seleccionCodigoEspecial() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lblCodEspecial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREIMPUESTOESPECIALCODIGO\"]")));
        Utils.enmarcarElemento(driver, lblCodEspecial);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREIMPUESTOESPECIALCODIGO\"]"), "Codigo Especial");
        Thread.sleep(2000);
        Select select = new Select(lblCodEspecial);
        select.selectByIndex(3);  // ANALCOHOL, CERVEZAS, COMB93, COMB95, COMB97, VINO , 23, LICORES, COMBDIESEL, PruebaImp
        Utils.desenmarcarObjeto(driver, lblCodEspecial);
        driver.switchTo().defaultContent();
    }

//    public static void ingresarCantidad() throws InterruptedException {
//        driver.switchTo().frame(0);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]")));
//        Utils.enmarcarElemento(driver, txtCantidad);
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]"), "cantidad");
//        Thread.sleep(2000);
//        txtCantidad.clear();
//        txtCantidad.sendKeys(DatosGlobales.datosPOS.get("cantProdC"));  //
//        Utils.desenmarcarObjeto(driver, txtCantidad);
//        driver.switchTo().defaultContent();
//    }
public static void ingresarCantidad() throws InterruptedException {
    driver.switchTo().frame(0);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    try {
        WebElement txtCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]"))
        );

        Utils.enmarcarElemento(driver, txtCantidad);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBRECANTIDAD\"]"), "cantidad");

        Thread.sleep(1000);
        txtCantidad.clear();

        String cantidad = DatosGlobales.datosPOS.get("cantProdC");
        System.out.println("🔢 Cantidad a ingresar: " + cantidad);

        if (cantidad == null || cantidad.isBlank()) {
            throw new IllegalArgumentException("❌ 'cantProdC' no está definido o está vacío.");
        }

        txtCantidad.sendKeys(cantidad);
        txtCantidad.sendKeys(Keys.TAB);
        Thread.sleep(500);

        String ingresado = txtCantidad.getAttribute("value");
        System.out.println("✅ Valor ingresado en el campo: '" + ingresado + "'");

        if (!ingresado.equals(cantidad)) {
            System.out.println("⚠ Valor no se ingresó correctamente. Probando con JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + cantidad + "';", txtCantidad);
        }

        Utils.desenmarcarObjeto(driver, txtCantidad);
    } catch (Exception e) {
        tomarCaptura("❌ Error al ingresar cantidad");
        System.out.println("⚠ Error al ingresar cantidad: " + e.getMessage());
        e.printStackTrace();
    } finally {
        driver.switchTo().defaultContent();
    }
}


    public static void ingresarPrecio() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtPrecio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREPRECIO\"]")));
        Utils.enmarcarElemento(driver, txtPrecio);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREPRECIO\"]"), "Ingreso Precio");
        Thread.sleep(2000);
        txtPrecio.clear();
        Thread.sleep(200);
        txtPrecio.sendKeys(DatosGlobales.datosPOS.get("precio"));  //
        Utils.desenmarcarObjeto(driver, txtPrecio);
        driver.switchTo().defaultContent();
    }

    public static void ingresoDescuento() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtDescuento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCUENTO\"]")));
        Utils.enmarcarElemento(driver, txtDescuento);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDESCUENTO\"]"), "Ingreso Descuento");
        Thread.sleep(2000);
        txtDescuento.clear();
        txtDescuento.sendKeys(DatosGlobales.datosPOS.get("descuento"));  //
        Utils.desenmarcarObjeto(driver, txtDescuento);
        driver.switchTo().defaultContent();
    }

    public static void ingresoDimensiones() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chbUniMedida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREDIMENSIONES\"]")));
        Utils.enmarcarElemento(driver, chbUniMedida);
        esperarElementoYMedirTiempo(By.xpath(""), "Ingreso Dimensiones");
        Thread.sleep(2000);
        Select select = new Select(chbUniMedida);
        select.selectByValue(DatosGlobales.datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, chbUniMedida);
        driver.switchTo().defaultContent();
    }

    public static void ingresarEstadoDeEntrega() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtEstadoEntrega = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREESTADOENTREGA\"]")));
        Utils.enmarcarElemento(driver, txtEstadoEntrega);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREESTADOENTREGA\"]"), "Estado de Entrega");
        Thread.sleep(2000);
        txtEstadoEntrega.sendKeys(DatosGlobales.datosPOS.get("uniMed"));  //
        Utils.desenmarcarObjeto(driver, txtEstadoEntrega);
        driver.switchTo().defaultContent();
    }

    public static void ingresarGlosa() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement txtGlosa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREGLOSACONTENIDO\"]")));
        Utils.enmarcarElemento(driver, txtGlosa);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NOTAVENTAITEMLIBREGLOSACONTENIDO\"]"), "Glosa");
        Thread.sleep(2000);
        txtGlosa.sendKeys(DatosGlobales.datosPOS.get("glosa"));  //
        Utils.desenmarcarObjeto(driver, txtGlosa);
        driver.switchTo().defaultContent();
    }

    public static void clickBtnConfirmarVistaProdLibre() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement btnConfirmarPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ENTER\"]")));
        Utils.enmarcarElemento(driver, btnConfirmarPL);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"ENTER\"]"), "Formulario Crear Prod Libre");
        Thread.sleep(2000);
        Utils.desenmarcarObjeto(driver, btnConfirmarPL);
        tomarCaptura("Formulario Crear Prod Libre");
        btnConfirmarPL.click();
        driver.switchTo().defaultContent();
    }

    public static void visualizarProductoAgreadoCarroCompras() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement trCarroCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]")));
        Utils.enmarcarElemento(driver, trCarroCompra);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0122GridContainerRow_0001\"]"), "Producto agregado en Carro");
        Thread.sleep(2000);
        Utils.desenmarcarObjeto(driver, trCarroCompra);
        tomarCaptura("Producto agregado en Carro");
        cerrarDriver();
    }

    public static void buscarClienteYSeleccionarPorRut() throws InterruptedException {
        String rutBusqueda = DatosGlobales.datosActuales.get("rutClienteFiado");
        Thread.sleep(3000);

        if (rutBusqueda == null || rutBusqueda.isEmpty()) {
            throw new IllegalArgumentException("❌ 'rutClienteFiado' no puede ser null o vacío");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Buscar el input de búsqueda
        WebElement inputBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vGENERICFILTER_GRID\"]")));
        Utils.enmarcarElemento(driver, inputBuscar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vGENERICFILTER_GRID\"]"), "Campo búsqueda de RUT");
        inputBuscar.clear();
        inputBuscar.sendKeys(rutBusqueda);
        Utils.desenmarcarObjeto(driver, inputBuscar);

        // Esperar que se actualicen los resultados
        Thread.sleep(1000);
        //XPath dinámico para encontrar la fila con ese RUT y luego el botón "play" (ícono de acción)
        String xpathBotonPlay = String.format("//td[9]");
        Thread.sleep(1000);
        WebElement botonPlay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBotonPlay)));
        Utils.enmarcarElemento(driver, botonPlay);
        tomarCaptura("Seleccion cliente por RUT");
        Thread.sleep(1000);
        botonPlay.click();

        System.out.println("✅ Cliente seleccionado con RUT: " + rutBusqueda);
    }


}



