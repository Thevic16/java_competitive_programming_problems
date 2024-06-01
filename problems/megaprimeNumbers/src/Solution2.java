import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Solution2 {
    public static boolean esPrimo(long numero) {
        if (numero < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getDigits(long number) {
        List<Integer> digits = new ArrayList<>();

        // Handle negative numbers by converting them to positive
        if (number < 0) {
            number = -number;
        }

        // Extract digits from the number
        do {
            digits.add((int) (number % 10)); // Add each digit to the front of the list
            number /= 10;
        } while (number > 0);

        return digits;
    }

    public static boolean validateListDigitsPrime(List<Integer> listDigits){
        boolean result = true;

        for (Integer d: listDigits){
            if(!esPrimo(d)){
                result = false;
                return result;
            }
        }

        return result;
    }

    public static BigInteger calcularMCD(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    public static ArrayList<Boolean> obtenerIndicadoresPrimos(long n) {
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

    public static ArrayList<Boolean> inicializarListaBooleana(long n) {
        ArrayList<Boolean> listaBooleana = initializeBooleanList(n);

        for (int i = 0; i < n; i++) {
            listaBooleana.add(false);
        }

        return listaBooleana;
    }

    public static ArrayList<Boolean> initializeBooleanList(long size) {
        ArrayList<Boolean> booleanList = new ArrayList<>((int) size);

        // Add `false` values to the list
        for (long i = 0; i < size; i++) {
            booleanList.add(false);
        }

        return booleanList;
    }

    public static Long getSolution(long first,  long last){
        Long count = 0L;
        ArrayList<Boolean> listIndicadorPrimos = obtenerIndicadoresPrimos(last);

        for (long i = first; i <= last ; i++) {

            if(listIndicadorPrimos.get((int) i)){
                List<Integer> listDigits = getDigits(i);

                if(validateListDigitsPrime(listDigits)){
                    count += 1;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long first = Long.parseLong(firstMultipleInput[0]);

        long last = Long.parseLong(firstMultipleInput[1]);

        // Write your code here
        System.out.println(getSolution(first, last));

        bufferedReader.close();
    }
}
