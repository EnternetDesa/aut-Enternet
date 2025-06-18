:run_tag
@echo off
setlocal enabledelayedexpansion
echo 📋 Buscando tags disponibles...

REM Limpiar archivo temporal si existe
set "tagfile=tags_temp.txt"
del "%tagfile%" 2>nul

REM Buscar líneas que comienzan con @ y guardar en archivo
for /f "tokens=* delims=" %%A in ('findstr /R /C:"^@[a-zA-Z0-9_@\-]*" src\main\java\feature\*.feature') do (
    echo %%A>>"%tagfile%"
)

REM Extraer todos los tags individuales (puede haber varios por línea)
set i=0
for /f "usebackq tokens=*" %%L in ("%tagfile%") do (
    for %%T in (%%L) do (
        set "tag=%%T"
        REM Validar si ya fue mostrado
        echo !lista! | findstr /C:"!tag!" >nul || (
            set /a i+=1
            set "tags[!i!]=!tag!"
            set "lista=!lista!!tag!;"
            echo   !i!. !tag!
        )
    )
)

if !i! EQU 0 (
    echo ❌ No se encontraron tags disponibles.
    del "%tagfile%"
    pause
    endlocal
    goto menu
)

echo.
set /p tagIndex=Selecciona el número del tag que deseas ejecutar: 

REM Validar entrada numérica válida
set /a tagNumber=0
for /f "delims=0123456789" %%x in ("!tagIndex!") do set tagIndex=

if not defined tagIndex (
    echo ❌ Opción inválida. Solo números del 1 al !i!.
    pause
    endlocal
    goto menu
)

if %tagIndex% LSS 1 (
    echo ❌ Número fuera de rango.
    pause
    endlocal
    goto menu
)

if %tagIndex% GTR %i% (
    echo ❌ Número fuera de rango.
    pause
    endlocal
    goto menu
)

REM Ejecutar prueba con el tag seleccionado
set "selectedTag=!tags[%tagIndex%]!"
echo 🏷️ Ejecutando pruebas con tag !selectedTag! ...
mvn clean test -Dcucumber.filter.tags="!selectedTag!"
del "%tagfile%"
endlocal
goto end
