package definitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadTxtFile {
    public static String readFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return String.join("\n", lines); // Une todas las líneas en un solo String
    }
}

