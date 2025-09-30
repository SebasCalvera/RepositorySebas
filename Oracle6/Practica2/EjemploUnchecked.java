package Oracle6.Practica2;

public class EjemploUnchecked {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[5]); // Error en ejecución
    }
}

/*

5. ¿Cuál es la diferencia entre una excepción marcada(Checked) y
   una excepción sin marcar(Unchecked)?


En Java, las excepciones se dividen en dos tipos:

1. Excepciones Marcadas (Checked):
   - El compilador obliga a manejarlas con try/catch o 
     declarando throws en el método.
   - Representan errores previsibles que el programador 
     debe anticipar, como problemas de archivos o bases 
     de datos.
   - Ejemplos: IOException, SQLException, FileNotFoundException.

2. Excepciones No Marcadas (Unchecked):
   - Ocurren en tiempo de ejecución y el compilador no 
     exige manejarlas.
   - Generalmente son errores de lógica o descuidos del 
     programador, como división por cero o acceder a un 
     índice inválido en un arreglo.
   - Ejemplos: ArithmeticException, NullPointerException, 
     ArrayIndexOutOfBoundsException.

Resumen:
- Excepción marcada (checked) → Verificada en compilación,
  el programador debe manejarla.
- Excepción sin marcar (unchecked) → Solo se detecta en 
  ejecución y no es obligatorio controlarla.

*/
