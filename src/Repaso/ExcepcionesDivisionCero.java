
// Ejercicio 1:
// Crea un programa en Java que:
// 1. Solicite al usuario que introduzca dos números enteros por consola.
// 2. Realice la división del primer número entre el segundo y muestre el resultado.
// 3. Implemente manejo de excepciones para capturar y manejar adecuadamente ArithmeticException en caso de que el usuario intente
// dividir por cero.
// 4. Asegúrese de que, después de una excepción, el programa siga funcionando y permita al usuario intentar de nuevo con nuevos números


package Repaso;

import java.util.Scanner;

public class ExcepcionesDivisionCero {
    public static void main(String[] args) {

        boolean repetir = true;
        Scanner sc = new Scanner(System.in);

        while (repetir) {
            System.out.println("Introduce dos números enteros para dividirlos:");

            int a = sc.nextInt();
            int b = sc.nextInt();

            try {

                if (b == 0) {
                    throw new ArithmeticException(
                            "No se puede dividir por cero. Inténtalo de nuevo con otros dos números.");
                }

                double resultado = (double) a / b;

                System.out.print("El resultado es: ");

                if (resultado % 1 == 0) { // Si el resultado es entero, muestra el resultado sin números decimales
                    System.out.println((int) resultado);
                } else { // Si el resultado es decimal, muestra el resultado con números decimales
                    System.out.println(resultado);
                }

                repetir = false;

            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir por cero. Inténtalo de nuevo con otros dos números.");
            }
        }

        sc.close();
    }
}
