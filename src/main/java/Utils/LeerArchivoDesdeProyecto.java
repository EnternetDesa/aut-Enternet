package definitions;

import java.io.InputStream;
import java.util.Scanner;

public class LeerArchivoDesdeProyecto {
    public static void main(String[] args) {
        try (InputStream inputStream = LeerArchivoDesdeProyecto.class.getResourceAsStream("/definitions/Comandos.txt");
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("❌ No se pudo leer el archivo.");
            e.printStackTrace();
        }
    }
}


