package servicios_en_red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MsgClientNom {
    public static boolean ejecutar = true;
    public static String username;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.38", 8080);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Solicitar y validar nombre de usuario
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean usernameAccepted = false;
            while (!usernameAccepted) {
                System.out.print("Ingrese su nombre de usuario: ");
                username = reader.readLine();
                out.println(username);
                
                String response = in.readLine();
                if (response.equals("NOMBRE_ACEPTADO")) {
                    usernameAccepted = true;
                    System.out.println("¡Conexión exitosa!");
                } else if (response.equals("NOMBRE_EN_USO")) {
                    System.out.println("Ese nombre de usuario ya está en uso. Por favor elija otro.");
                }
            }

            escribirRespuesta(in);

            String mensaje = "";
            System.out.println("Para escribir un mensaje usa el formato \"usuario:mensaje\": ");

            do {
                System.out.print("> ");
                mensaje = reader.readLine();
                out.println(mensaje);
            } while (!mensaje.equals("0"));

            socket.close();
            ejecutar = false;
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void escribirRespuesta(final BufferedReader in) throws InterruptedException {
        Thread imprimirThread = new Thread(new ImprimirMensajes(in));
        imprimirThread.start();
    }
}

class ImprimirMensajes implements Runnable {
    private BufferedReader in;

    public ImprimirMensajes(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (MsgClientNom.ejecutar) {
            try {
                if(in.ready()) {
                    System.out.println();
                    String respuesta = in.readLine();
                    System.out.println(respuesta);
                    System.out.print("> ");
                }                 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}