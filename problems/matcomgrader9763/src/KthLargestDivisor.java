import java.util.ArrayList;
import java.util.Collections;

public class KthLargestDivisor {

    public static int findKthLargestDivisor(int A, int B, int K) {
        // Find common divisors
        ArrayList<Integer> commonDivisors = new ArrayList<>();
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                commonDivisors.add(i);
            }
        }

        // Sort common divisors in descending order
        Collections.sort(commonDivisors, Collections.reverseOrder());

        // Return the K-th largest divisor
        return commonDivisors.get(K - 1);
    }

    public static void main(String[] args) {
        int A = 12;
        int B = 18;
        int K = 3;

        int result = findKthLargestDivisor(A, B, K);

        System.out.println("The " + K + "-th largest divisor of " + A + " and " + B + " is: " + result);
    }
}
