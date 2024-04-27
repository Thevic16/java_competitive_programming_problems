import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

// https://www.hackerrank.com/challenges/leonardo-and-prime/problem

class Result {

    /*
     * Complete the 'primeCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static int primeCount(long n) {
        // Write your code here
        ArrayList<Boolean> primos = encontrarPrimos((long) Math.sqrt(n)+1);
        int count = 0;
        Long factor = 1L;

        for (Long i = 0L; i <= (long) Math.sqrt(n)+1; i++) {
            if(primos.get(Math.toIntExact(i))){
                factor *= i;

                if (factor <= n){
                    count += 1;
                }
                else {
                    break;
                }
            }
        }

        return count;
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

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                int result = Result.primeCount(n);

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
