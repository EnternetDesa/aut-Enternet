#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces

@Proveedores
Feature: Inventario - Proveedores

  Background:
    Given que cargo los datos desde el archivo "datosProveedores.json"
    And Ingreso con el tipo de "user"
    And ingreso la contrasenia "clave"
    And luego presiono el boton continuar
    And visualizo la vista de seleccion de rol
    And selecciono la opcion "rol"
    And en la vista del warning selecciono enviar de todas formas
    And debe de mostrar la vista de Pos

  Scenario: Aplicar Filtros - Sin categorias
    Given estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de Inventario "<subMenu>"
    When este en el modulo de proveedores
   # And seleccionamos filtro por categoria
   # And seleccionamos sin categoria "<sinCategoria>"
   # And luego seleccionemos el boton buscar
   # Then nos debe de mostrar los productos Sin categoria