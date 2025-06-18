package definitions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoggerCapture {
    private static final ByteArrayOutputStream logStream = new ByteArrayOutputStream();
    private static final PrintStream logPrintStream = new PrintStream(logStream);
    private static final PrintStream originalOut = System.out;

    // Método para redirigir System.out a un String
    public static void startCapture() {
        System.setOut(logPrintStream);
    }

    // Método para detener la captura y obtener los logs
    public static String getLogs() {
        System.out.flush();
        System.setOut(originalOut); // Restaurar System.out original
        return logStream.toString();
    }
}

