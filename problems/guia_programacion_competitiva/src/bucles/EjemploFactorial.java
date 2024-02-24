package bucles;

public class EjemploFactorial {
    public static void main(String[] args) {
        int numero = 5;
        int factorial = 1;

        // factorial de 5 = 1*2*3*4*5 = 5*4*3*2*1 = 120

        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
            //factorial *= i;
        }

        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}
