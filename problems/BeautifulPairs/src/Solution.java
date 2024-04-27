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

class Result {

    /*
     * Complete the 'beautifulPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY A
     *  2. INTEGER_ARRAY B
     */

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
//        List<Integer> sortedA = A.stream().sorted().toList();
//        List<Integer> sortedB = new ArrayList<>(B.stream().sorted().toList());
        List<Integer> sortedA = A.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedB = new ArrayList<>(B.stream().sorted().collect(Collectors.toList()));
        List<Integer> results = new ArrayList<>();

        for(Integer a: sortedA){
            int indiceFindInB = binarySearch(sortedB, a, 0, sortedB.size()-1);

            if(indiceFindInB != -1){
                results.add(sortedB.get(indiceFindInB));
                sortedB.remove(indiceFindInB);
            }
        }

        if(sortedB.isEmpty()){
            return results.size()-1;
        }
        else {
            return results.size() + 1;
        }
    }

    public static int binarySearch(List<Integer> list, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid; // Se encontró el elemento
            } else if (list.get(mid) < target) {
                return binarySearch(list, target, mid + 1, right); // Buscar en la mitad derecha
            } else {
                return binarySearch(list, target, left, mid - 1); // Buscar en la mitad izquierda
            }
        }

        return -1; // Elemento no encontrado
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.beautifulPairs(A, B);

        System.out.println(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
