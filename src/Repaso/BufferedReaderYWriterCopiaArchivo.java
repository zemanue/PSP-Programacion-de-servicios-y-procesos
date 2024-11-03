
// Ejercicio 1:
// Desarrolla un programa que copie el contenido de un archivo de texto "original.txt" a un nuevo archivo "copia.txt". Asegúrate de que cada línea
// se copie correctamente.

package Repaso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderYWriterCopiaArchivo {
    public static void main(String[] args) throws IOException {

        System.out.println("Copiando original.txt a copia.txt");

        File archivoOriginal = new File("src\\Repaso\\original.txt");
        File archivoCopia = new File("src\\Repaso\\copia.txt");

        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal)); // Esto lee el archivo original
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCopia)); // Esto escribe en la copia

        String linea = br.readLine(); // Se guarda la primera línea del archivo original
        while (linea != null) { // Mientras haya líneas en el archivo original...
            bw.write(linea); // Se escribe la línea en la copia
            bw.newLine(); // Se añade un salto de línea
            linea = br.readLine(); // Se lee la siguiente línea (si no hay más líneas, "linea" será = null)
        }

        System.out.println("Archivo copiado con éxito.");

        br.close();
        bw.close();

    }
}
