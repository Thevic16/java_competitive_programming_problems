package aritmeticaModular;

public class CicloIteracion {
    public static void main(String[] args) {
        int a = 3, m = 7;
        int x = a;

        for (int i = 1; ; i++) {
            x = (x * a) % m;
            System.out.println("Iteración " + i + ": " + x);

            if (x == a) {
                System.out.println("Ciclo encontrado en la iteración " + i);
                break;
            }
        }

    }
}
