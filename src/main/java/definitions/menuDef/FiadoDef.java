package definitions.menuDef;

import Utils.Commons.BaseTest;
import Utils.Commons.DatosGlobales;
import io.cucumber.java.en.And;

import java.io.File;
import java.util.Map;

import static Utils.Commons.BaseTest.*;
import static page.menuPage.FiadoPage.*;
import static page.menuPage.PromocionesPage.buscarYEnmarcarPromocion;


public class FiadoDef {

    public static Map<String, String> datosFiado;

    @And("hacemos click en menu izquierdo y en la opcion fiado")
    public void hacemosClickEnMenuIzquierdoYEnLaOpcionFiado() throws InterruptedException {
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
    public void validamosQueSeHayaCreadoCorrectamente() throws InterruptedException {

        String nombreClienteFiado = DatosGlobales.datos.get("rutCliente"); //
        boolean encontrada = buscarYEnmarcarClienteFiado(nombreClienteFiado);

        if (encontrada) {
            System.out.println("✅ El cliente fue encontrado correctamente.");
        } else {
            System.out.println("❌ El cliente no fue encontrado.");
        }

        tomarCaptura("Promocion creada");

    }

    @And("hacemos click en menu opcion modulo de ventas")
    public void hacemosClickEnMenuOpcionModuloDeVentas() throws InterruptedException {
        ingresarModuloVEntas();
       // cerrarDriver();
    }

    @And("seleccionamos boton descargar cliente y luego exportar")
    public void seleccionamosBotonDescargarClienteYLuegoExportar() throws InterruptedException {
        clickDescargarTablaYExportar();
        //cerrarDriver();

    }

    @And("abrimos el documento")
    public void abrimosElDocumento() throws Exception {

//        String carpetaDescargas = "C:/Users/alexi/Downloads";
//        String prefijo = "ExportWWClienteFiado";
//
//        File archivo = buscarArchivoPorPrefijo(carpetaDescargas, prefijo);
//
//        if (archivo != null) {
//            System.out.println("✅ Archivo encontrado: " + archivo.getAbsolutePath());
//            // Puedes abrirlo
//            abrirArchivo(archivo);
//        }
        String carpetaDescargas = "C:/Users/alexi/Downloads";
        String prefijo = "ExportWWClienteFiado";

        File archivo = buscarArchivoPorPrefijo(carpetaDescargas, prefijo);

        if (archivo != null) {
            System.out.println("✅ Archivo encontrado: " + archivo.getAbsolutePath());

            // Abrir el archivo
            abrirArchivo(archivo);

            // Esperar unos segundos para asegurarse que el archivo está abierto en pantalla
            Thread.sleep(3000);

            // Tomar captura
            String nombreCaptura = "Captura_" + archivo.getName();
            String rutaCaptura = tomarCapturaPantalla(nombreCaptura);

            // Registrar captura si se generó correctamente
            if (rutaCaptura != null) {
              //  BaseTest.capturasPendientes.get().add(rutaCaptura);
                agregarCapturaAlReporte("C:/git/aut-Enternet/reportes/capturas/");
            } else {
                System.out.println("⚠ No se pudo tomar la captura del archivo abierto.");
            }
        } else {
            System.out.println("❌ No se encontró un archivo que comience con: " + prefijo);
        }

        cerrarDriver();

    }

    @And("seleccionamos el cliente que queremos editar")
    public void seleccionamosElClienteQueQueremosEditar() throws InterruptedException {
        clickBtnEditar();
    }
}
