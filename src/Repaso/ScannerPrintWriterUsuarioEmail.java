
// Ejercicio 1:
// Crea un programa que permita al usuario introducir datos de nuevos usuarios y los almacene en un archivo "usuarios.txt". La información de
// cada usuario debe contener un nombre y un correo electrónico.

package Repaso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerPrintWriterUsuarioEmail {
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Escriba el nombre y el correo electrónico de un usuario.");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Email: ");
            String correo = sc.nextLine();
            System.out.println();
            
            try {
                PrintWriter pw = new PrintWriter("src\\Repaso\\usuarios.txt");
                pw.println("Nombre de usuario: " + nombre + ". Email: " + correo);
                pw.flush();
                System.out.println("Datos guardados");
                pw.close();
            } catch (IOException e) {
                System.out.println("Error al guardar los datos");
            } 

            System.out.println("¿Desea continuar? Escribe 'n' o 'no' si quiere salir, cualquier otro texto para continuar");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("n") || respuesta.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Saliendo del programa");
        sc.close();
    }
}
