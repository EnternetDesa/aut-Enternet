package definitions.menuDef;

import definitions.Commons.BaseTest;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

import static definitions.Commons.BaseTest.cerrarDriver;
import static page.menuPage.PromocionesPage.*;

public class PromocionesDef {

    public static Map<String, String> datosPromociones;



    @Given("que ingreso los datos desde el archivo datosPromociones {string}")
    public void queIngresoLosDatosDesdeElArchivoDatosPromociones(String arg0) {
        try {
            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosPromociones.json");
            if (is == null) {
                throw new RuntimeException("❌ Archivo datosPromociones.json no encontrado en resources.");
            }
            ObjectMapper mapper = new ObjectMapper();
            datosPromociones = mapper.readValue(is, new TypeReference<>() {});
            System.out.println("✅ datosPromociones cargado correctamente.");
        } catch (Exception e) {
            System.err.println(STR."❌ Error al cargar datosPromociones: \{e.getMessage()}");
            datosPromociones = null; // evitar estado inconsistente
        }
    }
    @And("debe de mostrar la vista del Administrador de Promociones")
    public void debeDeMostrarLaVistaDelAdministradorDePromociones() throws IOException, InterruptedException {
        visualizarHomePromociones();
    }

    @And("selecciono el nombre de la empresa")
    public void seleccionoElNombreDeLaEmpresa() throws InterruptedException {
        seleccionEmpresa(datosPromociones.get("nombEmp"));
    }

    @And("nos debe dirigir a la vista de promociones")
    public void nosDebeDirigirALaVistaDePromociones() throws InterruptedException {
        validarVistaPromociones();
    }

    @And("seleccionamos el icono con el signo mas")
    public void seleccionamosElIconoConElSignoMas() throws InterruptedException {
        seleccionarNuevaPromo();
    }

    @And("nos debe mostrar la vista de vigencia e ingreso el nombre de la promocion <{string}>")
    public void nosDebeMostrarLaVistaDeVigenciaEIngresoElNombreDeLaPromocion(String fechaInicio) throws InterruptedException {
        ingresarNombrePromocion();
        fechaInicio = datosPromociones.get("fechaInicio");
        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);
    }

    @And("agregamos fecha de inicio <{string}>")
    public void agregamosFechaDeInicio(String fechaFin) throws InterruptedException {
        ingresoFechaFin();
        fechaFin = datosPromociones.get("fechaFin");
        escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);
    }

    @And("agregamos si la promocion se canjea en un horario determinado")
    public void agregamosSiLaPromocionSeCanjeaEnUnHorarioDeterminado() throws InterruptedException {
        seleccionarSiLaPromocionSeCanjeaEnHorarioDeterminado();
    }

    @And("agregamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no")
    public void agregamosSiDeseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromocionONo() throws InterruptedException {
        deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo();
    }

    @And("seleccionamos el boton siguiente")
    public void seleccionamosElBotonSiguiente() throws InterruptedException {
        seleccionarBtnSiguiente();
    }

    @And("ingresamos una ubicacion ,en caso de no ingresar la promocion aplicara para todas las ubicaciones")
    public void ingresamosUnaUbicacionEnCasoDeNoIngresarLaPromocionAplicaraParaTodasLasUbicaciones() throws InterruptedException {
      seleccionarUbicacionesParaCanje(Arrays.asList("POSONLINE", "TRAUCO"));
    }

    @And("en la vista de restriccion agregamos una seleccionando el boton mas")
    public void enLaVistaDeRestriccionAgregamosUnaSeleccionandoElBotonMas() {
        seleccionarSignoMas();

    }

    @And("ingresamos nombre de restriccion")
    public void ingresamosNombreDeRestriccion() throws InterruptedException {
        ingresarNombreRestriccion();
    }

    @And("ingresar cantidad minima de productos a llevar")
    public void ingresarCantidadMinimaDeProductosALlevar() {
        ingresarCantidadMinDeProductosALlevar();
    }

    @And("seleccionamos la categoria de la promocion <{string}>")
    public void seleccionamosLaCategoriaDeLaPromocion(String args0) throws InterruptedException {
        seleccionarCategorias(Arrays.asList("Bebidas", "Jugos"));
    }

    @And("seleccionamos el producto de la promocion por descripcion <{string}> o codigo <{string}>")
    public void seleccionamosElProductoDeLaPromocionPorDescripcionOCodigo(String criteria, String value) {

        seleccionarProductos( "description", datosPromociones.get("descProducto"));
    }
    @And("guardamos los cambios")
    public void guardamosLosCambios() throws InterruptedException {
        seleccionarBotonGuardar();
    }

    @And("agregamos el tipo de regla de la restriccion")
    public void agregamosElTipoDeReglaDeLaRestriccion() throws InterruptedException {
        seleccionarReglaDePromocion("Monto fijo", 200);

    }

    @And("ingresamos el tipo de descuento que tendra la promocion")
    public void ingresamosElTipoDeDescuentoQueTendraLaPromocion() {
    }

    @And("seleccionamos el tipo de regla , el tipo de descuento que tendra la promocion")
    public void seleccionamosElTipoDeReglaElTipoDeDescuentoQueTendraLaPromocion() {
    }

    @And("visualizamos el resumen de nuestra promocion")
    public void visualizamosElResumenDeNuestraPromocion() {
    }

    @And("validamos que sean los datos ingresados anteriormente")
    public void validamosQueSeanLosDatosIngresadosAnteriormente() {
        String horaIni = datosPromociones.get("validaDesde");
        String horaFin = datosPromociones.get("validaHasta");
        String restriccion = datosPromociones.get("tipoDeRestriccion");
        String descProducto = datosPromociones.get("descProducto");

        validacionDeDatos(
                "paPicar",
                horaIni,
                horaFin,
                horaIni+ "-" + horaFin,
                "Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo, Festivo, Víspera de festivo",
                "Lo promoción descontará 20 % del menor precio de la restricción prepack .",
                restriccion, descProducto
        );
    }

    @And("seleccionamos el boton finalizar")
    public void seleccionamosElBotonFinalizar() throws InterruptedException {
        seleccionarBtnFinalizar();
    }

    @Then("nos debe dirigir a la pantalla primcipal y visualizar nuestra promocion")
    public void nosDebeDirigirALaPantallaPrimcipalYVisualizarNuestraPromocion() {
        cerrarDriver();
    }



}
