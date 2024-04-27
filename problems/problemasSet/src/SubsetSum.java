import java.util.HashSet;
import java.util.Set;

public class SubsetSum {
    public static boolean hasSubsetSum(int[] nums, int K) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int num : nums) {
            Set<Integer> newSet = new HashSet<>(set);

            for (int sum : set) {
                if (sum + num == K) {
                    return true;
                }
                newSet.add(sum + num);
            }

            set = newSet;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int K = 9;

        System.out.println("¿Existe subconjunto con suma " + K + "? " + hasSubsetSum(nums, K)); // Salida esperada: ¿Existe subconjunto con suma 9? true
    }
}
