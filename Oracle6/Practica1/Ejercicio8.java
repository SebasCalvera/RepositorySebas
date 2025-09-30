package Oracle6.Practica1;

import java.util.Scanner;

public class Ejercicio8 {
    static int[][] A = new int[2][2];
    static int[][] B = new int[2][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("a. Ingresar matriz A");
            System.out.println("b. Ingresar matriz B");
            System.out.println("c. Mostrar A + B");
            System.out.println("d. Mostrar A - B");
            System.out.println("e. Mostrar A * B");
            System.out.println("f. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.next().charAt(0);

            switch (opcion) {
                case 'a':
                    ingresarMatriz(A, sc, "A");
                    break;
                case 'b':
                    ingresarMatriz(B, sc, "B");
                    break;
                case 'c':
                    mostrarMatriz(suma(A, B));
                    break;
                case 'd':
                    mostrarMatriz(resta(A, B));
                    break;
                case 'e':
                    mostrarMatriz(multiplicacion(A, B));
                    break;
                case 'f':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 'f');
    }

    public static void ingresarMatriz(int[][] M, Scanner sc, String nombre) {
        System.out.println("Ingrese valores para la matriz " + nombre + ":");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                M[i][j] = sc.nextInt();
            }
        }
    }

    public static int[][] suma(int[][] X, int[][] Y) {
        int[][] R = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                R[i][j] = X[i][j] + Y[i][j];
            }
        }
        return R;
    }

    public static int[][] resta(int[][] X, int[][] Y) {
        int[][] R = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                R[i][j] = X[i][j] - Y[i][j];
            }
        }
        return R;
    }

    public static int[][] multiplicacion(int[][] X, int[][] Y) {
        int[][] R = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                R[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    R[i][j] += X[i][k] * Y[k][j];
                }
            }
        }
        return R;
    }

    public static void mostrarMatriz(int[][] M) {
        System.out.println("Resultado:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
