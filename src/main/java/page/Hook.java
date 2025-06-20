package page;

import Utils.Commons.BaseTest;
import Utils.Commons.DataLoader;
import Utils.Commons.DatosGlobales;
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

      } else if (scenario.getSourceTagNames().contains("@Ventas")) {
//          archivo = "datosPOS.json";
          DatosGlobales.datosPOS = DataLoader.cargarDatosDesde( "datosPOS.json");
          DatosGlobales.datosActuales = DatosGlobales.datosPOS;

      } else if (scenario.getSourceTagNames().contains("@Fiado")) {
//          archivo = "datosFiado.json";
          DatosGlobales.datosFiado = DataLoader.cargarDatosDesde("datosFiado.json");
          DatosGlobales.datosActuales = DatosGlobales.datosFiado;

      } else if (scenario.getSourceTagNames().contains("@Items")) {
//          archivo = "datos.json";
          DatosGlobales.datos = DataLoader.cargarDatosDesde("datos.json");
          DatosGlobales.datosActuales = DatosGlobales.datos;
      }


  }
    public static String getNombreFeature() {
        return nombreFeature;
    }
//    @Before
//    public void setup(Scenario scenario) {
//        nombreFeature = scenario.getName();  // Aquí estamos capturando el nombre del feature
//    }




}


