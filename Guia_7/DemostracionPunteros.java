package Guia_7;

/**
 * Esta clase te ayuda a entender cómo funcionan los punteros (referencias) en Java usando listas enlazadas.
 * Un puntero es simplemente una variable que "apunta" a otro objeto en memoria, como el siguiente nodo de una lista.
 */
public class DemostracionPunteros {
    /**
     * Clase interna para representar un nodo simple
     */
    // Clase interna para representar un nodo simple (solo guarda un número y el siguiente)
    static class NodoSimple {
        int valor; // El dato que guarda el nodo
        NodoSimple siguiente; // El puntero al siguiente nodo

        public NodoSimple(int valor) {
            this.valor = valor; // Guarda el valor
            this.siguiente = null; // Al principio no apunta a nadie
        }

        @Override
        public String toString() {
            return "Nodo(" + valor + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demostración de Punteros/Referencias ===\n");
        // 1. Cómo se crean nodos y cómo se enlazan
        demostrarCreacionReferencias();
        // 2. Cómo puedes mover y manipular los punteros
        demostrarManipulacionPunteros();
        // 3. Qué pasa si dos listas comparten el mismo nodo
        demostrarReferenciasCompartidas();
        // 4. Cómo manejar referencias nulas (cuando un nodo no apunta a nadie)
        demostrarReferenciasNulas();
    }

    // Ejemplo 1: Crear nodos y enlazarlos
    private static void demostrarCreacionReferencias() {
        System.out.println("1. Creación de Referencias:");
        // Creamos tres nodos
        NodoSimple nodo1 = new NodoSimple(10);
        NodoSimple nodo2 = new NodoSimple(20);
        NodoSimple nodo3 = new NodoSimple(30);
        System.out.println("nodo1 apunta a: " + nodo1);
        System.out.println("nodo2 apunta a: " + nodo2);
        System.out.println("nodo3 apunta a: " + nodo3);
        // Enlazamos los nodos para formar una cadena
        nodo1.siguiente = nodo2; // nodo1 apunta a nodo2
        nodo2.siguiente = nodo3; // nodo2 apunta a nodo3
        System.out.println("\nDespués de enlazar:");
        System.out.println("nodo1.siguiente apunta a: " + nodo1.siguiente);
        System.out.println("nodo2.siguiente apunta a: " + nodo2.siguiente);
        System.out.println("nodo3.siguiente apunta a: " + nodo3.siguiente);
        System.out.println();
    }

    // Ejemplo 2: Manipular punteros para insertar nodos en diferentes posiciones
    private static void demostrarManipulacionPunteros() {
        System.out.println("2. Manipulación de Punteros:");
        // Creamos una lista con tres nodos
        NodoSimple cabeza = new NodoSimple(1);
        cabeza.siguiente = new NodoSimple(2);
        cabeza.siguiente.siguiente = new NodoSimple(3);
        System.out.println("Lista original:");
        imprimirLista(cabeza);
        // Insertamos un nodo al inicio
        NodoSimple nuevoCabeza = new NodoSimple(0);
        nuevoCabeza.siguiente = cabeza; // El nuevo nodo apunta al anterior primero
        cabeza = nuevoCabeza;           // Ahora la cabeza es el nuevo nodo
        System.out.println("\nDespués de insertar 0 al inicio:");
        imprimirLista(cabeza);
        // Insertamos un nodo en el medio (después del primer nodo)
        NodoSimple nuevoNodo = new NodoSimple(15);
        nuevoNodo.siguiente = cabeza.siguiente.siguiente; // Apunta al tercer nodo
        cabeza.siguiente.siguiente = nuevoNodo;           // El segundo nodo apunta al nuevo
        System.out.println("\nDespués de insertar 15 en la posición 3:");
        imprimirLista(cabeza);
        System.out.println();
    }

    // Ejemplo 3: Dos listas que comparten el mismo nodo
    private static void demostrarReferenciasCompartidas() {
        System.out.println("3. Referencias Compartidas:");
        NodoSimple nodoCompartido = new NodoSimple(100); // Nodo que será compartido
        NodoSimple lista1 = new NodoSimple(1);
        NodoSimple lista2 = new NodoSimple(2);
        // Ambas listas apuntan al mismo nodo compartido
        lista1.siguiente = nodoCompartido;
        lista2.siguiente = nodoCompartido;
        System.out.println("Lista 1:");
        imprimirLista(lista1);
        System.out.println("Lista 2:");
        imprimirLista(lista2);
        System.out.println("¿Apuntan al mismo nodo? " + (lista1.siguiente == lista2.siguiente));
        // Si cambiamos el valor del nodo compartido, afecta a ambas listas
        nodoCompartido.valor = 200;
        System.out.println("\nDespués de cambiar el valor del nodo compartido:");
        System.out.println("Lista 1:");
        imprimirLista(lista1);
        System.out.println("Lista 2:");
        imprimirLista(lista2);
        System.out.println();
    }

    // Ejemplo 4: Cómo manejar referencias nulas (cuando un nodo no apunta a nadie)
    private static void demostrarReferenciasNulas() {
        System.out.println("4. Manejo de Referencias Nulas:");
        NodoSimple nodo = new NodoSimple(42);
        System.out.println("Nodo creado: " + nodo);
        System.out.println("nodo.siguiente es null: " + (nodo.siguiente == null));
        // Si intentas acceder a un nodo nulo, Java da error (NullPointerException)
        System.out.println("Verificación segura de referencia nula:");
        if (nodo.siguiente != null) {
            System.out.println("El siguiente nodo es: " + nodo.siguiente.valor);
        } else {
            System.out.println("No hay siguiente nodo (referencia nula)");
        }
        // Ejemplo de cómo recorrer la lista sin errores
        System.out.println("\nNavegación segura por lista:");
        NodoSimple actual = nodo;
        int posicion = 0;
        while (actual != null) {
            System.out.println("Posición " + posicion + ": " + actual.valor);
            actual = actual.siguiente; // Mover el puntero al siguiente nodo
            posicion++;
        }
        System.out.println("Fin de la lista alcanzado (puntero es null)");
        System.out.println();
    }

    // Método para mostrar todos los nodos de la lista, desde la cabeza hasta el final
    private static void imprimirLista(NodoSimple cabeza) {
        NodoSimple actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor); // Muestra el valor del nodo
            if (actual.siguiente != null) {
                System.out.print(" -> "); // Si hay siguiente, muestra la flecha
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        System.out.println(" -> NULL"); // Al final muestra que ya no hay más nodos
    }
}
