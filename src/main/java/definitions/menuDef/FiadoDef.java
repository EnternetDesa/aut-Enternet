package definitions.menuDef;

import io.cucumber.java.en.And;

import java.util.Map;

import static Utils.Commons.BaseTest.cerrarDriver;
import static Utils.Commons.BaseTest.tomarCaptura;
import static page.menuPage.FiadoPage.*;
import static page.menuPage.PromocionesPage.buscarYEnmarcarPromocion;


public class FiadoDef {

    public static Map<String, String> datosFiado;

    @And("hacemos click en menu izquierdo y en la opcion fiado")
    public void hacemosClickEnMenuIzquierdoYEnLaOpcionFiado() throws InterruptedException {
        //cerrarMsjAlerta();
        seleccionarMenuFiado();
    }

    @And("seleccionamos boton agregar cliente")
    public void seleccionamosBotonAgregarCliente() throws InterruptedException {

        clickBtnAgregarCliente();
    }

    @And("ingresamos el rut del cliente {string}")
    public void ingresamosElRutDelCliente(String arg0) {
        ingresarRutCliente();

    }

    @And("seleccionamos el boton confirmar")
    public void seleccionamosElBotonConfirmar() throws InterruptedException {
        clickBtnConfirmar();
    }

    @And("mos mostrara un pop de estas seguro , debemos aceptar")
    public void mosMostraraUnPopDeEstasSeguroDebemosAceptar() throws InterruptedException {
        clickAceptarPopUp();
    }

    @And("en informacion general ingresamos el valor del credito a otorgar {string}")
    public void enInformacionGeneralIngresamosElValorDelCreditoAOtorgar(String arg0)  {
        seleccionarEstado();
        ingresarCreditoParaElFiado();
    }

    @And("seleccionamos el boton actualizar")
    public void seleccionamosElBotonActualizar() throws InterruptedException {
        seleccionarBtnActualizar();
    }

    @And("seleccionar boton volver")
    public void seleccionarBotonVolver() throws InterruptedException {
        clickBtnVolver();
    }

    @And("validamos que se haya creado correctamente")
    public void validamosQueSeHayaCreadoCorrectamente() {

        String nombreClienteFiado = datosFiado.get("rutCliente"); //
        boolean encontrada = buscarYEnmarcarPromocion(nombreClienteFiado);

        if (encontrada) {
            System.out.println("✅ El cliente fue encontrado correctamente.");
        } else {
            System.out.println("❌ El cliente no fue encontrado.");
        }

    }

    @And("hacemos click en menu opcion modulo de ventas")
    public void hacemosClickEnMenuOpcionModuloDeVentas() throws InterruptedException {
        ingresarModuloVEntas();
       // cerrarDriver();
    }

    @And("seleccionamos boton descargar cliente y luego exportar")
    public void seleccionamosBotonDescargarClienteYLuegoExportar() throws InterruptedException {
        clickDescargarTablaYExportar();
        cerrarDriver();

    }

    @And("abrimos el documento")
    public void abrimosElDocumento() throws InterruptedException {
        //abrirArchivoYTomarCaptura();
        Thread.sleep(2000);
        tomarCaptura("excell");
        cerrarDriver();

    }
}
