#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Promociones

  Background:
    Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And debe de mostrar la vista del Administrador de Promociones

Scenario: Promociones - Agregar Promocion
  Given que ingreso los datos desde el archivo datosPromociones "C:\git\aut-Enternet\src\java\resources\datosPromociones.json"
  And selecciono el nombre de la empresa
  And nos debe dirigir a la vista de promociones
  And seleccionamos el icono con el signo mas
  And nos debe mostrar la vista de vigencia e ingreso el nombre de la promocion <"nomPromo">
  And agregamos fecha de inicio <"fechaInicio">
  And agregamos si la promocion se canjea en un horario determinado o no
  And agregamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no
  And seleccionamos el boton siguiente
  And ingresamos una ubicacion ,en caso de no ingresar la promocion aplicara para todas las ubicaciones
  And seleccionamos el boton siguiente
  And en la vista de restriccion agregamos una seleccionando el boton mas
  And ingresamos nombre de restriccion
  And ingresar cantidad minima de productos a llevar
  And seleccionamos la categoria de la promocion <"categoriaPromo">
  And seleccionamos el producto de la promocion por descripcion <"descProducto"> o codigo <"codPromo">
  And guardamos los cambios
  And seleccionamos el boton siguiente
  And agregamos el tipo de regla de la restriccion
  And ingresamos el tipo de descuento que tendra la promocion
  And seleccionamos el boton siguiente
  And visualizamos el resumen de nuestra promocion
  And validamos que sean los datos ingresados anteriormente
  And seleccionamos el boton finalizar
  Then nos debe dirigir a la pantalla principal y visualizar nuestra promocion

  Scenario: Promociones - Editar Promocion
    Given que ingreso los datos desde el archivo datosPromociones "C:\git\aut-Enternet\src\java\resources\datosPromociones.json"
    And selecciono el nombre de la empresa
    And nos debe dirigir a la vista de promociones
    And editamos una promocion ya existente y modificamos el nombre a la promocion <"nombPromoEditado">
    And editamos con una nueva fecha de inicio <"fechaInicio">
    And editamos si la promocion se canjea en un horario determinado o no
    And editamos si Desea seleccionar dias en especificos en los que sea canjeable la promocion o no
    And seleccionamos el boton siguiente
    And editamos la ubicacion ,en caso de no ingresar una la promocion aplicara para todas las ubicaciones
    And seleccionamos el boton siguiente
    And en la vista de restriccion editamos la existente
    And editamos el nombre de restriccion
    And editamos la cantidad minima de productos a llevar
    And Editamos la categoria de la promocion <"categoriaPromo">
    And Editamos el producto de la promocion por descripcion <"descProducto"> o codigo <"codPromo">
    And guardamos los cambios
    And seleccionamos el boton siguiente
    And editamos el tipo de descuento que tendra la promocion
    And seleccionamos el boton siguiente
    And visualizamos el resumen de nuestra promocion
    And validamos que sean los datos ingresados anteriormente
    And seleccionamos el boton finalizar
    Then nos debe dirigir a la pantalla principal y visualizar nuestra promocion editada

  Scenario: Promociones - Copiar Promocion
    Given que ingreso los datos desde el archivo datosPromociones "C:\git\aut-Enternet\src\java\resources\datosPromociones.json"
    And selecciono el nombre de la empresa
    And nos debe dirigir a la vista de promociones
    And copiamos una promocion ya existente
    And validar que se despliega mensaje de copia exitosa
    And hacemos click en confirmar la promocion
    Then visualizar nuestra promocion copiada

  Scenario: Promociones - Anular Promocion
    Given que ingreso los datos desde el archivo datosPromociones "C:\git\aut-Enternet\src\java\resources\datosPromociones.json"
    And selecciono el nombre de la empresa
    And nos debe dirigir a la vista de promociones
    And buscamos la promocion que anularemos
    And validar que se despliega mensaje de anulacion exitosa
    Then visualizar nuestra promocion anulada no exista







