package aritmeticaModular;

public class EjemploBasicoCiclo {
    public static void main(String[] args) {
        int m = 12;

        for (int i = 0; i < 100; i++) {
            int x = i % m;
            System.out.println("Iteración: " + i + " % (12) = " + x);
        }

    }
}
