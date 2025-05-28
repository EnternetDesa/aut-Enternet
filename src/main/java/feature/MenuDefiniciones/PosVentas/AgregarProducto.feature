#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: POS - Promociones

Background:
     Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
     And Ingreso con el tipo de "user"
     And ingreso la contrasenia "clave"
     And luego presiono el boton continuar
     And visualizo la vista de seleccion de rol
     And selecciono la opcion "rol"
     And en la vista del warning selecciono enviar de todas formas
     And debe de mostrar la vista de Pos

Scenario: POS - Agregar Producto por Buscador
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
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And Ingresamos la descripcion o codigo de un producto y apretamos enter
    And ingresamos la cantidad de producto que llevaremos
    And seleccionamos la forma de pago <"formaDePago"> que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision
   #Then nos debe de mostrar los productos de esa categoria

Scenario: POS - Agregar Producto por Filtro Despensa
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
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And ingresamos un producto desde el modulo del filtro por categorias
    And ingresamos un producto en el filtro de despensa "<catDespensa>"
  #  And ingresamos un producto en el filtro de ANNO "<catANNO>"
  #  And ingresamos un producto en el filtro de Otros "<catOtros>"
    And seleccionamos el boton buscar
    And seleccionamos un producto
   #Then nos debe de mostrar los productos de esa categoria

Scenario: POS - Agregar Producto por boton Carta
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
    And ingresamos el rut "<userPOS>" y contrasenia "<clavePOS>"
    And seleccionamos el boton ingresar
    And hacemos click en la caja que muestra nuestro nombre
    And seleccionamos boton nueva venta
    And le asignamos el cliente a quien venderemos "<nombreCliente>"
    And hacemos click en el boton carta y seleccionamos el producto que muestre
    And le modificamos el precio al producto"<precio>"
    And le modificamos la cantidad de producto a comprar "<cantProdC>"
   #Then nos debe de mostrar los productos de esa categoria falta agregar la factura o boleta emitida

Scenario: Ventas - Probar boton Crear Producto libre
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
    And seleccionamos boton nueva venta
    And le damos click en el boton de crear prod libre
    And visualizamos el formulario para ingresar un producto
    And ingresamos el codigo "<codProd>"
    And ingresamos una descripcion "<descProd>"
    And ingresamos una unidad de medida "<uniMed>"
    And seleccionamos un Tratamiento Tributario
    #And seleccionamos una Actividad Economica
    And seleccionamos un Codigo Especial
    And ingresamos la cantidad del producto <"cantProdC"> el precio <"precio"> y descuento <"descuento">
  #  And ingresamos las dimensiones <"dimensiones"> y estado de entrega <"estadoE">
    And ingresamos la glosa <"glosa">
    And le damos click al boton confirmar
    Then visualizamos el producto ingresado en el carro de compras


