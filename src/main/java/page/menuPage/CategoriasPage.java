package page.menuPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriasPage {

    public static Object switchIframe;
    private WebDriver driver;
    //   Utils utils = new Utils();


    //button[(@class='bci-wk-btn bci-wk-btn--tertiary')and contains(text (), 'Descargar')]
    @FindBy(xpath = "//input[@name='_SRUT']")
    public WebElement txtUsuario;
}
