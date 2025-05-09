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

    public static void escribirFechaConValorJS(String idInput, String fecha) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idInput)));

            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", input, fecha);
            // También puedes disparar un evento si la página lo necesita
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", input);

        } catch (Exception e) {
            System.out.println("❌ No se pudo establecer la fecha con JS directamente.");
            e.printStackTrace();
        }
    }

    public static void ingresoFechaFin() throws InterruptedException {
        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement btnTieneFechaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOTIENEVIGENCIAContainer\"]/div/div/span[3]")));
            Utils.enmarcarElemento(driver, btnTieneFechaTermino);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026PROMOTIENEVIGENCIAContainer\"]/div/div/span[3]"), "Click a botón Fecha Término");
            Utils.desenmarcarObjeto(driver, btnTieneFechaTermino);
            btnTieneFechaTermino.click();
        } else {
            System.out.println("ℹ️ Producto sin fecha de término");
        }
    }

    public static void seleccionarSiLaPromocionSeCanjeaEnHorarioDeterminado() throws InterruptedException {
        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("canjeaHorarioDet")))) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnCanjeHorarioDet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOTIENEHORARIOContainer\"]/div/div/span[3]")));
            Utils.enmarcarElemento(driver, btnCanjeHorarioDet);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026PROMOTIENEHORARIOContainer\"]/div/div/span[3]"), "Click a botón Horario Canjeo");
            Utils.desenmarcarObjeto(driver, btnCanjeHorarioDet);
            btnCanjeHorarioDet.click();
            Thread.sleep(1000); // Esperar a que se habiliten los campos

            WebElement txtValidaDesde = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vPROMOINICIOHORAMINUTO\"]")));
            WebElement txtValidaHasta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vPROMOTERMINOHORAMINUTO\"]")));

            Object desdeRaw = datosPromociones.get("validaDesde");
            Object hastaRaw = datosPromociones.get("validaHasta");

            if (desdeRaw != null && hastaRaw != null) {
                // Forzar con JS si sendKeys no funciona
                ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaDesde, desdeRaw.toString());
                ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaHasta, hastaRaw.toString());
            } else {
                throw new RuntimeException("❌ Faltan los valores de 'validaDesde' o 'validaHasta'");
            }
        } else {
            System.out.println("ℹ️ La promoción NO se canjea en un horario determinado");
        }
    }

    public static void deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo() throws InterruptedException {
        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnDiasDeCanjePromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div/div/span[3]")));

            Utils.enmarcarElemento(driver, btnDiasDeCanjePromo);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div/div/span[3]"), "Click a botón Seleccionar Días de Canje");
            Utils.desenmarcarObjeto(driver, btnDiasDeCanjePromo);
            btnDiasDeCanjePromo.click();
            Thread.sleep(1000);

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
            System.out.println("ℹ️ La promoción NO se canjea en días específicos");
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
        if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneUbicacion")))) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnUbicacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONAUBICACIONESContainer\"]/div/div/span[3]")));
            Utils.enmarcarElemento(driver, btnUbicacion);
            esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026PROMOSELECCIONAUBICACIONESContainer\"]/div/div/span[3]"), "Lista de Ubicaciones");
            Utils.desenmarcarObjeto(driver, btnUbicacion);
            btnUbicacion.click();

            Thread.sleep(1000); // tiempo para cargar listado

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td]")); // evita cabecera

            for (WebElement fila : filas) {
                String nombreUbicacion = fila.getText().trim();
                for (String ubicacion : ubicacionesDeseadas) {
                    if (nombreUbicacion.contains(ubicacion)) {
                        WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));

                        // Verificar si el checkbox es visible e interactuable
                        if (!checkbox.isSelected()) {
                            try {
                                // Intentar hacer clic de forma normal
                                checkbox.click();
                                System.out.println(STR."✅ Ubicación seleccionada (Normal): \{ubicacion}");
                            } catch (Exception e) {
                                // Si falla, usar JavaScript para forzar el clic
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                                System.out.println(STR."✅ Ubicación seleccionada (JavaScript): \{ubicacion}");
                            }
                        } else {
                            System.out.println(STR."ℹLa ubicación ya está seleccionada: \{ubicacion}");
                        }
                        tomarCaptura(STR."Seleccion Ubicacion: \{ubicacion}");
                    }
                }
            }
        }
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

        // Obtener todas las filas visibles
        List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td]"));

        for (WebElement fila : filas) {
            String textoFila = fila.getText().replace("_", "").trim(); // limpiar guiones bajos

            for (String categoria : categoriasDeseadas) {

                if (textoFila.equalsIgnoreCase(categoria.trim())) {
                    WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));
                    if (!checkbox.isSelected()) {
                        try {
                            // Intentar con clic normal
                            checkbox.click();
                            System.out.println(STR."✅ Categoría seleccionada (click normal): \{categoria}");
                        } catch (Exception e) {
                            // Si el click normal falla, usamos JavaScript
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                            System.out.println(STR."✅ Categoría seleccionada (click JS): \{categoria}");
                        }

                        // Verificamos si realmente está seleccionado
                        if (!checkbox.isSelected()) {
                            System.out.println(STR."❌ No se pudo seleccionar la categoría: \{categoria}");
                            tomarCaptura(STR."Error_Seleccion_Categoria_\{categoria}");
                        }
                    } else {
                        System.out.println(STR."ℹ Categoría ya estaba seleccionada: \{categoria}");
                    }
                }
            }
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

    public static void seleccionarReglaDePromocion(String criteria, double value) throws InterruptedException {
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

        //driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]")));
        Utils.enmarcarElemento(driver, btnGuardar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]"), "Seleccionar boton Finalizar");
        Utils.desenmarcarObjeto(driver, btnGuardar);
        tomarCaptura("Se Finaliza promocion");
        btnGuardar.click();
       // driver.switchTo().defaultContent();
    }




}
