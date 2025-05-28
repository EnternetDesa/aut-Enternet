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

  Scenario: Pos Fiado - Agregar Cliente
    Given que ingreso los datos desde el archivo datosPos "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
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
    And que ingreso los datos desde el archivo datosFiado "C:\git\aut-Enternet\src\java\resources\datosFiado.json"
    And hacemos click en menu izquierdo y en la opcion fiado
    And seleccionamos boton agregar cliente
    And ingresamos el rut del cliente "<rutCliente>"
    And seleccionamos el boton confirmar
    And mos mostrara un pop de estas seguro , debemos aceptar
    And en informacion general ingresamos el valor del credito a otorgar "<montoCredito>"
    And seleccionamos el boton actualizar
    And seleccionar boton volver
    And validamos que se haya creado correctamente
    And hacemos click en menu opcion modulo de ventas
    And que ingreso los datos desde el archivo datosPos "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And Ingresamos la descripcion o codigo de un producto y apretamos enter
    And ingresamos la cantidad de producto que llevaremos
  #  And seleccionamos la forma de pago <"formaDePago"> que ocuparemos e ingresamos los datos para el pago
    And seleccionamos la forma de pago <"formaDePago"> y el tipo de pago <"tipoDePago"> que ocuparemos
    And seleccionar boton guardar
    And seleccionamos tipo de emision
   ## And firmamos la emision de factura o boleta


   #Then nos debe de mostrar los productos de esa categoria

  Scenario: Pos Fiado - Editar Cliente
    Given que ingreso los datos desde el archivo datosPos "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
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
    And que ingreso los datos desde el archivo datosFiado "C:\git\aut-Enternet\src\java\resources\datosFiado.json"
    And hacemos click en menu izquierdo y en la opcion fiado
    And seleccionamos el cliente que queremos editar
  #  And ingresamos el rut del cliente "<rutCliente>"
  #  And seleccionamos el boton confirmar
  #  And mos mostrara un pop de estas seguro , debemos aceptar
    And en informacion general ingresamos el valor del credito a otorgar "<montoCredito>"
    And seleccionamos el boton actualizar
    And seleccionar boton volver
    And validamos que se haya creado correctamente
    And hacemos click en menu opcion modulo de ventas
    And que ingreso los datos desde el archivo datosPos "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And Ingresamos la descripcion o codigo de un producto y apretamos enter
    And ingresamos la cantidad de producto que llevaremos
    And seleccionamos el tipo de pago que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision
    And firmamos la emision de factura o boleta


  Scenario: Pos Fiado - descargar Tabla clientes
    Given que ingreso los datos desde el archivo datosPos "C:\git\aut-Enternet\src\java\resources\datosPOS.json"
 #   And estoy en home de Pos
 #   And selecciono el menu de Pos "<menuPOS>"
 #   And luego el submenu de Pos "<subMenuP>"
 #   When este en el modulo de Enrolamiento de Terminales
 #   And seleccionamos un link de acceso QR
 #   And seleccionamos el boton copiar
 #   And luego pegamos la url en un nuevo navegador
 #   And ingresamos el tipo de perfil
 #   And ingresamos el modulo IDL
 #   And ingresamos el rut "<user>" y contrasenia "<clave>"
 #   And seleccionamos el boton ingresar
 #   And hacemos click en la caja que muestra nuestro nombre
 #   And hacemos click en menu izquierdo y en la opcion fiado
 #   And seleccionamos boton descargar cliente y luego exportar
    And abrimos el documento

