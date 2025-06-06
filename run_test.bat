@echo off
title Ejecutar pruebas automatizadas del proyecto
setlocal enabledelayedexpansion

REM Ubicarse en la carpeta donde está el .bat para que las rutas sean relativas
cd /d "%~dp0"

REM Verificar que existe pom.xml
if not exist pom.xml (
    echo ❌ ERROR: No se encontró pom.xml en esta carpeta: %cd%
    pause
    exit /b
)

:menu
cls
echo ============================================
echo        EJECUTOR DE PRUEBAS AUTOMATIZADAS
echo ============================================
echo 1. Ejecutar TODOS los features
echo 2. Ejecutar por TAG (@tag)
echo 3. Ejecutar un FEATURE específico
echo 4. Ver reporte HTML (si existe)
echo 5. Salir
echo ============================================
set /p opcion=Selecciona una opcion [1-5]:

if "%opcion%"=="1" goto run_all
if "%opcion%"=="2" goto run_tag
if "%opcion%"=="3" goto run_feature
if "%opcion%"=="4" goto open_report
if "%opcion%"=="5" exit

echo ❌ Opcion invalida.
pause
goto menu

:run_all
echo 🔁 Ejecutando TODOS los features...
mvn clean test -Dcucumber.filter.tags=""
goto end

:run_tag
set /p tag=Ingresa el tag (sin @): 
echo 🏷️ Ejecutando pruebas con tag @%tag% ...
mvn clean test -Dcucumber.filter.tags="@%tag%"
goto end

:run_feature
set /p feature=Ingresa el nombre del archivo feature (ej. login.feature): 
echo 📂 Ejecutando feature %feature% ...
mvn clean test -Dcucumber.features="src/main/java/feature/%feature%"
goto end

:open_report
if exist target\cucumber-report.html (
    echo 📄 Abriendo reporte...
    start "" "target\cucumber-report.html"
) else (
    echo ❌ No se encontró el reporte HTML.
)
pause
goto menu

:end
echo.
echo ✅ Pruebas finalizadas.
pause
goto menu
