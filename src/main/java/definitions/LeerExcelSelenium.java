package definitions;

//import net.masterthought.cucumber.json.Row;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class LeerExcelSelenium {
//    public static void main(String[] args) throws IOException {
//        // Leer Excel
//        FileInputStream file = new FileInputStream(new File("datos.xlsx"));
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//        Row row = sheet.getRow(1); // Primera fila de datos
//
//        String url = row.getCell(0).getStringCellValue();
//        String busqueda = row.getCell(1).getStringCellValue();
//
//        // Cerrar el Excel
//        workbook.close();
//        file.close();
//
//        // Iniciar Selenium
//        WebDriver driver = new ChromeDriver();
//        driver.get(url);
//
//        // Buscar elemento y enviar texto
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys(busqueda);
//        searchBox.submit();
//
//        System.out.println("✅ Búsqueda realizada con éxito.");
//        driver.quit();
//    }
//}