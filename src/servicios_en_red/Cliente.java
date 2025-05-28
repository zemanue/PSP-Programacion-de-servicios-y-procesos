package servicios_en_red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public Cliente() {
        try {
            Socket socket = new Socket("localhost", 2000);
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String datos = entrada.readUTF();
            System.out.println("Servidor dice: " + datos);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}