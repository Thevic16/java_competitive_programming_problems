import java.util.HashSet;
import java.util.Set;

public class SubsetSumZero {
    public static boolean hasSubsetSumZero(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            set.add(sum);
            sum += num;
            if (set.contains(sum) || sum == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        System.out.println("¿Existe subconjunto con suma cero? " + hasSubsetSumZero(nums)); // Salida esperada: ¿Existe subconjunto con suma cero? true
    }
}
