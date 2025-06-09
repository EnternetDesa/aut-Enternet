package definitions.loginDef;

import Utils.Commons.BaseTest;
import Utils.Commons.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static Utils.Commons.BaseTest.*;


public class TomaSimplificadaDef {
    LoginDef loginDef = new LoginDef();
   WebDriver driver = BaseTest.getDriver();
    // Ruta donde se guardarán los PDFs
    String rutaCarpeta = "C:/git/aut-Enternet/src/main/java/pdf/Captura/";

    // Obtener el próximo número consecutivo
    int numeroArchivo = obtenerNumeroConsecutivo(rutaCarpeta);

    public TomaSimplificadaDef() throws FileNotFoundException {
    }


    @When("este en seleccion de ubicacion y haga click en {string}")
    public void esteEnSeleccionDeUbicacionYHagaClickEn(String ubicacion) throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement linkUbi2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/form/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div[1]/div/div/table/tbody/tr[2]/td[1]/p/span")));
        Utils.enmarcarElemento(driver, linkUbi2 );
        //takeScreenshot("screenshot_");
        tomarCaptura("Ingreso codigo de items");
        esperarElementoYMedirTiempo(By.xpath("//html/body/form/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div[1]/div/div/div[1]/div/div/table/tbody/tr[2]/td[1]/p/span"),"");
        Utils.desenmarcarObjeto(driver, linkUbi2);
        linkUbi2.click();
        driver.switchTo().defaultContent();
    }

    @And("en la vista de formulario ingresamos <{string}> y la cantidad <{string}>")
    public void enLaVistaDeFormularioIngresamosYLaCantidad(String arg0, String arg1) throws IOException, InterruptedException {

        // Lista de datos a ingresar
        String[] datos = {BaseTest.datos.get("producto1"),BaseTest.datos.get("producto2")}; //"7801610323236", "130719"};
        for (String dato : datos) {
            // Buscar el campo de entrada y enviar el dato
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            long startTime2 = System.nanoTime(); // Inicio de medición
            Actions actions2 = new Actions(driver);
            WebElement codItems = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("vXTOMAINVENTARIOCODIGO")));
            long endTime2 = System.nanoTime(); // Fin de medición
            Utils.enmarcarElemento(driver, codItems);
            // WebElement codItems = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("vXTOMAINVENTARIOCODIGO"))); // Reemplaza con el ID real
            codItems.clear();
            codItems.sendKeys(dato);
            Utils.desenmarcarObjeto(driver, codItems);
            // Hacer clic en el botón de envío

            actions2.sendKeys(codItems, Keys.RETURN).perform();
            long duration2 = (endTime2 - startTime2) / 1_000_000; // Convertir a milisegundos
            System.out.println("⏳ Tiempo de espera hasta que se pueda ingresar el 'Codigo de Items' esté visible: " + duration2 + " ms");
            /**** ingreso por lotes*/
            Thread.sleep(4000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            long startTime = System.nanoTime(); // Inicio de medición
            driver.switchTo().frame(0);
            WebElement cantProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0032vSTRCANTIDADTOMADA\"]")));

            /*/-----------------> aqui_todo_bien */
            if (cantProd.isEnabled()) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                WebElement codLotes = driver.findElement(By.id("W0032vLOTECODIGO"));
                WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("W0032vLOTECODIGO")));

                if (codLotes.isDisplayed() && codLotes.isEnabled()) {
                    long endTime = System.nanoTime(); // Fin de medición
                    Utils.enmarcarElemento(driver, codLotes);
                    codLotes.sendKeys(BaseTest.datos.get("codigoLotes"));
                    Utils.desenmarcarObjeto(driver, codLotes);
                    long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
                    System.out.println("⏳ Tiempo de espera hasta que se pueda ingresar el 'Codigo de Lotes' esté visible: " + duration + " ms");

                    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement cantProd2 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0032vSTRCANTIDADTOMADA\"]")));
                    WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement btnAceptar = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0032ACEPTAR\"]")));
                    Utils.enmarcarElemento(driver, cantProd2);
                    // Generar número aleatorio y enviarlo al campo de entrada
                    int numeroAleatorio = generarNumeroAleatorio();
                    cantProd2.sendKeys(String.valueOf(numeroAleatorio));
                    // generarNumeroAleatorio();
                    //takeScreenshot("screenshot_");
                    tomarCaptura("Ingreso de codigo lotes");
                    esperarElementoYMedirTiempo( By.xpath("//*[@id=\"W0032ACEPTAR\"]"), "Ingreso codigo de lotes: "+codLotes+"");
                    Utils.desenmarcarObjeto(driver, cantProd2);
                    btnAceptar.click();
                    driver.switchTo().defaultContent();

                } else {
                     ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('element.style','display:none;');", codLotes);
                    boolean desaparecio = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("W0032vLOTECODIGO")));
                    if (desaparecio) {
                        // Esperar hasta que el primer objeto desaparezca
                        validarIngreso(driver, "7801610323236", By.xpath("W0032vLOTECODIGO"));
                        validarIngreso(driver, "130719", By.xpath("//*[@id=\"W0032vSTRCANTIDADTOMADA\"]"));

                        // Esperar hasta que el segundo objeto sea visible

                        WebElement cantProd3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0032vSTRCANTIDADTOMADA\"]")));
                        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
                        WebElement btnAceptar = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0032ACEPTAR\"]")));
                        Utils.enmarcarElemento(driver, cantProd3);
                        // Generar número aleatorio y enviarlo al campo de entrada
                        int numeroAleatorio = generarNumeroAleatorio();
                        cantProd3.clear();
                        cantProd3.sendKeys(String.valueOf(numeroAleatorio));
                        // generarNumeroAleatorio();
                        tomarCaptura("Ingreso de Catidad");
                        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0032ACEPTAR\"]"), "Ingreso de cantidad: "+numeroAleatorio+"");
                        Utils.desenmarcarObjeto(driver, cantProd3);
                        btnAceptar.click();
                        driver.switchTo().defaultContent();


                    }
                }
            }

        }
    }

    @And("hacemos click en el boton ir a resumen")
    public void hacemosClickEnElBotonIrAResumen() throws IOException, InterruptedException {

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnIrResumen = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IRRESUMEN\"]")));
        Utils.enmarcarElemento(driver, btnIrResumen );
        //takeScreenshot("screenshot_");
        tomarCaptura("Seleccion ir a Resumen");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IRRESUMEN\"]"), "Seleccion ir a Resumen");
        Utils.desenmarcarObjeto(driver, btnIrResumen);
        btnIrResumen.click();
        BaseTest.cerrarDriver(); //------------------------- eliminar---------------

    }
    @And("aceptamos el pop-up de ir a resumen")
    public void aceptamosElPopUpDeIrAResumen() throws IOException, InterruptedException {
//        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnAceptar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]")));
        Utils.enmarcarElemento(driver, btnAceptar );
        //takeScreenshot("screenshot_");
        tomarCaptura("popup ir a resumen");
        esperarElementoYMedirTiempo( By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]"), "Pop-up: ir a resumen");
        Utils.desenmarcarObjeto(driver, btnAceptar);
        btnAceptar.click();
//        driver.switchTo().defaultContent();
    }

    @And("en la vista de cierre de formulacion selecionamos procesar")
    public void enLaVistaDeCierreDeFormulacionSelecionamosProcesar() throws IOException, InterruptedException {
//*[@id="PROCESAR"]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tablaProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GrddetalleunificadoContainerTbl")));
        WebElement btnAceptar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PROCESAR\"]")));
        Utils.enmarcarElemento(driver, tablaProducto );
        Utils.enmarcarElemento(driver, btnAceptar );
        //takeScreenshot("screenshot_");
        tomarCaptura("Toma Simplificada - Procesar");
        esperarElementoYMedirTiempo( By.xpath("//*[@id=\"PROCESAR\"]"), "Toma Simplificada - Procesar" );
        Utils.desenmarcarObjeto(driver, tablaProducto);
        Utils.desenmarcarObjeto(driver, btnAceptar);
        btnAceptar.click();

    }

    @And("aceptamos nuevamente el pop-up")
    public void aceptamosNuevamenteElPopUp() throws IOException, InterruptedException {
//        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnAceptar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]")));
        Utils.enmarcarElemento(driver, btnAceptar );
        //takeScreenshot("screenshot_");
        tomarCaptura("popup - Procesar ");
        esperarElementoYMedirTiempo( By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]"), "pop-up : Procesar");
        Utils.desenmarcarObjeto(driver, btnAceptar);
        btnAceptar.click();
//        driver.switchTo().defaultContent();
    }

    @Then("nos debe de mostras la vista de Movimientos con los productos modificados")
    public void nosDebeDeMostrasLaVistaDeMovimientosConLosProductosModificados() throws IOException, InterruptedException {
    Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement movimientos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("span_vMOVITMCNTSTR_0001")));
        Utils.enmarcarElemento(driver, movimientos );
        //takeScreenshot("screenshot_");
        tomarCaptura("Vista Movimientos");
        esperarElementoYMedirTiempo(By.id("span_vMOVITMCNTSTR_0001"),"Vista Movimientos");
        Utils.desenmarcarObjeto(driver, movimientos);

       BaseTest.cerrarDriver();
    }

    public static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(101) + 300; // Genera un número entre 100 y 200
    }



}
