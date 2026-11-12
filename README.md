# LP3_Fase3

Repositorio dedicado a las prácticas y ejercicios desarrollados durante la **Fase 3** del curso de **Lenguajes de Programación 3** (Ingeniería de Sistemas - UCSM).

> Este repositorio contiene únicamente el código fuente y la documentación correspondiente a las sesiones de esta fase del semestre.

## Estructura del Repositorio

```text
LP3_Fase3/
├── README.md
└── Sesion9/
    ├── actividad_1/
    │   └── src/
    │       ├── borderLayout/
    │       ├── flowLayout/
    │       └── gridLayout/
    ├── ejercicio_1/
    │   └── src/
    └── ejercicio_2/
        └── src/
```

## Contenido de la Fase 3

### Sesión 9 — Interfaces Gráficas en Java (Swing)

- **Actividad 1 (`Sesion9/actividad_1/src/`)**: Demostración de administradores de diseño (*Layout Managers*) en Java Swing:
  - `flowLayout`: `MarcoFlowLayout.java`, `Main.java`
  - `borderLayout`: `MarcoBorderLayout.java`, `Main.java`
  - `gridLayout`: `MarcoGridLayout.java`, `Main.java`
- **Ejercicio 1 (`Sesion9/ejercicio_1/src/`)**: Formulario de cuestionario (`CuestionarioForm.java`, `CuestionarioForm.form`) con validación de entrada para nombre y edad, indicando si el usuario es mayor o menor de edad mediante componentes Swing (`JFrame`, `JTextField`, `JButton`, `JLabel`, `JOptionPane`).
- **Ejercicio 2 (`Sesion9/ejercicio_2/src/`)**: Aplicación de compra de pasajes terrestres implementada bajo el patrón **Modelo-Vista-Controlador (MVC)**:
  - `Pasaje.java` (Modelo): Encapsula los datos del pasajero y reglas de validación.
  - `VistaCompraPasaje.java` (Vista): Interfaz gráfica Swing para el registro de la compra.
  - `ControladorPasaje.java` (Controlador): Gestión de eventos y comunicación entre vista y modelo.
  - `App.java`: Punto de entrada de la aplicación.

## Requisitos

- **Java JDK** (8 o superior) con soporte para `javax.swing` y `java.awt`.
````
