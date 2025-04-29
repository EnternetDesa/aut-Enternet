package definitions.menuDef;

import definitions.Commons.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static definitions.Commons.BaseTest.obtenerNumeroConsecutivo;
import static definitions.Commons.BaseTest.*;
import static page.menuPage.ItemsPage.*;


public class ItemsDef {

    WebDriver driver = BaseTest.getDriver();
    // Ruta donde se guardarán los PDFs
    String rutaCarpeta = "C:/git/aut-Enternet/src/main/java/pdf/Captura/";

    // Obtener el próximo número consecutivo
    int numeroArchivo = obtenerNumeroConsecutivo(rutaCarpeta);

    private Map<String, String> datos;

    public ItemsDef() throws FileNotFoundException {
    }


    @When("este en lista de items y presionamos el boton crear items")
    public void esteEnListaDeItemsYPresionamosElBotonCrearItems() throws IOException, InterruptedException {
        seleccionarBtnCrearItems();
    }

    @And("nos redirige a la vista de creacion de producto")
    public void nosRedirigeALaVistaDeCreacionDeProducto() throws IOException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement btnCrearItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CREARITEM\"]")));
//        Utils.enmarcarElemento(driver, btnCrearItems );
//        //takeScreenshot("screenshot_");
//        tomarCaptura("Ingreso crear items");
//        medirTiempoDeCarga(By.xpath("//*[@id=\"CREARITEM\"]"),"Ingreso crear items");
//        btnCrearItems.click();
    }

    @And("ingresamos los datos de descripcion de producto {string}")
    public void ingresamosLosDatosDeDescripcionDeProducto(String arg0) {
        ingresarDescripcionDeProducto(BaseTest.datos.get("descProd"));
    }

    @And("seleccione una unidad de medida <{string}>")
    public void seleccioneUnaUnidadDeMedida(String uniMedida) {
        seleccionUnidadDeMedida(BaseTest.datos.get("uniMedida"));
    }

    @And("seleccione una unidad de comparacion <{string}>")
    public void seleccioneUnaUnidadDeComparacion(String uniComparacion) {
        seleccionUnidadDeComparacion(BaseTest.datos.get("uniComparacion"));
    }

    @And("seleccione una equivalencia de comparacion <{string}>")
    public void seleccioneUnaEquivalenciaDeComparacion(String equivalenciaComparacion) throws InterruptedException {
        ingresoEquivalenciaDeComparacion(BaseTest.datos.get("equivalenciaComparacion"));
    }

    @And("seleccionamos si el producto usa lotes o no")
    public void seleccionamosSiElProductoUsaLotesONo() {
        selecconarSiElProductoUsaLotesONo();
    }

    @And("ingresamos en codigo de producto el codigo INT <{string}>")
    public void ingresamosEnCodigoDeProductoElCodigoINT(String arg0) {
        ingresarCodigoInternoDelProducto(BaseTest.datos.get("codInterno"));
    }

    @And("ingresamos el codigo EAN <{string}>")
    public void ingresamosElCodigoEAN(String arg0) {
        ingresarCodigoEANDelProducto(BaseTest.datos.get("codEAN"));
    }

    @And("ingresamos el codigo SKU <{string}>")
    public void ingresamosElCodigoSKU(String arg0) {
        ingresarCodigoSKUDelProducto(BaseTest.datos.get("codSKU"));
    }

    @And("ingresamos el codigo base <{string}>")
    public void ingresamosElCodigoBase(String arg0) throws IOException, InterruptedException {

        ingresarCodigoBase(BaseTest.datos.get("codBase"));
    }

    @And("en la seccion de categorias del producto seleccionamos la categoria buscadora <{string}> y seleccionamos el boton buscar")
    public void enLaSeccionDeCategoriasDelProductoSeleccionamosLaCategoriaBuscadoraYSeleccionamosElBotonBuscar(String arg0) throws InterruptedException {
        seleccionCategoriaBuscadora(BaseTest.datos.get("catBuscadora"));
        seleccionarBtnBuscar();
    }
    @And("Luego seleccionamos la categoria Buscadora que necesitamos <{string}>")
    public void luegoSeleccionamosLaCategoriaBuscadoraQueNecesitamos(String arg0) throws IOException, InterruptedException {
        if (BaseTest.datos.get("catBuscadora").equals("ANNO")){
            seleccionCategoriaBuscadoraTipoANNO();

        }else {
            seleccionCategoriaBuscadoraTipoOtros(BaseTest.datos.get("codCatBuscadoraTipo"));
        }
        scroll();
    }

    @And("seleccionamos la categoria clasificadora <{string}> y seleccionamos el boton buscar")
    public void seleccionamosLaCategoriaClasificadoraYSeleccionamosElBotonBuscar(String arg0) throws InterruptedException {
        page.menuPage.ItemsPage.seleccionCategoriaClasificadora();
    }

    @And("luego seleccionamos el tipo de categoria  <{string}>")
    public void luegoSeleccionamosElTipoDeCategoria(String arg0) throws IOException, InterruptedException {
        page.menuPage.ItemsPage.seleccionCategoriaClasificadoraTipo(BaseTest.datos.get("catClasificadora"));
    }
    @And("en configuracion por ubicacion ingresamos la cantidad <{string}>")
    public void enConfiguracionPorUbicacionIngresamosLaCantidad(String arg0) throws InterruptedException {
        ingresoDeCantidadDeProductoPorUbicacion(BaseTest.datos.get("cantidadP"));
    }

    @And("el costo unitario <{string}>")
    public void elCostoUnitario(String arg0) throws InterruptedException {
        ingresoDeCostoUnitario(BaseTest.datos.get("costoUni"));

    }

    @And("el precio del producto <{string}>")
    public void elPrecioDelProducto(String arg0) throws InterruptedException {
        ingresarPrecioProducto(BaseTest.datos.get("precioProd"));
    }


    @And("seleccionamos guardar producto y nos debe redirigir a la vista de lista de items")
    public void seleccionamosGuardarProductoYNosDebeRedirigirALaVistaDeListaDeItems() throws IOException, InterruptedException {
        seleccionarBtnGuardarProducto();
    }

    @And("seleccionamos las categorias ingresadas anteriormente y buscamos por esos filtros")
    public void seleccionamosLasCategoriasIngresadasAnteriormenteYBuscamosPorEsosFiltros() throws InterruptedException, IOException {
        seleccionarFiltroCatClasificadoraVistaModuloItems();
        seleccionarCodigoCatClasificadoraVistaModuloItems(BaseTest.datos.get("catClasificadora"));

    }

    @Then("nos debe de mostrar el items creado en la lista el items")
    public void nosDebeDeMostrarElItemsCreadoEnLaListaElItems(String nombreProducto) throws InterruptedException, IOException {
//        ingresarDescripcionDeProducto(datos.get("descProd"));
//        seleccionarFiltroCatBuscadoraVistaModuloItems();
//        seleccionarCodigoCatBuscadoraVistaModuloItems(BaseTest.datos.get("codCatBuscadoraTipo"));
    //    seleccionarBtnBuscar();
       // mostrarListadoDeItems();
        buscarProductoPorNombre(nombreProducto);
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();
    }


    @And("luego seleccionemos el boton buscar")
    public void luegoSeleccionemosElBotonBuscar() {
        seleccionarBtnBuscar();
    }

//    @Then("nos debe de mostrar los productos creados")
//    public void nosDebeDeMostrarLosProductosCreados() throws IOException, InterruptedException {
//        mostrarListadoDeItems();
//        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
//        BaseTest.cerrarDriver();
//    }


    @Then("nos debe de mostrar los productos de esa categoria")
    public void nosDebeDeMostrarLosProductosDeEsaCategoria(String nombreProducto) throws IOException, InterruptedException {
        buscarProductoPorNombre(nombreProducto);
        //mostrarListadoDeItems();
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();

    }

    @When("este en el modulo de items")
    public void esteEnElModuloDeItems() throws IOException, InterruptedException {
        visualizarModuloItems();

    }

    @And("seleccionamos filtro por categoria")
    public void seleccionamosFiltroPorCategoria() {

    }

    @And("seleccionamos sin categoria {string}")
    public void seleccionamosSinCategoria(String sinCategoria) throws InterruptedException, IOException {
        seleccionarSinCategoria(sinCategoria);
    }

    @And("seleccionamos categoria clasificadora")
    public void seleccionamosCategoriaClasificadora() {
        seleccionarFiltroCatClasificadoraVistaModuloItems();
    }

    @And("seleccionamos codigo categoria Clasificadora {string}")
    public void seleccionamosCodigoCategoriaClasificadora(String catClasificadora) throws IOException, InterruptedException {
        seleccionarCodigoCatClasificadoraVistaModuloItems(catClasificadora);
    }

    @And("seleccionamos categoria buscadora {string}")
    public void seleccionamosCategoriaBuscadora(String arg0) throws InterruptedException {

        seleccionarFiltroCatBuscadoraVistaModuloItems();

    }

    @And("seleccionamos codigo categoria buscadora {string}")
    public void seleccionamosCodigoCategoriaBuscadora(String codCatBuscadoraTipo) throws IOException, InterruptedException {
        if (BaseTest.datos.get("catBuscadora").equals("ANNO")){
            seleccionarCodigoCatBuscadoraVistaModuloItemsANNO(codCatBuscadoraTipo);
        }else {
            seleccionarCodigoCatBuscadoraVistaModuloItems(codCatBuscadoraTipo);
        }
    }

    @And("seleccionamos filtros generales")
    public void seleccionamosFiltrosGenerales() {
    }

    @And("seleccionamos codigo {string}")
    public void seleccionamosCodigo(String codigo) throws InterruptedException, IOException {
        busquedaPorCodigoItems(codigo);
    }

    @And("seleccionamos descripcion {string}")
    public void seleccionamosDescripcion(String descProd) throws InterruptedException, IOException {
        busquedaPorDescripcionItems(BaseTest.datos.get("descProd"));
    }

    @And("le demos click en mostrar todo")
    public void leDemosClickEnMostrarTodo() throws InterruptedException, IOException {
        seleccionarCheckMostrarTodo();
    }

    @And("ingresamos el numero de ultimo dia de modificacion {string}")
    public void ingresamosElNumeroDeUltimoDiaDeModificacion(String diasMod) throws InterruptedException, IOException {
        busquedaPorDiasDeUltimaModificacion(diasMod);
    }

    @And("Seleccionamos Limpiar Filtros")
    public void seleccionamosLimpiarFiltros() throws InterruptedException, IOException {
        seleccionarLimpiarFiltros();
    }

    @Then("nos debe de mostrar que no este ningun filtro seleccionado")
    public void nosDebeDeMostrarQueNoEsteNingunFiltroSeleccionado() throws InterruptedException, IOException {
        BaseTest.tomarCaptura("Sin Filtros Aplicados");
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();
    }

    @And("seleccione el boton de descargar columna base para maestras")
    public void seleccioneElBotonDeDescargarColumnaBaseParaMaestras() throws InterruptedException, IOException {
        seleccionarDescargarColumnasBase();
    }

    @Then("se descarga el archivo cvs")
    public void seDescargaElArchivoCvs() {
        validarArchivoDescargado();
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();
    }

    @And("seleccionamos guardar producto")
    public void seleccionamosGuardarProducto() throws IOException, InterruptedException {
        seleccionarBtnGuardarProducto();
    }

    @Then("nos debe de mostrar el msj creado en la lista el items")
    public void nosDebeDeMostrarElMsjCreadoEnLaListaElItems() throws InterruptedException, IOException {
        visualizarMsjAlerta();
//        BaseTest.tomarCaptura(" Debe ingresar una descripcion");
        BaseTest.cerrarDriver();
    }

    @And("validar que los datos ingresados esten el la base de datos")
    public void validarQueLosDatosIngresadosEstenElLaBaseDeDatos(String texto) {
        ingresarDatosPutty();
        pegarEnPutty(texto);
    }

    @And("seleccionamos el boton importar archivo")
    public void seleccionamosElBotonImportarArchivo() {
        seleccionarBtnImportarArchivo();
    }

    @And("en la ventana de carga de archivo ingresamos el tipo de separador de celdas {string}")
    public void enLaVentanaDeCargaDeArchivoIngresamosElTipoDeSeparadorDeCeldas(String separadorCeldas) throws InterruptedException, IOException {
        ingresarTipoDeSeparadorDeCeldas();
    }
    @And("Seleccionamos el boton agregar archivos y cargamos el documento que contega la informacion")
    public void seleccionamosElBotonAgregarArchivosYCargamosElDocumentoQueContegaLaInformacion() throws InterruptedException {
        seleccionarBtnAgregarArchivos();
    }

    @And("cargamos el archivo que contega la informacion")
    public void cargamosElArchivoQueContegaLaInformacion() {
        seleccionarDocumentoConDataParaCargar();
    }

    @And("seleccionamos el boton procesar")
    public void seleccionamosElBotonProcesar() throws InterruptedException {
        seleccionarBtnProcesar();
    }

    @Then("nos debe de mostrar un mensaje que la base esta cargada")
    public void nosDebeDeMostrarUnMensajeQueLaBaseEstaCargada() throws InterruptedException, IOException {
       validarMensajeDeCarga();
        BaseTest.cerrarDriver();
    }

    @And("luego seleccionamos varios tipos de categoria  <{string}>")
    public void luegoSeleccionamosVariosTiposDeCategoria(String arg0) throws InterruptedException {
        List<String> despensas = Arrays.asList("Aceite y Condimentos", "Despensa Infantil");
        buscarVariasDespensasYAgregar(driver, despensas);
//         seleccionCategoriaBuscadoraTipoOtros(BaseTest.datos.get("codCatBuscadoraTipo"));
    }

    @Then("Al intentar seleccionar varios tipos de categoria clasificadora debe mostrar el mensaje que solo se puede seleccionar una")
    public void alIntentarSeleccionarVariosTiposDeCategoriaClasificadoraDebeMostrarElMensajeQueSoloSePuedeSeleccionarUna() throws InterruptedException, IOException {
        validarMsjAlerta();
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();
    }

    @And("Luego seleccionamos varios tipos de categoria Buscadoras <{string}>")
    public void luegoSeleccionamosVariosTiposDeCategoriaBuscadoras(String arg0) throws InterruptedException, IOException {
        if (BaseTest.datos.get("catBuscadora").equals("ANNO")){
            seleccionCategoriaBuscadoraTipoANNO();

        }else {
            seleccionCategoriaBuscadoraTipoOtros(BaseTest.datos.get("codCatBuscadoraTipo"));
        }
        scroll();
    }

    @And("seleccione el boton crear codigo barra")
    public void seleccioneElBotonCrearCodigoBarra() {
        seleccionarBtnCodigoDeBarras();
    }

    @And("se visualiza vista para ingresar codigo de barras e ingresamos el codigo y seleccionamos el boton editar")
    public void seVisualizaVistaParaIngresarCodigoDeBarrasEIngresamosElCodigoYSeleccionamosElBotonEditar() throws InterruptedException {
        ingresarCodigoDeBarras();
        seleccionarBtnEditar();
       // seleccionarBtnSigte();
    }

    @Then("nos debe de mostrar el producto creado {string}")
    public void nosDebeDeMostrarElProductoCreado(String nombreProducto) throws InterruptedException {
        buscarProductoPorNombre(nombreProducto);
        //mostrarListadoDeItems();
        System.out.println("PDF generado con éxito en: " + RUTA_PDF);
        BaseTest.cerrarDriver();
    }

    @Then("nos debe mostrar un mensaje de alerta que el producto ya existe")
    public void nosDebeMostrarUnMensajeDeAlertaQueElProductoYaExiste() throws IOException, InterruptedException {
        visualizarMsjAlerta();
        cerrarDriver();
    }

    @And("seleccionamos guardar producto y nos debe redirigir a la vista de Ingrese código de barras")
    public void seleccionamosGuardarProductoYNosDebeRedirigirALaVistaDeIngreseCódigoDeBarras() throws IOException, InterruptedException {
        seleccionarBtnGuardarProducto();
        tomarCaptura("vista Ingrese Codigo de Barra");
        cerrarDriver();
    }
}
