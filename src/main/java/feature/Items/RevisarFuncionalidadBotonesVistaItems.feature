#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Definiciones - Funcionalidades de botones

  Background:
    Given que cargo los datos desde el archivo "datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de stock

Scenario: Definiciones - Seleccionar Descargar Columnas Base para Maestras
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccione el boton de descargar columna base para maestras
    Then se descarga el archivo cvs

  Scenario: Definiciones - Items - Importar Archivo
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario {string} "<subMenuD>"
    When este en el modulo de items
    And seleccionamos el boton importar archivo
    And en la ventana de carga de archivo ingresamos el tipo de separador de celdas "<separadorCeldas>"
    And Seleccionamos el boton agregar archivos y cargamos el documento que contega la informacion
    And seleccionamos el boton procesar
    Then nos debe de mostrar un mensaje que la base esta cargada



