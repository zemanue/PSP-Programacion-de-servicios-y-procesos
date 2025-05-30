package servicios_en_red;

import java.net.*;
import java.io.*;

public class ReceptorUDP {

    public static void main(String args[]) {
        // Si hay argumentos, muestra el mensaje de uso (sin argumentos)
        if (args.length != 0) {
            System.err.println("Uso: java ReceptorUDP");
        } else
            try {
                // Crea el socket
                DatagramSocket socket = new DatagramSocket(1500);
                // Crea el espacio para los mensajes
                byte[] cadena = new byte[1000];
                DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
                System.out.println("Esperando mensajes..");

                while (true) {
                    // Recibe y muestra el mensaje
                    socket.receive(mensaje);
                    String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                    System.out.println("\tMensaje Recibido: " + datos);
                }

            } catch (SocketException e) {
                System.err.println("Socket: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("E/S: " + e.getMessage());
            }
    }

}
