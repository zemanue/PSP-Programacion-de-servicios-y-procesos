package procesos01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EjecucionProcesosConOrden {
    public static void main(String[] args) throws Exception {
        // Lista para guardar los comandos que se ejecutarán
        List<ProcessBuilder> processBuilders = new ArrayList<>();
        processBuilders.add(new ProcessBuilder("echo", "Proceso 1 completado"));
        processBuilders.add(new ProcessBuilder("echo", "Proceso 2 completado"));
        processBuilders.add(new ProcessBuilder("echo", "Proceso 3 completado"));

        // Lista para guardar los procesos y sus índices
        List<Process> processes = new ArrayList<>();
        
        // Iniciar los procesos
        for (ProcessBuilder builder : processBuilders) {
            processes.add(builder.start());
        }

        // Lista para guardar los resultados en el mismo orden de inicio
        List<String> results = new ArrayList<>();

        // Recopilar los resultados de los procesos en orden
        for (Process process : processes) {
            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }
            results.add(output.toString().trim()); // Agregar el resultado a la lista
        }

        // Imprimir los resultados en el mismo orden
        for (String result : results) {
            System.out.println(result);
        }
    }
}
