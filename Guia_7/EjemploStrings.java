package Guia_7;

public class EjemploStrings {
    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.agregarAlFinal("Manzana");
        lista.agregarAlFinal("Banana");
        lista.agregarAlInicio("Pera");
        lista.mostrarLista(); // Muestra: Pera -> Manzana -> Banana -> NULL
        System.out.println("¿Está 'Banana'? " + lista.buscar("Banana")); // true
        lista.eliminar("Manzana");
        lista.mostrarLista(); // Muestra: Pera -> Banana -> NULL
    }
}
