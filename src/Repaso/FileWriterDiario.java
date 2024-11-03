
// Ejercicio 1:
// Crea un programa que permita al usuario escribir entradas en un diario. Cada entrada debe agregarse a un archivo "diario.txt", sin sobrescribir
// el contenido anterior.

package Repaso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDiario {
    public static void main(String[] args) throws IOException {

        System.out.println("Abriendo diario...");
        File diario = new File("diario.txt");
        diario.createNewFile();

        FileWriter fw = new FileWriter(diario, true);

        boolean seguirEscribiendo = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Quieres escribir una entrada en el diario? (s/n)");

        while (seguirEscribiendo) {
            String opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("s")) {
                System.out.println("¿Qué quieres escribir en el diario?");
                String entradaDeDiario = sc.nextLine();

                fw.write(entradaDeDiario);
                fw.flush();
                fw.append("\r\n"); // Añade un salto de línea

                System.out.println("Entrada escrita con éxito.");
                System.out.println("¿Quieres escribir otra entrada? (s/n)");
            } else if (opcion.equalsIgnoreCase("n")) {
                seguirEscribiendo = false;
                System.out.println("Saliendo del diario.");
                sc.close();
            } else {
                System.out.println("Opción no válida. Escribe 's' o 'n'.");
            }            
        }

        fw.close();

    }
}
