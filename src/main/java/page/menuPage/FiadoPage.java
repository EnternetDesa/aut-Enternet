package page.menuPage;

import definitions.Commons.BaseTest;
import org.openqa.selenium.WebDriver;
import definitions.Commons.BaseTest;
import definitions.Commons.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static definitions.Commons.BaseTest.*;
import static definitions.Commons.BaseTest.datosPromociones;

public class FiadoPage {
    static WebDriver driver = BaseTest.getDriver();

    public static void seleccionarMenuFiado() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkFiado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LAYOUTDEFINED_GRID_INNER_GRIDPROMOTION\"]")));
        Utils.enmarcarElemento(driver, linkFiado);
        tomarCaptura("Vista promocion");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"LAYOUTDEFINED_GRID_INNER_GRIDPROMOTION\"]"), "Vista Promociones");
        Utils.desenmarcarObjeto(driver, linkFiado);
    }

}
