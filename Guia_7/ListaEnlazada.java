package Guia_7;


    
 /**
 * Implementación básica de una lista enlazada simple
 * Demuestra los conceptos fundamentales de nodos y punteros
 */

// Clase principal de la lista enlazada
public class ListaEnlazada<T> {
    // Puntero al primer nodo de la lista
    private Nodo<T> cabeza;
    // Tamaño de la lista
    private int tamaño;

    // Constructor: inicializa la lista vacía
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Agrega un elemento al inicio de la lista
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamaño++;
        System.out.println("Elemento agregado al inicio: " + dato);
    }

    // Agrega un elemento al final de la lista
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
        System.out.println("Elemento agregado al final: " + dato);
    }

    // Muestra todos los elementos de la lista
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        System.out.print("Lista: ");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> NULL");
    }

    // Devuelve el tamaño de la lista
    public int getTamaño() {
        return tamaño;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Busca un elemento en la lista
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Elimina un elemento de la lista
    public boolean eliminar(T dato) {
        if (cabeza == null) {
            return false;
        }
        // Si el elemento a eliminar es el primero
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }
        // Buscar el elemento en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Clase interna para representar nodos de la lista
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato; // 'this.dato' es el atributo del nodo, 'dato' es el parámetro recibido
            this.siguiente = null;
        }
    }
}

