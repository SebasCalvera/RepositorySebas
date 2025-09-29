package Guia_7;

/**
 * Esta clase te muestra cómo crear nodos, enlazarlos y recorrerlos manualmente.
 * Es útil para entender cómo funciona una lista enlazada desde cero.
 */
public class DemoNodo {
    public static void main(String[] args) {
        System.out.println("=== Demostración de Nodos ===\n");

    // Creamos tres nodos con texto
    Nodo<String> nodo1 = new Nodo<>("Primer nodo");
    Nodo<String> nodo2 = new Nodo<>("Segundo nodo");
    Nodo<String> nodo3 = new Nodo<>("Tercer nodo");

        System.out.println("Nodos creados:");
        System.out.println("Nodo 1: " + nodo1);
        System.out.println("Nodo 2: " + nodo2);
        System.out.println("Nodo 3: " + nodo3);

    // Enlazamos los nodos: nodo1 -> nodo2 -> nodo3
    nodo1.setSiguiente(nodo2);
    nodo2.setSiguiente(nodo3);

        System.out.println("\nDespués de enlazar:");
        System.out.println("Nodo 1: " + nodo1);
        System.out.println("Nodo 2: " + nodo2);
        System.out.println("Nodo 3: " + nodo3);

    System.out.println("\nCadena completa desde nodo1:");
    // Mostramos todos los nodos desde el primero
    nodo1.mostrarCadena();

        // Recorrer la lista nodo por nodo, mostrando la posición y el dato
        System.out.println("\nNavegación manual:");
        Nodo<String> actual = nodo1;
        int contador = 1;
        while (actual != null) {
            System.out.println("Posición " + contador + ": " + actual.getDato());
            actual = actual.getSiguiente();
            contador++;
        }
    }
}