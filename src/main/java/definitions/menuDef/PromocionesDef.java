package definitions.menuDef;

import definitions.Commons.BaseTest;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static definitions.Commons.BaseTest.*;
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
    public void nosDebeMostrarLaVistaDeVigenciaEIngresoElNombreDeLaPromocion(String args0) throws InterruptedException {
        ingresarNombrePromocion();
    }

    @And("agregamos fecha de inicio <{string}>")
    public void agregamosFechaDeInicio(String fechaInicio, String fechaFin) throws InterruptedException {
        fechaInicio = datosPromociones.get("fechaInicio");
        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);
        ingresoFechaFin();
        fechaFin = datosPromociones.get("fechaFin");
        escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);
    }

    @And("agregamos si la promocion se canjea en un horario determinado o no")
    public void agregamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo() throws InterruptedException {
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
        String restriccion = datosPromociones.get("categoriaRestriccion");
        String restriccion2 = datosPromociones.get("categoriaRestriccion2");
//        seleccionarCategorias(Arrays.asList(restriccion2, restriccion));
        List<String> categorias = Arrays.asList(restriccion, restriccion2, "Bebidas");
        seleccionarCategorias(categorias);
    }

    @And("seleccionamos el producto de la promocion por descripcion <{string}> o codigo <{string}>")
    public void seleccionamosElProductoDeLaPromocionPorDescripcionOCodigo(String criteria, String value) {

        seleccionarProductos( "description", "Aceitunas"); //"Agua Benedictino Gasificada 500 ML, Agua Benedictino Sin Gas 500 ML"
    }
    @And("guardamos los cambios")
    public void guardamosLosCambios() throws InterruptedException {
        seleccionarBotonGuardar();
    }

    @And("agregamos el tipo de regla de la restriccion")
    public void agregamosElTipoDeReglaDeLaRestriccion()  {

    }

    @And("ingresamos el tipo de descuento que tendra la promocion")
    public void ingresamosElTipoDeDescuentoQueTendraLaPromocion() throws InterruptedException {
        seleccionarReglaDePromocion("Monto fijo", 2000);
    }

    @And("visualizamos el resumen de nuestra promocion")
    public void visualizamosElResumenDeNuestraPromocion() {
        // Capturar el mensaje de pantalla
        capturarMensajePantalla("//*[@id=\"span_W0026vDESCUENTOAREALIZAR\"]");



    }

    @And("validamos que sean los datos ingresados anteriormente")
    public void validamosQueSeanLosDatosIngresadosAnteriormente() {
        String fechaInicio = datosPromociones.get("fechaInicio");
        String fechaFin = datosPromociones.get("fechaFin");
       String horaIni = datosPromociones.get("validaDesde");
        String horaFin = datosPromociones.get("validaHasta");
        String restriccion = datosPromociones.get("nombPromo");


        // Usar el mensaje capturado más adelante
        String mensaje = obtenerMensajeCapturado();
      //  System.out.println("[INFO] El mensaje capturado es: " + mensaje);
        validacionDeDatos(
                restriccion,
                fechaInicio,
                fechaFin,
                horaIni+" - "+horaFin,
                "Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo, Festivo, Víspera de festivo",
                mensaje ,
                restriccion,
                "Aceitunas Negras En Rodajas Excelencia 1700 Gr., Aceitunas Rellenas Pimiento Verdes Excelencia 1700 Gr."
        );


    }

    @And("seleccionamos el boton finalizar")
    public void seleccionamosElBotonFinalizar() throws InterruptedException {
        seleccionarBtnFinalizar();
    }

    @Then("nos debe dirigir a la pantalla principal y visualizar nuestra promocion")
    public void nosDebeDirigirALaPantallaPrincipalYVisualizarNuestraPromocion() throws InterruptedException {
      // tomarCaptura("Promociones");
        String nombrePromocion = datosPromociones.get("nombPromo"); // El nombre de la promoción que deseas buscar
        boolean encontrada = buscarYEnmarcarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue encontrada y enmarcada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }

        cerrarDriver();
    }


    @And("editamos una promocion ya existente y modificamos el nombre a la promocion <{string}>")
    public void editamosUnaPromocionYaExistenteYModificamosElNombreALaPromocion(String arg0) {

        String nombrePromocion = datosPromociones.get("nombPromo"); // El nombre de la promoción que deseas buscar
        boolean encontrada = editarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue encontrada y editada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
    }

    @And("editamos con una nueva fecha de inicio <{string}>")
    public void editamosConUnaNuevaFechaDeInicio(String fechaInicio) throws InterruptedException {
        fechaInicio = datosPromociones.get("fechaInicio");
        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);
        ingresoFechaFin();
    }
    @And("editamos si la promocion se canjea en un horario determinado o no")
    public void editamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo() throws InterruptedException {
        agregamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo();

    }

    @And("editamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no")
    public void editamosSiDeseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromocionONo() throws InterruptedException {
       // datosPromociones.put("diasDeCanjePromo", "Si");
       // datosPromociones.put("diasCanje", "Lunes, Miércoles, Viernes");
        deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo();

    }

    @And("editamos la ubicacion ,en caso de no ingresar una la promocion aplicara para todas las ubicaciones")
    public void editamosLaUbicacionEnCasoDeNoIngresarUnaLaPromocionAplicaraParaTodasLasUbicaciones() throws InterruptedException {
        // Si deseas seleccionar ubicaciones específicas
        List<String> ubicaciones = Arrays.asList("RUENDE", "TREHUACO");
        seleccionarUbicacionesParaCanje(ubicaciones);

        // Si no deseas seleccionar ninguna ubicación (desactivarlo)
        //seleccionarUbicacionesParaCanje(null);
        cerrarDriver();
    }

    @And("en la vista de restriccion editamos una agregando otra seleccionando el boton mas")
    public void enLaVistaDeRestriccionEditamosUnaAgregandoOtraSeleccionandoElBotonMas() {
        seleccionarSignoMas();
    }

    @And("Editamos la categoria de la promocion <{string}>")
    public void editamosLaCategoriaDeLaPromocion(String arg0) {
    }

    @And("Editamos el producto de la promocion por descripcion <{string}> o codigo <{string}>")
    public void editamosElProductoDeLaPromocionPorDescripcionOCodigo(String arg0, String arg1) {
    }

    @And("editamos el tipo de descuento que tendra la promocion")
    public void editamosElTipoDeDescuentoQueTendraLaPromocion() {
    }

    @Then("nos debe dirigir a la pantalla principal y visualizar nuestra promocion editada")
    public void nosDebeDirigirALaPantallaPrincipalYVisualizarNuestraPromocionEditada() {
        String nombrePromocion = datosPromociones.get("nombPromoEditado"); // El nombre de la promoción que deseas buscar
        boolean encontrada = buscarYEnmarcarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue editada y encontrada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
    }


}
