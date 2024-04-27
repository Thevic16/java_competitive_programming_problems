package problemas;

import java.util.Arrays;

// https://leetcode.com/problems/count-primes/

public class CountPrimes {

    public int countPrimes(int n) {
        if(n == 0 || n == 1){
            return 0;
        }

        boolean[] esPrimo = encontrarPrimos(n);

        return contarPrimos(esPrimo);
    }


    public static boolean[] encontrarPrimos(int limite) {
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

        return esPrimo;
    }

    public static int contarPrimos(boolean[] esPrimo){
        int cont = 0;

        for (int i = 0; i < esPrimo.length; i++) {
            if(esPrimo[i] == true){
                cont = cont + 1;
            }
        }

        return cont;
    }


}
