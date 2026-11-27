import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        calculadora.agregarProducto(new Producto("Arroz Varguitas", 50.0));
        calculadora.agregarProducto(new Producto("Turron", 15.0));
        calculadora.agregarProducto(new Producto("Doña pepa", 67.0));   
        
        int opcion;
        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1. Ver productos en el carrito");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Vaciar carrito");
            System.out.println("4. Seleccionar estrategia de descuento y calcular total");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion (1-5): ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarCarrito(calculadora);
                    break;
                case 2:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    calculadora.agregarProducto(new Producto(nombre, precio));
                    System.out.println("Producto agregado.");
                    break;
                case 3:
                    calculadora.getProductos().clear();
                    System.out.println("Carrito vaciado.");
                    break;
                case 4:
                    mostrarCarrito(calculadora);
                    System.out.println("\nSELECCIONE LA ESTRATEGIA DE DESCUENTO");
                    System.out.println("1. Sin Descuento");
                    System.out.println("2. Descuento Fijo (10%)");
                    System.out.println("3. Descuento Porcentual (2 productos iguales -> 30%)");
                    System.out.println("4. Descuento Porcentual Acumulado (>= 3 productos -> 50% al mas barato)");
                    System.out.print("Elija una opcion (1-4): ");
                    int estrategia = scanner.nextInt();
                    scanner.nextLine();

                    switch (estrategia) {
                        case 1:
                            calculadora.setDiscountStrategy(new SinDescuento());
                            break;
                        case 2:
                            calculadora.setDiscountStrategy(new DescuentoFijo());
                            break;
                        case 3:
                            calculadora.setDiscountStrategy(new DescuentoPorcentual());
                            break;
                        case 4:
                            calculadora.setDiscountStrategy(new DescuentoPorcentualAcumulado());
                            break;
                        default:
                            System.out.println("Opcion no valida. Se aplicara Sin Descuento.");
                            calculadora.setDiscountStrategy(new SinDescuento());
                            break;
                    }
                    double precioFinal = calculadora.calculatePrice();
                    System.out.printf("El precio final a pagar es: S/ %.2f%n", precioFinal);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarCarrito(CalculadoraDePrecios calculadora) {
        System.out.println("=== Productos en el carrito ===");
        if (calculadora.getProductos().isEmpty()) {
            System.out.println("(Carrito vacio)");
            return;
        }
        for (Producto p : calculadora.getProductos()) {
            System.out.println("- " + p.getNombre() + ": S/ " + p.getPrecio());
        }
    }
}
    
    

