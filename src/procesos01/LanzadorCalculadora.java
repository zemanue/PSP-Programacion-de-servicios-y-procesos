package procesos01;

import java.io.BufferedReader;
import java.io.FileReader;

public class LanzadorCalculadora {
    public Process LanzarOperacion(Double n1, Double n2, String operacion) {
        // Obtener la ruta absoluta de la clase Calculadora
        String rutaClaseCalculadora = System.getProperty("user.dir") + "/src/procesos01/Calculadora.java";

        ProcessBuilder pb;
        try {
            // Crear un nuevo proceso que ejecute la clase Calculadora con los argumentos
            // que necesita (n1, n2 y operacion)
            pb = new ProcessBuilder("java", rutaClaseCalculadora, n1.toString(), n2.toString(), operacion);
            // Redirigir la entrada y salida estándar del proceso (la terminal en este caso)
            pb.inheritIO();
            // Iniciar el proceso
            return pb.start();
        } catch (Exception e) {
            System.err.println("Error al lanzar la operación: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        
        // LANZAR UNA OPERACIÓN CON UN PROCESO
        System.out.println("Lanzando operación 1 con un proceso...");
        LanzadorCalculadora lanzador = new LanzadorCalculadora();
        String nombreArchivo = System.getProperty("user.dir") + "/src/procesos01/operacion_1.txt";
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
        System.out.println("----------------------------------------");

        // LANZAR VARIAS OPERACIONES CON VARIOS PROCESOS
        System.out.println("Lanzando 4 operaciones con un proceso cada una...");
        final int NUM_PROCESOS = 4;
        Process p;

        // OPCIÓN PARA GARANTIZAR ORDEN: ESPERAR A QUE TERMINE CADA PROCESO ANTES DE LANZAR EL SIGUIENTE
        System.out.println("Esperando a que termine cada proceso antes de lanzar el siguiente...");
        System.out.println("Garantizamos que las operaciones se ejecuten en orden, pero se pierde velocidad.");
        for (int i = 0; i < NUM_PROCESOS; i++) {
            // Obtenemos el nombre del archivo de operación correspondiente
            nombreArchivo = System.getProperty("user.dir") + "/src/procesos01/operacion_" + (i + 1) + ".txt";
            // Leemos el archivo línea por línea
            try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
                // Convertimos los números a Double
                n1 = Double.parseDouble(reader.readLine());
                n2 = Double.parseDouble(reader.readLine());
                operacion = reader.readLine();
                System.out.println("Lanzando operación " + (i + 1) + "...");
                // Lanzamos el proceso con los números y la operación leídos
                p = lanzador.LanzarOperacion(n1, n2, operacion);
                // Esperamos a que el proceso termine antes de pasar al siguiente
                p.waitFor();
            } catch (Exception e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
        System.out.println("----------------------------------------");

        // OPCIÓN PARA RÁPIDA: LANZAR TODOS LOS PROCESOS Y ESPERAR A QUE TERMINEN (SIN ORDEN)
        System.out.println("Lanzando todos los procesos y esperando a que terminen...");
        System.out.println("Permite lanzar todos los procesos a la vez, pero no garantiza el orden de ejecución.");
        Process[] procesos = new Process[NUM_PROCESOS];
        for (int i = 0; i < NUM_PROCESOS; i++) {
            // Obtenemos el nombre del archivo de operación correspondiente
            nombreArchivo = System.getProperty("user.dir") + "/src/procesos01/operacion_" + (i + 1) + ".txt";
            // Leemos el archivo línea por línea
            try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
                // Convertimos los números a Double
                n1 = Double.parseDouble(reader.readLine());
                n2 = Double.parseDouble(reader.readLine());
                operacion = reader.readLine();
                System.out.println("Lanzando operación " + (i + 1) + "...");
                // Lanzamos el proceso con los números y la operación leídos
                procesos[i] = lanzador.LanzarOperacion(n1, n2, operacion);
            } catch (Exception e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
        System.out.println("----------------------------------------");

    }
}
