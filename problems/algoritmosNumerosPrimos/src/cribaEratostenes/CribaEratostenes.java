package cribaEratostenes;

import java.util.Arrays;

public class CribaEratostenes {
    public static boolean[] encontrarPrimos(int limite) {
        boolean[] esPrimo = new boolean[limite + 1];
        Arrays.fill(esPrimo, true);

        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i * i <= limite; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= limite; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }

    public static void main(String[] args) {
        int limite = 30;
        boolean[] primos = encontrarPrimos(limite);
        for (int i = 2; i <= limite; i++) {
            if (primos[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

