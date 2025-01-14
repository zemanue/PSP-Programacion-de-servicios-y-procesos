
package procesos01;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EjecutaComandoTimeout {
    final static int MAX_TIEMPO = 20;

    public static void main(String[] args) {
        
        // Crear un proceso que ejecute el comando para buscar archivos: "cmd /c dir /s /b " + nombre a buscar
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir", "/s", "/b", "operacion_*.txt");
        System.out.println("Ejecutando el comando: " + pb.command());

        pb.inheritIO();
        // Redirigir la salida de error del proceso a la salida estándar
        pb.redirectErrorStream(true);

        try {
            // Iniciar el proceso
            Process p = pb.start();
            // Si el proceso no termina en el tiempo máximo establecido, destruirlo
            if(!p.waitFor(MAX_TIEMPO, TimeUnit.MILLISECONDS)) {
                System.out.println("El comando no ha podido ejecutarse en el tiempo máximo establecido: " + MAX_TIEMPO + " ms.");
                System.out.println("Destruyendo el proceso...");
                p.destroy();
            }
        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error, proceso interrumpido: " + e.getMessage());
        }
    }
}
