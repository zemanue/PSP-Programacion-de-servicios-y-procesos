
// Ejercicio 2:
// Crea un programa en Java que:
// 1. Defina una clase de excepción personalizada InvalidInputException que se lance cuando el usuario ingrese un dato no válido.
// 2. Solicite al usuario que ingrese su edad y valide que sea un número entero positivo.
// 3. Si la entrada no es válida (por ejemplo, una cadena de texto o un número negativo), lance InvalidInputException.
// 4. Implemente un bloque try-catch para capturar la excepción personalizada y proporcione al usuario un mensaje de error claro,
// invitándolo a ingresar un valor válido.
// 5. El programa debe continuar solicitando la edad hasta que se ingrese un valor válido

package Repaso;

import java.util.Scanner;

public class ExcepcionesInvalidInput {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        boolean repetir = true;
        while (repetir) {
            System.out.println("Introduzca su edad: ");

            try {

                int edad = sc.nextInt();
                examinarEdad(edad); // Este método es el que hace saltar la excepción si el número introducido es negativo
                System.out.println("Edad válida.");
                repetir = false;

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }

    public static void examinarEdad(int edad) throws InvalidInputException {
            
        if (edad < 0) {
            throw new InvalidInputException(
                    "El número introducido no es válido (la edad no puede ser negativa). Por favor, ingrese un valor positivo.");
        }
    }

}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
