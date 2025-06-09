package Utils.Commons;

import java.util.Map;

public class DatosGlobales {

    public static Map<String, String> datos;
    public static Map<String, String> datosLogin;
    public static Map<String, String> datosPOS;
    public static Map<String, String> datosPromociones;
    public static Map<String, String> datosFiado;

    // Si quieres una referencia "activa"
    public static Map<String, String> datosActuales;


//    public static void cargarDatosDesdeArchivo(String archivo) {
//        switch (archivo.toLowerCase()) {
//            case "datos.json":
//                datos = JsonUtils.leerArchivo("src/test/resources/data/datos.json");
//                break;
//            case "datospos.json":
//                datos = JsonUtils.leerArchivo("src/test/resources/data/datosPOS.json");
//                break;
//            case "datosfiado.json":
//                datos = JsonUtils.leerArchivo("src/test/resources/data/datosFiado.json");
//                break;
//            case "datospromociones.json":
//                datos = JsonUtils.leerArchivo("src/test/resources/data/datosPromociones.json");
//                break;
//            default:
//                throw new IllegalArgumentException("Archivo no reconocido: " + archivo);
//        }
//    }
}
