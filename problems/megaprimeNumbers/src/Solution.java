import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
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

    public static Long getSolution(long first,  long last){
        Long count = 0L;

        for (long i = first; i <= last ; i++) {
            List<Integer> listDigits = getDigits(i);

            if(validateListDigitsPrime(listDigits)){
                if(esPrimo(i)){
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
