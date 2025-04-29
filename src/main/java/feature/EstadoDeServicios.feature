#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Ingreso Recepcion - Movimientos

  Scenario: Ingreso a inventario
    Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de stock
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuM>"
    When este en la vista de salida de inventario y haga click en el icono crear
    And aparece la vista de nuevo movimiento de salida
    And ingresamos los datos de ubicacion de origen "<ubOrigen>"
    And ingresamos los datos de codigo items "<codItems>"
    And ingresamos los datos de cantidad "<cantProd>" y darle enter
    And darle enter nos debe cargar en la tabla el items agregado anteriormente
    And luego seleccionamos el boton seleccionar contraparte
    And seleccionamos el receptor
    And luego ingresamos nuevamente la ubicacion "<ubiOrigin>"
    And ingresamos los datos de codigo items "<codItems2>"
    And ingresamos los datos de cantidad "<cantProdct>" y presionamos enter
    And seleccionamos confirmar
    And luego nos mostrara la vista de Datos adicionales Receptor Guia
    And ingresamos direccion de receptor "<dirReceptor>"
    And ingresamos comuna de receptor "<comunaReceptor>"
    And ingresamos giro receptor "<giroRecept>"
    And seleccionamos confirmar nuevamente

    #And aceptamos el popup emergente
    #And seleccionamos el criterio de distribucion
    #And seleccionamos el picking y conciliacion
    #And luego seleccionamos asociar y confirmamos la conciliacion
    #And luego seleccionamos conciliar y aceptamos el pop-up
    #Then debe de mostras la vista del documento de factura


#Feature: Ingreso de Datos desde JSON

 # Scenario Outline: Ingresar datos en la plataforma
 #   Given el usuario está en la página de formulario
 #   When ingresa la dirección "<direccion>"
 #   And ingresa la comuna "<comuna>"
 #   And ingresa el giro "<giro>"
 #   Then se confirma el ingreso correctamente

#    Examples:
 #     | direccion         | comuna      | giro         |
 #     | Avenida 123       | Santiago    | Tecnología   |

