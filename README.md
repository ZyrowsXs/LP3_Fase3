  # LP3_Fase3                                                                                                        
                                                                                                                       
  Repositorio dedicado a las prácticas y ejercicios desarrollados durante la **Fase 3** del curso de **Lenguajes de  
  Programación 3** (Ingeniería de Sistemas — UCSM).                                                                    
                                                                                                                       
  > Este repositorio contiene únicamente el código fuente y la documentación correspondiente a las sesiones de esta  
  fase del semestre.                                                                                                   
                                                                                                                       
  ---                                                                                                                
                                                                                                                       
  ## Estructura del Repositorio                                                                                      
                                                                                                                       
    ```text                                                                                                            
    LP3_Fase3/                                                                                                         
    ├── README.md                                                                                                      
    ├── Sesion9/                                                                                                       
    │   ├── actividad_1/                                                                                               
    │   │   └── src/                                                                                                   
    │   │       ├── borderLayout/                                                                                      
    │   │       ├── flowLayout/                                                                                        
    │   │       └── gridLayout/                                                                                        
    │   ├── ejercicio_1/                                                                                               
    │   │   └── src/                                                                                                   
    │   └── ejercicio_2/                                                                                               
    │       └── src/                                                                                                   
    └── Sesion10/                                                                                                      
        ├── actividades/                                                                                               
        │   ├── 1_binding/                                                                                             
        │   │   └── Ejemplo/                                                                                           
        │   ├── 2_graficos/                                                                                            
        │   │   └── Ejemplo/                                                                                           
        │   └── 3_multimedia/                                                                                          
        │       └── Ejemplo/                                                                                           
        ├── ejercicio_1/                                                                                               
        │   └── src/                                                                                                   
        ├── ejercicio_2/                                                                                               
        │   └── src/                                                                                                   
        ├── ejercicio_3/                                                                                               
        │   └── src/                                                                                                   
        │       └── efectosSonido/                                                                                     
        └── ejercicio_4/                                                                                               
            └── src/                                                                                                   
    ```                                                                                                                
                                                                                                                       
  ---                                                                                                                
                                                                                                                       
  ## Contenido de la Fase 3                                                                                          
                                                                                                                       
  ### Sesión 9 — Interfaces Gráficas en Java (Swing)                                                                 
                                                                                                                       
  | Módulo | Ruta | Descripción |                                                                                    
  | :--- | :--- | :--- |                                                                                             
  | **Actividad 1** | `Sesion9/actividad_1/src/` | Demostración de *Layout Managers* en Swing: `flowLayout`          
  (`MarcoFlowLayout.java`, `Main.java`), `borderLayout` (`MarcoBorderLayout.java`, `Main.java`) y `gridLayout`         
  (`MarcoGridLayout.java`, `Main.java`). |                                                                             
  | **Ejercicio 1** | `Sesion9/ejercicio_1/src/` | Formulario de cuestionario (`CuestionarioForm.java`,              
  `CuestionarioForm.form`) con validación de nombre y edad para indicar si el usuario es mayor o menor de edad         
  (`JFrame`, `JTextField`, `JButton`, `JLabel`, `JOptionPane`). |                                                      
  | **Ejercicio 2** | `Sesion9/ejercicio_2/src/` | Aplicación de compra de pasajes terrestres bajo el patrón **MVC**:
  `Pasaje.java` (Modelo), `VistaCompraPasaje.java` (Vista), `ControladorPasaje.java` (Controlador) y `App.java` (punto 
  de entrada). |                                                                                                       
                                                                                                                       
    ---                                                                                                                
                                                                                                                       
  ### Sesión 10 — Java Swing Avanzado                                                                                
                                                                                                                       
  #### Actividades (`Sesion10/actividades/`)                                                                         
                                                                                                                       
  - **1. Binding de Datos (`1_binding/`)**:                                                                          
      - `Vehiculo.java` y `AppBindingVehiculo.java`: Sincronización manual bidireccional entre el modelo `Vehiculo`    
  (`placa`, `marca`, `anio`, `kilometraje`) y una interfaz Swing, con validación de rangos y botones para actualizar o 
  restaurar la vista.                                                                                                  
      - `Ejemplo/`: `AppBinding.java`.                                                                                 
    - **2. Gráficos 2D (`2_graficos/`)**:                                                                              
      - `AppGraficoAsistencia.java`: Lienzo personalizado con `Graphics2D` y antialiasing que dibuja un gráfico de     
  barras dinámico con el porcentaje de asistencia de cinco cursos (`LP3`, `REDES1`, `FSI`, `ECO`, `FISICA`) y permite  
  actualizar valores en tiempo real.                                                                                   
      - `Ejemplo/`: `AppGraficos.java`, `AppGraficos2D.java`, `AppGraficoBarras.java`.                                 
    - **3. Multimedia (`3_multimedia/`)**:                                                                             
      - `AppAlarmaSonora.java`: Alarma con cuenta regresiva implementada con `javax.swing.Timer` y reproducción de     
  tonos `.wav` mediante `javax.sound.sampled.Clip` (con opción de silenciar).                                          
      - `Ejemplo/`: `AppAudio.java`, `VideoExample.java` y archivos de prueba (`campana.wav`, `riser.wav`, `mayonesa.  
  mp4`).                                                                                                               
                                                                                                                       
  #### Ejercicios (`Sesion10/ejercicio_1` — `ejercicio_4`)                                                           
                                                                                                                       
  | Ejercicio | Ruta | Archivos Principales | Descripción |                                                          
  | :--- | :--- | :--- | :--- |                                                                                      
  | **Ejercicio 1** | `Sesion10/ejercicio_1/src/` | `Main.java`, `AppReproductorMusica.java` | Reproductor de audio  
  `.wav` con `Clip`, `LineListener` y `JFileChooser`. Permite reproducir, pausar, reanudar desde la posición guardada y
  cargar distintos archivos de audio. |                                                                                
  | **Ejercicio 2** | `Sesion10/ejercicio_2/src/` | `App.java`, `Paneltemperatura.java` | Visualizador semanal de    
  temperaturas (°C) que grafica una línea continua con puntos marcados mediante `Graphics2D` sobre un `JPanel`         
  personalizado, validando los 7 valores ingresados. |                                                                 
  | **Ejercicio 3** | `Sesion10/ejercicio_3/src/` | `AppEfectosSonido.java`, `efectosSonido/*.wav` | Panel de efectos
  sonoros en Swing con botones para reproducir `aplausos.wav`, `campana.wav` y `explosion.wav` usando `AudioSystem` y  
  `Clip`. |                                                                                                            
  | **Ejercicio 4** | `Sesion10/ejercicio_4/src/` | `Main.java`, `Producto.java`, `ProductoView.java`,               
  `ProductoController.java` | Gestión de un producto en memoria bajo el patrón **MVC**: `Producto` encapsula `nombre`, 
  `precio`, `cantidadStock` y `categoria`; `ProductoView` construye el formulario con `GridBagLayout`;                 
  `ProductoController` valida entradas, actualiza el modelo y refresca el resumen. |                                   
                                                                                                                       
    ---                                                                                                                
                                                                                                                       
  ## Compilación y Ejecución                                                                                         
                                                                                                                       
  En general, puedes compilar y ejecutar cualquiera de los proyectos desde su carpeta `src/`:                        
  
    ```sh
  javac *.java
    java Main   # o la clase principal correspondiente (App, AppEfectosSonido, etc.)
    ```
  
  - Para **`Sesion10/ejercicio_4`**, también se incluye un `Makefile`:
      ```sh
      make        # compila los archivos fuente en out/
      make run    # compila y ejecuta Main
      make clean  # elimina los archivos compilados
      ```
- Para los ejercicios que cargan archivos de audio mediante rutas relativas (`ejercicio_1`, `ejercicio_3`,         `3_multimedia`), asegúrate de ejecutar `java` desde el directorio donde está configurada la ruta del recurso `.wav`. 
  
    ---
  
    ## Requisitos
  
    - **Java JDK** (8 o superior) con soporte estándar para `javax.swing`, `java.awt` y `javax.sound.sampled`.         
    - *(Opcional)* **JavaFX**, requerido únicamente si deseas ejecutar el ejemplo de video
  `Sesion10/actividades/3_multimedia/Ejemplo/VideoExample.java`.
    `````*

