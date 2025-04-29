package definitions.loginDef;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AbrirPDF {
    public static void main(String[] args) {
        String rutaDelArchivo = "C:/git/aut-Enternet/src/main/java/pdf/Captura/Captura_.pdf"; // Ajusta la ruta

        File file = new File(rutaDelArchivo);
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println("PDF abierto correctamente.");
            } catch (IOException e) {
                System.out.println("Error al abrir el PDF: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo PDF no existe en la ruta especificada.");
        }
    }
}
