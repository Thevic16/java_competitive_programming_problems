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


class Result4 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    /*
    TODO la idea es hacer un backtracking con todos los modulos posibles de k, y sacar cuales serian todos los numeros que
    pueden ser parte de la solucion sin que se rompa la regla, despues buscar esos numeros en el arreglo de los modulos original.
    */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        List<Integer> sK = s.stream().map(x -> x % k).toList();
        List<Integer> allValuesOfK = getAllValuesOfK(k);
        List<Integer> greaterCombinationOfDifferentValuesOfK = backTracking(k,  allValuesOfK, new ArrayList<>());
        // Analizo que no necesariamente el greaterCombinationOfDifferentValuesOfK me va dar el resultado bien
        // porque puede haber otras combinaciones que cumplan que puedan tener mayor repeticiones en el arreglo original.
        // TODO lo que se me ocurre es que puedo retonar un arreglo de arreglo en greaterCombinationOfDifferentValuesOfK y probar con todas las combinaciones posibles

        return calculateResult(sK, greaterCombinationOfDifferentValuesOfK);
    }

    public static int calculateResult(List<Integer> allValuesOfK, List<Integer> greaterCombinationOfDifferentValuesOfK){
        int result = 0;

        for(Integer value: allValuesOfK){
            result += countElementInList(greaterCombinationOfDifferentValuesOfK, value);
        }

        return result;
    }

    private static int countElementInList(List<Integer> myList, Integer element){
        int amount = 0;

        for (int x: myList){
            if(x == element){
                amount += 1;
            }
        }

        return amount;
    }

    public static List<Integer> getAllValuesOfK(int k){
        List<Integer> allValuesOfK = new ArrayList<>();

        for (int i = 1; i < k; i++) {
            allValuesOfK.add(i);
        }

        return allValuesOfK;
    }

    public static List<Integer> backTracking(int k, List<Integer> s, List<Integer> solutions) {
//        System.out.println("evaluacion:" );
//        System.out.println(" ->  s            :" + s);
//        System.out.println(" ->  s(k)         :" + getListWithModulesValues(s, k));
//        System.out.println(" ->  solutions    :" + solutions);
//        System.out.println(" ->  solutions(k) :" + getListWithModulesValues(solutions, k).stream().sorted().toList());
//        System.out.println(" ->size solutions :" + solutions.size());
//        System.out.println(" ");
        if(s.isEmpty()){
            return solutions;
        }
        else if(s.size() == 1){
            List<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero
            return backTracking(k,  s.subList(1, s.size()),  newSolution1);
        }
        else {
            List<Integer> newSolution1 = insertXToSolutionIfAllow(s.get(0), k, solutions); // Este tomo el cuenta el primero
            List<Integer> newSolution2 = insertXToSolutionIfAllow(s.get(1), k, solutions); // En este tomo el cuenta el segundo

            List<Integer> result1 = backTracking(k,  s.subList(1, s.size()),  newSolution1);
            List<Integer> result2 = backTracking(k,  s.subList(2, s.size()),  newSolution2);

            if(result1.size() >= result2.size()){
                return result1;
            }
            else {
                return result2;
            }
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

public class Solution4 {
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
