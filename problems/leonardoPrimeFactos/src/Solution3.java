import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

class Result3 {

    /*
     * Complete the 'primeCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    public static int primeCount(long n) {
        int count = 1;
        BigInteger prod = BigInteger.valueOf(2);


        if (n < 2) {
            return 0;
        }


        for (BigInteger prim = BigInteger.valueOf(3); prod.multiply(prim).compareTo(BigInteger.valueOf(n)) <= 0; prim = prim.add(BigInteger.valueOf(2))) {
            BigInteger resultGcd = gcd(prod, prim);

            if(resultGcd.compareTo(BigInteger.ONE) == 0){
                prod = prod.multiply(prim);
                count++;
            }
        }

        return count;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                int result = Result3.primeCount(n);

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
