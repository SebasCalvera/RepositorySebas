package Guia_7;

class Persona {
    String nombre;
    int edad;
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}

public class EjemploPersonas {
    public static void main(String[] args) {
        ListaEnlazada<Persona> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(new Persona("Ana", 25));
        lista.agregarAlFinal(new Persona("Luis", 30));
        lista.agregarAlInicio(new Persona("Marta", 22));
        lista.mostrarLista(); // Muestra: Marta (22) -> Ana (25) -> Luis (30) -> NULL
        System.out.println("¿Está Luis? " + lista.buscar(new Persona("Luis", 30))); // false (por equals)
        lista.eliminar(new Persona("Ana", 25)); // No elimina por equals
        lista.mostrarLista(); // Muestra igual
    }
}
