package servicios_en_red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MsgServerNom {
    public static ArrayList<ClientHandler> clientes = new ArrayList<ClientHandler>();
    private static Set<String> usernames = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Servidor iniciado en " + serverIP + " puerto 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
                clientes.add(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized boolean addUsername(String username) {
        return usernames.add(username);
    }

    public static synchronized void removeUsername(String username) {
        usernames.remove(username);
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private String username;
    private PrintWriter out;
    private BufferedReader in;

    ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public Socket getSocket() {
        return this.clientSocket;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Recibir y validar username
            boolean usernameAccepted = false;
            while (!usernameAccepted) {
                username = in.readLine();
                if (MsgServerNom.addUsername(username)) {
                    out.println("NOMBRE_ACEPTADO");
                    usernameAccepted = true;
                } else {
                    out.println("NOMBRE_EN_USO");
                    continue;
                }
            }

            System.out.println("Usuario '" + username + "' se ha conectado desde: " 
                + clientSocket.getInetAddress().getHostAddress());

            String mensaje;
            do {
                mensaje = in.readLine();
                String[] partes = mensaje.split(":");
                String destino;
                if(partes.length > 1) {
                    destino = partes[0];
                    mensaje = partes[1];
                } else {
                    destino = "Ninguno";
                }

                if(!mensaje.equals("0")) {
                    System.out.println("El usuario '" + username + "' dice \"" + mensaje + 
                        "\" al usuario '" + destino + "'");
                } else {
                    System.out.println("El usuario '" + username + "' se ha desconectado.");
                }

                boolean mensajeEntregado = false;
                for(ClientHandler cliente : MsgServerNom.clientes) {
                    if(cliente.getUsername().equals(destino)) {
                        Socket destinoSocket = cliente.getSocket();
                        PrintWriter outDestino = new PrintWriter(destinoSocket.getOutputStream(), true);
                        outDestino.println("El usuario '" + username + "' dice: " + mensaje);
                        out.println("Mensaje entregado a '" + destino + "'");
                        mensajeEntregado = true;
                        break;
                    }
                }
                
                if(!mensajeEntregado && !destino.equals("Ninguno")) {
                    out.println("El usuario '" + destino + "' no está conectado.");
                }

            } while (!mensaje.equals("0"));

            MsgServerNom.removeUsername(username);
            MsgServerNom.clientes.remove(this);
            clientSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}