package definitions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class EscribirEnPutty {
    public static void pegarEnPutty(String texto) {
        try {
            // Copiar el texto al portapapeles
            StringSelection seleccion = new StringSelection(texto);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

            // Simular teclas con Robot
            Robot robot = new Robot();
            Thread.sleep(2000); // Espera para asegurarse de que PuTTY está activo

            // Pegar el contenido con CTRL + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Presionar ENTER
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

