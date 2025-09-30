package Oracle6.Proyecto;

import java.util.Arrays;
 
public class Inventario {
    private Product[] productos;
    private int count; // número de productos agregados
 
    public Inventario(int maxSize) {
        productos = new Product[maxSize];
        count = 0;
    }
 
    public void agregarProducto(Product p) {
        if (count < productos.length) {
            productos[count] = p;
            count++;
        } else {
            System.out.println("Inventario lleno. No se puede agregar más productos.");
        }
    }
 
    public void mostrarProductos() {
        if (count == 0) {
            System.out.println("Inventario vacío.");
        } else {
            System.out.println("===== Inventario =====");
            for (Product p : Arrays.copyOf(productos, count)) {
                System.out.println(p);
            }
        }
    }
 
    public int getCantidadProductos() {
        return count;
    }
}