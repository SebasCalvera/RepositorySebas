
package Guia_7;

/**
 * Clase Nodo genérica para listas enlazadas
 * Un nodo es como una cajita que guarda un dato y sabe quién es el siguiente nodo en la lista.
 * @param <T> Tipo de dato que almacena el nodo (puede ser número, texto, etc.)
 */
public class Nodo<T> {
    // Aquí guardamos el dato que queremos almacenar en el nodo
    T dato;
    // Aquí guardamos la referencia (puntero) al siguiente nodo de la lista
    Nodo<T> siguiente;

    // Constructor por defecto: crea un nodo vacío, sin dato y sin siguiente
    public Nodo() {
        this.dato = null;      // No hay dato
        this.siguiente = null; // No apunta a ningún nodo
    }

    // Constructor con dato: crea un nodo con un dato, pero sin siguiente
    public Nodo(T dato) {
        this.dato = dato;      // Guarda el dato recibido
        this.siguiente = null; // No apunta a ningún nodo aún
    }

    // Constructor completo: crea un nodo con dato y con referencia al siguiente nodo
    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;          // Guarda el dato recibido
        this.siguiente = siguiente; // Apunta al nodo recibido
    }

    // Métodos para obtener y cambiar el dato guardado en el nodo
    public T getDato() {
        return dato; // Devuelve el dato guardado
    }

    public void setDato(T dato) {
        this.dato = dato; // Cambia el dato guardado
    }

    // Métodos para obtener y cambiar el siguiente nodo al que apunta
    public Nodo<T> getSiguiente() {
        return siguiente; // Devuelve el siguiente nodo
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente; // Cambia el siguiente nodo
    }

    // ¿Este nodo apunta a otro nodo? (true si sí, false si no)
    public boolean tieneSiguiente() {
        return siguiente != null;
    }

    // Para mostrar el nodo como texto (útil para depurar y entender el estado)
    @Override
    public String toString() {
        return "Nodo(dato=" + dato + ", tieneSiguiente=" + tieneSiguiente() + ")";
    }

    // Método para mostrar todos los nodos a partir de este, en forma de cadena
    // Recorre la lista desde este nodo y muestra cada dato
    public void mostrarCadena() {
        Nodo<T> actual = this; // Empezamos desde este nodo
        while (actual != null) {
            System.out.print("[" + actual.dato + "]"); // Muestra el dato
            if (actual.siguiente != null) {
                System.out.print(" -> "); // Si hay siguiente, muestra la flecha
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        System.out.println(" -> NULL"); // Al final muestra que ya no hay más nodos
    }
}

