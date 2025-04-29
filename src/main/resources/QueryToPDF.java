package resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class QueryToPDF {
    public static void main(String[] args) {
        try {
            // 1️⃣ Ejecutar la consulta en PostgreSQL usando ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "su", "-c",
                    "psql -d pos -tc \"select * from itemmaestro where mitemnom = 'Lentejas Listas Para Servir Esmeralda 400 Gr';\"",
                    "postgres"
            );

            Process process = processBuilder.start();

            // 2️⃣ Capturar la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            process.waitFor(); // Esperar a que termine el proceso

            // 3️⃣ Crear el PDF con el resultado de la consulta
            String outputPath = "/tmp/ResultadoConsulta.pdf";
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
//
//            document.open();
//            document.add(new Paragraph("Resultado de la consulta:"));
//            document.add(new Paragraph(result.toString()));
//            document.close();

            System.out.println("PDF generado en: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
