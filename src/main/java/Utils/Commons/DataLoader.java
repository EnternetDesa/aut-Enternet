package Utils.Commons;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DataLoader {

    // Campos obligatorios para login
    private static final Set<String> CAMPOS_OBLIGATORIOS = Set.of("user", "clave");

    private static void validarCamposObligatorios(Map<String, String> datos, String ruta) {
        for (String campo : CAMPOS_OBLIGATORIOS) {
            if (!datos.containsKey(campo)) {
                throw new IllegalArgumentException("⚠️ El archivo JSON '" + ruta + "' no contiene el campo obligatorio: '" + campo + "'");
            }
        }
    }
    public static Map<String, String> cargarDatosDesde(String ruta) throws IOException {
        Map<String, String> datos = BaseTest.cargarJsonComoMapa(ruta);

        // Aquí validamos que tenga campos obligatorios
        if (!datos.containsKey("user")) {
            throw new IllegalArgumentException("El archivo cargado no contiene el campo 'user'");
        }
        if (!datos.containsKey("clave")) {
            throw new IllegalArgumentException("El archivo cargado no contiene el campo 'clave'");
        }

        return datos;
    }



}
