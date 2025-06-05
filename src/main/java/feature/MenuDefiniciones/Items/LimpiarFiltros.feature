#Auto generated Octane revision tag
#given:dado - when: cuando - then:entonces
Feature: Definiciones - Aplicar Filtros

Background:
     Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
     And Ingreso con el tipo de "user"
     And ingreso la contrasenia "clave"
     And luego presiono el boton continuar
     And visualizo la vista de seleccion de rol
     And selecciono la opcion "rol"
     And en la vista del warning selecciono enviar de todas formas
     And debe de mostrar la vista de stock

@itemsLimpiarFiltro
Scenario: Limpiar Filtros - Sin categorias
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos sin categoria "<sinCategoria>"
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado

@itemsLimpiarFiltro
Scenario: Limpiar Filtros - Categoria Clasificadora
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos categoria clasificadora
    And seleccionamos codigo categoria Clasificadora "<catClasificadora>"
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado

@itemsLimpiarFiltro
Scenario: Limpiar Filtros - Categoria Buscadora
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos categoria buscadora "<catBuscadora>"
    And seleccionamos codigo categoria buscadora "<codCatBuscadoraTipo>"
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado

@itemsLimpiarFiltro
    Scenario: Limpiar Filtros - Filtros Generales -Codigo
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And seleccionamos codigo "<codigo>"
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado

@itemsLimpiarFiltro
Scenario: Limpiar Filtros - Filtros Generales -Descripcion
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And seleccionamos descripcion "<descProd>"
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado

@itemsLimpiarFiltroM
    Scenario: Limpiar Filtros - Filtros Generales - Mostrar Todo
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And le demos click en mostrar todo
    And Seleccionamos Limpiar Filtros
    Then nos debe de mostrar que no este ningun filtro seleccionado