
// Ejercicio 2:
// Escribe un programa que lea un archivo de texto "texto.txt" y cuente el número de palabras que contiene. 
// Asume que las palabras están separadas por espacios


package Repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderContarPalabras {
    public static void main(String[] args) throws IOException{
        
        System.out.println("Leyendo el número de palabras de texto.txt");

        File archivo = new File("texto.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        br.close();

    }
}
