import java.math.BigInteger;
import java.util.*;

// https://leetcode.com/problems/prime-pairs-with-target-sum/submissions/1261907345/

public class Solution {

    public static void main(String[] args) {
//        List<List<Integer>> r1 = findPrimePairs(10);
//        List<List<Integer>> r2 = findPrimePairs(2);
//        List<List<Integer>> r3 = findPrimePairs(1);
//        List<List<Integer>> r4 = findPrimePairs(5);
        //List<List<Integer>> r5 = findPrimePairs(133);
        List<List<Integer>> r6 = findPrimePairs(1000000);

        System.out.println(r6);
    }

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> resultados = new ArrayList<>();


        if(n <= 2){
            return resultados;
        }

        ArrayList<Boolean> listaIndicadoresPrimos = obtenerIndicadoresPrimos(n);
        Set<Integer> setPrimos = obtenerListaPrimo(listaIndicadoresPrimos);
        List<Integer> listaPrimos = setPrimos.stream().sorted().toList();


        for (int i = 0; i < listaPrimos.size(); i++) {
            Optional<List<Integer>> result = getResult(n, listaPrimos.get(i), setPrimos);


            if(result.isPresent()){
                List<Integer> r1 = result.get().stream().sorted().toList();
                resultados = addResultados(resultados, r1);
            }
        }

        return resultados;
    }

    public static List<List<Integer>> addResultados(List<List<Integer>> resultados, List<Integer> r1){

        for (List<Integer> r2: resultados){
            if(sonIguales(r1, r2)){
                 return resultados;
            }
        }

        resultados.add(r1);
        return resultados;
    }


    public  static boolean sonIguales(List<Integer> result1, List<Integer> result2){
        boolean r = true;

        for (int i = 0; i < result1.size(); i++) {
            if(!Objects.equals(result1.get(i), result2.get(i))){
                r = false;
                return r;
            }
        }

        return r;
    }

    public static Set<Integer> obtenerListaPrimo(ArrayList<Boolean> listaIndicadoresPrimos){
        Set<Integer> setPrimos = new HashSet<>();

        for (int i = 0; i < listaIndicadoresPrimos.size(); i++) {
            if(listaIndicadoresPrimos.get(i)){
                setPrimos.add(i);
            }
        }

        return setPrimos;
    }


    public static Optional<List<Integer>> getResult(Integer n, Integer x, Set<Integer> setPrimos){
        ArrayList<Integer> result = new ArrayList<>();

        Integer y = n - x;

        if(setPrimos.contains(y)){
            result.add(x);
            result.add(y);

            return Optional.of(result);
        }
        else {
            return Optional.empty();
        }

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
