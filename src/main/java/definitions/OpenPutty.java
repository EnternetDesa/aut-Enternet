package definitions;

import java.io.IOException;


public class OpenPutty {
    public static void main(String[] args) throws InterruptedException, IOException {
//        try {
//            // 🔹 Abrir PuTTY
//            String puttyPath = "C:\\Program Files\\PuTTY\\putty.exe";
//            String host = "qa2.enternet.cl";
//            ProcessBuilder pb = new ProcessBuilder(puttyPath, "-ssh", host);
//            pb.start();
//            System.out.println("✅ PuTTY abierto con conexión a: " + host);
//
//            Thread.sleep(2000); // Esperar que PuTTY abra
//
//            // 🔹 Crear instancia de Robot
//            Robot robot = new Robot();
//
//            // 🔹 Escribir usuario con primera letra mayúscula
//            String usuario = "root";
//            escribirTexto(robot, usuario);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            Thread.sleep(3000);
//
//            // 🔹 Escribir contraseña con primera letra mayúscula y caracteres especiales
//            String password = "Enternet!1267?";
//            password = capitalizarPrimeraLetra(password);
//            escribirTextoEspecial(robot, password);
//
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//            System.out.println("✅ Usuario y contraseña ingresados en PuTTY.");
//            Thread.sleep(2000);
//
//            //EscribirEnPutty.pegarEnPutty();
//
//            Thread.sleep(3000);
//
//            // 6️⃣ Escribir el segundo comando: "cat /tmp/Testpsql.txt"
//            escribirTexto(robot, "cat /tmp/Testpsql.txt");
//            presionarEnter(robot);
//            Thread.sleep(3000);
//
//            System.out.println("Comandos ejecutados en PuTTY");
//
//            //su -c "psql -d pos -tc \"select * from itemmaestro where mitemnom = 'Lentejas Listas Para Servir Esmeralda 400 Gr';\"" postgres > /tmp/Testpsql.txt
//            //cat /tmp/Testpsql.txt  //imprime lo de arriba
//
//            //    document.add(new Paragraph(result.toString()));
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    // 🔹 Método para convertir la primera letra a mayúscula
//    public static String capitalizarPrimeraLetra(String texto) {
//        if (texto == null || texto.isEmpty()) {
//            return texto;
//        }
//        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
//    }
//
//    // 🔹 Método para escribir texto con caracteres especiales y primera letra en mayúscula
//    public static void escribirTextoEspecial(Robot robot, String texto) {
//        for (int i = 0; i < texto.length(); i++) {
//            char c = texto.charAt(i);
//
//            if (i == 0 && Character.isLetter(c)) { // Primera letra en mayúscula
//                presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(c)));
//            } else {
//                switch (c) {
//                    case '@': presionarTeclas(robot, KeyEvent.VK_ALT_GRAPH, KeyEvent.VK_2); break;
//                    case '!': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
//                    case '$': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_4); break;
//                    case '*': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_8); break;
//                    case '?': escribirCaracterPregunta(robot); break; // Nuevo metodo para "?"
//                    case '/': presionarTeclas(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_7); break;
//                    default: escribirTexto(robot, String.valueOf(c));
//                }
//            }
//        }
//    }
//
//    // 🔹 Método para escribir texto normal
//    public static void escribirTexto(Robot robot, String texto) {
//        for (char c : texto.toCharArray()) {
//            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
//            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
//                throw new RuntimeException("No se puede escribir: " + c);
//            }
//            robot.keyPress(keyCode);
//            robot.keyRelease(keyCode);
//        }
//    }
//
//    // 🔹 Método especial para escribir "?" en teclado español latinoamericano
//    public static void escribirCaracterPregunta(Robot robot) {
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_QUOTE); // 🔹 Para "?" en teclado LATAM
//        robot.keyRelease(KeyEvent.VK_QUOTE);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//    }
//
//    // 🔹 Método para presionar teclas combinadas
//    public static void presionarTeclas(Robot robot, int tecla1, int tecla2) {
//        robot.keyPress(tecla1);
//        robot.keyPress(tecla2);
//        robot.keyRelease(tecla2);
//        robot.keyRelease(tecla1);
//    }
//    // Función para escribir texto usando Robot
////    private static void escribirTexto(Robot robot, String texto) {
////        for (char c : texto.toCharArray()) {
////            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
////            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
////                throw new RuntimeException("No se puede escribir el carácter: " + c);
////            }
////            robot.keyPress(keyCode);
////            robot.keyRelease(keyCode);
////        }
////    }
//
//    // Función para presionar ENTER
//    public static void presionarEnter(Robot robot) {
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }
//
//    // Función para escribir " (comillas dobles)
//    private static void presionarComillasDobles(Robot robot) {
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_QUOTE);
//        robot.keyRelease(KeyEvent.VK_QUOTE);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//    }
//
//    // Función para escribir ' (comillas simples)
//    private static void presionarComillaSimple(Robot robot) {
//        robot.keyPress(KeyEvent.VK_QUOTE);
//        robot.keyRelease(KeyEvent.VK_QUOTE);
//    }

}
    }


