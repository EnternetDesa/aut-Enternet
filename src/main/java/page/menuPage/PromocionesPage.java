package page.menuPage;

import definitions.Commons.BaseTest;
import definitions.Commons.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static definitions.Commons.BaseTest.*;
import static definitions.Commons.BaseTest.datosPromociones;

public class PromocionesPage {
    static WebDriver driver = BaseTest.getDriver();


    public static void visualizarHomePromociones() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtAdminPromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"APPLICATIONNAME_MPAGE\"]")));
        Utils.enmarcarElemento(driver, txtAdminPromo);
        tomarCaptura("Administrador Promociones");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"APPLICATIONNAME_MPAGE\"]"), "Administrador Promociones");
        Utils.desenmarcarObjeto(driver, txtAdminPromo);
    }
    public static void seleccionEmpresa(String nombreEmpresa) throws InterruptedException {
        Thread.sleep(2000);

        Object nombreEmpRaw = datosPromociones.get("nombEmp");
        if (nombreEmpRaw != null) {
            nombreEmpresa = nombreEmpRaw.toString();
        } else {
            throw new RuntimeException("dato 'nombEmp' no encontrado en datosPromociones");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GridempresaContainerTbl")));
        List<WebElement> filas = driver.findElements(By.xpath("//*[@id=\"GridempresaContainerTbl\"]//tr[position()>1]"));
        boolean encontrado = false;

        for (WebElement fila : filas) {
            WebElement celdaCodigoEmpresa = fila.findElement(By.xpath("./td[1]")); // columna 1

            if (celdaCodigoEmpresa.getText().trim().equalsIgnoreCase(nombreEmpresa.trim())) {
                // Buscar el enlace <a> dentro de la celda
                WebElement enlaceEmpresa = celdaCodigoEmpresa.findElement(By.xpath(".//a"));
                Utils.enmarcarElemento(driver, enlaceEmpresa);
                System.out.println(STR."✅ Enlace de la empresa encontrado: \{enlaceEmpresa.getText()}");
                tomarCaptura("Empresa encontrada");
                Utils.desenmarcarObjeto(driver, enlaceEmpresa);

                // Usar JavaScript para asegurar el clic
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", enlaceEmpresa);
                Thread.sleep(300);

                try {
                    enlaceEmpresa.click(); // Metodo directo de Selenium
                    System.out.println("✅ Click directo en el enlace.");
                } catch (Exception e) {
                    System.out.println("❌ Error al hacer click directo. Intentando con JS...");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enlaceEmpresa);
                    System.out.println("✅ Click ejecutado por JS.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(STR."❌ Empresa no encontrada: \{nombreEmpresa}");
        }
    }

    public static void validarVistaPromociones() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tblNuevaPromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LAYOUTDEFINED_GRID_INNER_GRIDPROMOTION\"]")));
        Utils.enmarcarElemento(driver, tblNuevaPromo);
        tomarCaptura("Vista promocion");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"LAYOUTDEFINED_GRID_INNER_GRIDPROMOTION\"]"), "Vista Promociones");
        Utils.desenmarcarObjeto(driver, tblNuevaPromo);
    }
    public static void seleccionarNuevaPromo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnNuevaPromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NUEVAPROMOCIONContainer\"]/div/i")));
        Utils.enmarcarElemento(driver, btnNuevaPromo);
        tomarCaptura("click Nueva promocion");
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NUEVAPROMOCIONContainer\"]/div/i"), "click nueva Promocion");
        Utils.desenmarcarObjeto(driver, btnNuevaPromo);
        btnNuevaPromo.click();
    }
    public static void ingresarNombrePromocion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String nombPromo = datosPromociones.get("nombPromo").toString();
        WebElement txtNuevaPromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vPROMODESCRIPCION\"]")));
        Utils.enmarcarElemento(driver, txtNuevaPromo);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026vPROMODESCRIPCION\"]"), "Nombre Nueva Promocion");
        Utils.desenmarcarObjeto(driver, txtNuevaPromo);
        txtNuevaPromo.sendKeys(nombPromo);
    }

    public static void escribirFechaConValorJS(String idInput, String fecha) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idInput)));

            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", input, fecha);
            // También puedes disparar un evento si la página lo necesita
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", input);
            tomarCaptura("Fecha inicio");

        } catch (Exception e) {
            System.out.println(" No se pudo establecer la fecha con JS directamente.");
            e.printStackTrace();
            tomarCaptura("Fecha inicio Failed");
        }
    }

public static void ingresoFechaFin() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement btnTieneFechaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026PROMOTIENEVIGENCIAContainer']/div/div/span[1]")));
    Utils.enmarcarElemento(driver, btnTieneFechaTermino);
    System.out.println("ℹ Verificando el estado del botón 'Tiene fecha de termino'...");

    String estadoBoton = btnTieneFechaTermino.getAttribute("class");
    System.out.println(" Estado inicial del botón: " + estadoBoton);

    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

    if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))) {
        if (!estaActivado) {
            System.out.println(" El botón está en 'OFF'. Activando...");
            btnTieneFechaTermino.click();
            Thread.sleep(1000);
        }

        String fechaFin = String.valueOf(datosPromociones.get("fechaFin"));
        System.out.println(" Ingresando fecha de término: " + fechaFin);
        escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);

    } else {
        if ("No".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))) {
            System.out.println(" La promoción NO tiene fecha de término. Desactivando...");
            btnTieneFechaTermino.click();
            Thread.sleep(500);
        }
        System.out.println("ℹ️ El botón ya está en 'OFF'. No se ingresará fecha.");
    }
}

public static void seleccionarSiLaPromocionSeCanjeaEnHorarioDeterminado() throws InterruptedException {
    if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("canjeaHorarioDet")))) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCanjeHorarioDet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026PROMOTIENEHORARIOContainer']/div/div/span[3]")));
        Utils.enmarcarElemento(driver, btnCanjeHorarioDet);
        System.out.println("ℹ️ Verificando el estado del botón 'Horario de Canjeo'...");

        // Verificar si el botón está en "ON" o "OFF" (activo o inactivo)
        String estadoBoton = btnCanjeHorarioDet.getAttribute("class"); // Clase que indica el estado (ON/OFF)
        System.out.println("🔍 Estado inicial del botón: " + estadoBoton);

        // Verificar si está activado (ON)
        boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

        if (estaActivado) {
            System.out.println("✅ El botón ya está en 'ON'. No es necesario hacer clic.");
        } else {
            System.out.println("🔧 El botón está en 'OFF'. Haciendo clic para activarlo...");
            esperarElementoYMedirTiempo(By.xpath("//*[@id='W0026PROMOTIENEHORARIOContainer']/div/div/span[3]"), "Click a botón Horario Canjeo");
            btnCanjeHorarioDet.click();
            Thread.sleep(1000); // Esperar a que se habiliten los campos
        }

        WebElement txtValidaDesde = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026vPROMOINICIOHORAMINUTO']")));
        WebElement txtValidaHasta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026vPROMOTERMINOHORAMINUTO']")));

        Object desdeRaw = datosPromociones.get("validaDesde");
        Object hastaRaw = datosPromociones.get("validaHasta");

        if (desdeRaw != null && hastaRaw != null) {
            // Forzar con JS si sendKeys no funciona
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaDesde, desdeRaw.toString());
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaHasta, hastaRaw.toString());
            System.out.println("✅ Horarios ingresados correctamente: " + desdeRaw + " - " + hastaRaw);
            tomarCaptura("Se agrega hora de Canje");
        } else {
            throw new RuntimeException("❌ Faltan los valores de 'validaDesde' o 'validaHasta'");
        }

    } else {
        // Si está en "ON" pero no debe estar, lo cambiamos a "OFF"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCanjeHorarioDet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026PROMOTIENEHORARIOContainer']/div/div/span[3]")));
        String estadoBoton = btnCanjeHorarioDet.getAttribute("class");

        if ("No".equalsIgnoreCase(String.valueOf(datosPromociones.get("canjeaHorarioDet")))) {
            System.out.println("🔧 La promoción NO debe canjearse en horario determinado. Cambiando a 'OFF'...");
            btnCanjeHorarioDet.click();
            tomarCaptura("La promo NO tiene hora de Canje");
            Thread.sleep(500);
        } else {
            System.out.println("ℹ️ El botón ya está en 'OFF'.");
        }
    }
}

//    public static void deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo() throws InterruptedException {
//        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))) {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement btnDiasDeCanjePromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div/div/span[3]")));
//
//            Utils.enmarcarElemento(driver, btnDiasDeCanjePromo);
//            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div/div/span[3]"), "Click a botón Seleccionar Días de Canje");
//            Utils.desenmarcarObjeto(driver, btnDiasDeCanjePromo);
//            btnDiasDeCanjePromo.click();
//            Thread.sleep(1000);
//
//            Object diasCanjeRaw = datosPromociones.get("diasCanje");
//            if (diasCanjeRaw != null) {
//                String diasCanje = diasCanjeRaw.toString();
//
//                if ("todos".equalsIgnoreCase(diasCanje)) {
//                    seleccionarTodosLosDias();
//                } else {
//                    List<String> dias = Arrays.stream(diasCanje.split(","))
//                            .map(String::trim)
//                            .collect(Collectors.toList());
//                    seleccionarDiasEspecificos(dias);
//                }
//            } else {
//                throw new RuntimeException("❌ No se encontró el valor 'diasCanje' en datosPromociones");
//            }
//        } else {
//            System.out.println("ℹ️ La promoción NO se canjea en días específicos");
//        }
//    }
public static void deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement btnDiasDeCanjePromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div/div/span[3]")));

    // Verificar el estado del botón (ON/OFF)
    String estadoBoton = btnDiasDeCanjePromo.getAttribute("class");
    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

    if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))) {
        if (!estaActivado) {
            // Si está en OFF y necesita estar en ON, hacemos clic para activarlo
            System.out.println("✅ Activando el botón 'Días de Canje'.");
            Utils.enmarcarElemento(driver, btnDiasDeCanjePromo);
            btnDiasDeCanjePromo.click();
            Thread.sleep(1000);
        }

        Object diasCanjeRaw = datosPromociones.get("diasCanje");
        if (diasCanjeRaw != null) {
            String diasCanje = diasCanjeRaw.toString();
            if ("todos".equalsIgnoreCase(diasCanje)) {
                seleccionarTodosLosDias();
            } else {
                List<String> dias = Arrays.stream(diasCanje.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
                seleccionarDiasEspecificos(dias);
            }
        } else {
            throw new RuntimeException("❌ No se encontró el valor 'diasCanje' en datosPromociones");
        }

    } else {
        // Si NO debe estar activado, verificamos si está ON para apagarlo
        if ("No".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))) {
            System.out.println("❌ Desactivando el botón 'Días de Canje'.");
            Utils.enmarcarElemento(driver, btnDiasDeCanjePromo);
            btnDiasDeCanjePromo.click();
            Thread.sleep(1000);
        } else {
            System.out.println("ℹ️ El botón 'Días de Canje' ya está en OFF.");
        }
    }
}

    public static void seleccionarDiasEspecificos(List<String> dias) throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"W0026COLDIASSEMANAContainer\"]/k2bt-enhancedcombo/div/div/div[1]/div"));
        dropdown.click();
        Thread.sleep(500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String dia : dias) {
            try {
                WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space()='" + dia + "']/preceding-sibling::input")));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                System.out.println(STR."✅ Día seleccionado: \{dia}");
            } catch (Exception e) {
                System.out.println(STR."❌ No se encontró o no se pudo hacer clic en el día: \{dia}");
            }
        }

        dropdown.click(); // Cierra el dropdown si es necesario
        tomarCaptura("Dias de Promocion");
    }

    public static void seleccionarTodosLosDias() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"W0026COLDIASSEMANAContainer\"]/k2bt-enhancedcombo/div/div/div[1]/div"));
        dropdown.click();
        Thread.sleep(500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement seleccionarTodos = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[contains(text(),'Seleccionar todos')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seleccionarTodos);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seleccionarTodos);
        System.out.println("✅ Todos los días seleccionados.");
        tomarCaptura("Dias de Promocion");
    }


    public static void seleccionarBtnSiguiente() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSgte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NEXT_WIZARDMAIN\"]")));
        Utils.enmarcarElemento(driver, btnSgte);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"NEXT_WIZARDMAIN\"]"), "click siguiente");
        Utils.desenmarcarObjeto(driver, btnSgte);
        tomarCaptura("click Siguiente");
        btnSgte.click();

    }

    public static void seleccionarUbicacionesParaCanje(List<String> ubicacionesDeseadas) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnUbicacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONAUBICACIONESContainer\"]/div/div/span[3]")));

        // Verificar el estado del botón (ON/OFF)
        String estadoBoton = btnUbicacion.getAttribute("class");
        boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

        // Si se desean ubicaciones específicas
        if (ubicacionesDeseadas != null && !ubicacionesDeseadas.isEmpty()) {
            // Esperar que se cargue el listado
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            // Obtener solo las filas visibles (ubicaciones)
            List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td and not(contains(@style, 'display: none'))]"));
            System.out.println(" Total de ubicaciones visibles encontradas: " + filas.size());

            // Primero deseleccionar las ubicaciones seleccionadas (solo las visibles)
            for (WebElement fila : filas) {
                try {
                    List<WebElement> checkboxes = fila.findElements(By.xpath(".//input[@type='checkbox']"));

                    if (checkboxes.size() > 0) {
                        WebElement checkbox = checkboxes.get(0);

                        // Verificar que sea visible e interactuable
                        if (checkbox.isDisplayed() || checkbox.isEnabled()) {
                            if (checkbox.isSelected()) {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                                System.out.println("❌ Deseleccionando ubicación visible: " + fila.getText().trim());
                            }
                        } else {
                            System.out.println("⚠ Checkbox encontrado pero no es interactuable.");
                        }
                    } else {
                        System.out.println("⚠ No se encontró checkbox en esta fila visible.");
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("⚠ Error al intentar deseleccionar: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("⚠ Error inesperado al deseleccionar: " + e.getMessage());
                }
            }

            // Seleccionar las ubicaciones deseadas (solo si están visibles)
            for (String ubicacion : ubicacionesDeseadas) {
                boolean ubicacionSeleccionada = false;
                for (WebElement fila : filas) {
                    String nombreUbicacion = fila.getText().trim();
                    if (nombreUbicacion.contains(ubicacion)) {
                        try {
                            WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));
                            if (!checkbox.isSelected()) {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                                System.out.println("✅ Ubicación visible seleccionada: " + ubicacion);
                                tomarCaptura("Seleccion Ubicacion: " );
                            }
                            ubicacionSeleccionada = true;
                            break; // ✅ Sale del bucle tan pronto selecciona la ubicación
                        } catch (Exception e) {
                            System.err.println("⚠ Error al seleccionar la ubicación: " + ubicacion);
                            throw e;
                        }
                    }
                }

                if (!ubicacionSeleccionada) {
                    System.err.println("❌ Ubicación no encontrada entre las visibles: " + ubicacion);
                }
            }

        } else {
            // Si no se desean ubicaciones específicas
            if (estaActivado) {
                System.out.println("❌ Desactivando el botón 'Ubicaciones'.");
                Utils.enmarcarElemento(driver, btnUbicacion);
                btnUbicacion.click();
                Thread.sleep(1000);
            } else {
                System.out.println("ℹ️ El botón 'Ubicaciones' ya está en OFF.");
            }
        }
        // ✅ Continuar con el resto del código después de salir del bucle
        System.out.println("✅ Proceso de selección de ubicaciones finalizado.");
    }

    public static void seleccionarSignoMas(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnMas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026NEWRESTRICCIONContainer\"]/div/i")));
        Utils.enmarcarElemento(driver, btnMas);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026NEWRESTRICCIONContainer\"]/div/i"), "click +");
        Utils.desenmarcarObjeto(driver, btnMas);
        btnMas.click();
    }
    public static void ingresarNombreRestriccion() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtnomRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vRESTRICTIONNOMBRE\"]")));
        Utils.enmarcarElemento(driver, txtnomRestriccion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vRESTRICTIONNOMBRE\"]"), "ingreso Nombre Restriccion");
        Utils.desenmarcarObjeto(driver, txtnomRestriccion);
        txtnomRestriccion.sendKeys(String.valueOf(datosPromociones.get("nombreRestriccion")));
        driver.switchTo().defaultContent();
    }
    public static void ingresarCantidadMinDeProductosALlevar(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCantMinProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vITEMCANTIDAD\"]")));
        Utils.enmarcarElemento(driver, txtCantMinProd);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"vITEMCANTIDAD\"]"), "Cantidad de mínima productos a llevar");
        Utils.desenmarcarObjeto(driver, txtCantMinProd);
        txtCantMinProd.clear();
        txtCantMinProd.sendKeys(String.valueOf(datosPromociones.get("cantidadMinProd")));
        driver.switchTo().defaultContent();
    }

    public static void seleccionarCategorias(List<String> categoriasDeseadas) throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar que la tabla o contenedor esté visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

        boolean categoriaEncontrada = false;

        for (String categoria : categoriasDeseadas) {
            while (true) {
                List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td]"));
                for (WebElement fila : filas) {
                    String textoFila = fila.getText().replace("_", "").trim(); // limpiar guiones bajos

                    if (textoFila.equalsIgnoreCase(categoria.trim())) {
                        WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));
                        if (!checkbox.isSelected()) {
                            try {
                                // Intentar con clic normal
                                checkbox.click();
                                System.out.println("✅ Categoría seleccionada (click normal): " + categoria);
                            } catch (Exception e) {
                                // Si el click normal falla, usamos JavaScript
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                                System.out.println("✅ Categoría seleccionada (click JS): " + categoria);
                            }
                        }
                        categoriaEncontrada = true;
                        break;
                    }
                }

                if (categoriaEncontrada) break;

                // Hacer scroll hacia abajo
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
                Thread.sleep(500);
            }

            if (!categoriaEncontrada) {
                System.out.println("❌ No se encontró la categoría: " + categoria);
            }

            categoriaEncontrada = false; // Reset para la siguiente categoría
        }

        driver.switchTo().defaultContent();
    }


    public static void seleccionarProductos( String criteria, String value) {
        try {
            System.out.println("[INFO] Iniciando selección de productos.");

            // Verificar y cambiar al frame correcto
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));
            System.out.println("[INFO] Total frames found: " + frames.size());
            driver.switchTo().frame(0);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='GridproductContainerTbl']/tbody/tr")));

            System.out.println("[INFO] Total rows found: " + rows.size());

            int selectedCount = 0;
            for (WebElement row : rows) {
                System.out.println("[DEBUG] Analizando fila...");

                String description = row.findElement(By.xpath(".//td[3]")).getText();
                String code = row.findElement(By.xpath(".//td[4]")).getText();

                System.out.println("[DEBUG] Description: " + description);
                System.out.println("[DEBUG] Code: " + code);

                if ((criteria.equalsIgnoreCase("description") && description.contains(value)) ||
                        (criteria.equalsIgnoreCase("code") && code.equals(value))) {
                    WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
                    System.out.println("[DEBUG] Checkbox visible: " + checkbox.isDisplayed());
                    System.out.println("[DEBUG] Checkbox enabled: " + checkbox.isEnabled());

                    if (!checkbox.isDisplayed()) {
                        System.out.println("[INFO] Checkbox no visible, desplazando para hacer visible.");
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                    }

                    if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                        checkbox.click();
                        System.out.println("[INFO] Checkbox seleccionado para: " + (criteria.equalsIgnoreCase("description") ? description : code));
                        selectedCount++;
                    } else {
                        System.out.println("[INFO] Intentando seleccionar checkbox usando JavaScript.");
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                        selectedCount++;
                    }
                }

                if (selectedCount >= 2) {
                    System.out.println("[INFO] Dos productos seleccionados. Deteniendo el bucle.");
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Error seleccionando productos: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
            System.out.println("[INFO] Selección de productos finalizada.");
        }

    }
    public static void seleccionarBotonGuardar() throws InterruptedException {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GUARDAR\"]")));
        Utils.enmarcarElemento(driver, btnGuardar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"GUARDAR\"]"), "Seleccionar boton guar");
        Utils.desenmarcarObjeto(driver, btnGuardar);
        tomarCaptura("Se agrega restriccion");
        btnGuardar.click();
        driver.switchTo().defaultContent();
    }

    public static void seleccionarReglaDePromocion(String criteria, int value) throws InterruptedException {
        try {
            System.out.println("[INFO] Iniciando selección de productos.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> ruleRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//tr//td[2]")));


            boolean ruleSelected = false;

            for (WebElement row : ruleRows) {
                String ruleText = row.getText().split("\n")[0].trim();
                System.out.println("[DEBUG] Regla encontrada en la página: '" + ruleText + "'");
                System.out.println("[DEBUG] Regla esperada: '" + criteria + "'");

                if (ruleText.equalsIgnoreCase(criteria.trim())) {
                    row.click();
                    System.out.println("Regla seleccionada: " + criteria);
                    ruleSelected = true;

                    // Verificar si necesita seleccionar la restricción "Prepack"
                    if (criteria.equalsIgnoreCase("Menor precio monto fijo") || criteria.equalsIgnoreCase("Menor precio")) {
                        System.out.println("Seleccionando restricción");

                        WebElement restrictionOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//*[translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')='PREPACK']")));

                        WebElement parentContainer = restrictionOption.findElement(By.xpath("./ancestor::tr | ./ancestor::div"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", parentContainer);

                        wait.until(ExpectedConditions.elementToBeClickable(restrictionOption));

                        try {
                            restrictionOption.click();
                            System.out.println("Restricción 'Prepack' aplicada.");
                        } catch (Exception e) {
                            System.out.println("[WARN] Click normal falló. Intentando con JavaScript.");
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", restrictionOption);
                            System.out.println("Restricción 'Prepack' aplicada con JavaScript.");
                        }
                    }
                    // Aplicar el descuento
                    WebElement discountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vVALORDESCUENTO\"]")));
                    discountInput.clear();
                    discountInput.sendKeys(String.valueOf(value));
                    System.out.println("Descuento aplicado: " + value + "%");

                    break; // Detener el bucle si ya encontró y seleccionó la regla
                }
            }

            if (!ruleSelected) {
                System.err.println("[ERROR] No se encontró la regla que coincide con: '" + criteria + "'");
            }

        } catch (Exception e) {
            System.err.println("[ERROR] Error aplicando regla de promoción: " + e.getMessage());
        } finally {
            tomarCaptura("Se aplica regla restricciones y descuento");
            System.out.println("[INFO] Selección de productos finalizada.");
        }
    }

    public static void validacionDeDatos(String nombrePromocion, String fechaInicio, String fechaFin, String horario, String dias, String descuento, String restriccion, String productos) {
            try {
                System.out.println("[INFO] Iniciando validación de datos de la promoción.");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Validar nombre de la promoción
                WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Nombre')]/following-sibling::div")));
                System.out.println("[INFO] Nombre: " + nombre.getText());
                validarTexto(nombre.getText(), nombrePromocion, "Nombre de la promoción");

                // Validar fechas de la promoción
                WebElement fechas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Promoción válida')]/following-sibling::div")));
                System.out.println("[INFO] Fechas: " + fechas.getText());
                validarTexto(fechas.getText(), fechaInicio + " - " + fechaFin, "Fechas de la promoción");

                // Validar horario de canje
                WebElement horarioCanje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Horario de canje')]/following-sibling::div")));
                System.out.println("[INFO] Horario: " + horarioCanje.getText());
                validarTexto(horarioCanje.getText(), horario, "Horario de canje");

                // Validar días de canje
                WebElement diasCanje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Días de canje')]/following-sibling::div")));
                System.out.println("[INFO] Días: " + diasCanje.getText());
                validarTexto(diasCanje.getText(), dias, "Días de canje");

                // Validar descuento a realizar
                WebElement descuentoRealizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Descuento a realizar')]/following-sibling::div")));
                System.out.println("[INFO] Descuento: " + descuentoRealizar.getText());
                validarTexto(descuentoRealizar.getText(), descuento, "Descuento a realizar");

                // Validar nombre de la restricción
                WebElement nombreRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[1]")));
                System.out.println("[INFO] Restricción: " + nombreRestriccion.getText());
                validarTexto(nombreRestriccion.getText(), restriccion, "Restricción");

                // Validar productos de la restricción
                WebElement productosRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[3]")));
                System.out.println("[INFO] Productos: " + productosRestriccion.getText());
                validarTexto(productosRestriccion.getText(), productos, "Productos");

                System.out.println("[INFO] Validación de datos de la promoción completada.");

            } catch (Exception e) {
                System.err.println("[ERROR] Error validando datos de la promoción: " + e.getMessage());
            }
    }

// Metodo para comparar texto y mostrar si coinciden o no
    private static void validarTexto(String textoActual, String textoEsperado, String campo) {
         if (textoActual.trim().equalsIgnoreCase(textoEsperado.trim())) {
              System.out.println("[SUCCESS] El " + campo + " es correcto: " + textoActual);
         } else {
              System.err.println("[FAIL] El " + campo + " es incorrecto. Esperado: '" + textoEsperado + "', Actual: '" + textoActual + "'");
         }
    }


    public static void seleccionarBtnFinalizar() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]")));
        Utils.enmarcarElemento(driver, btnGuardar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]"), "Seleccionar boton Finalizar");
        Utils.desenmarcarObjeto(driver, btnGuardar);
        tomarCaptura("Se Finaliza promocion");
        btnGuardar.click();
    }
    private static String mensajeCapturado = ""; // Variable global para guardar el mensaje capturado

    public static void capturarMensajePantalla(String xpathMensaje) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement mensajeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathMensaje)));
            mensajeCapturado = mensajeElemento.getText().trim();
            System.out.println("[INFO] Mensaje capturado: " + mensajeCapturado);
        } catch (Exception e) {
            System.err.println("[ERROR] No se pudo capturar el mensaje de pantalla: " + e.getMessage());
            mensajeCapturado = "";
        }
    }

    // Metodo para obtener el mensaje capturado
    public static String obtenerMensajeCapturado() {
        return mensajeCapturado;
    }


    public static boolean buscarYEnmarcarPromocion(String nombrePromocion) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr//td[3]")));

            for (WebElement promo : promociones) {
                String nombreActual = promo.getText().trim();
                System.out.println("[DEBUG] Promoción encontrada: " + nombreActual);

                if (nombreActual.contains(nombrePromocion)) {
                    // Utiliza el metodo Utils para enmarcar el elemento
                    Utils.enmarcarElemento(driver, promo);
                    tomarCaptura("Promocion Encontrada");
                    driver.switchTo().defaultContent();
                    return true;
                }

                // Intentar hacer scroll para buscar más promociones
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promo);
                Thread.sleep(500);
            }

            System.err.println("[ERROR] Promoción '" + nombrePromocion + "' no encontrada.");
            return false;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al buscar y enmarcar la promoción: " + e.getMessage());
            return false;
        }
    }
    public static boolean editarPromocion(String nombrePromocion) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Verificar si hay un iframe y cambiar a él
            if (driver.findElements(By.tagName("iframe")).size() > 0) {
                driver.switchTo().frame(0);
                System.out.println("[INFO] Cambiado al iframe para editar la promoción.");
            }

            // Esperar que la tabla esté visible y cargada
            WebElement tabla = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", tabla);
            System.out.println("Tabla de promociones encontrada.");

            // Obtener todas las filas visibles
            List<WebElement> filas = tabla.findElements(By.xpath(".//tr[td]"));
            System.out.println("[DEBUG] Total de filas encontradas: " + filas.size());

            boolean encontrado = false;
            for (WebElement fila : filas) {
                String textoFila = fila.getText().trim();
                System.out.println("Contenido de la fila: " + textoFila);

                if (textoFila.contains(nombrePromocion)) {
                    // Enmarcar la fila para asegurarnos de que es la correcta
                    Utils.enmarcarElemento(driver, fila);
                    System.out.println("Promoción '" + nombrePromocion + "' encontrada.");
                    Utils.desenmarcarObjeto(driver, fila);

                    // Buscar el botón de editar (ícono de lápiz) dentro de la misma fila
                    WebElement botonEditar = fila.findElement(By.xpath(".//td[15]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", botonEditar);
                    Utils.enmarcarElemento(driver, botonEditar);
                    esperarElementoYMedirTiempo(By.xpath(".//td[15]"), "click editar promocion");
                    botonEditar.click();
                   // Utils.desenmarcarObjeto(driver, fila);
                    System.out.println("[INFO] Se hizo clic en el botón de editar.");


                    // Esperar a que la página de edición se cargue
                    WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vPROMODESCRIPCION\"]")));
                    inputNombre.clear();
                    inputNombre.sendKeys(datosPromociones.get("nombPromoEditado")+"");
                    tomarCaptura("edicion de promocion");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.err.println("[ERROR] No se encontró la promoción: " + nombrePromocion);
            }

            // Salir del iframe si estábamos dentro de uno
            driver.switchTo().defaultContent();
            return encontrado;

        } catch (Exception e) {
            System.err.println("[ERROR] Error al editar la promoción: " + e.getMessage());
            return false;
        }
    }






    public static boolean eliminarPromocion(String nombrePromocion) {
        driver.switchTo().frame(0);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr")));

            for (WebElement promo : promociones) {
                String nombreActual = promo.findElement(By.xpath(".//td[1]")).getText().trim();
                if (nombreActual.equalsIgnoreCase(nombrePromocion)) {
                    WebElement btnEliminar = promo.findElement(By.xpath(".//td//i[contains(@class, 'fa-trash')]"));
                    Utils.enmarcarElemento(driver, btnEliminar);
                    btnEliminar.click();
                    System.out.println("[INFO] Promoción '" + nombrePromocion + "' seleccionada para eliminar.");

                    // Confirmar eliminación si aparece una ventana emergente
                    WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    popupWait.until(ExpectedConditions.alertIsPresent());
                    driver.switchTo().alert().accept();
                    System.out.println("[INFO] Promoción eliminada.");
                    return true;
                }
            }
            System.err.println("[ERROR] No se encontró la promoción para eliminar: " + nombrePromocion);
            return false;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al intentar eliminar la promoción: " + e.getMessage());
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }
    public static boolean copiarPromocion(String nombrePromocion) {
        driver.switchTo().frame(0);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr")));

            for (WebElement promo : promociones) {
                String nombreActual = promo.findElement(By.xpath(".//td[1]")).getText().trim();
                if (nombreActual.equalsIgnoreCase(nombrePromocion)) {
                    WebElement btnCopiar = promo.findElement(By.xpath(".//td//i[contains(@class, 'fa-copy')]"));
                    Utils.enmarcarElemento(driver, btnCopiar);
                    btnCopiar.click();
                    System.out.println("[INFO] Promoción '" + nombrePromocion + "' seleccionada para copiar.");
                    return true;
                }
            }
            System.err.println("[ERROR] No se encontró la promoción para copiar: " + nombrePromocion);
            return false;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al intentar copiar la promoción: " + e.getMessage());
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }
    public static boolean verPromocion(String nombrePromocion) {
        driver.switchTo().frame(0);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr")));

            for (WebElement promo : promociones) {
                String nombreActual = promo.findElement(By.xpath(".//td[1]")).getText().trim();
                if (nombreActual.equalsIgnoreCase(nombrePromocion)) {
                    WebElement btnVer = promo.findElement(By.xpath(".//td//i[contains(@class, 'fa-eye')]"));
                    Utils.enmarcarElemento(driver, btnVer);
                    btnVer.click();
                    System.out.println("[INFO] Promoción '" + nombrePromocion + "' seleccionada para ver.");
                    return true;
                }
            }
            System.err.println("[ERROR] No se encontró la promoción para ver: " + nombrePromocion);
            return false;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al intentar ver la promoción: " + e.getMessage());
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }
    public static void probarAccionesPromocion(String nombrePromocion) {
        System.out.println("===== INICIO PRUEBA DE ACCIONES PARA LA PROMOCIÓN: " + nombrePromocion + " =====");

        // Probar Editar
        if (editarPromocion(nombrePromocion)) {
            System.out.println("✅ Prueba de Edición: ÉXITO.");
            // Puedes agregar aquí pasos para modificar algún dato y guardar, si deseas.
        } else {
            System.err.println("❌ Prueba de Edición: FALLIDA.");
        }

        // Probar Copiar
        if (copiarPromocion(nombrePromocion)) {
            System.out.println("✅ Prueba de Copiar: ÉXITO.");
            // Puedes agregar pasos para validar que la copia se realizó correctamente.
        } else {
            System.err.println("❌ Prueba de Copiar: FALLIDA.");
        }

        // Probar Ver
        if (verPromocion(nombrePromocion)) {
            System.out.println("✅ Prueba de Ver: ÉXITO.");
            // Puedes agregar validaciones para confirmar que la información se ve correctamente.
            driver.navigate().back(); // Regresar a la lista después de ver
        } else {
            System.err.println("❌ Prueba de Ver: FALLIDA.");
        }

        // Probar Eliminar
        if (eliminarPromocion(nombrePromocion)) {
            System.out.println("✅ Prueba de Eliminación: ÉXITO.");
            // Confirmar que ya no aparece en la lista
            if (!buscarPromocionEnLista(nombrePromocion)) {
                System.out.println("✅ Confirmación de Eliminación: La promoción no aparece en la lista.");
            } else {
                System.err.println("❌ Confirmación de Eliminación: La promoción aún aparece en la lista.");
            }
        } else {
            System.err.println("❌ Prueba de Eliminación: FALLIDA.");
        }

        System.out.println("===== FIN PRUEBA DE ACCIONES PARA LA PROMOCIÓN: " + nombrePromocion + " =====");
    }
    public static boolean buscarPromocionEnLista(String nombrePromocion) {
        driver.switchTo().frame(0);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr")));

            for (WebElement promo : promociones) {
                String nombreActual = promo.findElement(By.xpath(".//td[1]")).getText().trim();
                if (nombreActual.equalsIgnoreCase(nombrePromocion)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al buscar la promoción: " + e.getMessage());
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }















}
