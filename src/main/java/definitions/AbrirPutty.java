package definitions;

import definitions.Commons.BaseTest;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static definitions.Commons.BaseTest.*;

public class AbrirPutty {
    public static void main(String[] args) {

        try {
            // 🔹 Abrir PuTTY
            String puttyPath = "C:/Program Files/PuTTY/putty.exe";
            String host = "qa2.enternet.cl";
            ProcessBuilder pb = new ProcessBuilder(puttyPath, "-ssh", host);
            pb.start();
            System.out.println("✅ PuTTY abierto con conexión a: " + host);

            Thread.sleep(2000); // Esperar que PuTTY abra

            // 🔹 Crear instancia de Robot
            Robot robot = new Robot();

            // 🔹 Escribir usuario con primera letra mayúscula
            String usuario = "root";
            escribirTexto(robot, usuario);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);

            // 🔹 Escribir contraseña con primera letra mayúscula y caracteres especiales
            String password = "Enternet!1267?";
            password = capitalizarPrimeraLetra(password);
            escribirTextoEspecial(robot, password);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("✅ Usuario y contraseña ingresados en PuTTY.");
            Thread.sleep(2000);

            // Leer contenido del archivo .txt
            String filePath = "C:/git/aut-Enternet/src/main/java/definitions/Comandos.txt";
            String contenido = BaseTest.readFile(filePath);

            // Copiar al portapapeles
            StringSelection stringSelection = new StringSelection(contenido);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            Thread.sleep(2000); // Esperar que se abra PuTTY

            // Crear Robot para pegar el contenido y hacer clic derecho
            Robot robot2 = new Robot();

            // Pegar contenido (CTRL + V)
            robot2.keyPress(KeyEvent.VK_CONTROL);
            robot2.keyPress(KeyEvent.VK_V);
            robot2.keyRelease(KeyEvent.VK_V);
            robot2.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(1000); // Esperar que el contenido se pegue

            // Simular clic derecho
            robot2.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
            robot2.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);

            robot2.keyPress(KeyEvent.VK_ENTER);
            robot2.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("se ingresa query");

            Thread.sleep(2000); // Esperar a que aparezca el menú contextual

            // 6️⃣ Escribir el segundo comando: "cat /tmp/Testpsql.txt"
            escribirTextoEspecial(robot, "cat /definitions/Comandos.txt");
            presionarEnter(robot);



//            if (contenido != null) {
//                // Pegar el contenido en PuTTY
//                EscribirEnPutty.pegarEnPutty(contenido);
//            }
//            System.out.println("textocopiado: " + contenido);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}

