package page.menuPage;

import definitions.Commons.BaseTest;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import definitions.Commons.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.awt.Toolkit;
import java.awt.Robot;

import static definitions.Commons.BaseTest.*;


public class FiadoPage {
    public static WebDriver driver = BaseTest.getDriver();

    public static void cerrarMsjAlerta()  {
       // driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//div/div[2]"), "cerrar mensaje de alerta");
        WebElement btnCerrarMsjAlerta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[2]")));
        Utils.enmarcarElemento(driver, btnCerrarMsjAlerta);
        Utils.desenmarcarObjeto(driver, btnCerrarMsjAlerta);
        btnCerrarMsjAlerta.click();
        //driver.switchTo().defaultContent();
    }

    public static void seleccionarMenuFiado() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"MENUTOGGLE_MPAGE\"]"), "menu izquierdo");
        WebElement btnMenuAndesPos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MENUTOGGLE_MPAGE\"]")));
        btnMenuAndesPos.click();
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[8]/a/div/span"), "Seleccion Fiado");
        WebElement linkFiado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[8]/a/div/span")));
        Utils.enmarcarElemento(driver, linkFiado);
        tomarCaptura("Seleccion Fiado");
       // esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[8]/a"), "Seleccion Fiado");
        Utils.desenmarcarObjeto(driver, linkFiado);
        linkFiado.click();
    }
    public static void clickBtnAgregarCliente() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"AGREGARCLIENTE\"]"), "Btn agregar cliente");
        WebElement btnAgregarCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AGREGARCLIENTE\"]")));
        Utils.enmarcarElemento(driver, btnAgregarCliente);
        Utils.desenmarcarObjeto(driver, btnAgregarCliente);
        tomarCaptura("Vista clientes");
        btnAgregarCliente.click();
    }
    public static void ingresarRutCliente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vCLIENTEFIADORUT\"]"), "rut cliente");
        WebElement txtRutCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vCLIENTEFIADORUT\"]")));
        Utils.enmarcarElemento(driver, txtRutCliente);
        Utils.desenmarcarObjeto(driver, txtRutCliente);
        txtRutCliente.clear();
        txtRutCliente.sendKeys((CharSequence) datosFiado.get("rutCliente"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txtRutCliente);
    }
    public static void clickBtnConfirmar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"CONFIRMAR\"]"), "click confirmar");
        WebElement btnConfirmar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CONFIRMAR\"]")));
        Utils.enmarcarElemento(driver, btnConfirmar);
        Utils.desenmarcarObjeto(driver, btnConfirmar);
       // tomarCaptura("click confirmar");
        btnConfirmar.click();
    }
    public static void clickAceptarPopUp() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]"), "Pop-Up");
        WebElement btnAceptarPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2BT_CONFIRMDIALOGContainer\"]/div/div/div/div/input[1]")));
        Utils.enmarcarElemento(driver, btnAceptarPopUp);
        Utils.desenmarcarObjeto(driver, btnAceptarPopUp);
        tomarCaptura("Aceptar pop-up");
        btnAceptarPopUp.click();

    }
    public static void ingresarCreditoParaElFiado()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0036W0024CLIENTEFIADOCREDITO\"]"), "ingrese monto credito");
        WebElement txtRutCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0036W0024CLIENTEFIADOCREDITO\"]")));
        Utils.enmarcarElemento(driver, txtRutCliente);
        Utils.desenmarcarObjeto(driver, txtRutCliente);
        txtRutCliente.clear();
        txtRutCliente.sendKeys(String.valueOf(datosFiado.get("montoCredito")));
    }
    public static void seleccionarBtnActualizar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0036W0024ENTER\"]"), "btn actualizar");
        WebElement btnActualizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0036W0024ENTER\"]")));
        Utils.enmarcarElemento(driver, btnActualizar);
        Utils.desenmarcarObjeto(driver, btnActualizar);
        tomarCaptura("btn actualizar");
        btnActualizar.click();
    }
    public static void seleccionarEstado(){
        String valorEstado = String.valueOf(datosFiado.get("estado")).trim();
        try {
            WebElement selectEstado = driver.findElement(By.xpath("//select[contains(@id, 'W0036W0024CLIENTEFIADOESTADO')]"));
            Select dropdown = new Select(selectEstado);

            // Verificar si el valor existe entre las opciones
            boolean existe = dropdown.getOptions().stream()
                    .anyMatch(option -> option.getText().equalsIgnoreCase(valorEstado));

            if (existe) {
                dropdown.selectByVisibleText(valorEstado);
                System.out.println("✅ Estado seleccionado: " + valorEstado);
            } else {
                System.err.println("❌ El valor '" + valorEstado + "' no está en el desplegable.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al seleccionar el estado: " + e.getMessage());
        }
    }
    public static void clickBtnVolver() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"VOLVER\"]"), "btn volver");
        WebElement btnActualizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VOLVER\"]")));
        Utils.enmarcarElemento(driver, btnActualizar);
        Utils.desenmarcarObjeto(driver, btnActualizar);
        tomarCaptura("btn volver");
        btnActualizar.click();
    }
    public static void validarDatosIngresados(String nombreCliente, String fechaInicio, String fechaFin, String horario, String dias, String descuento, String restriccion, String productos) {
        try {
            System.out.println("[INFO] Iniciando validación de datos de la promoción.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Validar nombre de la promoción
            WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Nombre')]/following-sibling::div")));
            System.out.println("[INFO] Nombre: " + nombre.getText());
            validarTexto(nombre.getText(), nombreCliente, "Nombre Cliente");

            // Validar fechas de la promoción
            WebElement fechas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Promoción válida')]/following-sibling::div")));
            System.out.println("[INFO] Fechas: " + fechas.getText());
            validarTexto(fechas.getText(), fechaInicio + " - " + fechaFin, "Fechas de la promoción");

            // Validar horario de canje
            WebElement horarioCanje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Horario de canje')]/following-sibling::div")));
            System.out.println("[INFO] Horario: " + horarioCanje.getText());
            validarTexto(horarioCanje.getText(), horario, "Horario de canje");

            // Validar días de canje
            WebElement diasCanje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Días de canje')]/following-sibling::div")));
            System.out.println("[INFO] Días: " + diasCanje.getText());
            validarTexto(diasCanje.getText(), dias, "Días de canje");

            // Validar descuento a realizar
            WebElement descuentoRealizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Descuento a realizar')]/following-sibling::div")));
            System.out.println("[INFO] Descuento: " + descuentoRealizar.getText());
            validarTexto(descuentoRealizar.getText(), descuento, "Descuento a realizar");

            // Validar nombre de la restricción
            WebElement nombreRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[1]")));
            System.out.println("[INFO] Restricción: " + nombreRestriccion.getText());
            validarTexto(nombreRestriccion.getText(), restriccion, "Restricción");

            // Validar productos de la restricción
            WebElement productosRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[3]")));
            System.out.println("[INFO] Productos: " + productosRestriccion.getText());
            validarTexto(productosRestriccion.getText(), productos, "Productos");

            System.out.println("[INFO] Validación de datos de la promoción completada.");

        } catch (Exception e) {
            System.err.println("[ERROR] Error validando datos de la promoción: " + e.getMessage());
        }
    }
    // Metodo para comparar texto y mostrar si coinciden o no
    private static void validarTexto(String textoActual, String textoEsperado, String campo) {
        if (textoActual.trim().equalsIgnoreCase(textoEsperado.trim())) {
            System.out.println("[SUCCESS] El " + campo + " es correcto: " + textoActual);
        } else {
            System.err.println("[FAIL] El " + campo + " es incorrecto. Esperado: '" + textoEsperado + "', Actual: '" + textoActual + "'");
        }
    }
    public static void ingresarModuloVEntas() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //*[@id="MENUTOGGLE_MPAGE"]
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"MENUTOGGLE_MPAGE\"]"), "menu izquierdo");
        WebElement btnMenuAndesPos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MENUTOGGLE_MPAGE\"]")));
        btnMenuAndesPos.click();
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[2]/a"), "Seleccion Modulo de Ventas");
        WebElement linkVentas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[2]/a")));
        Utils.enmarcarElemento(driver, linkVentas);
        tomarCaptura("Seleccion Modulo de Ventas");
        // esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[8]/a"), "Seleccion Fiado");
        Utils.desenmarcarObjeto(driver, linkVentas);
        linkVentas.click();
    }
    public static void clickDescargarTablaYExportar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //*[@id="MENUTOGGLE_MPAGE"]
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"IMAGE1\"]"), "Descarga");
        WebElement btnDescarga = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"IMAGE1\"]")));
        btnDescarga.click();
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"EXPORT\"]"), "Exportar");
        WebElement linkExportar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"EXPORT\"]")));
        Utils.enmarcarElemento(driver, linkExportar);
        tomarCaptura("Exportar");
        // esperarElementoYMedirTiempo(By.xpath("//*[@id=\"K2baccordionmenu\"]/li[8]/a"), "Seleccion Fiado");
        Utils.desenmarcarObjeto(driver, linkExportar);
        linkExportar.click();
    }

//    public static void abrirArchivoYTomarCaptura() {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Selecciona un archivo para abrir");
//
//        int seleccion = fileChooser.showOpenDialog(null);
//
//        if (seleccion == JFileChooser.APPROVE_OPTION) {
////            File archivoSeleccionado = fileChooser.getSelectedFile();
//            File archivoSeleccionado = new File("C:\\Users\\alexi\\Downloads\\ExportWWClienteFiado-0140e025-f270-46e4-be6c-cace9a72d795.xlsx");
//            if (archivoSeleccionado.exists()) {
//                try {
//                    // Abre el archivo con la app predeterminada
//                    Desktop.getDesktop().open(archivoSeleccionado);
//                    System.out.println("✅ Archivo abierto: " + archivoSeleccionado.getAbsolutePath());
//
//                    // Espera a que se abra la app
//                    Thread.sleep(3000);
//
//                    // Captura de pantalla
//                    Robot robot = new Robot();
//                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//                    Rectangle screenRect = new Rectangle(screenSize);
//                    BufferedImage captura = robot.createScreenCapture(screenRect);
//
//                    // Guardar la imagen
//                    String rutaCaptura = "captura_pantalla.png";
//                    ImageIO.write(captura, "png", new File(rutaCaptura));
//                    System.out.println("📸 Captura guardada como: " + rutaCaptura);
//
//                } catch (IOException | InterruptedException | AWTException e) {
//                    System.err.println("❌ Error: " + e.getMessage());
//                    e.printStackTrace();
//                }
//            } else {
//                System.err.println("❌ El archivo no existe.");
//            }
//        } else {
//            System.out.println("ℹ️ Selección cancelada por el usuario.");
//        }
//    }


}
