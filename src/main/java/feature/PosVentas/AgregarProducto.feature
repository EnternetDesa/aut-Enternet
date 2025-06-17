#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces

@Ventas
Feature: POS - Ventas

Background:
     Given que cargo los datos desde el archivo "datosPOS.json"
     And Ingreso con el tipo de "user"
     And ingreso la contrasenia "clave"
     And luego presiono el boton continuar
     And visualizo la vista de seleccion de rol
     And selecciono la opcion "rol"
     And en la vista del warning selecciono enviar de todas formas
     And debe de mostrar la vista de Pos

  @agregarProducto
Scenario: POS - Agregar Producto por Buscador
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
    And seleccionamos tipo de emision <"tipoEmision">
   #Then seleccionar boton imprimir

    @agregarProdFiltroDespensa @agregarPorDespensa
Scenario: POS - Agregar Producto por Filtro Despensa
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
    And seleccionamos el boton buscar
    And seleccionamos un producto
    And ingresamos la cantidad de producto que llevaremos
    And seleccionamos la forma de pago <"formaDePago"> que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision <"tipoEmision">
   Then seleccionar boton imprimir

    @agregarProdBtnCarta
Scenario: POS - Agregar Producto por boton Carta
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
    And hacemos click en el boton carta y seleccionamos el producto que muestre
    And le modificamos el precio al producto"<precio>"
    And ingresamos la cantidad de producto que llevaremos
    And seleccionamos la forma de pago <"formaDePago"> que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision <"tipoEmision">
   #Then seleccionar boton imprimir

    @crearProdLibre
Scenario: Ventas - Probar boton Crear Producto libre
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
    And le damos click en el boton de crear prod libre y visualizamos el formulario para ingresar un producto
    And ingresamos el codigo "<codProd>", una descripcion "<descProd>" , una unidad de medida "<uniMed>"
    And seleccionamos un Tratamiento Tributario y un Codigo Especial
    And ingresamos la cantidad del producto <"cantProdC"> el precio <"precio"> y descuento <"descuento">
  #  And ingresamos las dimensiones <"dimensiones"> y estado de entrega <"estadoE">
    And ingresamos la glosa <"glosa">
    And le damos click al boton confirmar
    And seleccionamos la forma de pago <"formaDePago"> que ocuparemos e ingresamos los datos para el pago
    And seleccionar boton guardar
    And seleccionamos tipo de emision <"tipoEmision">
   #Then seleccionar boton imprimir


