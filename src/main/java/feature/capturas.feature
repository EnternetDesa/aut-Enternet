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