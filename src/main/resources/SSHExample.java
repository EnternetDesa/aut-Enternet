package resources;

import java.io.FileWriter;

//public class PuTTYAutomation {
    public class SSHExample {
    public static void main(String[] args) {
        try {
            // Comando para abrir PuTTY y ejecutar la consulta
            String command = "putty -ssh root@servidor -pw Enternet!1267 -m script.sh";

            // Crear un script temporal
            String scriptPath = "/tmp/script.sh";
            FileWriter writer = new FileWriter(scriptPath);
            writer.write("su -c \"psql -d pos -tc \\\"SELECT im.empkey EmpresaKey, im.mitemkey ItemKey, " +
                    "im.mitemnom NombreItem, im.mitempropiauniitmid_ unidad, im.mitemusalote UsaLote, " +
                    "im.mitemvendelote VendeLote, s.ubistockcod Ubicacion, s.stkacucnt Stock, s.stkval costo, " +
                    "s.lotekey LoteKey, im.mitemestado ItemEstado FROM itemmaestro im JOIN stock s ON im.empkey = s.empkey " +
                    "and im.mitemkey = s.iteminvkey where im.EmpKey = 1008 and s.ubistockcod = 'Local1' " +
                    "and im.mitemnom = 'Lentejas Listas Para Servir Esmeralda 400 Gr';\\\" postgres > /tmp/Testpsql.txt\"");
            writer.close();

            // Dar permisos de ejecución al script
            Runtime.getRuntime().exec("chmod +x " + scriptPath);

            // Ejecutar PuTTY con el script
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            System.out.println("Consulta ejecutada, revisa /tmp/Testpsql.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


