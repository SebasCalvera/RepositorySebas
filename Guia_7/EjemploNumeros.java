package Guia_7;

public class EjemploNumeros {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlInicio(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.mostrarLista(); // Muestra: 10 -> 20 -> 30 -> NULL
        System.out.println("¿Está el 20? " + lista.buscar(20)); // true
        lista.eliminar(10);
        lista.mostrarLista(); // Muestra: 20 -> 30 -> NULL
    }
}
