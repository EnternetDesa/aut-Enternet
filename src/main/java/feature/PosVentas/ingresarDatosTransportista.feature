#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: POS -Definiciones - Ingresar Datos Transportista

  Background:
    Given que cargo los datos desde el archivo "datosPOS.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de Pos

  Scenario: POS - Agregar Datos Transportista
    And estoy en home de Pos
    And selecciono el menu de Pos "<menuPOS>"
    And luego el submenu de Pos "<subMenuP>"
    When este en el modulo de Enrolamiento de Terminales
    And seleccionamos un link de acceso QR
    And seleccionamos el boton copiar
    And luego pegamos la url en un nuevo navegador
    And ingresamos el tipo de perfil
    And ingresamos el modulo IDL
    And ingresamos el rut "<user>" y contrasenia "<clave>"
    And seleccionamos el boton ingresar
    And hacemos click en la caja que muestra nuestro nombre
    And seleccionamos boton nueva venta
    And seleccionamos el boton transportista
    And ingresamos el motivo de traslado
    And Ingresamos el tipo de traslado
    And ingresamos el nombre del chofer <"nombreChofer">
    And ingresamos el rut del chofer <"rutChofer">
    And ingresamos el numero de patente <"patente"> y confirmamos
   #Then nos debe de mostrar los productos de esa categoria


