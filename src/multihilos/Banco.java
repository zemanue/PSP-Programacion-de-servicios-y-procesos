package multihilos;

class CuentaBancaria {
    private double saldo;
    private String nombreBanco;
    private final String moneda = " euros";

    public CuentaBancaria(double saldo, String nombreBanco) {
        this.saldo = saldo;
        this.nombreBanco = nombreBanco;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getMoneda() {
        return moneda;
    }

    public synchronized void depositar(int idCliente, double cantidad) {
        System.out.printf("Cliente %d intenta depositar %.2f%s \n", idCliente, cantidad, this.getMoneda());
        double saldoAnterior = this.getSaldo();
        this.saldo += cantidad;
        System.out.printf("Cliente %d depositó: %.2f%s \n", idCliente, cantidad, this.getMoneda());
        System.out.printf("Saldo anterior: %.2f%s. Saldo actual: %.2f%s\n", saldoAnterior, this.getMoneda(), this.getSaldo(), this.getMoneda());
    }

    public synchronized void retirar(int idCliente, double cantidad) {
        System.out.printf("Cliente %d intenta retirar %.2f%s \n", idCliente, cantidad, this.getMoneda());
        double saldoAnterior = this.getSaldo();
        if (saldo >= cantidad) {
            this.saldo -= cantidad;
            System.out.printf("Cliente %d retiró: %.2f%s\n", idCliente, cantidad, this.getMoneda());
            System.out.printf("Saldo anterior: %.2f%s. Saldo actual: %.2f%s\n", saldoAnterior, this.getMoneda(), this.getSaldo(), this.getMoneda());
        } else {
            System.out.printf("Cliente %d no pudo retirar %.2f%s. Saldo insuficiente.\n", idCliente, cantidad, this.getMoneda());
        }
    }
}

class Cliente implements Runnable {
    private final CuentaBancaria cuenta;
    private int idCliente;

    public Cliente(CuentaBancaria cuenta, int idCliente) {
        this.cuenta = cuenta;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if (Math.random() < 0.5) {
                cuenta.depositar(idCliente, 100);
            } else {
                cuenta.retirar(idCliente, 100);
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500, "BBVA");
        System.out.printf("Cuenta bancaria %s creada con saldo inicial de %.2f%s\n", cuenta.getNombreBanco(), cuenta.getSaldo(), cuenta.getMoneda());

        Thread[] clientes = new Thread[5];
        System.out.printf("%d clientes van a realizar transacciones\n", clientes.length);

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Thread(new Cliente(cuenta, i + 1));
            clientes[i].start();
        }

        for (Thread cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Saldo final: %.2f%s\n", cuenta.getSaldo(), cuenta.getMoneda());
    }
}
