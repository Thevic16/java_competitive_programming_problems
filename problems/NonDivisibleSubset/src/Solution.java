import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/non-divisible-subset/problem

/*
4 3
1 7 2 4
*/

/*
7 4
19 10 12 10 24 25 22
*/

/*
9 4
19 10 12 10 24 25 22 43 61
*/

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    // TODO HACER UN DP QUE SOLO TOME EN CUANTA LOS K
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

//        s.stream().sorted().forEach(x -> System.out.println(x + " % " + k + " = " + x % k));
//        System.out.println(" ");

        return backTracking(k,  s, new HashSet<Integer>());
    }

    public static int backTracking(int k, List<Integer> s, Set<Integer> solutions) {
        if(s.isEmpty()){
            return solutions.size();
        }
        else if(s.size() == 1){
            Set<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero
            return backTracking(k,  s.subList(1, s.size()),  newSolution1);
        }
        else {
            Set<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero
            Set<Integer> newSolution2 = insertXToSolutionIfAllow(s.get(1), k, solutions); // En este tomo el cuenta el segundo

            return Math.max(backTracking(k,  s.subList(1, s.size()),  newSolution1),  backTracking(k,  s.subList(1, s.size()),  newSolution2));
        }

    }

    public static Set<Integer> insertXToSolutionIfAllow(int x, int k, Set<Integer> solutions){
        boolean allow = true;
        Set<Integer> newSolution = new HashSet<>();

        for (Integer number : solutions) {
            if((number + x) % k == 0){
                allow = false;
            }
        }

        newSolution.addAll(solutions);

        if(allow){
            newSolution.add(x);
        }

        return newSolution;
    }

}

public class Solution {
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
