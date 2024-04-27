import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/non-divisible-subset/problem

/*
4 3
1 7 2 4
*/

/*
Esto no es un set
7 4
19 10 12 10 24 25 22
*/

/*
Esto es un set
6 4
19 10 12 24 25 22
*/

/*
9 4
19 10 12 10 24 25 22 43 61
*/


/*
15 7
278 576 496 727 410 124 338 149 209 702 282 718 771 575 436
11
*/

class Result3 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        List<Integer> sK = s.stream().map(x -> x % k).toList();
        int amountEven = getAmountEven(sK);
        int amountOdd = sK.size() - amountEven;

        int result = Math.max(amountEven, amountOdd);

        return result;
    }

   public static int getAmountEven(List<Integer> sK){
        int amount = 0;

        for (Integer x: sK){
            if(x != 0 && x % 2 == 0){
                amount += 1;
            }
        }

        return amount;
   }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result3.nonDivisibleSubset(k, s);

        System.out.println(String.valueOf(result));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
