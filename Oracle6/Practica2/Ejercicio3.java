public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            String texto = null;  
            // Intentamos usar el objeto null
            System.out.println("La longitud es: " + texto.length());  
        } catch (NullPointerException e) {
            System.out.println("Error: Intentaste acceder a un objeto que no existe (null).");
        }
    }
}

        

