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
    When este en recepcion y haga click en digitar documento
    And aparece la vista de formulario
    And ingresamos los datos de tipo documento "<tipoDocumento>"
    And ingresamos los datos de folio "<folio>"
    And ingresamos los datos de rut emisor "<rutEmisor>"
    And ingresamos los datos de total neto "<totalNeto>"
    And ingresamos los datos de total bruto "<totalBruto>"
    And ingresamos los datos de codigoP "<codigo>"
    And ingresamos los datos de nombreP "<nombreProd>"
    And ingresamos los datos de cantidadP "<cantidadP>"
    And ingresamos los datos de precio neto "<precioNeto>"
    And ingresamos los datos de total "<total>"
    And seleccionamos confirmar
    And luego guardar y registrar
    And luego seleccionamos registrar mercaderia
    And seleccionamos "<ubicacion>"
    And ingresamos los datos de codigo "<codigo>"
    And ingresamos los datos de cantidad "<cantidad>"
    And seleccionamos guardar y conciliar
    And aceptamos el popup emergente
    And seleccionamos el criterio de distribucion
    And seleccionamos el picking
    And seleccionamos conciliacion
    And luego seleccionamos asociar
    And confirmamos la conciliacion
    And luego seleccionamos conciliar
    And aceptamos el pop-up
    Then debe de mostras la vista del documento de factura