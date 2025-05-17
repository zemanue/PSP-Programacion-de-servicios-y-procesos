package multiprocesos;

public class Calculadora {
    public static String calcula(double n1, double n2, String operacion) {
        switch (operacion) {
            case "suma":
                return "El resultado de la suma es: " + (n1 + n2);
            case "resta":
                return "El resultado de la resta es: " + (n1 - n2);
            case "multiplicacion":
                return "El resultado de la multiplicación es: " + (n1 * n2);
            case "division":
                return "El resultado de la división es: " + (n1 / n2);
            default:
                return "Operación no válida.";
        }
    }

    public static void main(String[] args) {
        double n1 = Double.parseDouble(args[0]);
        double n2 = Double.parseDouble(args[1]);
        String operacion = args[2];

        System.out.println(calcula(n1, n2, operacion));
    }
}
