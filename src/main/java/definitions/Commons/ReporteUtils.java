package definitions.Commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReporteUtils {
    // Lista sincronizada para almacenar los tiempos
    public static List<String> tiemposDeCarga = Collections.synchronizedList(new ArrayList<>());

}
