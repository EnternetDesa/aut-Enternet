package definitions.menuDef;

import Utils.Commons.DatosGlobales;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.Commons.BaseTest.cerrarDriver;
import static Utils.Commons.BaseTest.tomarCaptura;
import static page.menuPage.PromocionesPage.*;
import static page.menuPage.PromocionesPage.capturarMensajePantalla;
import static page.menuPage.PromocionesPage.validacionDeDatos;

public class PromocionesDef {

    public static Map<String, String> datosPromociones;


//    @Given("que ingreso los datos desde el archivo datosPromociones {string}")
//    public void queIngresoLosDatosDesdeElArchivoDatosPromociones(String arg0) {
//        try {
//            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosPromociones.json");
//            if (is == null) {
//                throw new RuntimeException("❌ Archivo datosPromociones.json no encontrado en resources.");
//            }
//            ObjectMapper mapper = new ObjectMapper();
//            datosPromociones = mapper.readValue(is, new TypeReference<>() {});
//            System.out.println("✅ datosPromociones cargado correctamente.");
//        } catch (Exception e) {
//            System.err.println(STR."❌ Error al cargar datosPromociones: \{e.getMessage()}");
//            datosPromociones = null; // evitar estado inconsistente
//        }
//    }
    @And("debe de mostrar la vista del Administrador de Promociones")
    public void debeDeMostrarLaVistaDelAdministradorDePromociones() throws IOException, InterruptedException {
        visualizarHomePromociones();
    }

    @And("selecciono el nombre de la empresa")
    public void seleccionoElNombreDeLaEmpresa() throws InterruptedException {
        seleccionEmpresa();
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


    @And("agregamos fecha de inicio <{string}> y fecha fin <{string}> si tiene")
    public void agregamosFechaDeInicioYFechaFinSiTiene(String fechaInicio, String fechaFin) throws InterruptedException {
//        fechaInicio = datosPromociones.get("fechaInicio");
//        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);
//
//        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))){
//        ingresoFechaFin();
//        fechaFin = datosPromociones.get("fechaFin");
//        escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);
//        }

        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", DatosGlobales.datos.get("fechaInicio"));

        if ("Si".equalsIgnoreCase(DatosGlobales.datos.get("tieneFechaFin"))) {
            ingresoFechaFin();
            escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", DatosGlobales.datos.get("fechaFin"));
        }
    }

    @And("agregamos si la promocion se canjea en un horario determinado o no")
    public void agregamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo() throws InterruptedException {
        seleccionarSiLaPromocionSeCanjeaEnHorarioDeterminado();
    }

    @And("agregamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no")
    public void agregamosSiDeseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromocionONo() throws InterruptedException {
        Thread.sleep(2000);
        // Configurar los datos de promoción (cambiar según tu contexto)
        Map<String, Object> datosPromociones = new HashMap<>();
        datosPromociones.put("diasDeCanjePromo", datosPromociones.get("diasDeCanjePromo")); // Activar días de canje
        datosPromociones.put("diasCanje", "todos"); // Días específicos

        deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo();
    }

    @And("seleccionamos el boton siguiente")
    public void seleccionamosElBotonSiguiente() throws InterruptedException {
        seleccionarBtnSiguiente();

    }

    @And("ingresamos una ubicacion ,en caso de no ingresar la promocion aplicara para todas las ubicaciones")
    public void ingresamosUnaUbicacionEnCasoDeNoIngresarLaPromocionAplicaraParaTodasLasUbicaciones() throws InterruptedException {

        List<String> ubicaciones = Arrays.asList("POSONLINE","TRAUCO");

            /* Si quieres deseleccionar todo antes de seleccionar nuevas ubicaciones */
            //seleccionarUbicacionesParaCanje(ubicaciones, true);

            // Si NO quieres deseleccionar, solo seleccionar adicionales
             seleccionarUbicacionesParaCanje(ubicaciones, false);

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
        String restriccion = DatosGlobales.datos.get("categoriaRestriccion");
        String restriccion2 = DatosGlobales.datos.get("categoriaRestriccion2");
//        seleccionarCategorias(Arrays.asList(restriccion2, restriccion));
        List<String> categorias = Arrays.asList(restriccion, restriccion2, "Bebidas");
        seleccionarCategorias(categorias);
    }

    @And("seleccionamos el producto de la promocion por descripcion <{string}> o codigo <{string}>")
    public void seleccionamosElProductoDeLaPromocionPorDescripcionOCodigo(String criteria, String value) {
        seleccionarProductos("description", "Aceitunas", 9999);

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
        String nombreRestriccion = DatosGlobales.datos.get("nombreRestriccion");
        seleccionarReglaDePromocion("Monto fijo", nombreRestriccion, 150 );
    }

    @And("visualizamos el resumen de nuestra promocion")
    public void visualizamosElResumenDeNuestraPromocion() {
        // Capturar el mensaje de pantalla
       // String descuento = capturarMensajePantalla("//*[@id=\"span_W0026vDESCUENTOAREALIZAR\"]");
    }

    @And("validamos que sean los datos ingresados anteriormente")
    public void validamosQueSeanLosDatosIngresadosAnteriormente() {

//        String horaIni = datosPromociones.get("validaDesde");
//        String horaFin = datosPromociones.get("validaHasta");
        String nombrePromo = DatosGlobales.datos.get("nombPromo");
        String fechaInicio = DatosGlobales.datos.get("fechaInicio");
        String fechaFin = DatosGlobales.datos.get("fechaFin");
        String horaCanje = capturarMensajePantalla("//*[@id=\"span_W0026vHORARIO\"]");
        String diasCanje = capturarMensajePantalla("//*[@id=\"span_W0026vDIASDECANGE\"]");
        String descuento = capturarMensajePantalla("//*[@id=\"span_W0026vDESCUENTOAREALIZAR\"]");
        String restriccion = capturarMensajePantalla("//*[@id=\"span_W0026vCATEGORIAS_0001\"]");
        String productosRest = capturarMensajePantalla("//*[@id=\"span_W0026vPRODUCTOS_0001\"]");

        validacionDeDatos(
                nombrePromo,
                fechaInicio,
                fechaFin,
                horaCanje,
                diasCanje,
                descuento ,
                restriccion,
                productosRest
        );
    }

    @And("validamos que sean los datos editados anteriormente")
    public void validamosQueSeanLosDatosEditadosAnteriormente() {

        String nombrePromo = DatosGlobales.datos.get("nombPromoEditado");
        String fechaInicio = DatosGlobales.datos.get("fechaInicio");
        String fechaFin = DatosGlobales.datos.get("fechaFin");
        String horaIni = DatosGlobales.datos.get("validaDesde");
        String horaFin = DatosGlobales.datos.get("validaHasta");
        String horaCanje = capturarMensajePantalla("//*[@id=\"span_W0026vHORARIO\"]");
        String diasCanje = capturarMensajePantalla("//*[@id=\"span_W0026vDIASDECANGE\"]");
        String descuento = capturarMensajePantalla("//*[@id=\"span_W0026vDESCUENTOAREALIZAR\"]");
        String restriccion = capturarMensajePantalla("//*[@id=\"span_W0026vCATEGORIAS_0001\"]");
        String productosRest = capturarMensajePantalla("//*[@id=\"span_W0026vPRODUCTOS_0001\"]");

        validacionDeDatos(
                nombrePromo,
                fechaInicio,
                fechaFin,
               // horaCanje,
                horaIni+" - "+horaFin,
                diasCanje,
                descuento ,
                restriccion,
                productosRest
        );

    }

    @And("seleccionamos el boton finalizar")
    public void seleccionamosElBotonFinalizar() throws InterruptedException {
        seleccionarBtnFinalizar();
    }

    @Then("nos debe dirigir a la pantalla principal y visualizar nuestra promocion")
    public void nosDebeDirigirALaPantallaPrincipalYVisualizarNuestraPromocion() throws InterruptedException {
      // tomarCaptura("Promociones");
        Thread.sleep(2000);
        String nombrePromocion = DatosGlobales.datos.get("nombPromo"); // El nombre de la promoción que deseas buscar
        boolean encontrada = buscarYEnmarcarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue encontrada y enmarcada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
        tomarCaptura("Promocion creada");
        cerrarDriver();
    }


    @And("editamos una promocion ya existente y modificamos el nombre a la promocion <{string}>")
    public void editamosUnaPromocionYaExistenteYModificamosElNombreALaPromocion(String arg0) throws InterruptedException {

        String nombrePromocion = DatosGlobales.datos.get("nombPromo");

        System.out.println("[INFO] Buscando la promoción a editar: " + nombrePromocion);
        boolean encontrada = editarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue encontrada y editada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }

        if (DatosGlobales.datos == null || !DatosGlobales.datos.containsKey("nombPromo")) {
            throw new IllegalStateException("❌ No se encontró la clave 'nombPromo' en los datos cargados. Asegúrate de haber cargado los datos correctamente.");
        }

    }

    @And("editamos con una nueva fecha de inicio <{string}>")
    public void editamosConUnaNuevaFechaDeInicio(String fechaInicio) throws InterruptedException {
        fechaInicio = DatosGlobales.datos.get("fechaInicio");
//        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);
//        ingresoFechaFin();

        fechaInicio = DatosGlobales.datos.get("fechaInicio");
        escribirFechaConValorJS("W0026vPROMOVIGENCIAINICIOFECHA", fechaInicio);

        if ("Si".equalsIgnoreCase(String.valueOf(DatosGlobales.datos.get("tieneFechaFin")))){
            ingresoFechaFin();
          String fechaFin = DatosGlobales.datos.get("fechaFin");
            escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);
        }
    }
    @And("editamos si la promocion se canjea en un horario determinado o no")
    public void editamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo() throws InterruptedException {
        agregamosSiLaPromocionSeCanjeaEnUnHorarioDeterminadoONo();

    }

    @And("editamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no")
    public void editamosSiDeseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromocionONo() throws InterruptedException {
        datosPromociones.put("diasDeCanjePromo", "No");
//        datosPromociones.put("diasCanje", "Lunes, Miércoles");
        Map<String, Object> datosPromociones = new HashMap<>();
        datosPromociones.put("diasCanje", "Lunes, Miércoles");

        deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo();

    }

    @And("editamos la ubicacion ,en caso de no ingresar una la promocion aplicara para todas las ubicaciones")
    public void editamosLaUbicacionEnCasoDeNoIngresarUnaLaPromocionAplicaraParaTodasLasUbicaciones() throws InterruptedException {
        // Si deseas seleccionar ubicaciones específicas

        List<String> ubicaciones = Arrays.asList("POSONLINE","TRAUCO");

        try {
            // Si quieres deseleccionar todo antes de seleccionar nuevas ubicaciones
            seleccionarUbicacionesParaCanje(ubicaciones, true);

            // Si NO quieres deseleccionar, solo seleccionar adicionales
            // seleccionarUbicacionesParaCanje(ubicacionesDeseadas, false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @And("Editamos la categoria de la promocion <{string}>")
    public void editamosLaCategoriaDeLaPromocion(String arg0) throws InterruptedException {
        String restriccion = DatosGlobales.datos.get("categoriaRestriccion");
        String restriccion2 = DatosGlobales.datos.get("categoriaRestriccion2");
        List<String> categorias = Arrays.asList(restriccion, restriccion2, "Aguas", "Hielo" );
        seleccionarCategorias(categorias);

    }

    @And("Editamos el producto de la promocion por descripcion <{string}> o codigo <{string}>")
    public void editamosElProductoDeLaPromocionPorDescripcionOCodigo(String arg0, String arg1) {
        //seleccionarProductos( "description", "Aceitunas");
        // Seleccionar hasta 3 productos que coincidan con la descripción "Chocolate"
        //  seleccionarProductos("description", "Chocolate", 3);

        // Seleccionar hasta 5 productos que coincidan con el código "12345"
        //    seleccionarProductos("code", "12345", 5);

        // Seleccionar todos los productos que coincidan con la descripción "Galleta"
        seleccionarProductos("description", "Agua", 9999);

    }

    @And("editamos el tipo de descuento que tendra la promocion")
    public void editamosElTipoDeDescuentoQueTendraLaPromocion() throws InterruptedException {
        String nombreRestriccion = DatosGlobales.datos.get("nombreRestriccion");
        seleccionarReglaDePromocion("Menor precio monto fijo", nombreRestriccion, 1000 );
    }

    @Then("nos debe dirigir a la pantalla principal y visualizar nuestra promocion editada")
    public void nosDebeDirigirALaPantallaPrincipalYVisualizarNuestraPromocionEditada() throws InterruptedException {
        String nombrePromocion = DatosGlobales.datos.get("nombPromoEditado"); // El nombre de la promoción que deseas buscar
        boolean encontrada = buscarYEnmarcarPromocion(nombrePromocion);
        tomarCaptura("error");
        if (encontrada) {
            System.out.println("✅ La promoción fue editada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }

        cerrarDriver();
    }


    @And("editamos la cantidad minima de productos a llevar")
    public void editamosLaCantidadMinimaDeProductosALlevar() {
        ingresarCantidadMinimaDeProductosALlevar();
    }

    @And("en la vista de restriccion editamos la existente")
    public void enLaVistaDeRestriccionEditamosLaExistente() throws InterruptedException {
        clickEnEditarRestriccionExistente();
    }

    @And("editamos el nombre de restriccion")
    public void editamosElNombreDeRestriccion() throws InterruptedException {
        ingresarNombreRestriccion();
    }

    @And("copiamos una promocion ya existente")
    public void copiamosUnaPromocionYaExistente() {
        String nombrePromocion = DatosGlobales.datos.get("nombPromo"); // El nombre de la promoción que deseas buscar
        boolean encontrada = copiarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue encontrada y editada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
    }

    @And("validar que se despliega mensaje de copia exitosa")
    public void validarQueSeDespliegaMensajeDeCopiaExitosa() throws InterruptedException {
        validarMsjDeCopia();
    }

    @Then("visualizar nuestra promocion copiada")
    public void visualizarNuestraPromocionCopiada() {
        String nombrePromocion = DatosGlobales.datos.get("nombPromo") + " Copia"; // El nombre de la promoción que deseas buscar
        boolean encontrada = buscarYEnmarcarPromocion(nombrePromocion);

        if (encontrada) {
            System.out.println("✅ La promoción fue editada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
        cerrarDriver();
    }

    @And("hacemos click en confirmar la promocion")
    public void hacemosClickEnConfirmarLaPromocion() {
        String nombrePromocion= DatosGlobales.datos.get("nombPromo") + " Copia";
        boolean encontrada = confirmarPromocion(nombrePromocion);
        if (encontrada) {
            System.out.println("✅ La promoción fue confirmada correctamente.");
        } else {
            System.out.println("❌ La promoción no fue encontrada.");
        }
    }

    @And("buscamos la promocion que anularemos")
    public void buscamosLaPromocionQueAnularemos() {

        String nombrePromocion = DatosGlobales.datos.get("nombPromo") + " Copia";
        boolean encontrada = eliminarPromocion(nombrePromocion);
        if (!encontrada) {
            System.out.println("❌  La promoción fue eliminada correctamente.");
        } else {
            System.out.println("✅ La promoción fue eliminada correctamente.");

        }

    }

    @And("validar que se despliega mensaje de anulacion exitosa")
    public void validarQueSeDespliegaMensajeDeAnulacionExitosa() throws InterruptedException {
        //html/body/k2bt-floating-messages/div/div[2]
        validarMsjDeCopia();
        cerrarDriver();
    }

    @And("buscamos la promocion que necesitamos ver y hacemos clicn en ella")
    public void buscamosLaPromocionQueNecesitamosVerYHacemosClicnEnElla() {
        Map<String, String> datos = DatosGlobales.datos;

        if (datos == null) {
            throw new IllegalStateException("❌ Los datos no han sido cargados antes de llamar a verPromocion().");
        }

        String nombrePromocion = datos.get("nombPromo");

        if (nombrePromocion == null || nombrePromocion.isBlank()) {
            throw new IllegalArgumentException("❌ El campo 'nombPromo' no fue encontrado o está vacío en el JSON.");
        }

        verPromocion(nombrePromocion);

    }

    private void validarClavesRequeridas(String... claves) {
        if (DatosGlobales.datos == null) {
            throw new IllegalStateException("❌ Los datos no han sido cargados. Asegúrate de llamar primero al step que carga los datos.");
        }

        for (String clave : claves) {
            if (!DatosGlobales.datos.containsKey(clave) || DatosGlobales.datos.get(clave) == null) {
                throw new RuntimeException("❌ La clave '" + clave + "' está ausente o es nula en los datos cargados.");
            }
        }
    }


    @And("validamos los datos del resumen de la promocion")
    public void validamosLosDatosDelResumenDeLaPromocion() throws InterruptedException {
        Thread.sleep(2000);

        // Validar que todos los datos requeridos existen
        validarClavesRequeridas(
                "nombPromo", "fechaInicio", "fechaFin",
                "validaDesde", "validaHasta", "nombreRestriccion"
        );

        // Captura mensaje desde frame
        String mensaje = capturarMensajePantallaDesdeFrame("//*[@id=\"span_W0016vDESCUENTOAREALIZAR\"]", 0);
        tomarCaptura("Validacion de datos promocion");

        // Obtener los datos con seguridad
        String nombrePromo = DatosGlobales.datos.get("nombPromo").toString();
        String fechaInicio = DatosGlobales.datos.get("fechaInicio").toString();
        String fechaFin = DatosGlobales.datos.get("fechaFin").toString();
        String horaIni = DatosGlobales.datos.get("validaDesde").toString();
        String horaFin = DatosGlobales.datos.get("validaHasta").toString();
        String nombreRestriccion = DatosGlobales.datos.get("nombreRestriccion").toString();

        // Ejecutar validación final
        validacionDeDatos(
                nombrePromo,
                fechaInicio,
                fechaFin,
                horaIni,
                "Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo, Festivo, Víspera de festivo",
                mensaje,
                nombreRestriccion,
                "Aceitunas Negras En Rodajas Excelencia 1700 Gr., Aceitunas Rellenas Pimiento Verdes Excelencia 1700 Gr., Aceitunas Sevillana Don Juan 340 Gr."
        );
    }


    @Then("verificamos que esten correctos")
    public void verificamosQueEstenCorrectos() {
        cerrarDriver();
    }





}
