package page.menuPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class IngresoRecepcionPage {

    public static Object switchIframe;
    private WebDriver driver;
    //   Utils utils = new Utils();



    //button[(@class='bci-wk-btn bci-wk-btn--tertiary')and contains(text (), 'Descargar')]

    @FindBy(xpath = "//*[@id=\"IMPORTARXML\"]")
    public WebElement btnTraerDocumento;
    @FindBy(xpath = "//*[@id=\"CREARRECEPCION\"]")
    public WebElement btnDigitarDocumento;
    @FindBy(xpath = "//*[@id=\"ACTUALIZARSTOCK\"]")
    public WebElement btnActualizarStock;

    //INF DEL DOCUMENTO   /select //*[@id="W0012DOCTIP"]
    @FindBy(xpath = "//*[@id=\"W0012DOCTIP\"]/option[2]")
    public WebElement btnTipoDocumento;
    @FindBy(xpath = "//*[@id=\"W0012DOCFOL\"]")
    public WebElement txtFolio;
    @FindBy(xpath = "//*[@id=\"W0012DOCRUTEMI\"]")
    public WebElement txtRutEmisor;
    @FindBy(xpath = "//*[@id=\"W0012DOCTOTNET\"]")
    public WebElement txtTotalNeto;
    @FindBy(xpath = "//*[@id=\"W0012DOCTOTBRU\"]")
    public WebElement txtTotalBruto;
    @FindBy(xpath = "//*[@id=\"W0012DOCDETCOD_0001\"]")
    public WebElement txtCodigo;
    @FindBy(xpath = "//*[@id=\"W0012DOCDETDES_0001\"]")
    public WebElement txtNombre;
    @FindBy(xpath = "//*[@id=\"W0012DOCDETCNT_0001\"]")
    public WebElement txtCantidad;
    @FindBy(xpath = "//*[@id=\"W0012DOCDETPRC_0001\"]")
    public WebElement txtPrecioNeto;
    @FindBy(xpath = "//*[@id=\"W0012DOCDETTOT_0001\"]")
    public WebElement txtTotal;
    @FindBy(xpath = "//*[@id=\"W0012ENTER\"]")
    public WebElement btnConfirmar;

    @FindBy(xpath = "//*[@id=\"GUARDARREGISTRAR\"]")
            public WebElement btnGuardarYConfirmar;
    WebElement iframeElement = driver.findElement(By.id("gxp0_ifrm"));





    public void seleccionarBtn(String opc)
    {
        switch (opc){
            case "Traer Documento":
                btnTraerDocumento.click();
                break;
                case "Digitar Documento":
                    btnDigitarDocumento.click();
                    break;
                    case "Actualizar Stock":
                        btnActualizarStock.click();
                        break;
                        default:
                            break;
        }
    }

    public void seleccionarTipoDocumento(){
        btnTipoDocumento.click();

    }
    public void ingresarNroFolio(String nroFolio){
        txtFolio.sendKeys(nroFolio);

    }
    public void ingresarRutEmisor(String rutEmisor){
        txtRutEmisor.sendKeys(rutEmisor);
    }
    public void ingresarTotalNeto(String totalNeto){
        txtTotalNeto.sendKeys(totalNeto);
    }
    public void ingresarTotalBruto(String totalBruto){
        txtTotalBruto.sendKeys(totalBruto);
    }
    public void ingresarCodigo(String codigo){
        txtCodigo.sendKeys(codigo);
    }
    public void ingresarNombre(String nombre){
        txtNombre.sendKeys(nombre);
    }
    public void ingresarCantidad(String cantidad){
        txtCantidad.sendKeys(cantidad);
    }
    public void ingresarPrecioNeto(String precioNeto){
        txtPrecioNeto.sendKeys(precioNeto);
    }
    public void ingresarTotal(String total){
        txtTotal.sendKeys(total);
    }
    public void clickBtnConfirmar(){
        btnConfirmar.click();
    }
    public void clickBtnGuardarRegistrar(){
       // btnGuardarRegistrar.click();
        WebDriver driver = new ChromeDriver();
        driver.get("URL");// URL OF WEBPAGE HAVING FRAMES
//First finding the element using any of locator strategy
        WebElement iframeElement = driver.findElement(By.id("gxp0_ifrm"));
//now using the switch command to switch to main frame.
        driver.switchTo().frame(0);
        btnGuardarYConfirmar.click();
//Perform all the required tasks in the frame 0
//Switching back to the main window
        driver.switchTo().defaultContent();
        driver.quit();
    }



}
