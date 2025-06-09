package page.loginPage;

import Utils.Commons.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuInventarioPage {
    public static Object switchIframe;
    public static WebDriver driver;
  //  WebDriver driver = new ChromeDriver();
    //menu - submenu
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/a")
    public WebElement btnMovimientos;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/a")
    public WebElement btnProcesos;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/a")
    public WebElement btnReportes;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/a")
    public WebElement btnDefiniciones;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/a")
    public WebElement btnconfiguracion;

    //Submenu - Movimientos
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[1]/a")
    public WebElement btnIngresarRecepcion;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a")
    public WebElement btnSalidaInventario;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[3]/a")
    public WebElement btnMermasAltasTraslados;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[4]/a")
    public WebElement btnListarMovimientos;

    //Submenu - Procesos
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[1]/a")
    public WebElement btnTansAplicadas;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[2]/a")
    public WebElement btnTomInventario;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[3]/ul/li[3]/a")
    public WebElement btnTomaSimplificada;

    //Submenu - Reportes
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[4]/ul/li/a")
    public WebElement btnReporteMargen;

    //Submenu - Definiciones
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[1]/a")
    public WebElement btnItems;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[2]/a")
    public WebElement btnProveedores;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[3]/a")
    public WebElement btnTransformaciones;
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[4]/a")
    public WebElement btnLotes;
    @FindBy(xpath ="//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[5]/ul/li[5]/a")
    public WebElement ReglasStockCritico;

    //Submenu - Configuracion
    @FindBy(xpath = "//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[6]/ul/li[2]/a")
    public WebElement btnCategorias;

    public void seleccionarProcesos(String menu) throws InterruptedException {

        switch (menu) {
            case "Movimientos":
                switchIframe = btnMovimientos;
                Utils.enmarcarElemento(driver, btnMovimientos );

                System.out.println("Se selecciono el menu de Movimientos");
                break;
            case "Procesos":
                switchIframe = btnProcesos;
                Utils.enmarcarElemento(driver, btnProcesos );

                System.out.println("Se selecciono el menu de Procesos");
                break;
            case "Reportes":
                switchIframe = btnReportes;
                Utils.enmarcarElemento(driver, btnReportes );
                System.out.println("Se selecciono el menu de Reportes");
                break;
            case "Definiciones":
                switchIframe = btnDefiniciones;
                Utils.enmarcarElemento(driver, btnDefiniciones );

                System.out.println("Se selecciono el menu de Definiciones");
                break;
            case "Configuracion":
                switchIframe = btnconfiguracion;
                Utils.enmarcarElemento(driver, btnconfiguracion );
                btnconfiguracion.click();
                System.out.println("Se selecciono el menu de Configuracion");
                break;
            default:
                System.out.println("prueba");

        }
    }

    public void seleccionarSubMenuMovimientos(String subMenuM){
        switch (subMenuM){
            case "Ingresar recepcion":
             //   switchIframe = btnIngresarRecepcion;
                Utils.enmarcarElemento(driver, btnIngresarRecepcion );
                btnIngresarRecepcion.click();
                System.out.println("Ingresar recepcion");
                break;
            case "Salidas de Inventario":
                System.out.println("Salidas de inventario");
               // EsperaElemento.enmarcarElemento(driver, btnrecepcion );
//                switchIframe = btnSalidaInventario;
                WebElement btnSalidaInventario = driver.findElement(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a"));

                //EsperaElemento.enmarcarElemento(driver, btnSalidaInventario );
                btnSalidaInventario.click();


                //esperarElementoVisible(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a"), 30);
//                WebElement btnrecepcion = driver.findElement(By.xpath("//*[@id=\"SECTION1_MPAGE\"]/div[1]/div/div[1]/nav/ul/li[2]/ul/li[2]/a"));
//                System.out.println("➡ Selecciono Ingresar recepcion  ");
//
//                btnrecepcion.click();
                break;
            case "Mermas Altas y Traslados":
                switchIframe = btnMermasAltasTraslados;
                Utils.enmarcarElemento(driver, btnMermasAltasTraslados );
                btnMermasAltasTraslados.click();
                System.out.println("Mermas, Altas y Traslados");
                break;
            case "Listar Movimientos":
                switchIframe = btnListarMovimientos;
                Utils.enmarcarElemento(driver, btnListarMovimientos );
                btnListarMovimientos.click();
                System.out.println("Listar Movimientos");
                break;
            default:
                System.out.println("prueba");
        }
    }
    public void seleccionarSubMenuProcesos(String subMenuP){
        switch (subMenuP){
            case "Transformaciones aplicadas ":
                switchIframe = btnTansAplicadas;
                System.out.println("Transformaciones aplicadas");
                break;
            case "Toma de inventario":
                switchIframe = btnTomInventario;
                System.out.println("Toma de inventario");
                break;
            case "Toma Simplificada":
                switchIframe = btnTomaSimplificada;
                System.out.println("Toma Simplificada");
                break;
            default:
                System.out.println("prueba");
        }
    }
    public void seleccionarSubMenuReportes(String subMenuR){
        switch (subMenuR){
            case "Reporte de Margen ":
                switchIframe = btnReporteMargen;
                System.out.println("Reporte de Margen");
                break;
            default:
                System.out.println("prueba");
        }
    }
    public void seleccionarSubMenuDefiniciones(String subMenuD){
        switch (subMenuD){
            case "Items ":
                switchIframe = btnItems;
                System.out.println("Items");
                break;
            case "Proveedores":
                switchIframe = btnProveedores;
                System.out.println("Proveedores");
                break;
            case "Transformaciones":
                switchIframe = btnTomaSimplificada;
                System.out.println("Transformaciones");
                break;
            case "Lotes":
                switchIframe = btnTomaSimplificada;
                System.out.println("Lotes");
                break;
            case "Reglas de Stock criticos":
                switchIframe = btnTomaSimplificada;
                System.out.println("Reglas de stock criticos");
                break;
            default:
                System.out.println("prueba");
        }
    }
    public void seleccionarSubMenuConfiguracion(String subMenuC){
        switch (subMenuC){
            case "Categorias ":
                switchIframe = btnCategorias;
                System.out.println("Categorias");
                break;
            default:
                System.out.println("prueba");
        }
    }
    public void switchToFrames(){
        driver.get("http://webapp.enternet.cl");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1250)");
        driver.switchTo().frame(2);
        driver.findElement(By.xpath("//*[@id=\"span_UBICOD_0002\"]/a")).click();
    }
    public void switchToInformationAlert() throws Exception{
        driver.findElement(By.xpath("//*[@id=\"span_UBICOD_0002\"]/a")).click();
      //  WebDriverWait wait = new WebDriverWait(driver,5);
      //  wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    public boolean esperarElementoVisible(By locator, int tiempoEsperaSegundos) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaSegundos));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("✅ Elemento encontrado: " + locator);
            return true;
        } catch (TimeoutException e) {
            System.out.println("⏳ Tiempo de espera agotado. Elemento NO encontrado: " + locator);
            return false;
        }
    }


}
