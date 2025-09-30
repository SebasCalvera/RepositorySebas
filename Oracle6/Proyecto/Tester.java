package Oracle6.Proyecto;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Tester {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = -1; // INDICACIÓN: valor que falle el ciclo hasta que se asigna uno correcto
 
        System.out.println("Enter the number of products you would like to add");
        System.out.println("Enter 0 (zero) if you do not wish to add products:");
 
        // do-while que no termina hasta que se introduce un entero >= 0
        do {
            try {
                System.out.print("Número de productos: ");
                maxSize = scanner.nextInt();
                if (maxSize < 0) {
                    System.out.println("Valor incorrecto introducido. Debe ser 0 o un entero positivo.");
                }
            } catch (InputMismatchException ime) {
                // Tipo de dato introducido no es un entero
                System.out.println("Tipo de datos incorrecto introducido.");
                scanner.nextLine(); // limpia buffer de entrada
            } catch (Exception e) {
                // Captura genérica y limpieza de buffer
                System.out.println(e);
                scanner.nextLine();
            }
        } while (maxSize < 0);
 
        // Si maxSize == 0, no se requieren productos
        if (maxSize == 0) {
            System.out.println("No se requieren productos.");
            scanner.close();
            return;
        }
 
        // maxSize > 0 -> crear arreglo
        Product[] productos = new Product[maxSize];
 
        for (int i = 0; i < maxSize; i++) {
            // limpiar buffer antes de leer cadenas si la última entrada fue numérica
            scanner.nextLine();
 
            System.out.printf("---- Introduzca datos para el producto %d ----%n", i + 1);
 
            // Nombre
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
 
            // Cantidad (int) con validación
            int quantity = -1;
            while (quantity < 0) {
                try {
                    System.out.print("Cantidad (entero >= 0): ");
                    quantity = Integer.parseInt(scanner.nextLine().trim());
                    if (quantity < 0) {
                        System.out.println("La cantidad debe ser 0 o un entero positivo.");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Tipo de datos incorrecto introducido para cantidad. Introduce un entero.");
                }
            }
 
            // Precio (double) con validación
            double price = -1.0;
            while (price < 0.0) {
                try {
                    System.out.print("Precio (ej. 19.99): ");
                    price = Double.parseDouble(scanner.nextLine().trim());
                    if (price < 0.0) {
                        System.out.println("El precio no puede ser negativo.");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Tipo de datos incorrecto introducido para precio. Introduce un número (ej. 12.50).");
                }
            }
 
            // Número de elemento (int) con validación
            int itemNumber = -1;
            while (itemNumber < 0) {
                try {
                    System.out.print("Número de elemento (entero >= 0): ");
                    itemNumber = Integer.parseInt(scanner.nextLine().trim());
                    if (itemNumber < 0) {
                        System.out.println("El número de elemento debe ser 0 o un entero positivo.");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Tipo de datos incorrecto introducido para número de elemento. Introduce un entero.");
                }
            }
 
            // Crear y guardar el producto en el arreglo
            productos[i] = new Product(name, quantity, price, itemNumber);
            System.out.println("Producto añadido correctamente.\n");
        }
 
        // Mostrar todos los productos con for-each
        System.out.println("===== Resumen de productos =====");
        for (Product p : productos) {
            System.out.println(p);
        }
 
        scanner.close();
    }
}
 