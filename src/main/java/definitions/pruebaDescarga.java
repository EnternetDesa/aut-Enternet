package definitions;

public class pruebaDescarga {

    public static void main(String[] args) {
        // Ruta de la carpeta de descargas (ajústala según tu sistema)
        String carpetaDescargas = "C:/Users/alexi/Downloads/";
        String nombreArchivo = "BaseMaestra_1008.csv";
        String rutaArchivo = carpetaDescargas + nombreArchivo;

        // Configurar WebDriver (Chrome en este caso)
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.ejemplo.com/descarga"); // Reemplaza con la URL de la descarga

        // Click en el botón de descarga
//        driver.findElement(By.id("btnDescargar")).click();

        // Esperar que el archivo se descargue
        //boolean archivoDescargado = verificarArchivo.esperarArchivoDescarga(rutaArchivo, 20);
        boolean archivoDescargado = verificarArchivo.existeArchivo(rutaArchivo, 20);

        if (archivoDescargado) {
            System.out.println("✅ Archivo descargado correctamente.");
        } else {
            System.out.println("❌ Error: El archivo no se descargó.");
        }

       // driver.quit();
    }
}
