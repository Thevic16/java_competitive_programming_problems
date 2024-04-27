import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result2 {

    /*
     * Complete the 'primeCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static int primeCount(long n) {
        int count = 0;
        int factor = 1;
        List<Integer> primes = new ArrayList<>();

        if(2 <= n){
            primes.add(2);  // Agregamos el primer número primo a la lista
            factor *= 2;
            count += 1;
        }
        else {
            return count;
        }

        int nextPrime = generateNextPrime(primes);

        while (factor < n){
            primes.add(nextPrime);
            factor *= nextPrime;
            count += 1;

            nextPrime = generateNextPrime(primes);
        }

        return count;
    }

    public static int generateNextPrime(List<Integer> primes) {
        int lastPrime = primes.isEmpty() ? 1 : primes.get(primes.size() - 1);
        int nextPrime = lastPrime + 1;

        while (!isPrime(nextPrime)) {
            nextPrime++;
        }

        primes.add(nextPrime);
        return nextPrime;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                int result = Result2.primeCount(n);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
