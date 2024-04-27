package cribaEratostenes;

import java.util.Arrays;

public class CribaDeEratostenesOptimizada {
    public static void encontrarPrimos(int limite) {
        boolean[] esPrimo = new boolean[limite + 1];
        Arrays.fill(esPrimo, true);

        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i <= Math.sqrt(limite); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= limite; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        System.out.print("Números primos hasta " + limite + ": ");
        for (int i = 2; i <= limite; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int limite = 30;
        encontrarPrimos(limite);
    }
}

