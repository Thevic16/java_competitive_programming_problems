import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/non-divisible-subset/problem

// https://app.diagrams.net/#G1A9V3Rq8oX6UeLf6_9nxo1oayx1OR6hoN

/*
4 3
1 7 2 4
*/

/*
7 4
19 10 12 10 24 25 22
*/


/*
6 4
19 12 10 24 25 22
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

/*
Estudiar este caso

4 4
1 1 3 4
*/


class Result2 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    // TODO HACER UN DP QUE SOLO TOME EN CUANTA LOS K
    static Map<String, Integer> dp = new HashMap<>();

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

//        s.stream().sorted().forEach(x -> System.out.println(x + " % " + k + " = " + x % k));
//        System.out.println(" ");
        dp.clear();

        return backTracking(k,  s, new ArrayList<>());
    }

    public static int backTracking(int k, List<Integer> s, List<Integer> solutions) {
        System.out.println("evaluacion:" );
        System.out.println(" ->  s            :" + s);
        System.out.println(" ->  s(k)         :" + getListWithModulesValues(s, k));
        System.out.println(" ->  solutions    :" + solutions);
        System.out.println(" ->  solutions(k) :" + getListWithModulesValues(solutions, k).stream().sorted().toList());
        System.out.println(" ->size solutions :" + solutions.size());
        System.out.println(" ");
        if(s.isEmpty()){
            return solutions.size();
        }
        else if(dp.containsKey(s.size() + ":"+ getSumList(solutions))){
            System.out.println("dp:");
            System.out.println(" ->  s            :" + s);
            System.out.println(" ->  solutions    :" + solutions);
            System.out.println(" ->  solutions(k) :" + getListWithModulesValues(solutions, k));
            System.out.println(" ");
            return dp.get(s.size() + ":"+ getSumList(solutions));
        }
        else if(s.size() == 1){
            List<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero

            int result = backTracking(k,  s.subList(1, s.size()),  newSolution1);
            String key = s.size() + ":"+ getSumList(solutions);
            dp.put(key, result);

            return result;
        }
        else {
            List<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero
            List<Integer> newSolution2 = insertXToSolutionIfAllow(s.get(1), k, solutions); // En este tomo el cuenta el segundo

            int result = Math.max(backTracking(k,  s.subList(1, s.size()),  newSolution1),  backTracking(k,  s.subList(2, s.size()),  newSolution2));
            String key = s.size() + ":"+ getSumList(solutions);
            dp.put(key, result);

            return result;
        }

    }

    public static List<Integer> insertXToSolutionIfAllow(int x, int k, List<Integer> solutions){
        boolean allow = true;
        List<Integer> newSolution = new ArrayList<>();

        for (Integer number : solutions) {
            if((number + x) % k == 0){
                allow = false;
            }
        }

        newSolution.addAll(solutions);

        if(allow){
            //TODO Resaltar este cambio
            newSolution.add(x % k);
        }

        return newSolution;
    }

    private static List<Integer> getListWithModulesValues(List<Integer> s, int k){
        return s.stream().map(x -> x % k).toList();
    }

    private static int getSumList(List<Integer> s){
        int sum = 0;

        for (Integer x: s){
            sum += x;
        }

        return sum;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result4.nonDivisibleSubset(k, s);

        System.out.println(String.valueOf(result));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
