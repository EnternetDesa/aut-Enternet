#Feature: Generar un PDF con capturas de pantalla

 # Scenario: Tomar captura de pantalla y guardarla en un PDF
  #  Given el usuario abre Google
   # When el usuario toma una captura de pantalla
    #Then se genera un PDF con la captura en la ruta predefinida

Feature: Generar un PDF con múltiples capturas

  Scenario: Capturar múltiples pantallas y medir tiempos de carga
    Given el usuario abre Google
    When el usuario toma capturas de pantalla con tiempos de carga
    Then se genera un PDF con todas las capturas y tiempos registrados

    Scenario: prueba de agregar tiempo de elemento
      Given que cargo los datos desde el archivo "C:\git\aut-Enternet\src\java\resources\datos.json"
      And Ingreso con el tipo de "user"
      And ingreso la contrasenia "clave"
      And luego presiono el boton continuar
      And visualizo la vista de seleccion de rol
      And selecciono la opcion "rol"