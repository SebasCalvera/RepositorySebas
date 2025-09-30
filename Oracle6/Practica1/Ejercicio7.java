package Oracle6.Practica1;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] notas = new int[5];
        int suma = 0;

        // Ingresar las 5 notas
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota de la prueba " + (i + 1) + ": ");
            notas[i] = sc.nextInt();
            suma += notas[i];
        }

        // Calcular promedio
        double promedio = (double) suma / notas.length;

        System.out.println("El promedio del estudiante es: " + promedio);
    }
}
