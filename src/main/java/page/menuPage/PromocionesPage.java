package page.menuPage;

import definitions.Commons.BaseTest;
import definitions.Commons.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
    WebElement btnTieneFechaTermino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026PROMOTIENEVIGENCIAContainer']/div/div")));
   // Utils.enmarcarElemento(driver, btnTieneFechaTermino);
    System.out.println("ℹ Verificando el estado del botón 'Tiene fecha de termino'...");

    String estadoBoton = btnTieneFechaTermino.getAttribute("class");
    System.out.println(" Estado inicial del botón: " + estadoBoton);

    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");
   // boolean estaActivado = estadoBoton.contains("bootstrap-switch-handle-on bootstrap-switch-success on") || estadoBoton.contains("active");

    if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))) {
        if (!estaActivado) {
            System.out.println(" El botón está en 'OFF'. Activando...");
            btnTieneFechaTermino.click();
            Thread.sleep(1000);
         //   Utils.desenmarcarObjeto(driver, btnTieneFechaTermino);
        }

        String fechaFin = String.valueOf(datosPromociones.get("fechaFin"));
        System.out.println(" Ingresando fecha de término: " + fechaFin);
        escribirFechaConValorJS("W0026vPROMOVIGENCIATERMINOFECHA", fechaFin);


    } else if ("No".equalsIgnoreCase(String.valueOf(datosPromociones.get("tieneFechaFin")))) {
        if (estaActivado) {
            System.out.println(" El botón está en 'ON'. Desactivando...");
            btnTieneFechaTermino.click();
            Thread.sleep(500);
        } else {
            System.out.println(" El botón ya está en 'OFF'. No se ingresará fecha.");
        }
    }
}

public static void seleccionarSiLaPromocionSeCanjeaEnHorarioDeterminado() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement btnCanjeHorarioDet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026PROMOTIENEHORARIOContainer']/div/div")));
    System.out.println("ℹVerificando el estado del botón 'Horario de Canjeo'...");
    String estadoBoton = btnCanjeHorarioDet.getAttribute("class");
    System.out.println("Estado inicial del botón: " + estadoBoton);

    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

    String valorCanjeaHorarioDet = String.valueOf(datosPromociones.get("canjeaHorarioDet"));

    if ("Si".equalsIgnoreCase(valorCanjeaHorarioDet)) {
        // Si debe estar activado y no lo está, activarlo
        if (!estaActivado) {
            System.out.println("El botón está en 'OFF'. Haciendo clic para activarlo...");
            btnCanjeHorarioDet.click();
            Thread.sleep(1000);
        } else {
            System.out.println("✅ El botón ya está en 'ON'. No es necesario hacer clic.");
        }

        // Ingresar horarios
        WebElement txtValidaDesde = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026vPROMOINICIOHORAMINUTO']")));
        WebElement txtValidaHasta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026vPROMOTERMINOHORAMINUTO']")));

        Object desdeRaw = datosPromociones.get("validaDesde");
        Object hastaRaw = datosPromociones.get("validaHasta");

        if (desdeRaw != null && hastaRaw != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaDesde, desdeRaw.toString());
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", txtValidaHasta, hastaRaw.toString());
            System.out.println("✅ Horarios ingresados correctamente: " + desdeRaw + " - " + hastaRaw);
            tomarCaptura("Se agrega hora de Canje");
        } else {
            throw new RuntimeException("Faltan los valores de 'validaDesde' o 'validaHasta'");
        }

    } else if ("No".equalsIgnoreCase(valorCanjeaHorarioDet)) {
        // Si NO debe estar activado y está activado, apagarlo
        if (estaActivado) {
            System.out.println("🔧 La promoción NO debe canjearse en horario determinado. Cambiando a 'OFF'...");
            btnCanjeHorarioDet.click();
            tomarCaptura("La promo NO tiene hora de Canje");
            Thread.sleep(500);
        } else {
            System.out.println("ℹ️ El botón ya está en 'OFF'. No es necesario hacer clic.");
        }
    } else {
        System.out.println("⚠️ Valor desconocido para 'canjeaHorarioDet': " + valorCanjeaHorarioDet);
    }
}


    public static void deseaSeleccionarDiasEnEspecificosEnLosQueSeaCanjeableLaPromo() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement btnDiasDeCanjePromo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONADIASContainer\"]/div")));

    // Verificar el estado del botón (ON/OFF)
    String estadoBoton = btnDiasDeCanjePromo.getAttribute("class");
    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");
    System.out.println(" Estado inicial del botón 'Días de Canje': " + (estaActivado ? "ON" : "OFF"));

    if ("Si".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))) {
        if (!estaActivado) {
//            System.out.println("✅ Activando el botón 'Días de Canje'.");
            try {
//                Utils.enmarcarElemento(driver, btnDiasDeCanjePromo);
                btnDiasDeCanjePromo.click();
//                Utils.desenmarcarObjeto(driver, btnDiasDeCanjePromo);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("⚠ Click normal falló. Intentando con JavaScript.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnDiasDeCanjePromo);
                Thread.sleep(1000);
            }
        }

        Object diasCanjeRaw = datosPromociones.get("diasCanje");
        if (diasCanjeRaw != null) {
            String diasCanje = diasCanjeRaw.toString().trim();
            System.out.println("📅 Días especificados: " + diasCanje);

            if ("todos".equalsIgnoreCase(diasCanje)) {
                seleccionarTodosLosDias();
            } else {
                List<String> diasDeseados = Arrays.stream(diasCanje.split(",")).map(String::trim).collect(Collectors.toList());
                seleccionarDiasEspecificos(diasDeseados);
            }
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("document.body.click();");

        } else {
            throw new RuntimeException("❌ No se encontró el valor 'diasCanje' en datosPromociones");
        }
    } else if ("No".equalsIgnoreCase(String.valueOf(datosPromociones.get("diasDeCanjePromo")))){
        if (estaActivado) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnDiasDeCanjePromo);
            System.out.println("❌ Desactivando el botón 'Días de Canje'.");
            btnDiasDeCanjePromo.click();
            Thread.sleep(1000);
        } else {
            System.out.println("ℹ️ El botón 'Días de Canje' ya está en OFF.");
        }
    }
}

    public static void seleccionarTodosLosDias() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='W0026COLDIASSEMANAContainer']/k2bt-enhancedcombo/div/div/div[1]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement seleccionarTodos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Seleccionar todos')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seleccionarTodos);
        System.out.println("✅ Todos los días seleccionados.");
        tomarCaptura("Dias de Promocion");
    }

    public static void seleccionarDiasEspecificos(List<String> diasDeseados) throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='W0026COLDIASSEMANAContainer']/k2bt-enhancedcombo/div/div/div[1]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuDias = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='W0026COLDIASSEMANAContainer']/k2bt-enhancedcombo/div/div/div[2]/div[2]")));

        // Mapa para días y sus checkboxes
        Map<String, WebElement> diasMap = new HashMap<>();

        List<WebElement> labels = menuDias.findElements(By.xpath(".//label"));
        for (WebElement label : labels) {
            try {
                String labelText = label.getText().trim();
                WebElement checkbox = label.findElement(By.xpath("./preceding-sibling::input[@type='checkbox']"));
                diasMap.put(labelText, checkbox);
            } catch (Exception e) {
                System.err.println("⚠ No se pudo procesar el día: " + e.getMessage());
            }
        }

        // Seleccionar o desmarcar según corresponda
        for (Map.Entry<String, WebElement> entry : diasMap.entrySet()) {
            String dia = entry.getKey();
            WebElement checkbox = entry.getValue();
            boolean estaSeleccionado = checkbox.isSelected();

            if (diasDeseados.contains(dia) && !estaSeleccionado) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                System.out.println("✅ Día seleccionado: " + dia);
            } else if (!diasDeseados.contains(dia) && estaSeleccionado) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                System.out.println("❌ Día desmarcado: " + dia);
            }
        }

        // Cerrar menú desplegable
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
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

//    public static void seleccionarUbicacionesParaCanje(List<String> ubicacionesDeseadas) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement btnUbicacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026PROMOSELECCIONAUBICACIONESContainer\"]/div/div")));
//
//        // Verificar el estado del botón (ON/OFF)
//        String estadoBoton = btnUbicacion.getAttribute("class");
//        boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");
//
//        // Si se desean ubicaciones específicas
//        if (ubicacionesDeseadas != null && !ubicacionesDeseadas.isEmpty()) {
//            // Esperar que se cargue el listado
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//
//            // Obtener solo las filas visibles (ubicaciones)
//            List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td and not(contains(@style, 'display: none'))]"));
//            System.out.println(" Total de ubicaciones visibles encontradas: " + filas.size());
//
//            // Primero deseleccionar las ubicaciones seleccionadas (solo las visibles)
//            for (WebElement fila : filas) {
//                try {
//                    List<WebElement> checkboxes = fila.findElements(By.xpath(".//input[@type='checkbox']"));
//
//                    if (checkboxes.size() > 0) {
//                        WebElement checkbox = checkboxes.get(0);
//
//                        // Verificar que sea visible e interactuable
//                        if (checkbox.isDisplayed() || checkbox.isEnabled()) {
//                            if (checkbox.isSelected()) {
//                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
//                                System.out.println("Deseleccionando ubicación visible: " + fila.getText().trim());
//                            }
//                        } else {
//                            System.out.println("⚠ Checkbox encontrado pero no es interactuable.");
//                        }
//                    } else {
//                        System.out.println("⚠ No se encontró checkbox en esta fila visible.");
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println("⚠ Error al intentar deseleccionar: " + e.getMessage());
//                } catch (Exception e) {
//                    System.out.println("⚠ Error inesperado al deseleccionar: " + e.getMessage());
//                }
//            }
//
//            // Seleccionar las ubicaciones deseadas (solo si están visibles)
//            for (String ubicacion : ubicacionesDeseadas) {
//                boolean ubicacionSeleccionada = false;
//                for (WebElement fila : filas) {
//                    String nombreUbicacion = fila.getText().trim();
//                    if (nombreUbicacion.contains(ubicacion)) {
//                        try {
//                            WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));
//                            if (!checkbox.isSelected()) {
//                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
//                                System.out.println("✅ Ubicación visible seleccionada: " + ubicacion);
//                                tomarCaptura("Seleccion Ubicacion: " );
//                            }
//                            ubicacionSeleccionada = true;
//                            break; // ✅ Sale del bucle tan pronto selecciona la ubicación
//                        } catch (Exception e) {
//                            System.err.println("⚠ Error al seleccionar la ubicación: " + ubicacion);
//                            throw e;
//                        }
//                    }
//                }
//
//                if (!ubicacionSeleccionada) {
//                    System.err.println("❌ Ubicación no encontrada entre las visibles: " + ubicacion);
//                }
//            }
//
//        } else {
//            // Si no se desean ubicaciones específicas
//            if (estaActivado) {
//                System.out.println("❌ Desactivando el botón 'Ubicaciones'.");
//                Utils.enmarcarElemento(driver, btnUbicacion);
//                btnUbicacion.click();
//                Thread.sleep(1000);
//            } else {
//                System.out.println("ℹ️ El botón 'Ubicaciones' ya está en OFF.");
//            }
//        }
//        // ✅ Continuar con el resto del código después de salir del bucle
//        System.out.println("✅ Proceso de selección de ubicaciones finalizado.");
//    }
public static void clickElementoRobusto(By locator) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    try {
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elemento);
        Thread.sleep(500);

        try {
            elemento.click();
            System.out.println("✅ Click realizado con método normal en: " + locator.toString());
        } catch (Exception e) {
            System.out.println("⚠ Click normal falló en: " + locator.toString() + ". Intentando con JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
            System.out.println("✅ Click realizado con JavaScript en: " + locator.toString());
        }
    } catch (TimeoutException e) {
        System.err.println("❌ No se encontró o no es clickeable el elemento: " + locator.toString());
        throw e;
    }
}


//
public static void seleccionarUbicacionesParaCanje(List<String> ubicacionesDeseadas, boolean deseaDeseleccionar) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    By btnUbicacionLocator = By.xpath("//*[@id=\"W0026PROMOSELECCIONAUBICACIONESContainer\"]/div/div");

    // Hacer click en el botón para activar el listado de ubicaciones
    clickElementoRobusto(btnUbicacionLocator);
    Thread.sleep(1000); // esperar a que cargue el listado

    // Obtener el estado del botón
    WebElement btnUbicacion = driver.findElement(btnUbicacionLocator);
    String estadoBoton = btnUbicacion.getAttribute("class");
    boolean estaActivado = estadoBoton.contains("toggle-on") || estadoBoton.contains("active");

    if (ubicacionesDeseadas != null && !ubicacionesDeseadas.isEmpty()) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

        List<WebElement> filas = driver.findElements(By.xpath("//table//tr[td and not(contains(@style, 'display: none'))]"));
        System.out.println(" Total de ubicaciones visibles encontradas: " + filas.size());

        // Solo deselecciona si así se indicó
        if (deseaDeseleccionar) {
            for (WebElement fila : filas) {
                try {
                    WebElement checkbox = fila.findElement(By.xpath(".//input[@type='checkbox']"));
                    if (checkbox.isDisplayed() && checkbox.isEnabled() && checkbox.isSelected()) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                        System.out.println("Deseleccionando ubicación visible: " + fila.getText().trim());
                    }
                } catch (Exception e) {
                    System.out.println("⚠ Error al intentar deseleccionar: " + e.getMessage());
                }
            }
        }

        // Seleccionar las ubicaciones deseadas
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
                        }
                        ubicacionSeleccionada = true;
                        break;
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
            clickElementoRobusto(btnUbicacionLocator);
            Thread.sleep(1000);
        } else {
            System.out.println("ℹ️ El botón 'Ubicaciones' ya está en OFF.");
        }
    }
    //tomarCaptura("Seleccion Ubicacion: ");
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
        txtnomRestriccion.clear();
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
                                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
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


//    public static void seleccionarProductos( String criteria, String value) {
//        try {
//            System.out.println("Iniciando selección de productos.");
//
//            // Verificar y cambiar al frame correcto
//            List<WebElement> frames = driver.findElements(By.tagName("iframe"));
//            System.out.println("Total frames found: " + frames.size());
//            driver.switchTo().frame(0);
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='GridproductContainerTbl']/tbody/tr")));
//
//            System.out.println("Total rows found: " + rows.size());
//
//            int selectedCount = 0;
//            for (WebElement row : rows) {
//                System.out.println("Analizando fila...");
//
//                String description = row.findElement(By.xpath(".//td[3]")).getText();
//                String code = row.findElement(By.xpath(".//td[4]")).getText();
//
//                System.out.println("Description: " + description);
//                System.out.println("Code: " + code);
//
//                if ((criteria.equalsIgnoreCase("description") && description.contains(value)) ||
//                        (criteria.equalsIgnoreCase("code") && code.equals(value))) {
//                    WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
//                    System.out.println("Checkbox visible: " + checkbox.isDisplayed());
//                    System.out.println("Checkbox enabled: " + checkbox.isEnabled());
//
//                    if (!checkbox.isDisplayed()) {
//                        System.out.println("Checkbox no visible, desplazando para hacer visible.");
//                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
//                    }
//
//                    if (checkbox.isDisplayed() && checkbox.isEnabled()) {
//                        checkbox.click();
//                        System.out.println("Checkbox seleccionado para: " + (criteria.equalsIgnoreCase("description") ? description : code));
//                        selectedCount++;
//                    } else {
//                        System.out.println("Intentando seleccionar checkbox usando JavaScript.");
//                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
//                        selectedCount++;
//                    }
//                }
//
//                if (selectedCount >= 2) {
//                    System.out.println("Dos productos seleccionados. Deteniendo el bucle.");
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error seleccionando productos: " + e.getMessage());
//        } finally {
//            driver.switchTo().defaultContent();
//            System.out.println("Selección de productos finalizada.");
//        }
//
//    }
public static void seleccionarProductos(String criteria, String value, int cantidadProductos) {
    try {
        System.out.println("Iniciando selección de productos.");

        // Verificar y cambiar al frame correcto
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total frames found: " + frames.size());
        driver.switchTo().frame(0);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='GridproductContainerTbl']/tbody/tr")));

        System.out.println("Total rows found: " + rows.size());

        int selectedCount = 0;
        for (WebElement row : rows) {
            System.out.println("Analizando fila...");

            String description = row.findElement(By.xpath(".//td[3]")).getText();
            String code = row.findElement(By.xpath(".//td[4]")).getText();

            System.out.println("Description: " + description);
            System.out.println("Code: " + code);

            if ((criteria.equalsIgnoreCase("description") && description.contains(value)) ||
                    (criteria.equalsIgnoreCase("code") && code.equals(value))) {
                WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));

                // Verificar si el checkbox es visible y seleccionable
                if (!checkbox.isDisplayed()) {
                    System.out.println("Checkbox no visible, desplazando para hacer visible.");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                }

                if (checkbox.isDisplayed() && checkbox.isEnabled() && !checkbox.isSelected()) {
                    checkbox.click();
                    System.out.println("✅ Checkbox seleccionado para: " + (criteria.equalsIgnoreCase("description") ? description : code));
                    selectedCount++;
                } else if (!checkbox.isSelected()) {
                    System.out.println("Intentando seleccionar checkbox usando JavaScript.");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    selectedCount++;
                } else {
                    System.out.println("ℹ️ El producto ya estaba seleccionado.");
                }

                if (selectedCount >= cantidadProductos) {
                    System.out.println("✅ Se han seleccionado " + selectedCount + " productos. Deteniendo el bucle.");
                    break;
                }
            }
        }

        if (selectedCount == 0) {
            System.out.println("⚠ No se encontraron productos que coincidan con el criterio.");
        }

    } catch (Exception e) {
        System.err.println("❌ Error seleccionando productos: " + e.getMessage());
    } finally {
        driver.switchTo().defaultContent();
        System.out.println("✅ Selección de productos finalizada.");
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnGuardar);
        btnGuardar.click();
        driver.switchTo().defaultContent();

    }

    public static void seleccionarReglaDePromocion(String criteria, String nombreRestriccion, int value) throws InterruptedException {
        Thread.sleep(2000);
        try {
            System.out.println("Iniciando selección de productos.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            List<WebElement> ruleRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//tr//td[2]")));

            boolean ruleSelected = false;

            for (WebElement row : ruleRows) {
                String ruleText = row.getText().split("\n")[0].trim();
                System.out.println("Regla encontrada en la página: '" + ruleText + "'");
                System.out.println("Regla esperada: '" + criteria + "'");

                if (ruleText.equalsIgnoreCase(criteria.trim())) {
                    row.click();
                    System.out.println("Regla seleccionada: " + criteria);
                    ruleSelected = true;

                    // Verificar si necesita seleccionar la restricción "Prepack"
                    if (criteria.equalsIgnoreCase("Menor precio monto fijo") || criteria.equalsIgnoreCase("Menor precio")) {
                        System.out.println("Seleccionando restricción");

                        WebElement restrictionOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//*[translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')='" + nombreRestriccion.toUpperCase() + "']")));

                        WebElement parentContainer = restrictionOption.findElement(By.xpath("./ancestor::tr | ./ancestor::div"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", restrictionOption);

                        wait.until(ExpectedConditions.elementToBeClickable(restrictionOption));

                        try {
                            restrictionOption.click();
                            System.out.println("Restricción '" + nombreRestriccion + "' aplicada.");
                        } catch (Exception e) {
                            System.out.println("[WARN] Click normal falló. Intentando con JavaScript.");
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", restrictionOption);
                            System.out.println("Restricción '" + nombreRestriccion + "' aplicada con JavaScript.");
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

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

              //  WebElement nombreRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[1]")));
                WebElement nombreRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0026vCATEGORIAS_0001\"]")));
                System.out.println("[INFO] Restricción Categorias: " + nombreRestriccion.getText());
                validarTexto(nombreRestriccion.getText(), restriccion, "Restricción");

                // Validar productos de la restricción

//                WebElement productosRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr/td[3]")));
                WebElement productosRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"span_W0026vPRODUCTOS_0001\"]")));
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnFinalizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]")));
        Utils.enmarcarElemento(driver, btnFinalizar);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"FINISH_WIZARDMAIN\"]"), "Seleccionar boton Finalizar");
        Utils.desenmarcarObjeto(driver, btnFinalizar);
        tomarCaptura("Se Finaliza promocion");
        btnFinalizar.click();
    }
    private static String mensajeCapturado = ""; // Variable global para guardar el mensaje capturado

    public static String capturarMensajePantalla(String xpathMensaje) {
         String mensaje = "";
         try {
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
               WebElement mensajeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathMensaje)));
               mensaje = mensajeElemento.getText().trim();
               System.out.println("📩 Mensaje capturado: " + mensaje);
         } catch (Exception e) {
               System.err.println("❌ No se pudo capturar el mensaje: " + e.getMessage());
         }
           return mensaje;

    }

    public static String capturarMensajePantallaDesdeFrame(String xpathMensaje, int frameIndex) {
        String mensaje = "";
        try {
            driver.switchTo().frame(frameIndex);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement mensajeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathMensaje)));
            mensaje = mensajeElemento.getText().trim();
            System.out.println("📩 Mensaje capturado desde frame " + frameIndex + ": " + mensaje);
        } catch (Exception e) {
            System.err.println("❌ No se pudo capturar el mensaje desde frame " + frameIndex + ": " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
        }
        return mensaje;
    }


    // Metodo para obtener el mensaje capturado
    public static String obtenerMensajeCapturado() {
        return mensajeCapturado;
    }

    public static boolean buscarYEnmarcarPromocion(String nombrePromocion) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

                if (textoFila.equalsIgnoreCase(nombrePromocion)){
//                if (textoFila.contains(nombrePromocion)) {
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
                    WebElement btnAnular = fila.findElement(By.xpath(".//td[16]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnAnular);
                    Utils.enmarcarElemento(driver, btnAnular);
                    esperarElementoYMedirTiempo(By.xpath(".//td[16]"), " anular promocion");
                    btnAnular.click();
                    // Utils.desenmarcarObjeto(driver, fila);
                    System.out.println("[INFO] Se hizo clic en el botón de eliminar.");
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
            System.err.println("[ERROR] Error al eliminar promoción: " + e.getMessage());
            return false;
        }
    }
    public static boolean copiarPromocion(String nombrePromocion) {

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
                    WebElement btnCopiar = fila.findElement(By.xpath(".//td[14]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnCopiar);
                    Utils.enmarcarElemento(driver, btnCopiar);
                    esperarElementoYMedirTiempo(By.xpath(".//td[14]"), "click copiar promocion");
                    btnCopiar.click();
                    // Utils.desenmarcarObjeto(driver, fila);
                    System.out.println("[INFO] Se hizo clic en el botón de copiar.");

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
            System.err.println("[ERROR] Error al copiar la promoción: " + e.getMessage());
            return false;
        }
    }
    public static boolean verPromocion(String nombrePromocion) {
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            List<WebElement> promociones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr")));
//
//            for (WebElement promo : promociones) {
//                String nombreActual = promo.findElement(By.xpath(".//td[17]")).getText().trim();
//                if (nombreActual.equalsIgnoreCase(nombrePromocion)) {
//                    WebElement btnVer = promo.findElement(By.xpath(".//td//i[contains(@class, 'fa-eye')]"));
//                    Utils.enmarcarElemento(driver, btnVer);
//                    btnVer.click();
//                    System.out.println("[INFO] Promoción '" + nombrePromocion + "' seleccionada para ver.");
//                    return true;
//                }
//            }
//            System.err.println("[ERROR] No se encontró la promoción para ver: " + nombrePromocion);
//            return false;
//        } catch (Exception e) {
//            System.err.println("[ERROR] Error al intentar ver la promoción: " + e.getMessage());
//            return false;
//        } finally {
//
//        }

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
                    WebElement btnVer = fila.findElement(By.xpath(".//td[17]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnVer);
                    Utils.enmarcarElemento(driver, btnVer);
                    esperarElementoYMedirTiempo(By.xpath(".//td[17]"), "click ver promocion");
                    btnVer.click();
                    System.out.println("[INFO] Se hizo clic en el botón de ver.");

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
            System.err.println("[ERROR] Error al copiar la promoción: " + e.getMessage());
            return false;
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
    public static boolean confirmarPromocion(String nombrePromocion){
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
                    WebElement btnConfirmar = fila.findElement(By.xpath(".//td[13]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnConfirmar);
                    Utils.enmarcarElemento(driver, btnConfirmar);
                    esperarElementoYMedirTiempo(By.xpath(".//td[13]"), "click copiar promocion");
                    btnConfirmar.click();

                    System.out.println("[INFO] Se hizo clic en el botón de copiar.");


                    // Esperar a que la página de edición se cargue
//                    WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026vPROMODESCRIPCION\"]")));
//                    inputNombre.clear();
//                    inputNombre.sendKeys(datosPromociones.get("nombPromoEditado")+"");
                    tomarCaptura("confirmacion de promocion copiada");
                    Utils.desenmarcarObjeto(driver, fila);
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
            System.err.println("[ERROR] Error al copiar la promoción: " + e.getMessage());
            return false;
        }
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
    public static void clickEnEditarRestriccionExistente() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnEditarRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"W0026GridwizardrestrictionsdtContainerRow_0001\"]/td[5]/p/i")));
        Utils.enmarcarElemento(driver, btnEditarRestriccion);
        esperarElementoYMedirTiempo(By.xpath("//*[@id=\"W0026GridwizardrestrictionsdtContainerRow_0001\"]/td[5]/p/i"), "Editar restriccion");
        tomarCaptura("Administrador Promociones");
        Utils.desenmarcarObjeto(driver, btnEditarRestriccion);
        btnEditarRestriccion.click();
    }
    public static void validarMsjDeCopia() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnEditarRestriccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/k2bt-floating-messages[2]/div/div")));
        Utils.enmarcarElemento(driver, btnEditarRestriccion);
        esperarElementoYMedirTiempo(By.xpath("/html/body/k2bt-floating-messages[2]/div/div"), "Mensaje Exitoso");
        tomarCaptura("Exitosa");
        Utils.desenmarcarObjeto(driver, btnEditarRestriccion);
        btnEditarRestriccion.click();
    }

















}
