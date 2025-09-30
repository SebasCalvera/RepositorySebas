package Oracle6.Practica1;

public class Ejercicio1 {


    public static void main(String[] args) {
        //1. array con 9 valores
        int[] calificacion = new int[9];
       
 
        //2. array con dos dimensiones
        float[][] precio = new float[10][3];
       
 
        //3. array bidimensional
        long[][] arreglo = {
            {5, 5, 5},
            {5, 5, 5},
            {5, 5, 5},
            {5, 5, 5}
        };
        System.out.println(arreglo.length);
 
        //4. array unidimensional
        int[] valores = {1,1,1,1,1,1,1,1,1,1};
       
    }
}
 
 /*


 //5. Sin escribir el código, determine el resultado del siguiente programa
      
 int num[] = {7,7,6,6,5,5,4,4};
        for(int i = 0; i < 8; i = i + 2)
        System.out.print(num[i]);
 
        Resultado: 7654
        */
 

       // 6. Sin escribir el código, determine el resultado del siguiente programa.
       
       /*
        int[][] num = {{3,3,3},{2,2,2}};
        int[] array = {4,3,2};
        for(int i = 0; i < 3; i++){
        num[1][i] = num[0][i]+array[i];
        }
        for(int i = 0; i < 2; i++){  
        for(int j = 0; j < 3; j++){
        System.out.print(num[i][j]);
        }
        System.out.println();
        }
       
 
        Resultado: 333 - 765
 
         */
 