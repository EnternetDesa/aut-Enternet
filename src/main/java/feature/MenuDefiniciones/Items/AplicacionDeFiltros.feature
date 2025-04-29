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

Scenario: Aplicar Filtros - Sin categorias
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos sin categoria "<sinCategoria>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria

Scenario: Aplicar Filtros - categoria Clasificadora
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos categoria clasificadora
    And seleccionamos codigo categoria Clasificadora "<catClasificadora>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria

Scenario: Aplicar Filtros - categoria Buscadora
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtro por categoria
    And seleccionamos categoria buscadora "<catBuscadora>"
    And seleccionamos codigo categoria buscadora "<codCatBuscadoraTipo>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria

Scenario: Aplicar Filtros - Filtros Generales -Codigo
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And seleccionamos codigo "<codigo>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria

Scenario: Aplicar Filtros - Filtros Generales -Descripcion
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And seleccionamos descripcion "<descProd>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar el producto creado "<descProd>"

Scenario: Aplicar Filtros - Filtros Generales - Mostrar Todo
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And le demos click en mostrar todo
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria

Scenario: Aplicar Filtros - Filtros Generales - Días ultima modificacion
    And estoy en home de stock
    And selecciono el menu de "<menu>"
    And luego el submenu de "<subMenuD>"
    When este en el modulo de items
    And seleccionamos filtros generales
    And ingresamos el numero de ultimo dia de modificacion "<diasMod>"
    And luego seleccionemos el boton buscar
    Then nos debe de mostrar los productos de esa categoria