package page.menuPage;


import Utils.Commons.BaseTest;
import Utils.Commons.DatosGlobales;
import Utils.Commons.Utils;
import definitions.verificarArchivo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static Utils.Commons.BaseTest.*;
import static Utils.Commons.DatosGlobales.datos;


public class ItemsPage {

    static WebDriver driver = BaseTest.getDriver();

    public static void seleccionarBtnCrearItems() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCrearItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CREARITEM\"]")));
        Utils.enmarcarElemento(driver, btnCrearItems);
        //takeScreenshot("screenshot_");
        tomarCaptura("Ingreso crear items");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CREARITEM\"]"), "Ingreso crear items");
        Utils.desenmarcarObjeto(driver, btnCrearItems);
        btnCrearItems.click();
    }

    public static void ingresarDescripcionDeProducto(String descProd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDescProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMNOM\"]")));
        Utils.enmarcarElemento(driver, txtDescProd);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMNOM\"]"), "Ingreso Descripcion Items");
        Utils.desenmarcarObjeto(driver, txtDescProd);
        txtDescProd.sendKeys(DatosGlobales.datos.get("descProd"));
    }

    public static void seleccionUnidadDeMedida(String uniMedida) {
        uniMedida = DatosGlobales.datos.get("uniMedida");
//        uniMedida = "Unidad";
        switch (uniMedida) {
            case "Botella":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnBotella = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[1]")));
                Utils.enmarcarElemento(driver, btnUniMed);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed.click();
                Utils.desenmarcarObjeto(driver, btnUniMed);
                btnBotella.click();
                break;

            case "Kilo":

                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnKilo = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[2]")));
                Utils.enmarcarElemento(driver, btnUniMed2);
                esperarElementoYMedirTiempo( By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[2]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed2.click();
                Utils.desenmarcarObjeto(driver, btnUniMed2);
                btnKilo.click();
                break;

            case "Litro":

                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnLitro = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[3]")));
                Utils.enmarcarElemento(driver, btnUniMed3);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[3]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed3.click();
                Utils.desenmarcarObjeto(driver, btnUniMed3);
                btnLitro.click();
                break;

            case "Metro":

                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnMetro = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[4]")));
                Utils.enmarcarElemento(driver, btnUniMed4);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[4]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed4.click();
                Utils.desenmarcarObjeto(driver, btnUniMed4);
                btnMetro.click();
                break;

            case "Metro Cuadrado":

                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed5 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnMetroCuadrado = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[5]")));
                Utils.enmarcarElemento(driver, btnUniMed5);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[5]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed5.click();
                Utils.desenmarcarObjeto(driver, btnUniMed5);
                btnMetroCuadrado.click();
                break;

            case "Metro Cubico":

                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed6 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnMetroCubico = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[6]")));
                Utils.enmarcarElemento(driver, btnUniMed6);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[6]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed6.click();
                Utils.desenmarcarObjeto(driver, btnUniMed6);
                btnMetroCubico.click();
                break;

            case "Unidad":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed7 = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]")));
                WebElement btnUnidad = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[7]")));
                Utils.enmarcarElemento(driver, btnUniMed7);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMPROPIAUNIITMID_\"]/option[7]"), "opc. Unidad De Medida: " + uniMedida + "");
                btnUniMed7.click();
                Utils.desenmarcarObjeto(driver, btnUniMed7);
                btnUnidad.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void seleccionUnidadDeComparacion(String uniComparacion) {
        uniComparacion = DatosGlobales.datos.get("uniComparacion");
        switch (uniComparacion) {
            case "Botella":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnBotella = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[1]")));
                Utils.enmarcarElemento(driver, btnUniMed);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed.click();
                Utils.desenmarcarObjeto(driver, btnUniMed);
                btnBotella.click();
                break;

            case "Kilo":

                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnKilo = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[2]")));
                Utils.enmarcarElemento(driver, btnUniMed2);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[2]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed2.click();
                Utils.desenmarcarObjeto(driver, btnUniMed2);
                btnKilo.click();
                break;

            case "Litro":

                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnLitro = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[3]")));
                Utils.enmarcarElemento(driver, btnUniMed3);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[3]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed3.click();
                Utils.desenmarcarObjeto(driver, btnUniMed3);
                btnLitro.click();
                break;

            case "Metro":

                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnMetro = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[4]")));
                Utils.enmarcarElemento(driver, btnUniMed4);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[4]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed4.click();
                Utils.desenmarcarObjeto(driver, btnUniMed4);
                btnMetro.click();
                break;

            case "Metro Cuadrado":

                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed5 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnMetroCuadrado = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[5]")));
                Utils.enmarcarElemento(driver, btnUniMed5);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[5]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed5.click();
                Utils.desenmarcarObjeto(driver, btnUniMed5);
                btnMetroCuadrado.click();
                break;

            case "Metro Cubico":

                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed6 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnMetroCubico = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[6]")));
                Utils.enmarcarElemento(driver, btnUniMed6);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[6]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed6.click();
                Utils.desenmarcarObjeto(driver, btnUniMed6);
                btnMetroCubico.click();
                break;

            case "Unidad":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnUniMed7 = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]")));
                WebElement btnUnidad = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[7]")));
                Utils.enmarcarElemento(driver, btnUniMed7);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vMITEMCOMPUNIITEMID_\"]/option[7]"), "opc. Unidad De Medida: " + uniComparacion + "");
                btnUniMed7.click();
                Utils.desenmarcarObjeto(driver, btnUniMed7);
                btnUnidad.click();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void ingresoEquivalenciaDeComparacion(String equivalenciaComparacion) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtEquivalenciaComparacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vMITEMCOMPCANTIDAD")));
        Utils.enmarcarElemento(driver, txtEquivalenciaComparacion);
        esperarElementoYMedirTiempo(By.id("vMITEMCOMPCANTIDAD"), "Ingreso equivalencia de comparacion");
        txtEquivalenciaComparacion.clear();
        Thread.sleep(1000);
        Utils.desenmarcarObjeto(driver, txtEquivalenciaComparacion);
        txtEquivalenciaComparacion.sendKeys(DatosGlobales.datos.get("equivalenciaComparacion"));
    }

    public static void selecconarSiElProductoUsaLotesONo() {
        String lotes = DatosGlobales.datos.get("lotes");
        String vendeLotes = DatosGlobales.datos.get("vendeLotes");

        if (lotes.equals("Si")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chxUsaLotes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TABLE_CONTAINER_USALOTE\"]/div/div/span/label")));
            Utils.enmarcarElemento(driver, chxUsaLotes);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"TABLE_CONTAINER_USALOTE\"]/div/div/span/label"), "¿Producto usa Lotes?: " + lotes + "");
            Utils.desenmarcarObjeto(driver, chxUsaLotes);
            chxUsaLotes.click();

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chbxProdVendeLotes = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TABLE_CONTAINER_MITEMVENDELOTE\"]/div/div/span/label")));
            Utils.enmarcarElemento(driver, chbxProdVendeLotes);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"TABLE_CONTAINER_MITEMVENDELOTE\"]/div/div/span/label"), "¿Producto vende con Lotes?" + vendeLotes + "");
            Utils.desenmarcarObjeto(driver, chbxProdVendeLotes);

            if (vendeLotes.equals("Si")) {
                chbxProdVendeLotes.click();
            }

            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement txtCodLotes = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vLOTECODIGO\"]")));
            Utils.enmarcarElemento(driver, chxUsaLotes);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vLOTECODIGO\"]"), "¿Producto usa Lotes?: " + lotes + "");
            Utils.desenmarcarObjeto(driver, chxUsaLotes);
            txtCodLotes.sendKeys(DatosGlobales.datos.get("codigoLotes"));

        }
        System.out.println("El producto no usa lotes");
    }

    public static void ingresarCodigoInternoDelProducto(String codInterno) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtcodigoInterno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOINT\"]")));
        Utils.enmarcarElemento(driver, txtcodigoInterno);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOINT\"]"), "Ingreso Codigo interno: " + codInterno + "");
        Utils.desenmarcarObjeto(driver, txtcodigoInterno);
        txtcodigoInterno.sendKeys(DatosGlobales.datos.get("codInterno"));
    }

    public static void ingresarCodigoEANDelProducto(String codEAN) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtcodigoEAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOEAN\"]")));
        Utils.enmarcarElemento(driver, txtcodigoEAN);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOEAN\"]"), "Ingreso Codigo EAN: " + codEAN + "");
        Utils.desenmarcarObjeto(driver, txtcodigoEAN);
        txtcodigoEAN.sendKeys(DatosGlobales.datos.get("codEAN"));

    }

    public static void ingresarCodigoSKUDelProducto(String codSKU) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtcodigoSKU = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOSKU\"]")));
        Utils.enmarcarElemento(driver, txtcodigoSKU);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOSKU\"]"), "Ingreso Codigo SKU: " + codSKU + "");
        Utils.desenmarcarObjeto(driver, txtcodigoSKU);
        txtcodigoSKU.sendKeys(DatosGlobales.datos.get("codSKU"));
    }

    public static void ingresarCodigoBase(String codBase) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtcodigoBase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCODIGOBASE\"]")));
        Utils.enmarcarElemento(driver, txtcodigoBase);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCODIGOBASE\"]"), "Ingreso Codigo Base: " + codBase + "");
        Utils.desenmarcarObjeto(driver, txtcodigoBase);
        txtcodigoBase.sendKeys(DatosGlobales.datos.get("codBase"));
        tomarCaptura("Menu Movimientos");
    }

    public static void seleccionCategoriaBuscadora(String catBuscadora) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btnCatBuscadora = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCATEGORIABUSCADORA\"]")));
        Utils.enmarcarElemento(driver, btnCatBuscadora);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCATEGORIABUSCADORA\"]"), "Categoria Buscadora: " + catBuscadora + "");
        Utils.desenmarcarObjeto(driver, btnCatBuscadora);
        if (DatosGlobales.datos.get("catBuscadora").equals("ANNO")) {
            Select select = new Select(btnCatBuscadora);
            select.selectByIndex(1);

        } else {
            Select select = new Select(btnCatBuscadora);
            select.selectByIndex(2);
        }
        Thread.sleep(2000);
    }

    public static void seleccionarBtnBuscar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BUSCAR\"]")));
        Utils.enmarcarElemento(driver, btnBuscar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"BUSCAR\"]"), "Seleccion boton buscar");
        Utils.desenmarcarObjeto(driver, btnBuscar);
        btnBuscar.click();
    }

    public static void seleccionCategoriaBuscadoraTipoOtros(String codCatBuscadoraTipo) throws IOException, InterruptedException {
        codCatBuscadoraTipo = DatosGlobales.datos.get("codCatBuscadoraTipo");
        Thread.sleep(3000);
        switch (codCatBuscadoraTipo) {
            case "Ferreteria":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFerreteria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0001\"]")));
                Utils.enmarcarElemento(driver, btnFerreteria);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0001\"]"), "Categoria Buscadora: " + codCatBuscadoraTipo );
                Utils.desenmarcarObjeto(driver, btnFerreteria);
                btnFerreteria.click();
                tomarCaptura("Categoria Buscadora");
                break;

            case "Fiesta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFiesta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0002\"]")));
                Utils.enmarcarElemento(driver, btnFiesta);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0002\"]"), "Categoria Buscadora: " + codCatBuscadoraTipo);
                Utils.desenmarcarObjeto(driver, btnFiesta);
                btnFiesta.click();
                tomarCaptura("Categoria Buscadora");
                break;

            case "Parrilla":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnParrilla = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0003\"]")));
                Utils.enmarcarElemento(driver, btnParrilla);
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIA_ACTION_0003\"]"), "Categoria Buscadora: " + codCatBuscadoraTipo );
                Utils.desenmarcarObjeto(driver, btnParrilla);
                btnParrilla.click();
                tomarCaptura("Categoria Buscadora");
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    public static void seleccionCategoriaBuscadoraTipoANNO() throws InterruptedException {
        List<String> fechas = Arrays.asList("2020", "2022");
        buscarVariasFechasYAgregar(driver, fechas);

    }

    public static void seleccionCategoriaClasificadora() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btncatClasificadora = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCATEGORIACLASIFICADORA\"]")));
        WebElement btnBuscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BUSCARCLASIFICADORAS")));

        // tomarCaptura("Menu Movimientos");
        Utils.enmarcarElemento(driver, btncatClasificadora);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCATEGORIACLASIFICADORA\"]"),"");
        Utils.desenmarcarObjeto(driver, btncatClasificadora);
        Select select = new Select(btncatClasificadora);
        select.selectByIndex(1);
        btnBuscar.click();

    }

    public static void seleccionCategoriaClasificadoraTipo(String catClasificadora) throws IOException, InterruptedException {
        catClasificadora = DatosGlobales.datos.get("catClasificadora");
        Thread.sleep(3000);
        switch (catClasificadora) {
            case "Aceite y Condimentos":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnAceiteCondimento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0001\"]")));
                Utils.enmarcarElemento(driver, btnAceiteCondimento );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0001\"]"), "Categoria clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnAceiteCondimento);
                btnAceiteCondimento.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Aderezos y Salsas":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnAderezos = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0002\"]")));
                Utils.enmarcarElemento(driver, btnAderezos ); //*[@id="vAGREGARCATEGORIACLASIFICADORA_ACTION_0001"]
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0002\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnAderezos);
                btnAderezos.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Arroz Legumbres y Semillas":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnLegumbres = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0003\"]")));
                Utils.enmarcarElemento(driver, btnLegumbres );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0003\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver,  btnLegumbres);
                btnLegumbres.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Coctel y Snack":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnCoctel = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0004\"]")));
                Utils.enmarcarElemento(driver, btnCoctel );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0004\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnCoctel);
                btnCoctel.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Conservas":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnConservas = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0005\"]")));
                Utils.enmarcarElemento(driver, btnConservas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0005\"]"), "CategoriaClasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnConservas);
                btnConservas.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Despensa Infantil" :
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnDespensaInfantil = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0006\"]")));
                Utils.enmarcarElemento(driver, btnDespensaInfantil );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0006\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnDespensaInfantil);
                btnDespensaInfantil.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Fideos Instantaneos":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFideosInstantaneos = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0007\"]")));
                Utils.enmarcarElemento(driver, btnFideosInstantaneos );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0007\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnFideosInstantaneos);
                btnFideosInstantaneos.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Harina y Complementos":
                WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnHarinaComplementos = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0008\"]")));
                Utils.enmarcarElemento(driver, btnHarinaComplementos );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0008\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnHarinaComplementos);
                btnHarinaComplementos.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Pastas y Salsas":
                WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPastasYSalsas = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0009\"]")));
                Utils.enmarcarElemento(driver, btnPastasYSalsas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0009\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnPastasYSalsas);
                btnPastasYSalsas.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            case "Sopas Instantaneas":
                WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnSopasInstantaneas = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0010\"]")));
                Utils.enmarcarElemento(driver, btnSopasInstantaneas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vAGREGARCATEGORIACLASIFICADORA_ACTION_0010\"]"), "Categoria Clasificadora: "+catClasificadora);
                Utils.desenmarcarObjeto(driver, btnSopasInstantaneas);
                btnSopasInstantaneas.click();
                tomarCaptura("Categoria Clasififcadora");
                break;

            default:
                System.out.println("Opción no válida");
        }
    }



    public static void ingresoDeCantidadDeProductoPorUbicacion(String ubicacionStock ) throws InterruptedException {


            ubicacionStock = DatosGlobales.datos.get("ubicacionStock");
            Thread.sleep(3000);
            switch (ubicacionStock) {
                case "Raiz":
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtCant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0001\"]")));
                    Utils.enmarcarElemento(driver, txtCant );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vSTOCK_0001\"]"), "");
                    Utils.desenmarcarObjeto(driver, txtCant);
                    txtCant.clear();
                    txtCant.sendKeys(DatosGlobales.datos.get("cantidadP"));

                    break;

                case "UbiBox":
                    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtCant2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0002\"]")));
                    Utils.enmarcarElemento(driver, txtCant2 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vSTOCK_0002\"]"), "");
                    Utils.desenmarcarObjeto(driver, txtCant2);
                    txtCant2.clear();
                    txtCant2.sendKeys(DatosGlobales.datos.get("cantidadP"));  //stock del items
//                    txtCostoUni2.sendKeys(BaseTest.datos.get("costoUni"));  //valor de compra del items
//                    txtPrecioProd2.sendKeys(BaseTest.datos.get("precioProd"));   //precio venta del items
                    break;
//
                case "UbiOlmue":
                    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtCant3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0003\"]")));
                    Utils.enmarcarElemento(driver, txtCant3 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vSTOCK_0003\"]"), "");
                    Utils.desenmarcarObjeto(driver, txtCant3);
                    txtCant3.clear();
                    txtCant3.sendKeys(DatosGlobales.datos.get("cantidadP"));

                    break;
//
                case "TURNO SIN INVENTARIO":
                    WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtCant4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0004\"]")));
                    Utils.enmarcarElemento(driver, txtCant4 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vSTOCK_0004\"]"), "");
                    Utils.desenmarcarObjeto(driver, txtCant4);
                    txtCant4.clear();
                    txtCant4.sendKeys(DatosGlobales.datos.get("cantidadP"));

                break;

                default:
                    System.out.println("Opción no válida");
            }

    }

    public static void ingresoDeCostoUnitario(String ubicacionStock) throws InterruptedException {
        ubicacionStock = DatosGlobales.datos.get("ubicacionStock");
       // cantidadP = datos.get("cantidadP");

        Thread.sleep(3000);
        switch (ubicacionStock) {
            case "Raiz":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//              WebElement txtCant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0001\"]")));
                WebElement txtCostoUni = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCOSTOUNITARIO_0001\"]")));
                WebElement txtPrecioProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0001\"]")));
//              Utils.enmarcarElemento(driver, txtCant );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCOSTOUNITARIO_0001\"]"), "");
//              Utils.desenmarcarObjeto(driver, txtCant);
//              txtCant.sendKeys(BaseTest.datos.get("cantidadP"));
                Utils.enmarcarElemento(driver, txtCostoUni);
                Utils.desenmarcarObjeto(driver, txtCostoUni);
                txtCostoUni.clear();
                txtCostoUni.sendKeys(DatosGlobales.datos.get("costoUni"));
//              Utils.enmarcarElemento(driver, txtPrecioProd);
//              Utils.desenmarcarObjeto(driver, txtPrecioProd);
//              txtPrecioProd.sendKeys(BaseTest.datos.get("precioProd"));
                break;

            case "UbiBox":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement txtCant2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0002\"]")));
                WebElement txtCostoUni2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCOSTOUNITARIO_0002\"]")));
//                WebElement txtPrecioProd2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0002\"]")));
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCOSTOUNITARIO_0002\"]"), "");
                Utils.enmarcarElemento(driver, txtCostoUni2 );
                Utils.desenmarcarObjeto(driver, txtCostoUni2);
 //               txtCant2.sendKeys(BaseTest.datos.get("cantidadP"));  //stock del items
                txtCostoUni2.clear();
                txtCostoUni2.sendKeys(DatosGlobales.datos.get("costoUni"));  //valor de compra del items
//                txtPrecioProd2.sendKeys(BaseTest.datos.get("precioProd"));   //precio venta del items
                break;

            case "UbiOlmue":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement txtCant3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0003\"]")));
                WebElement txtCostoUni3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCOSTOUNITARIO_0003\"]")));
 //               WebElement txtPrecioProd3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0003\"]")));
                Utils.enmarcarElemento(driver, txtCostoUni3 );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCOSTOUNITARIO_0003\"]"), "");
                Utils.desenmarcarObjeto(driver, txtCostoUni3);
                txtCostoUni3.clear();
                txtCostoUni3.sendKeys(DatosGlobales.datos.get("costoUni"));
                break;

            case "TURNO SIN INVENTARIO":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
 //               WebElement txtCant4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vSTOCK_0004\"]")));
                WebElement txtCostoUni4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCOSTOUNITARIO_0004\"]")));
 //               WebElement txtPrecioProd4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0004\"]")));
                Utils.enmarcarElemento(driver, txtCostoUni4 );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCOSTOUNITARIO_0004\"]"), "");
                Utils.desenmarcarObjeto(driver, txtCostoUni4);
                txtCostoUni4.clear();
                txtCostoUni4.sendKeys(DatosGlobales.datos.get("costoUni"));
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    public static void ingresarPrecioProducto(String ubicacionStock) throws InterruptedException {
        if(DatosGlobales.datos.get("lotes").equals("Si")){

            ubicacionStock = DatosGlobales.datos.get("ubicacionStock");


            Thread.sleep(3000);
            switch (ubicacionStock) {
                case "Raiz":
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0001\"]")));
                    Utils.enmarcarElemento(driver, txtPrecioProd );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0001\"]"), "");
                    Utils.desenmarcarObjeto(driver, txtPrecioProd);
                    txtPrecioProd.clear();
                    txtPrecioProd.sendKeys(DatosGlobales.datos.get("precioPorLotes"));
                    break;

                case "UbiBox":
                    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0002\"]")));
                    Utils.enmarcarElemento(driver, txtPrecioProd2 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0002\"]"),"");
                    Utils.desenmarcarObjeto(driver, txtPrecioProd2);
                    txtPrecioProd2.clear();
                    txtPrecioProd2.sendKeys(DatosGlobales.datos.get("precioPorLotes"));
                    break;

                case "UbiOlmue":
                    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0003\"]")));
                    Utils.enmarcarElemento(driver, txtPrecioProd3 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0003\"]"),"");
                    Utils.desenmarcarObjeto(driver, txtPrecioProd3);
                    txtPrecioProd3.clear();
                    txtPrecioProd3.sendKeys(DatosGlobales.datos.get("precioPorLotes"));
                    break;

                case "TURNO SIN INVENTARIO":
                    WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0004\"]")));
                    Utils.enmarcarElemento(driver, txtPrecioProd4 );
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0004\"]"),"");
                    Utils.desenmarcarObjeto(driver, txtPrecioProd4);
                    txtPrecioProd4.clear();
                    txtPrecioProd4.sendKeys(DatosGlobales.datos.get("precioPorLotes"));
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        }else {
            ubicacionStock = DatosGlobales.datos.get("ubicacionStock");
            Thread.sleep(3000);
            switch (ubicacionStock) {
                case "Raiz":
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0001\"]")));
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0001\"]"),"");
                    Utils.enmarcarElemento(driver, txtPrecioProd);
                    Utils.desenmarcarObjeto(driver, txtPrecioProd);
                    txtPrecioProd.clear();
                    txtPrecioProd.sendKeys(DatosGlobales.datos.get("precioProd"));
                    break;

                case "UbiBox":
                    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0002\"]")));
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0002\"]"),"");
                    Utils.enmarcarElemento(driver, txtPrecioProd2);
                    Utils.desenmarcarObjeto(driver, txtPrecioProd2);
                    txtPrecioProd2.clear();
                    txtPrecioProd2.sendKeys(DatosGlobales.datos.get("precioProd"));   //precio venta del items
                    break;

                case "UbiOlmue":
                    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0003\"]")));
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0003\"]"),"");
                    Utils.enmarcarElemento(driver, txtPrecioProd3);
                    Utils.desenmarcarObjeto(driver, txtPrecioProd3);
                    txtPrecioProd3.clear();
                    txtPrecioProd3.sendKeys(DatosGlobales.datos.get("precioProd"));
                    break;

                case "TURNO SIN INVENTARIO":
                    WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement txtPrecioProd4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vPRECIOVENTA_0004\"]")));
                    esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vPRECIOVENTA_0004\"]"),"");
                    Utils.enmarcarElemento(driver, txtPrecioProd4);
                    Utils.desenmarcarObjeto(driver, txtPrecioProd4);
                    txtPrecioProd4.clear();
                    txtPrecioProd4.sendKeys(DatosGlobales.datos.get("precioProd"));
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void seleccionarBtnGuardarProducto() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGuardarProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDARPRODUCTO\"]")));
        Utils.enmarcarElemento(driver, btnGuardarProducto );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDARPRODUCTO\"]"),"");
        tomarCaptura("boton guardar");
        Utils.desenmarcarObjeto(driver,btnGuardarProducto);
        btnGuardarProducto.click();
        Thread.sleep(2000);


    }
    public static void ingresarFiltros(){

    }
    public static void seleccionarFiltroCatClasificadoraVistaModuloItems()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCatClasificadora = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCLASIFICADORACATPDRCOD\"]")));
        Utils.enmarcarElemento(driver, btnCatClasificadora);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCLASIFICADORACATPDRCOD\"]"),"");
        Utils.desenmarcarObjeto(driver, btnCatClasificadora);
        Select select = new Select(btnCatClasificadora);
        select.selectByIndex(1);

    }
    public static void seleccionarCodigoCatClasificadoraVistaModuloItems(String catClasificadora) throws InterruptedException, IOException {

        catClasificadora = DatosGlobales.datos.get("catClasificadora");
        Thread.sleep(3000);
        switch (catClasificadora) {
            case "Aceite y Condimentos":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnAceiteCondimento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[1]")));
                Utils.enmarcarElemento(driver, btnAceiteCondimento );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[1]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnAceiteCondimento);
                btnAceiteCondimento.click();

                break;

            case "Aderezos y Salsas":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnAderezos = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[2]")));
                Utils.enmarcarElemento(driver, btnAderezos ); //*[@id="vAGREGARCATEGORIACLASIFICADORA_ACTION_0001"]
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[2]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnAderezos);
                btnAderezos.click();

                break;

            case "Arroz Legumbres y Semillas":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnLegumbres = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[3]")));
                Utils.enmarcarElemento(driver, btnLegumbres );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[3]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver,  btnLegumbres);
                btnLegumbres.click();

                break;

            case "Coctel y Snack":
                WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnCoctel = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[4]")));
                Utils.enmarcarElemento(driver, btnCoctel );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[4]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnCoctel);
                btnCoctel.click();

                break;

            case "Conservas":
                WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnConservas = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[5]")));
                Utils.enmarcarElemento(driver, btnConservas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[5]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnConservas);
                btnConservas.click();
                break;

            case "Despensa Infantil" :
                WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnDespensaInfantil = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[6]")));
                Utils.enmarcarElemento(driver, btnDespensaInfantil );
               esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[6]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnDespensaInfantil);
                btnDespensaInfantil.click();
                break;

            case "Fideos Instantaneos":
                WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFideosInstantaneos = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[7]")));
                Utils.enmarcarElemento(driver, btnFideosInstantaneos );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[7]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnFideosInstantaneos);
                btnFideosInstantaneos.click();
                break;

            case "Harina y Complementos":
                WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnHarinaComplementos = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[8]")));
                Utils.enmarcarElemento(driver, btnHarinaComplementos );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[8]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnHarinaComplementos);
                btnHarinaComplementos.click();

                break;

            case "Pastas y Salsas":
                WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnPastasYSalsas = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[9]")));
                Utils.enmarcarElemento(driver, btnPastasYSalsas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[9]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnPastasYSalsas);
                btnPastasYSalsas.click();

                break;

            case "Sopas Instantaneas":
                WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnSopasInstantaneas = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[10]")));
                Utils.enmarcarElemento(driver, btnSopasInstantaneas );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROCLASIFICADORACATCOD\"]/option[10]"),"Categoria Clasificadora: "+catClasificadora+"");
                tomarCaptura("Categoria_Clasificadora_VP");
                Utils.desenmarcarObjeto(driver, btnSopasInstantaneas);
                btnSopasInstantaneas.click();
                break;

            default:
                System.out.println("Opción no válida");
        }

    }

    public static void seleccionarFiltroCatBuscadoraVistaModuloItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCatBuscadora = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vBUSCADORACATPDRCOD\"]")));
        Utils.enmarcarElemento(driver, btnCatBuscadora);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vBUSCADORACATPDRCOD\"]"), "");
        Utils.desenmarcarObjeto(driver, btnCatBuscadora);
        if (DatosGlobales.datos.get("catBuscadora").equals("ANNO")){
            Select select = new Select(btnCatBuscadora);
            select.selectByIndex(1);
        }else {
            Select select = new Select(btnCatBuscadora);
            select.selectByIndex(2);
        }
        Thread.sleep(2000);
    }
    public static void seleccionarCodigoCatBuscadoraVistaModuloItems(String codCatBuscadoraTipo) throws InterruptedException, IOException {
        codCatBuscadoraTipo = DatosGlobales.datos.get("codCatBuscadoraTipo");
        Thread.sleep(3000);
        switch (codCatBuscadoraTipo) {
            case "Ferreteria":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFerreteria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[1]")));
                Utils.enmarcarElemento(driver, btnFerreteria );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[1]"),"Categoria Buscadora: "+codCatBuscadoraTipo+"");
                btnFerreteria.click();
                tomarCaptura("Categoria_Buscadora_VP");
                Utils.desenmarcarObjeto(driver, btnFerreteria);
                break;

            case "Fiesta":
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnFiesta = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[2]")));
                Utils.enmarcarElemento(driver, btnFiesta );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[2]"),"Categoria Buscadora: "+codCatBuscadoraTipo+"");
                btnFiesta.click();
                tomarCaptura("Categoria_Buscadora_VP");
                Utils.desenmarcarObjeto(driver, btnFiesta);
                break;

            case "Parrilla":
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement btnParrilla = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[3]")));
                Utils.enmarcarElemento(driver, btnParrilla );
                esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[3]"),"Categoria Buscadora: "+codCatBuscadoraTipo+"");
                btnParrilla.click();
                tomarCaptura("Categoria_Buscadora_VP");
                Utils.desenmarcarObjeto(driver, btnParrilla);
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    public static void seleccionarCheckMostrarTodo() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chkMostrarTodo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TABLE_CONTAINER_MOSTRARTODO\"]/div/div/span/label")));
        Utils.enmarcarElemento(driver, chkMostrarTodo );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"TABLE_CONTAINER_MOSTRARTODO\"]/div/div/span/label"),"Check Mostrar Todo");
        chkMostrarTodo.click();
        tomarCaptura("Mostrar Todo");
        Utils.desenmarcarObjeto(driver,chkMostrarTodo);
    }

    public static void mostrarListadoDeItems() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ListaDeItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LAYOUTDEFINED_TABLE3_GRIDITEMS\"]/div[1]")));
        Utils.enmarcarElemento(driver, ListaDeItems);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"LAYOUTDEFINED_TABLE3_GRIDITEMS\"]/div[1]"), "Lista de Items encontrados");
        tomarCaptura("Listado de Items");
        Utils.desenmarcarObjeto(driver, ListaDeItems);

    }
    public static void scroll(){
        // Realizar un desplazamiento hacia abajo (por ejemplo, 1000 píxeles)
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 1000);");
    }
    public static void seleccionarCodigoCatBuscadoraVistaModuloItemsANNO(String codCatBuscadoraTipov1) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement codCatBuscadoraTipo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[1]")));
        Utils.enmarcarElemento(driver, codCatBuscadoraTipo);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vFILTROBUSCADORACATCOD\"]/option[1]"),"");

        Thread.sleep(2000);
        // Ubicar la lista desplegable
        WebElement dropdown = driver.findElement(By.id("vFILTROBUSCADORACATCOD"));
        Select select = new Select(dropdown);
        // Selecciona por VALOR del atributo 'value'
        select.selectByValue(datos.get("codCatBuscadoraTipo"));
        tomarCaptura("Seleccion Codigo Categoria Buscadora");
        Utils.desenmarcarObjeto(driver, codCatBuscadoraTipo);


    }
    public static void seleccionarSinCategoria(String sinCategoria) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSinCategoria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCHKBOXSELSINCATBUSCADORA\"]")));
        Utils.enmarcarElemento(driver, btnSinCategoria);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCHKBOXSELSINCATBUSCADORA\"]"), "Sin Categoria : ");
        Select select = new Select(btnSinCategoria);
        select.selectByIndex(1);
        tomarCaptura("Seleccion Sin Categoria");
        Utils.desenmarcarObjeto(driver, btnSinCategoria);

    }
    public static void visualizarModuloItems() throws IOException, InterruptedException {
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtModuloItems = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TITLECONTAINERSECTION\"]")));
        Utils.enmarcarElemento(driver, txtModuloItems );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"TITLECONTAINERSECTION\"]"),"");
        Utils.desenmarcarObjeto(driver, txtModuloItems);
        tomarCaptura("Modulo Items");

    }
    public static void busquedaPorCodigoItems(String codigo) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCodigoItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vITMCOD")));
        Utils.enmarcarElemento(driver, txtCodigoItems );
        esperarElementoYMedirTiempo(By.id("vITMCOD"),"Busqueda por Codigo:"+codigo);
        txtCodigoItems.sendKeys(DatosGlobales.datos.get("codigo"));
        tomarCaptura("Busqueda por codigo de items");
        Utils.desenmarcarObjeto(driver,txtCodigoItems);
    }
    public static void busquedaPorDescripcionItems(String descProd) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCodigoItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vITMDES")));
        Utils.enmarcarElemento(driver, txtCodigoItems );
        esperarElementoYMedirTiempo(By.id("vITMDES"), "Busqueda por Descripcion "+descProd );
        txtCodigoItems.sendKeys(DatosGlobales.datos.get("descProd"));
        tomarCaptura("Busqueda por descripcion de Items");
        Utils.desenmarcarObjeto(driver,txtCodigoItems);
    }
    public static void busquedaPorDiasDeUltimaModificacion(String diasMod) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtDiaUltMod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vMODIFICACIONDIAS")));
        Utils.enmarcarElemento(driver, txtDiaUltMod );
        esperarElementoYMedirTiempo( By.id("vMODIFICACIONDIAS"), "Busqueda por Ultimos "+DatosGlobales.datos.get("diasMod")+" modificados");
        Utils.desenmarcarObjeto(driver,txtDiaUltMod);
        txtDiaUltMod.clear();
        txtDiaUltMod.sendKeys(DatosGlobales.datos.get("diasMod"));
        tomarCaptura("Busqueda por dias de ultima modificacion");
    }
    public static void seleccionarLimpiarFiltros() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnLimpiarFiltros = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("LIMPIARFILTROS")));
        Utils.enmarcarElemento(driver, btnLimpiarFiltros );
        esperarElementoYMedirTiempo(By.name("LIMPIARFILTROS"), "Selecciona Limpiar Filtros");
        btnLimpiarFiltros.click();
        tomarCaptura("Selecciona Limpiar Filtros");
        Utils.desenmarcarObjeto(driver,btnLimpiarFiltros);

    }
    public static void seleccionarDescargarColumnasBase() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnDescargar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DESCARGARCOLUMNASBASE")));
        Utils.enmarcarElemento(driver, btnDescargar );
        esperarElementoYMedirTiempo(By.id("DESCARGARCOLUMNASBASE"), "Selecciona Descargar Columna Base para maestras");
        btnDescargar.click();
        tomarCaptura("Selecciona Descargar Columna Base para maestras");
        Utils.desenmarcarObjeto(driver,btnDescargar);
    }
    public static void validarArchivoDescargado(){
        String carpetaDescargas = "C:/Users/alexi/Downloads/";
        String nombreArchivo = "BaseMaestra_1008.csv";
        String rutaArchivo = carpetaDescargas + nombreArchivo;

        // Esperar que el archivo se descargue
        boolean archivoDescargado = verificarArchivo.esperarArchivoDescarga(rutaArchivo, 20);
//        boolean archivoDescargado = verificarArchivo.existeArchivo(rutaArchivo, 20);
        if (archivoDescargado) {
            System.out.println("✅ Archivo descargado correctamente.");
        } else {
            System.out.println("❌ Error: El archivo no se descargó.");
        }
    }

    public static void visualizarMsjAlerta() throws InterruptedException, IOException {
        Thread.sleep(2000);
       // BaseTest.tomarCaptura("Mensaje Alerta: Debe ingresar una descripción para el producto");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msjAlerta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/k2bt-floating-messages[2]/div/div/div[1]")));
        Utils.enmarcarElemento(driver, msjAlerta );
        esperarElementoYMedirTiempo(By.xpath("//html/body/k2bt-floating-messages[2]/div/div/div[1]"), "Mensaje Alerta");
        Utils.desenmarcarObjeto(driver,msjAlerta);
        String capturedText = msjAlerta.getText();
        capturedText = capturedText.replace("\"", "");  // Elimina todas las comillas
        tomarCaptura(" MSJ " +capturedText);
        System.out.println(capturedText);
    }

    public static void pegarEnPutty(String texto) {
        try {
            // Copiar el texto al portapapeles
            StringSelection seleccion = new StringSelection(texto);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

            // Simular teclas con Robot
            Robot robot = new Robot();
            Thread.sleep(2000); // Espera para asegurarse de que PuTTY está activo

            // Pegar el contenido con CTRL + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Presionar ENTER
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // 6️⃣ Escribir el segundo comando: "cat /tmp/Testpsql.txt"
//            escribirTexto(robot, "cat /tmp/Testpsql.txt");
//            presionarEnter(robot);
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ingresarDatosPutty(){
        try {
            // 🔹 Abrir PuTTY
            String puttyPath = "C:\\Program Files\\putty.exe";
            String host = "qa2.enternet.cl";
            ProcessBuilder pb = new ProcessBuilder(puttyPath, "-ssh", host);
            pb.start();
            System.out.println("✅ PuTTY abierto con conexión a: " + host);

            Thread.sleep(2000); // Esperar que PuTTY abra

            // 🔹 Crear instancia de Robot
            Robot robot = new Robot();

            // 🔹 Escribir usuario con primera letra mayúscula
            String usuario = "root";
//            escribirTexto(robot, usuario);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);

            // 🔹 Escribir contraseña con primera letra mayúscula y caracteres especiales
            String password = "Enternet!1267?";
//            password = capitalizarPrimeraLetra(password);
//            escribirTextoEspecial(robot, password);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("✅ Usuario y contraseña ingresados en PuTTY.");
            Thread.sleep(2000);


            Thread.sleep(3000);

            // 6️⃣ Escribir el segundo comando: "cat /tmp/Testpsql.txt"
            escribirTexto(robot, "cat /tmp/Testpsql.txt");
            presionarEnter(robot);
            Thread.sleep(3000);

            System.out.println("Comandos ejecutados en PuTTY");

            //su -c "psql -d pos -tc \"select * from itemmaestro where mitemnom = 'Lentejas Listas Para Servir Esmeralda 400 Gr';\"" postgres > /tmp/Testpsql.txt
            //cat /tmp/Testpsql.txt  //imprime lo de arriba

            //    document.add(new Paragraph(result.toString()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void seleccionarBtnImportarArchivo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnImportar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("IMPORTARARCHIVO")));
        Utils.enmarcarElemento(driver, btnImportar );
        esperarElementoYMedirTiempo(By.id("IMPORTARARCHIVO"), "seleccion boton importar archivo");
        Utils.desenmarcarObjeto(driver,btnImportar);
        btnImportar.click();
}

    public static void ingresarTipoDeSeparadorDeCeldas() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtSeparador = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vSEPARADOR")));
        Utils.enmarcarElemento(driver, txtSeparador );
        esperarElementoYMedirTiempo(By.id("vSEPARADOR"), "Separador de celdas");
        Utils.desenmarcarObjeto(driver,txtSeparador);
        txtSeparador.sendKeys(datos.get("separadorCeldas"));
        tomarCaptura("Seleccionar Separador de celdas ");
        driver.switchTo().defaultContent();
    }
    public static void seleccionarBtnAgregarArchivos() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnAgregar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FILEUPLOAD1Container\"]/div/div[1]/div[1]/span[1]")));
        Utils.enmarcarElemento(driver, btnAgregar );
        esperarElementoYMedirTiempo( By.xpath("//*[@id=\"FILEUPLOAD1Container\"]/div/div[1]/div[1]/span[1]"), "seleccion boton importar archivo");
        Utils.desenmarcarObjeto(driver,btnAgregar);
       // btnAgregar.click();
        Thread.sleep(2000);
        // Ubicar el elemento de carga de archivo
        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));

        // Especificar la ruta del archivo a subir
        String filePath = "C:/Users/alexi/Downloads/CargaMaestraLotes1159.csv"; // Asegúrate de usar la ruta correcta
        uploadElement.sendKeys(filePath);
       // uploadElement.sendKeys(Keys.ENTER);

        driver.switchTo().defaultContent();
    }
    public static void seleccionarDocumentoConDataParaCargar(){

    }
    public static void seleccionarBtnProcesar() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        scroll();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnProcesar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PROCESAR\"]")));
        Utils.enmarcarElemento(driver, btnProcesar );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"PROCESAR\"]"), "seleccion boton Procesar");
        Utils.desenmarcarObjeto(driver,btnProcesar);
        btnProcesar.click();
        driver.switchTo().defaultContent();
    }
    public static String validarMensajeDeCarga() throws InterruptedException, IOException {

        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msjAlerta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/k2bt-floating-messages/div/div/div[1]")));
        Utils.enmarcarElemento(driver, msjAlerta );

        // Capturar el texto en una variable
       // String capturedText = msjAlerta.getText();
        String capturedText = msjAlerta.getText();
        esperarElementoYMedirTiempo(By.xpath("//html/body/k2bt-floating-messages/div/div/div[1]"), " "+capturedText);
        if (capturedText.equals("Producto creado de manera exitosa"))
        {

            tomarCaptura("Mensaje Exitoso");
            System.out.println(capturedText);
        }else{
            tomarCaptura("Mensaje de error ");
            System.out.println(capturedText);
        }

        return capturedText;
    }
    public static void seleccionarBtnCodigoDeBarras(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCrearCodigoBarra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CREARCODIGOBARRA")));
        Utils.enmarcarElemento(driver, btnCrearCodigoBarra );
        esperarElementoYMedirTiempo(By.id("CREARCODIGOBARRA"), "seleccion boton Crear Codigo Barra");
        Utils.desenmarcarObjeto(driver,btnCrearCodigoBarra);
        btnCrearCodigoBarra.click();
    }
    public static void ingresarCodigoDeBarras(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCodigoBarra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vCODIGOBARRA")));
        Utils.enmarcarElemento(driver, txtCodigoBarra );
        esperarElementoYMedirTiempo(By.id("vCODIGOBARRA"), "ingreso Codigo Barra");
        Utils.desenmarcarObjeto(driver,txtCodigoBarra);
        txtCodigoBarra.sendKeys(datos.get("codSKU"));
    }
    public static void seleccionarBtnSigte() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSigte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SIGUIENTE\"]")));
        Utils.enmarcarElemento(driver, btnSigte );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"SIGUIENTE\"]"), "seleccion boton siguiente");
        Utils.desenmarcarObjeto(driver,btnSigte);
        btnSigte.click();

    }
    public static void seleccionarBtnEditar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnEditar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_vEDITAR_ACTION_0001\"]")));
        Utils.enmarcarElemento(driver, btnEditar );
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"span_vEDITAR_ACTION_0001\"]"), "seleccion boton Editar");
        Utils.desenmarcarObjeto(driver,btnEditar);
        btnEditar.click();
    }
    public static void validarMsjAlerta() throws InterruptedException, IOException {
        //html/body/k2bt-floating-messages[2]/div/div/div[1]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msjAlerta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/k2bt-floating-messages[2]/div/div/div[1]")));
        Utils.enmarcarElemento(driver, msjAlerta );

        // Capturar el texto en una variable
        String capturedText = msjAlerta.getText();
        capturedText = capturedText.replace("\"", "");
        esperarElementoYMedirTiempo(By.xpath("//html/body/k2bt-floating-messages[2]/div/div/div[1]"), capturedText);
        tomarCaptura(capturedText);
        System.out.println(capturedText);

    }
    public static void buscarProductoPorNombre(String nombreProducto) throws InterruptedException {
        Thread.sleep(2000);
        nombreProducto= DatosGlobales.datos.get("descProd");
        // Espera que cargue la tabla
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GriditemsContainerTbl\"]")));

        // Encuentra todas las filas de la tabla (excepto el encabezado)
        List<WebElement> filas = driver.findElements(By.xpath("//*[@id=\"GriditemsContainerTbl\"]//tr[position()>1]"));

        boolean encontrado = false;

        for (WebElement fila : filas) {
            // Busca el valor de la columna "Nombre"
            WebElement celdaNombre = fila.findElement(By.xpath("./td[3]")); // Asumiendo que 'Nombre' es la tercera columna

            if (celdaNombre.getText().trim().equalsIgnoreCase(nombreProducto.trim())) {
                Utils.enmarcarElemento(driver, celdaNombre );
                System.out.println("✅ Producto encontrado: " + celdaNombre.getText());
                tomarCaptura("Producto encontrado");
                Utils.desenmarcarObjeto(driver, celdaNombre );
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Producto no encontrado: " + nombreProducto);
        }
    }

    public static void buscarVariasDespensasYAgregar(WebDriver driver, List<String> DespensasDeseadas) throws InterruptedException {
        for (String Despensa : DespensasDeseadas) {
            boolean encontrada = false;

            while (!encontrada) {
                // Obtener todas las filas visibles
                List<WebElement> filas = driver.findElements(By.xpath("//tr[starts-with(@id,'GridcategoriasclasificadorasContainerRow_')]"));

                for (int i = 0; i < filas.size(); i++) {
                    try {
                        // Obtener la celda de la columna "Nombre" (segunda columna) //*[@id="GridcategoriasclasificadorasContainerRow_0001"]/td[2]
                        WebElement celdaNombre = filas.get(i).findElement(By.xpath(".//td[2]"));
                        String texto = celdaNombre.getText().trim();

                        if (texto.equals(Despensa)) {
                            encontrada = true;
                            System.out.println("✅ Despensa encontrada: " + texto);

                            // Calcular el ID dinámico del botón +
                            String numeroFormateado = String.format("%04d", i + 1); // ej: "0001"
                            String xpathBotonMas = "//*[@id='vAGREGARCATEGORIACLASIFICADORA_ACTION_" + numeroFormateado + "']";

                            WebElement botonMas = driver.findElement(By.xpath(xpathBotonMas));
                            botonMas.click();

                            Thread.sleep(1000); // Espera tras clic
                            break;
                        }
                    } catch (Exception e) {
                        // Ignorar fila si da error
                    }
                }

                if (!encontrada) {
                    try {
                        WebElement botonSiguiente = driver.findElement(By.xpath("//*[@id=\"PAGINATIONBAR_PAGINGCONTAINERTABLE_GRIDCATEGORIASBUSCADORASContainer\"]/div/span[9]"));
                        if (botonSiguiente.isDisplayed() && botonSiguiente.isEnabled()) {
                            botonSiguiente.click();
                            Thread.sleep(2000); // Espera tras cambiar de página
                        } else {
                            System.out.println("⚠️ No se encontró la Despensa: " + Despensa);
                            break;
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("❌ Botón 'Siguiente' no disponible.");
                        break;
                    }
                }
            }

        }
    }

    public static void buscarVariasFechasYAgregar(WebDriver driver, List<String> fechasDeseadas) throws InterruptedException {
        Thread.sleep(2000);

        for (String fecha : fechasDeseadas) {
            boolean encontrada = false;

            while (!encontrada) {
                // Obtener todas las filas visibles
                List<WebElement> filas = driver.findElements(By.xpath("//tr[starts-with(@id,'GridcategoriasbuscadorasContainerRow_')]"));

                for (int i = 0; i < filas.size(); i++) {
                    try {
                        // Obtener la celda de la columna "Nombre" (segunda columna)
                        WebElement celdaNombre = filas.get(i).findElement(By.xpath(".//td[2]"));
                        String texto = celdaNombre.getText().trim();

                        if (texto.equals(fecha)) {
                            encontrada = true;
                            System.out.println("✅ Fecha encontrada: " + texto);

                            // Calcular el ID dinámico del botón +
                            String numeroFormateado = String.format("%04d", i + 1); // ej: "0001"
                            String xpathBotonMas = "//*[@id='vAGREGARCATEGORIA_ACTION_" + numeroFormateado + "']";

                            WebElement botonMas = driver.findElement(By.xpath(xpathBotonMas));
                            botonMas.click();

                            Thread.sleep(1000); // Espera tras clic
                            break;
                        }
                    } catch (Exception e) {
                        // Ignorar fila si da error
                    }
                }

                if (!encontrada) {
                    try {
                        WebElement botonSiguiente = driver.findElement(By.xpath("//*[@id=\"PAGINATIONBAR_PAGINGCONTAINERTABLE_GRIDCATEGORIASBUSCADORASContainer\"]/div/span[9]"));
                        if (botonSiguiente.isDisplayed() && botonSiguiente.isEnabled()) {
                            botonSiguiente.click();
                            Thread.sleep(2000); // Espera tras cambiar de página
                        } else {
                            System.out.println("⚠️ No se encontró la fecha: " + fecha);
                            break;
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("❌ Botón 'Siguiente' no disponible.");
                        break;
                    }
                }
            }

            // Regresar a la primera página antes de buscar la siguiente fecha
            try {
                WebElement botonPrimera = driver.findElement(By.xpath("//*[@id=\"PAGINATIONBAR_PAGINGCONTAINERTABLE_GRIDCATEGORIASBUSCADORASContainer\"]/div/span[1]/a"));
                if (botonPrimera.isDisplayed() && botonPrimera.isEnabled()) {
                    botonPrimera.click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                // Si no está el botón, no pasa nada
            }
        }

    }



}
