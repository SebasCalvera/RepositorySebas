package Oracle6.Practica2;

import java.io.*;

public class EjemploChecked {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("archivo.txt"); // Puede no existir
        } catch (IOException e) {
            System.out.println("Error: el archivo no se encontró.");
        }
    }
}

