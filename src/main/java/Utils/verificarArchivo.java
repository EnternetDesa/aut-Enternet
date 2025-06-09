package definitions;

import java.io.File;

public class verificarArchivo {

    public static boolean existeArchivo(String rutaArchivo, int i) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
    public static boolean esperarArchivoDescarga(String rutaArchivo, int tiempoMaximoSegundos) {
        File archivo = new File(rutaArchivo);
        int tiempoEsperado = 0;

        while (tiempoEsperado < tiempoMaximoSegundos) {
            if (archivo.exists()) {
                System.out.println("✅ Archivo encontrado: " + rutaArchivo);
                return true;
            }
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de volver a verificar
                tiempoEsperado++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("⏳ Tiempo de espera agotado. No se encontró el archivo.");
        return false;
    }
}
