#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
  @Items
Feature: Definiciones - Crear Items
  Background:
    Given que cargo los datos desde el archivo "datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de stock

    @itemsSinLotes
Scenario: Definiciones - Crear Items Sin Lotes
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And seleccionamos si el producto usa lotes o no
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And en la seccion de categorias del producto seleccionamos la categoria buscadora <"catBuscadora"> y seleccionamos el boton buscar
    And Luego seleccionamos la categoria Buscadora que necesitamos <"tipoCatBuscadora">
    And seleccionamos la categoria clasificadora <"catClasificadora"> y seleccionamos el boton buscar
    And luego seleccionamos el tipo de categoria  <"tipoCatClasificadora">
    And en configuracion por ubicacion ingresamos la cantidad <"cantidad">
    And el costo unitario <"costoUnitario">
    And el precio del producto <"precioProd">
    And seleccionamos guardar producto y nos debe redirigir a la vista de lista de items
    And seleccionamos las categorias ingresadas anteriormente y buscamos por esos filtros
    Then nos debe de mostrar el items creado en la lista el items
 ##   And validar que los datos ingresados esten el la base de datos

  @itemsConLotes
Scenario: Definiciones - Crear Items Usa Lotes
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenuD>"
    When este en lista de items y presionamos el boton crear items
    And nos redirige a la vista de creacion de producto
    And ingresamos los datos de descripcion de producto "<descProducto>"
    And seleccione una unidad de medida <"uniMedida">
    And seleccione una unidad de comparacion <"uniComparacion">
    And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
    And seleccionamos si el producto usa lotes o no
    And ingresamos en codigo de producto el codigo INT <"codInt">
    And ingresamos el codigo EAN <"codEAN">
    And ingresamos el codigo SKU <"codSKU">
    And ingresamos el codigo base <"codBase">
    And en la seccion de categorias del producto seleccionamos la categoria buscadora <"catBuscadora"> y seleccionamos el boton buscar
    And Luego seleccionamos la categoria Buscadora que necesitamos <"tipoCatBuscadora">
    And seleccionamos la categoria clasificadora <"catClasificadora"> y seleccionamos el boton buscar
    And luego seleccionamos el tipo de categoria  <"tipoCatClasificadora">
 #   And en configuracion por ubicacion ingresamos la cantidad <"cantidad">
 #   And el costo unitario <"costoUnitario">
    And el precio del producto <"precioProd">
    And seleccionamos guardar producto y nos debe redirigir a la vista de lista de items
    And seleccionamos las categorias ingresadas anteriormente y buscamos por esos filtros
    Then nos debe de mostrar el items creado en la lista el items

  @itemsVendeConLotes
Scenario: Definiciones - Crear Items vende con Lotes
        And estoy en home de stock
        And selecciono el menu de "<menu>"
        And luego el submenu de Inventario "<subMenuD>"
        When este en lista de items y presionamos el boton crear items
        And nos redirige a la vista de creacion de producto
        And ingresamos los datos de descripcion de producto "<descProducto>"
        And seleccione una unidad de medida <"uniMedida">
        And seleccione una unidad de comparacion <"uniComparacion">
        And seleccione una equivalencia de comparacion <"equivalenciaComparacion">
        And seleccionamos si el producto usa lotes o no
        And ingresamos en codigo de producto el codigo INT <"codInt">
        And ingresamos el codigo EAN <"codEAN">
        And ingresamos el codigo SKU <"codSKU">
        And ingresamos el codigo base <"codBase">
        And en la seccion de categorias del producto seleccionamos la categoria buscadora <"catBuscadora"> y seleccionamos el boton buscar
        And Luego seleccionamos la categoria Buscadora que necesitamos <"tipoCatBuscadora">
        And seleccionamos la categoria clasificadora <"catClasificadora"> y seleccionamos el boton buscar
        And luego seleccionamos el tipo de categoria  <"tipoCatClasificadora">
      #  And en configuracion por ubicacion ingresamos la cantidad <"cantidad">
      #  And el costo unitario <"costoUnitario">
        And el precio del producto <"precioProd">
        And seleccionamos guardar producto y nos debe redirigir a la vista de lista de items
        And seleccionamos las categorias ingresadas anteriormente y buscamos por esos filtros
        Then nos debe de mostrar el items creado en la lista el items