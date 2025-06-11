#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Definiciones- Crear Items - EditarProducto.

  Background:
    Given que cargo los datos desde el archivo "datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de stock

  @items
Scenario: Editar items - Crear Items Sin descripcion
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
   # And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And seleccionamos si el producto usa lotes o no
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And seleccionamos guardar producto
    Then nos debe de mostrar el msj creado en la lista el items

  @items
  Scenario: Crear items - Crear Items Sin equivalencia de comparacion
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
   # And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And seleccionamos guardar producto
    Then nos debe de mostrar el msj creado en la lista el items

  @items
  Scenario: Crear items - Sin codigo interno, EAN o SKU
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
   # And ingresamos en codigo de producto el codigo INT <"codInt">
   # And ingresamos el codigo EAN <"codEAN">
   # And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And seleccionamos guardar producto
    Then nos debe de mostrar el msj creado en la lista el items

  @items
  Scenario: Crear items - Crear Items Sin codigo Base
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
  #  And ingresamos el codigo base <"codBase">
    And seleccionamos guardar producto
    Then nos debe de mostrar el msj creado en la lista el items

  @items
  Scenario: Crear items - Ingresar un codigo EAN incorrecto
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And seleccionamos guardar producto
    Then nos debe de mostrar el msj creado en la lista el items

  @items
  Scenario: Crear items - Validacion de filtro clasificadora/Buscadora
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And en la seccion de categorias del producto seleccionamos la categoria buscadora <"catBuscadora"> y seleccionamos el boton buscar
    And Luego seleccionamos varios tipos de categoria Buscadoras <"tipoCatBuscadora">
    And seleccionamos la categoria clasificadora <"catClasificadora"> y seleccionamos el boton buscar
    And luego seleccionamos varios tipos de categoria  <"tipoCatClasificadora">
   Then Al intentar seleccionar varios tipos de categoria clasificadora debe mostrar el mensaje que solo se puede seleccionar una