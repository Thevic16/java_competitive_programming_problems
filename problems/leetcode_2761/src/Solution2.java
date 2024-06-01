import java.math.BigInteger;
import java.util.*;

// https://leetcode.com/problems/prime-pairs-with-target-sum/submissions/1261907345/

public class Solution2 {

    public static void main(String[] args) {
        List<List<Integer>> r1 = findPrimePairs(10);
        List<List<Integer>> r2 = findPrimePairs(2);
        List<List<Integer>> r3 = findPrimePairs(1);
        List<List<Integer>> r4 = findPrimePairs(5);
        List<List<Integer>> r5 = findPrimePairs(133);
//        List<List<Integer>> r6 = findPrimePairs(1000000);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
//        System.out.println(r6);
    }

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> resultados = new ArrayList<>();


        if(n <= 2){
            return resultados;
        }

        ArrayList<Boolean> primos = encontrarPrimos(n+1);
        ArrayList<Boolean> visitados = inicializarListaBooleana(n + 1);

        for (int i = 0; i <= n; i++) {

            if((n-i)<= n && (n-i) > 0 && primos.get(i) && primos.get(n-i) && !visitados.get(i) && !visitados.get(n-i)){
                resultados.add(new ArrayList<>(Arrays.asList(i,n-i)));
                visitados.set(i, true);
                visitados.set(n-i, true);
            }

        }

        Collections.sort(resultados, (a, b) -> Integer.compare(a.get(0),b.get(0)));
        return resultados;
    }

    public static ArrayList<Boolean> encontrarPrimos(long limite) {
        ArrayList<Boolean> esPrimo = new ArrayList<Boolean>((int) (limite + 1));

        for (int i = 0; i <= limite; i++) {
            esPrimo.add(true);
        }

        esPrimo.set(0, false);
        esPrimo.set(1, false);

        for (int i = 2; i * i <= limite; i++) {
            if (esPrimo.get(i)) {
                for (long j = (long) (i * i); j <= limite; j += i) {
                    esPrimo.set((int) j, false);
                }
            }
        }
        return esPrimo;
    }

    public static BigInteger calcularMCD(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    public static ArrayList<Boolean> obtenerIndicadoresPrimos(int n) {
        BigInteger prod = BigInteger.valueOf(2);
        ArrayList<Boolean> indicadoresPrimos = inicializarListaBooleana(n + 1);

        indicadoresPrimos.set(2, true);

        for (BigInteger primo = BigInteger.valueOf(3); primo.compareTo(BigInteger.valueOf(n)) <= 0; primo = primo.add(BigInteger.valueOf(2))) {
            BigInteger resultadoMCD = calcularMCD(prod, primo);

            if (resultadoMCD.compareTo(BigInteger.ONE) == 0) {
                prod = prod.multiply(primo);
                indicadoresPrimos.set(primo.intValue(), true);
            }
        }

        return indicadoresPrimos;
    }

    public static ArrayList<Boolean> inicializarListaBooleana(int n) {
        ArrayList<Boolean> listaBooleana = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            listaBooleana.add(false);
        }

        return listaBooleana;
    }

}
