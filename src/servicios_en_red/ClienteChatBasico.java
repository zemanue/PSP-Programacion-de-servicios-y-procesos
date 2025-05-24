package servicios_en_red;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteChatBasico {
    private static final String HOST = "localhost";
    private static final int PUERTO = 2000;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(HOST, PUERTO);
                // Se crean los flujos de entrada y salida
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)
            ) {

            System.out.println("Conectado al servidor en " + HOST + ":" + PUERTO);

            // Se registra el mensaje a enviar al servidor por la consola
            System.out.print("Escribe tu mensaje para el servidor: ");
            String mensajeAEnviar = scanner.nextLine();

            // Se envía el mensaje al servidor
            out.println(mensajeAEnviar);

            // Se espera la respuesta del servidor
            String respuestaServer = in.readLine();
            System.out.println("Respuesta del servidor: " + respuestaServer);

        } catch (ConnectException ce) {
            System.err
                    .println("No se pudo conectar al servidor. Prueba a iniciar el servidor primero. " + ce.getMessage());
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
