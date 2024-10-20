package Repaso;

import java.util.Scanner;

public class Calculadora implements OperacionesMatematicas {

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }

    @Override
    public int restar(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }

    @Override
    public double dividir(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        OperacionesMatematicas calculadora = new Calculadora();
        Scanner sc = new Scanner(System.in);
        boolean repetir = true;
        while (repetir) {
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            int opcion = sc.nextInt();

            if (opcion == 5) {
                System.out.println("Saliendo de la calculadora");
                repetir = false;
            } else if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida");
            } else {
                System.out.println("Ingrese los dos números a operar: ");
                int a = sc.nextInt();
                int b = sc.nextInt();

                System.out.print("Resultado: ");

                switch (opcion) {
                    case 1:
                        System.out.println(calculadora.sumar(a, b));
                        break;
                    case 2:
                        System.out.println(calculadora.restar(a, b));
                        break;
                    case 3:
                        System.out.println(calculadora.multiplicar(a, b));
                        break;
                    case 4:
                        System.out.println(calculadora.dividir(a, b));
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            }

        }

        sc.close();
    }
}
