
// Ejercicio 2:
// Desarrolla un programa que cree un archivo llamado "miArchivo.txt" y luego lo elimine. El programa debe informar en cada paso si la operación
// fue exitosa o no.

package Repaso;

import java.io.File;
import java.io.IOException;

public class FileCrearYEliminarArchivo {
    public static void main(String[] args) throws IOException {

        System.out.println("Creando archivo");

        File archivo = new File("miArchivo.txt");
        archivo.createNewFile();

        if (!archivo.exists()) {
            System.out.println("Error al crear el archivo.");
        } else {
            System.out.println(archivo.getName() + " se ha creado con éxito.");
            
            System.out.println("Eliminando archivo");

            archivo.delete();

            if (archivo.exists()) {
                System.out.println("Error al eliminar el archivo.");
            } else {
                System.out.println(archivo.getName() + " se ha eliminado con éxito.");
            }

            System.out.println("Programa finalizado.");
        }

    }
}
