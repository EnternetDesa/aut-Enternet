package page;

import definitions.Commons.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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
  public void beforeScenario(Scenario scenario) {
      // Capturamos el nombre del feature o escenario
      String nombreFeature = scenario.getName();  // O usa 'scenario.getName()' si prefieres el nombre del escenario
      System.out.println("Feature: " + nombreFeature);  // Para verificar que se captura correctamente
      BaseTest.nombreFeature = nombreFeature;  // Asigna el valor al campo estático 'nombreFeature' de BaseTest
  }
    public static String getNombreFeature() {
        return nombreFeature;
    }
//    @Before
//    public void setup(Scenario scenario) {
//        nombreFeature = scenario.getName();  // Aquí estamos capturando el nombre del feature
//    }




}


