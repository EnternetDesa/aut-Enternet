package definitions.menuDef;

import definitions.Commons.BaseTest;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.awt.*;

import java.io.InputStream;
import java.util.Map;

import static definitions.Commons.BaseTest.cerrarDriver;
import static page.loginPage.PosPage.*;
import static page.menuPage.FiadoPage.seleccionarMenuFiado;

public class FiadoDef {
    WebDriver driver = BaseTest.getDriver();
    public static Map<String, String> datosPOS;

    @Given("que ingreso los datos desde el archivo datosFiado {string}")
    public void queIngresoLosDatosDesdeElArchivoDatosFiado(String arg0) {

        try {
            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosFiado.json");
            if (is == null) {
                throw new RuntimeException("❌ Archivo datosFiado.json no encontrado en resources.");
            }
            ObjectMapper mapper = new ObjectMapper();
            datosPOS = mapper.readValue(is, new TypeReference<>() {});
            System.out.println("✅ datosPOS cargado correctamente.");
        } catch (Exception e) {
            System.err.println(STR."❌ Error al cargar datosPOS: \{e.getMessage()}");
            datosPOS = null; // evitar estado inconsistente
        }
    }


    @And("hacemos click en menu izquierdo y en la opcion fiado")
    public void hacemosClickEnMenuIzquierdoYEnLaOpcionFiado() throws InterruptedException {
        seleccionarMenuFiado();
    }
}
