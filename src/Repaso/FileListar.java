
// Ejercicio 1:
// Escribe un programa que liste todos los archivos y directorios de un directorio dado por el usuario.

package Repaso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileListar {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta la ruta del directorio:");
        String ruta = sc.nextLine();

        File archivo = new File(ruta);
        String[] lista = archivo.list(); // Devuelve un array de String con los nombres de los archivos y directorios

        System.out.println("Listando archivos del directorio: ");

        for (String elemento : lista) {
            System.out.println(elemento);
        } 

        sc.close();

    }
}
