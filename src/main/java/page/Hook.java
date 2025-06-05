package page;

import definitions.Commons.BaseTest;
import definitions.Commons.DataLoader;
import definitions.Commons.DatosGlobales;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hook {

    public static String nombreFeature;

  //  @Before
//    public void beforeScenario(Scenario scenario) {
//        // Obtener el nombre del feature
//        nombreFeature = scenario.getUri().toString(); // Obtén la URI del feature
//        System.out.println("Nombre del Feature: " + nombreFeature);
//    }
//    public void beforeScenario(Scenario scenario) {
//        // Obtener solo el nombre del feature desde la URI
//        String uri = scenario.getUri().toString();
//        String nombreFeature = uri.substring(uri.lastIndexOf("/") + 1); // Extrae solo el nombre del archivo
//        // Aquí podrías llamar a tu metodo que agrega esto al PDF
//        // reportePdf.agregarTexto("Feature: " + nombreFeature);
//        System.out.println("Nombre del Feature: " + nombreFeature);
//    }
  @Before
  public void beforeScenario(Scenario scenario) throws IOException {
      // Capturamos el nombre del feature o escenario
      String nombreFeature = scenario.getName();  // O usa 'scenario.getName()' si prefieres el nombre del escenario
      System.out.println("Feature: " + nombreFeature);  // Para verificar que se captura correctamente
      BaseTest.nombreFeature = nombreFeature;  // Asigna el valor al campo estático 'nombreFeature' de BaseTest

      // Ruta base de tus JSONs
      String basePath = "C:/git/aut-Enternet/src/main/resources/";
//      String archivo = null;

      if (scenario.getSourceTagNames().contains("@Promociones")) {
//          archivo = "datosPromociones.json";
          DatosGlobales.datosPromociones = DataLoader.cargarDatosDesde( "datosPromociones.json");
          DatosGlobales.datosActuales = DatosGlobales.datosPromociones;

      } else if (scenario.getSourceTagNames().contains("@POS")) {
//          archivo = "datosPOS.json";
          DatosGlobales.datosPOS = DataLoader.cargarDatosDesde(basePath + "datosPOS.json");
          DatosGlobales.datosActuales = DatosGlobales.datosPOS;

      } else if (scenario.getSourceTagNames().contains("@Fiado")) {
//          archivo = "datosFiado.json";
          DatosGlobales.datosFiado = DataLoader.cargarDatosDesde(basePath + "datosFiado.json");
          DatosGlobales.datosActuales = DatosGlobales.datosFiado;

      } else if (scenario.getSourceTagNames().contains("@Inventario")) {
//          archivo = "datos.json";
          DatosGlobales.datosLogin = DataLoader.cargarDatosDesde(basePath + "datos.json");
          DatosGlobales.datosActuales = DatosGlobales.datosLogin;
      }

//      if (archivo != null) {
//          DatosGlobales.datos = DataLoader.cargarDatosDesde(basePath + archivo);
//          System.out.println("✅ Datos cargados desde: " + archivo);
//      } else {
//          System.out.println("⚠️ No se encontró una etiqueta reconocida para cargar datos automáticamente.");
//      }


  }
    public static String getNombreFeature() {
        return nombreFeature;
    }
//    @Before
//    public void setup(Scenario scenario) {
//        nombreFeature = scenario.getName();  // Aquí estamos capturando el nombre del feature
//    }




}


