#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: POS - Fiado

  Background:
    Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de Pos

  Scenario: POS - Agregar Cliente
    Given que ingreso los datos desde el archivo datosFiado "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
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
    And hacemos click en menu izquierdo y en la opcion fiado
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And Ingresamos la descripcion o codigo de un producto y apretamos enter
    And ingresamos la cantidad de producto que llevaremos
    And seleccionamos el tipo de pago que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision
   #Then nos debe de mostrar los productos de esa categoria