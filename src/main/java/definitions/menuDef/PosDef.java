package definitions.menuDef;

import Utils.Commons.BaseTest;
import Utils.Commons.DatosGlobales;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.menuPage.PosPage;

import java.io.InputStream;
import java.time.Duration;
import java.util.Map;
import java.awt.*;


import static Utils.Commons.BaseTest.cerrarDriver;
import static Utils.Commons.BaseTest.tomarCaptura;
import static page.menuPage.PosPage.*;
import static page.menuPage.PromocionesPage.capturarMensajePantalla;

public class PosDef {
     public static Map<String, String> datosPOS;


    @Given("que ingreso los datos desde el archivo datosPos {string}")
    public void queIngresoLosDatosDesdeElArchivoDatosPOS(String arg0) {
        try {
            InputStream is = BaseTest.class.getClassLoader().getResourceAsStream("datosPOS.json");
            if (is == null) {
                throw new RuntimeException("❌ Archivo datosPOS.json no encontrado en resources.");
            }
            ObjectMapper mapper = new ObjectMapper();
            datosPOS = mapper.readValue(is, new TypeReference<>() {});
            System.out.println("✅ datosPOS cargado correctamente.");
        } catch (Exception e) {
            System.err.println(STR."❌ Error al cargar datosPOS: \{e.getMessage()}");
            datosPOS = null; // evitar estado inconsistente
        }
    }


//    @Given("que ingreso los datos desde el archivo datosPos {string}")
//    public static void queIngresoLosDatosDesdeElArchivoDatosPos(String nombreArchivo) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            InputStream input = PosDef.class.getClassLoader().getResourceAsStream(nombreArchivo);
//            if (input != null) {
//                datosPOS = mapper.readValue(input, new TypeReference<Map<String, String>>() {});
//                System.out.println("✅ datosPOS cargado correctamente.");
//            } else {
//                System.err.println("❌ No se encontró el archivo: " + nombreArchivo);
//            }
//        } catch (Exception e) {
//            System.err.println("❌ Error al cargar datosPOS: " + e.getMessage());
//        }
//    }
//    @Given("cargo los datos del POS")
//    public void cargoLosDatosDelPOS() {
//        PosDef.queIngresoLosDatosDesdeElArchivoDatosPos("datosPOS.json"); // El archivo debe estar en `resources`
//    }



        public static void cargarDatosPOSDesdeJson(String nombreArchivo) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream input = PosDef.class.getClassLoader().getResourceAsStream(nombreArchivo);
                if (input != null) {
                    datosPOS = mapper.readValue(input, new TypeReference<Map<String, String>>() {});
                    System.out.println("✅ datosPOS cargado correctamente.");
                } else {
                    System.err.println("❌ No se encontró el archivo: " + nombreArchivo);
                }
            } catch (Exception e) {
                System.err.println("❌ Error al cargar datosPOS: " + e.getMessage());
            }
        }

        @Given("cargo los datos del POS")
        public void cargoLosDatosDelPOS() {
            cargarDatosPOSDesdeJson("datosPOS.json");
        }


    @And("debe de mostrar la vista de Pos")
    public void debeDeMostrarLaVistaDePos() throws InterruptedException {
        visualizarVistaPos();
    }

    @And("estoy en home de Pos")
    public void estoyEnHomeDePos()  {
        seleccionOpcioPOS();
    }

    @And("selecciono el menu de Pos {string}")
    public void seleccionoElMenuDePos(String menuP) throws InterruptedException {
        String menu = DatosGlobales.datos.get("menuPOS");
        PosPage.seleccionMenuPos(menu);
    }

    @And("luego el submenu de Pos {string}")
    public void luegoElSubmenuDePos(String args0) throws InterruptedException {
        String subMenuP = DatosGlobales.datos.get("subMenuP");
        PosPage.seleccionamosSubMenuPOS(subMenuP);
    }

    @When("este en el modulo de Enrolamiento de Terminales")
    public void esteEnElModuloDeEnrolamientoDeTerminales() throws InterruptedException {
      visualizarVistaEnrolamientoTerminales();

    }

    @And("seleccionamos un link de acceso QR")
    public void seleccionamosUnLinkDeAccesoQR() throws InterruptedException {
        seleccionQR();
    }

    @And("seleccionamos el boton copiar")
    public void seleccionamosElBotonCopiar() throws InterruptedException {
        seleccionBtnCopiar();
    }

    @And("luego pegamos la url en un nuevo navegador")
    public void luegoPegamosLaUrlEnUnNuevoNavegador() {
        abrirnuevaPestania();
    }

    @And("ingresamos el tipo de perfil")
    public void ingresamosElTipoDePerfil() throws InterruptedException, AWTException {

        clickBtnIrALogin();
        seleccionTipoPerfil();
    }

    @And("ingresamos el modulo IDL")
    public void ingresamosElModuloIDL() throws InterruptedException {
        seleccionarModuloIDL();
    }

    @And("ingresamos el rut {string} y contrasenia {string}")
    public void ingresamosElRutYContrasenia(String args0, String args1) {
        ingresarRut();
        ingresarClave();
    }

    @And("seleccionamos el boton ingresar")
    public void seleccionamosElBotonIngresar() throws InterruptedException {
       // seleccionarBtnIngresar();
    }

    @And("hacemos click en la caja que muestra nuestro nombre")
    public void hacemosClickEnLaCajaQueMuestraNuestroNombre() throws InterruptedException {
        seleccionarCajaConNuestroNombre();
    }

    @And("seleccionamos boton nueva venta")
    public void seleccionamosBotonNuevaVenta() throws InterruptedException {
        clickBtnNuevaVenta();
    }

    @And("le asignamos el cliente a quien venderemos {string}")
    public void leAsignamosElClienteAQuienVenderemos(String nombreCliente) throws InterruptedException {
        buscarClienteYSeleccionarPorRut(); //poner que si se depliega antes la lista de clientes seleccione
//        clickBtnCliente();  //clickbtnCliente
//        ingresarRutcliente(); //203344473
//        seleccionCliente(); //hace click en nombe cliente
    }

    @And("Ingresamos la descripcion o codigo de un producto y apretamos enter")
    public void ingresamosLaDescripcionOCodigoDeUnProductoYApretamosEnter() throws InterruptedException {
        ingresarProductoPorDescripcion();
        PosPage.seleccionarNombreProducto();
       // ingresarProductoPorCodigo();
      //  clickBtnEnter();
    }

    @And("ingresamos la cantidad de producto que llevaremos")
    public void ingresamosLaCantidadDeProductoQueLlevaremos() throws InterruptedException {
        ingresarCantidadDeProducto();
    }
    @And("seleccionamos la forma de pago <{string}> que ocuparemos e ingresamos los datos para el pago")
    public void seleccionamosLaFormaDePagoQueOcuparemosEIngresamosLosDatosParaElPago(String args0) throws InterruptedException {
        ingresarFormaDePago();

        if ("Efectivo".equalsIgnoreCase(DatosGlobales.datos.get("formaDePago"))) {

            ingresoMontoEfectivo();
        } else {
            ingresarTipoDePago();
        }

          // ingresoDeDatosParaElPago();

    }

    @And("seleccionar boton guardar")
    public void seleccionarBotonGuardar() throws InterruptedException {
        seleccionarBtnGuardar();
    }
    @And("seleccionamos tipo de emision <{string}>")
    public void seleccionamosTipoDeEmision(String arg0) throws InterruptedException {
        seleccionTipoDeEmision();
        Thread.sleep(6000);

    }

    @And("ingresamos un producto desde el modulo del filtro por categorias")
    public void ingresamosUnProductoDesdeElModuloDelFiltroPorCategorias() throws InterruptedException {

    }

    @And("ingresamos un producto en el filtro de despensa {string}")
    public void ingresamosUnProductoEnElFiltroDeDespensa(String arg0) throws InterruptedException {
        String tipoCategoria = DatosGlobales.datosPOS.get("tipoCategoria");
        escribirProductoEnFiltroDespensa();

        if ("Despensa".equalsIgnoreCase(tipoCategoria)) {
            escribirProductoEnFiltroDespensa();
        } else if ("Anio".equalsIgnoreCase(tipoCategoria)){
            escribirProductoEnFiltroANNO();
        }else {
            escribirProductoEnFiltroOtros();
        }
    }

//    @And("ingresamos un producto en el filtro de ANNO {string}")
//    public void ingresamosUnProductoEnElFiltroDeANNO(String arg0) throws InterruptedException {
//        escribirProductoEnFiltroANNO();
//    }

//    @And("ingresamos un producto en el filtro de Otros {string}")
//    public void ingresamosUnProductoEnElFiltroDeOtros(String arg0) throws InterruptedException {
//        escribirProductoEnFiltroOtros();
//    }

    @And("hacemos click en el boton carta y seleccionamos el producto que muestre")
    public void hacemosClickEnElBotonCartaYSeleccionamosElProductoQueMuestre() throws InterruptedException {
        clickBtnCarta();
        clickCategoria();
        seleccionarProducto();
    }

    @And("le modificamos el precio al producto{string}")
    public void leModificamosElPrecioAlProducto(String arg0) throws InterruptedException {
        modificarPrecioProducto();
    }

    @And("le modificamos la cantidad de producto a comprar {string}")
    public void leModificamosLaCantidadDeProductoAComprar(String arg0) throws InterruptedException {
        modificarCantidadProducto();
        cerrarDriver();
    }

    @And("seleccionamos el boton buscar")
    public void seleccionamosElBotonBuscar() throws InterruptedException {
        clickBtnBuscar();
    }

    @And("seleccionamos un producto")
    public void seleccionamosUnProducto() throws InterruptedException {
        hacerClickEnProducto();
     //   visualizarInformacionDeProducto();
    }

    @And("seleccionamos el boton transportista")
    public void seleccionamosElBotonTransportista() throws InterruptedException {
        clickBtnTransportista();
    }

    @And("ingresamos el motivo de traslado")
    public void ingresamosElMotivoDeTraslado() throws InterruptedException {
        seleccionarMotivoDeTraslado();
    }

    @And("Ingresamos el tipo de traslado")
    public void ingresamosElTipoDeTraslado() throws InterruptedException {
        seleccionarTipoDeTraslado();
    }

    @And("ingresamos el nombre del chofer <{string}>")
    public void ingresamosElNombreDelChofer(String arg0) throws InterruptedException {
        ingresarNombreChofer();
    }

    @And("ingresamos el rut del chofer <{string}>")
    public void ingresamosElRutDelChofer(String arg0) {
        ingresarRutChofer();
    }

    @And("ingresamos el numero de patente <{string}> y confirmamos")
    public void ingresamosElNumeroDePatenteYConfirmamos(String arg0) throws InterruptedException {
        ingresarPatente();
        cerrarDriver();
    }

    @And("le damos click en el boton de crear prod libre y visualizamos el formulario para ingresar un producto")
    public void leDamosClickEnElBotonDeCrearProdLibreYVisualizamosElFormularioParaIngresarUnProducto() {
    }

    @And("ingresamos el codigo {string}, una descripcion {string} , una unidad de medida {string}")
    public void ingresamosElCodigoUnaDescripcionUnaUnidadDeMedida(String arg0, String arg1, String arg2) throws InterruptedException {
        crearEIngresarProductoLibre();
    }
    @And("seleccionamos un Tratamiento Tributario y un Codigo Especial")
    public void seleccionamosUnTratamientoTributarioYUnCodigoEspecial() {
    }

//    @And("ingresamos una unidad de medida {string}")
//    public void ingresamosUnaUnidadDeMedida(String arg0) throws InterruptedException {
//        seleccionarUnidadDeMedida();
//        seleccionarUnidadDeMedida2();
//    }

//    @And("seleccionamos un Tratamiento Tributario")
//    public void seleccionamosUnTratamientoTributario() throws InterruptedException {
//        seleccionTratamientoTributario();
//    }

//    @And("seleccionamos un Codigo Especial")
//    public void seleccionamosUnCodigoEspecial() throws InterruptedException {
//        seleccionCodigoEspecial();
//    }

    @And("ingresamos la cantidad del producto <{string}> el precio <{string}> y descuento <{string}>")
    public void ingresamosLaCantidadDelProductoElPrecioYDescuento(String arg0, String arg1, String arg2) throws InterruptedException {
        ingresarCantidad();
        ingresarPrecio();
        ingresoDescuento();
    }

    @And("ingresamos las dimensiones <{string}> y estado de entrega <{string}>")
    public void ingresamosLasDimensionesYEstadoDeEntrega(String arg0, String arg1) throws InterruptedException {
        ingresoDimensiones();
        ingresarEstadoDeEntrega();
    }

    @And("ingresamos la glosa <{string}>")
    public void ingresamosLaGlosa(String arg0) throws InterruptedException {
        ingresarGlosa();
    }

    @And("le damos click al boton confirmar")
    public void leDamosClickAlBotonConfirmar() throws InterruptedException {
        clickBtnConfirmarVistaProdLibre();
    }

    @Then("visualizamos el producto ingresado en el carro de compras")
    public void visualizamosElProductoIngresadoEnElCarroDeCompras() throws InterruptedException {
        visualizarProductoAgreadoCarroCompras();
    }

    @And("seleccionamos la forma de pago <{string}> y el tipo de pago <{string}> que ocuparemos")
    public void seleccionamosLaFormaDePagoYElTipoDePagoQueOcuparemos(String formaDePago, String tipoDePAgo) throws InterruptedException {
        ingresarFormaDePago();
        ingresoDeDatosParaElPago();
    }

    @Then("seleccionar boton imprimir")
    public void seleccionarBotonImprimir() throws InterruptedException {
        seleccionarBtnImprimir();
        Thread.sleep(3000);
        cerrarDriver();
    }



}
