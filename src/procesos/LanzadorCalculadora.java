package procesos;

import java.io.BufferedReader;
import java.io.FileReader;

public class LanzadorCalculadora {
    public Process LanzarOperacion(Double n1, Double n2, String operacion) {
        // Obtener la ruta absoluta de la clase Calculadora
        String rutaClaseCalculadora = System.getProperty("user.dir") + "/src/procesos/Calculadora.java";

        ProcessBuilder pb;
        try {
            // Crear un nuevo proceso que ejecute la clase Calculadora con los argumentos
            // que necesita (n1, n2 y operacion)
            pb = new ProcessBuilder("java", rutaClaseCalculadora, n1.toString(), n2.toString(), operacion);
            // Redirigir la entrada y salida estándar del proceso
            pb.inheritIO();
            // Iniciar el proceso
            return pb.start();
        } catch (Exception e) {
            System.err.println("Error al lanzar la operación: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Lanzar una operación con un solo proceso
        LanzadorCalculadora lanzador = new LanzadorCalculadora();
        String nombreArchivo = System.getProperty("user.dir") + "/src/procesos/operacion_1.txt";
        double n1, n2;
        String operacion;
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            n1 = Double.parseDouble(reader.readLine());
            n2 = Double.parseDouble(reader.readLine());
            operacion = reader.readLine();
            lanzador.LanzarOperacion(n1, n2, operacion);
            System.out.println("Operación lanzada con éxito.");
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
