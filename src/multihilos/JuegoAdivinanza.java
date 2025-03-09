package multihilos;

import java.util.Random;

// Clase que representa el número secreto y el estado del juego
class NumeroSecreto {
    private int numero;
    private boolean juegoTerminado;

    public NumeroSecreto(int numero) {
        this.numero = numero;
        this.juegoTerminado = false;
    }

    // Método sincronizado para proponer un número
    public synchronized int intentarAdivinar(int propuesta) {
        if (juegoTerminado) {
            return -1; // El juego ya ha terminado
        }

        if (propuesta == numero) {
            juegoTerminado = true;
            return 1; // Número adivinado correctamente
        }

        return 0; // Número incorrecto
    }
}

// Clase que representa un hilo adivinador
class HiloAdivinador implements Runnable {
    private NumeroSecreto numeroSecreto;
    private int idHilo;
    private Random random;

    public HiloAdivinador(NumeroSecreto numeroSecreto, int idHilo) {
        this.numeroSecreto = numeroSecreto;
        this.idHilo = idHilo;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            int propuesta = random.nextInt(101); // Número aleatorio entre 0 y 100
            int resultado = numeroSecreto.intentarAdivinar(propuesta);

            if (resultado == 1) {
                System.out.println(String.format("¡Hilo %d ha adivinado el número secreto! Era: %d", idHilo, propuesta));
                break;
            } else if (resultado == -1) {
                System.out.println(String.format("¡Hilo %d ha perdido! Otro hilo ya ha adivinado el número secreto.", idHilo));
                break;
            } else {
                System.out.println(String.format("Hilo %d propone: %d (incorrecto)", idHilo, propuesta));
            }

            try {
                Thread.sleep(100); // Pequeña pausa entre intentos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(101); // Número aleatorio entre 0 y 100
        
        System.out.println("Número secreto generado: " + numeroSecreto);

        NumeroSecreto numeroOculto = new NumeroSecreto(numeroSecreto);
        Thread[] hilosAdivinadores = new Thread[10]; // Array para almacenar los 10 hilos adivinadores

        // Crear y lanzar los hilos adivinadores
        for (int i = 0; i < hilosAdivinadores.length; i++) {
            hilosAdivinadores[i] = new Thread(new HiloAdivinador(numeroOculto, i + 1));
            hilosAdivinadores[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilosAdivinadores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin del juego.");
    }
}