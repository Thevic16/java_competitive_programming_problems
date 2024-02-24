package aritmeticaModular;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CicloAritmeticaModularSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();

        int x = scanner.nextInt();
        int iteraciones = 0;

        Set<Integer> visitados = new HashSet<>();

        while (!visitados.contains(x)) {
            visitados.add(x);
            x = (a * x + b) % m;
            iteraciones++;
        }

        System.out.println("Largo del ciclo: " + iteraciones);
    }
}

