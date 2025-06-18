package definitions.menuDef;

import Utils.Commons.Utils;
import definitions.loginDef.LoginDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.loginPage.MenuInventarioPage;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Map;

public class SalidaDeInventarioDef {

    WebDriver driver;
    LoginDef loginDef= new LoginDef();
    MenuInventarioPage menuInventarioPage= new MenuInventarioPage();
    private Map<String, String> datos;


    @When("este en la vista de salida de inventario y haga click en el icono crear")
    public void esteEnLaVistaDeSalidaDeInventarioYHagaClickEnElIconoCrear() {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.mouseMove(790, 630);
            // LEFT CLICK
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
//        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"ICONCREAR\"]"), "Icono crear");

        loginDef.esperarElementoVisible(By.xpath("//*[@id=\"ICONCREAR\"]"),10);
        WebElement btnCrear = driver.findElement(By.xpath("//*[@id=\"ICONCREAR\"]"));
        Utils.esperar(driver,btnCrear, 10);
        Utils.enmarcarElemento(driver, btnCrear );
        btnCrear.click();

    }

    @And("aparece la vista de nuevo movimiento de salida")
    public void apareceLaVistaDeNuevoMovimientoDeSalida() {
        loginDef.esperarElementoVisible(By.xpath("//*[@id=\"UBICODORI\"]"),10);
        WebElement txtubOrigen = driver.findElement(By.xpath("//*[@id=\"UBICODORI\"]"));
        Utils.esperar(driver,txtubOrigen, 10);
        Utils.enmarcarElemento(driver, txtubOrigen );
        txtubOrigen.sendKeys(datos.get("ubOrigen"));
    }

    @And("ingresamos los datos de ubicacion de origen {string}")
    public void ingresamosLosDatosDeUbicacionDeOrigen(String arg0) {
        loginDef.esperarElementoVisible(By.xpath("//*[@id=\"W0083vINITEMINVCODIGO\"]"),10);
        WebElement txtcodItems = driver.findElement(By.xpath("//*[@id=\"W0083vINITEMINVCODIGO\"]"));
        Utils.esperar(driver,txtcodItems, 10);
        Utils.enmarcarElemento(driver, txtcodItems );
        txtcodItems.sendKeys(datos.get("codItems"));
    }

    @And("ingresamos los datos de codigo items {string}")
    public void ingresamosLosDatosDeCodigoItems(String arg0) {

        Actions actions = new Actions(driver);
        loginDef.esperarElementoVisible(By.xpath("//*[@id=\"W0083vCANTIDAD\"]"),10);
        WebElement txtcantProd = driver.findElement(By.xpath("//*[@id=\"W0083vCANTIDAD\"]"));
        Utils.esperar(driver,txtcantProd, 10);
        Utils.enmarcarElemento(driver, txtcantProd);
        txtcantProd.clear();
        txtcantProd.sendKeys(datos.get("cantProd"));

        actions.sendKeys(datos.get("cantProd"), Keys.RETURN).perform();

        actions.sendKeys(txtcantProd, Keys.RETURN).perform();
    }

    @And("ingresamos los datos de cantidad {string} y darle enter")
    public void ingresamosLosDatosDeCantidadYDarleEnter(String arg0) {
        loginDef.esperarElementoVisible(By.xpath("//*[@id=\"W0083vCANTIDAD\"]"),10);
        WebElement txtcantProd = driver.findElement(By.xpath("//*[@id=\"W0083vCANTIDAD\"]"));
        Utils.esperar(driver,txtcantProd, 10);
        Utils.enmarcarElemento(driver, txtcantProd);

    }

    @And("darle enter nos debe cargar en la tabla el items agregado anteriormente")
    public void darleEnterNosDebeCargarEnLaTablaElItemsAgregadoAnteriormente() {
    }

    @And("luego seleccionamos el boton seleccionar contraparte")
    public void luegoSeleccionamosElBotonSeleccionarContraparte() {
    }

    @And("seleccionamos el receptor")
    public void seleccionamosElReceptor() {
    }

    @And("luego ingresamos nuevamente la ubicacion {string}")
    public void luegoIngresamosNuevamenteLaUbicacion(String arg0) {
    }

    @And("ingresamos los datos de cantidad {string} y presionamos enter")
    public void ingresamosLosDatosDeCantidadYPresionamosEnter(String arg0) {
    }

//    @And("seleccionamos confirmar")
//    public void seleccionamosConfirmar() {
//    }

    @And("luego nos mostrara la vista de Datos adicionales Receptor Guia")
    public void luegoNosMostraraLaVistaDeDatosAdicionalesReceptorGuia() {
    }

    @And("ingresamos direccion de receptor {string}")
    public void ingresamosDireccionDeReceptor(String arg0) {
    }

    @And("ingresamos comuna de receptor {string}")
    public void ingresamosComunaDeReceptor(String arg0) {
    }

    @And("ingresamos giro receptor {string}")
    public void ingresamosGiroReceptor(String arg0) {
    }

    @And("seleccionamos confirmar nuevamente")
    public void seleccionamosConfirmarNuevamente() {
//        utils.EsperaElemento espera = new utils.EsperaElemento(driver);

// Esperar hasta 10 segundos por un botón con ID "btnInicio"
//        boolean elementoPresente = espera.esperarElementoVisible(By.id("btnInicio"), 10);
//        if (elementoPresente) {
//            driver.findElement(By.id("btnInicio")).click();
//        }
    }

}
