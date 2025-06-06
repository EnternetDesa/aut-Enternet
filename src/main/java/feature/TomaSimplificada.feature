#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Toma Simplificada - Procesos

  Background:
    Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de stock

  Scenario: Toma Simplificada - Procesos
    Given estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuP>"
    When este en seleccion de ubicacion y haga click en "<ubicacion>"
    And en la vista de formulario ingresamos <"codigoItems"> y la cantidad <"cantidad">
    And hacemos click en el boton ir a resumen
    And aceptamos el pop-up de ir a resumen
    And en la vista de cierre de formulacion selecionamos procesar
    And aceptamos nuevamente el pop-up
    Then nos debe de mostras la vista de Movimientos con los productos modificados