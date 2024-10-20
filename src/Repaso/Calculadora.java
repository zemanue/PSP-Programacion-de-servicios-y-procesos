package Repaso;

public class Calculadora implements OperacionesMatematicas {

    @Override
    public double sumar(int a, int b) {
        return a + b;
    }

    @Override
    public double restar(int a, int b) {
        return a - b;
    }

    @Override
    public double multiplicar(int a, int b) {
        return a * b;
    }

    @Override
    public double dividir(int a, int b) {
        return a / b;
    }

}
