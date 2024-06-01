import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// https://leetcode.com/problems/closest-prime-numbers-in-range/

class Solution {

    public static void main(String[] args) {
//        int[] prueba1 = closestPrimes(10, 19);
//        int[] prueba2 = closestPrimes(4, 6);
        int[] prueba3 = closestPrimes(19, 31);

        System.out.println(prueba3);
    }
    public static int[] closestPrimes(int left, int right) {
        ArrayList<Boolean> indicadoresPrimo = obtenerIndicadoresPrimos(right);
        List<Integer> resultado = obtenerResultado(indicadoresPrimo, left, right, Optional.empty(),
                Optional.empty(), Optional.empty());

        return new int[]{resultado.get(0), resultado.get(1)};
    }

    public static List<Integer> obtenerResultado(List<Boolean> indicadoresPrimo, int left, int right,
                                                 Optional<Integer> resulIzqOptional,
                                                 Optional<Integer> resultDerOptional,
                                                 Optional<Integer> ultimoPrimoOptional){
        if(left > right && resulIzqOptional.isEmpty() && resultDerOptional.isEmpty()){
            List<Integer> resultado = new ArrayList<>();
            resultado.add(-1);
            resultado.add(-1);
            return resultado;
        } else if (left > right && resultDerOptional.isEmpty()) {
            List<Integer> resultado = new ArrayList<>();
            resultado.add(-1);
            resultado.add(-1);
            return resultado;
        } else if (left > right && resulIzqOptional.isPresent() && resultDerOptional.isPresent()) {
            List<Integer> resultado = new ArrayList<>();
            resultado.add(resulIzqOptional.get());
            resultado.add(resultDerOptional.get());
            return resultado;
        } else if (left <= right && indicadoresPrimo.get(left) && resulIzqOptional.isEmpty()) {
            return obtenerResultado(indicadoresPrimo, left +1, right, Optional.of(left), resultDerOptional, Optional.of(left));
        } else if (left <= right && indicadoresPrimo.get(left) && resulIzqOptional.isPresent() && resultDerOptional.isEmpty()) {
            return obtenerResultado(indicadoresPrimo, left +1, right, resulIzqOptional, Optional.of(left), Optional.of(left));
        } else if (left <= right && indicadoresPrimo.get(left) && resulIzqOptional.isPresent() && resultDerOptional.isPresent()) {
            int diferenciaAnterior = resultDerOptional.get() - resulIzqOptional.get();
            int diferenciaActual = left - ultimoPrimoOptional.get();

            if(diferenciaAnterior <= diferenciaActual){
                return obtenerResultado(indicadoresPrimo, left +1, right, resulIzqOptional, resultDerOptional, Optional.of(left));
            }
            else {
                return obtenerResultado(indicadoresPrimo, left +1, right, ultimoPrimoOptional, Optional.of(left), Optional.of(left));
            }
        }
        else {
            return obtenerResultado(indicadoresPrimo, left +1, right, resulIzqOptional, resultDerOptional, ultimoPrimoOptional);
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