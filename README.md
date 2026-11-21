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
  ──────                                                                                                               
  ### 2. Nueva sección en ## Contenido de la Fase 3                                                                    
                                                                                                                       
  Agrega este bloque justo debajo de la Sesión 9:                                                                      
                                                                                                                       
    ### Sesión 10 — Java Swing Avanzado                                                                                
                                                                                                                       
    - **Actividades (`Sesion10/actividades/`)**:                                                                       
      - **Binding de Datos (`1_binding/`)**: `Vehiculo.java` y `AppBindingVehiculo.java` implementan sincronización    
  bidireccional manual entre modelo y vista Swing con validación de placa, marca, año y kilometraje (incluye carpeta   
  `Ejemplo/` con `AppBinding.java`).                                                                                   
      - **Gráficos 2D (`2_graficos/`)**: `AppGraficoAsistencia.java` dibuja un gráfico de barras interactivo con       
  `Graphics2D` para visualizar y actualizar porcentajes de asistencia por curso (incluye carpeta `Ejemplo/` con        
  `AppGraficos.java`, `AppGraficos2D.java` y `AppGraficoBarras.java`).                                                 
      - **Multimedia (`3_multimedia/`)**: `AppAlarmaSonora.java` implementa un temporizador con `javax.swing.Timer` y  
  reproducción de tonos `.wav` mediante `javax.sound.sampled.Clip` (incluye carpeta `Ejemplo/` con `AppAudio.java`,    
  `VideoExample.java` y recursos multimedia).                                                                          
    - **Ejercicio 1 (`Sesion10/ejercicio_1/src/`)**: Reproductor de música en Java Swing (`AppReproductorMusica.java`, 
  `Main.java`) usando `javax.sound.sampled.Clip` y `JFileChooser`, con controles para reproducir, pausar, reanudar y   
  seleccionar archivos `.wav`.
    - **Ejercicio 2 (`Sesion10/ejercicio_2/src/`)**: Visualizador de temperatura semanal (`App.java`, 
  `Paneltemperatura.java`) que grafica una curva de temperaturas en °C mediante `Graphics2D` sobre un `JPanel`         
  personalizado, con entrada validada para los 7 días de la semana.
    - **Ejercicio 3 (`Sesion10/ejercicio_3/src/`)**: Aplicación de efectos de sonido (`AppEfectosSonido.java`) con     
  botones Swing para reproducir clips `.wav` (`aplausos.wav`, `campana.wav`, `explosion.wav`) ubicados en
  `efectosSonido/`.
    - **Ejercicio 4 (`Sesion10/ejercicio_4/src/`)**: Gestión de producto en memoria implementada bajo el patrón        
  **Modelo-Vista-Controlador (MVC)**:
      - `Producto.java` (Modelo): Encapsula `nombre`, `precio`, `cantidadStock` y `categoria`.
      - `ProductoView.java` (Vista): Formulario Swing (`GridBagLayout`) con botón de actualización y panel de resumen. 
      - `ProductoController.java` (Controlador): Valida los datos ingresados, actualiza el modelo y refresca la vista. 
      - `Main.java`: Punto de entrada de la aplicación.
  ──────
  ### 3. Actualización opcional en ## Requisitos
  
    ## Requisitos
  
    - **Java JDK** (8 o superior) con soporte para `javax.swing`, `java.awt` y `javax.sound.sampled`.
    - *(Opcional)* **JavaFX** únicamente si se desea ejecutar el ejemplo de video
  `Sesion10/actividades/3_multimedia/Ejemplo/VideoExample.java`.

  - `App.java`: Punto de entrada de la aplicación.

## Requisitos

- **Java JDK** (8 o superior) con soporte para `javax.swing` y `java.awt`.
````
**
