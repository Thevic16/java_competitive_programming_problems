package maximoComunDivisor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class PrimeNumberDetector {

    // Método para calcular el máximo común divisor (GCD) de dos números BigInteger
    public static BigInteger calcularMCD(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    // Método para obtener una lista de indicadores booleanos de números primos hasta el número dado 'n'
    public static ArrayList<Boolean> obtenerIndicadoresPrimos(int n) {
        BigInteger prod = BigInteger.valueOf(2); // Inicializar el producto acumulado con 2
        ArrayList<Boolean> indicadoresPrimos = inicializarListaBooleana(n + 1); // Inicializar la lista de indicadores

        indicadoresPrimos.set(2, true); // Establecer el primer número primo, 2, como verdadero

        // Iterar sobre los números impares a partir de 3 hasta 'n'
        for (BigInteger primo = BigInteger.valueOf(3); primo.compareTo(BigInteger.valueOf(n)) <= 0; primo = primo.add(BigInteger.valueOf(2))) {
            // Calcular el máximo común divisor entre el producto acumulado y el número actual
            BigInteger resultadoMCD = calcularMCD(prod, primo);

            // Si el máximo común divisor es 1, entonces el número es primo
            if (resultadoMCD.compareTo(BigInteger.ONE) == 0) {
                prod = prod.multiply(primo); // Actualizar el producto acumulado
                indicadoresPrimos.set(primo.intValue(), true); // Establecer el indicador del número primo como verdadero
            }
        }

        return indicadoresPrimos; // Devolver la lista de indicadores booleanos de números primos
    }

    // Método para inicializar una lista de booleanos con valores predeterminados como falsos
    public static ArrayList<Boolean> inicializarListaBooleana(int n) {
        ArrayList<Boolean> listaBooleana = new ArrayList<>(n);

        // Llenar la lista con valores predeterminados (en este caso, todos falsos)
        for (int i = 0; i < n; i++) {
            listaBooleana.add(false);
        }

        return listaBooleana;
    }

    // Método principal para probar la funcionalidad de obtenerIndicadoresPrimos
    public static void main(String[] args) {
        int limiteSuperior = 100; // Definir el límite superior para generar la lista de indicadores primos
        ArrayList<Boolean> indicadoresPrimos = obtenerIndicadoresPrimos(limiteSuperior); // Obtener la lista de indicadores primos
        System.out.println(indicadoresPrimos); // Imprimir la lista de indicadores primos
    }

}
