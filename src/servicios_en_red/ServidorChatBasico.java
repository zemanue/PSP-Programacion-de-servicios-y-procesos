package servicios_en_red;

import java.io.*;
import java.net.*;

public class ServidorChatBasico {
    private static final int PUERTO = 2000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);

            // Con el método accept() el servidor espera a que un cliente se conecte
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress());

            // Aquí se crean los flujos de entrada y salida
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);

            // Se lee el mensaje del cliente
            String mensajeCliente = in.readLine();
            System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

            // Se envía una respuesta al cliente
            out.println("Mensaje recibido por el servidor: " + mensajeCliente);

            socketCliente.close();
            System.out.println("Conexión con el cliente cerrada.");

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}