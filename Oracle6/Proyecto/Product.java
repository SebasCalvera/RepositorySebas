package Oracle6.Proyecto;

 
/**
* Clase que representa un producto genérico.
*/
public class Product {
    private String name;
    private int quantity;
    private double price;
    private int itemNumber;
 
    public Product(String name, int quantity, double price, int itemNumber) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.itemNumber = itemNumber;
    }
 
    // Getters (si los necesitas después)
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public int getItemNumber() { return itemNumber; }
 
    @Override
    public String toString() {
        return String.format("Producto: %s | Cantidad: %d | Precio: %.2f | Nº de elemento: %d",
                name, quantity, price, itemNumber);
    }
}
 
