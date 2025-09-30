package Oracle6.Practica2;

public class Ejercicio2 {
    public static void main(String[] args) {
        String str = "Hello World";

        for(int i = 0; i < 4; i++){
        System.out.println(str);
        }
    }
}

/*
 * for(int i = 0; i < 4; i++);   // <-- Este punto y coma cierra el for inmediatamente
 * 
 * 
 * En cada iteración del bucle, se añade un signo de exclamación al final de la cadena.
 */


 /*


a) ERROR DE SINTAXIS

System.out.println("Hola mundo")   //  Falta el ;

El compilador detecta este error y NO permite ejecutar 
el programa.


b) ERROR LÓGICO

Ejemplo: calcular el área de un triángulo. La fórmula 
correcta es (base * altura) / 2, pero si olvidamos dividir 
entre 2:

    int base = 10;
    int altura = 5;
    int area = base * altura;  // Error lógico
    System.out.println("Área del triángulo: " + area);

Resultado obtenido: 50  
Resultado correcto: 25


c) UNA EXCEPCIÓN

    try {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[5]);  //  Índice inválido
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: índice fuera de rango en el arreglo.");
    }

En este caso, el bloque try intenta ejecutar el código, y el bloque catch atrapa la excepción evitando 
que el programa se cierre inesperadamente.

*/




