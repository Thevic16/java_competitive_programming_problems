import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int diagonalPrime(int[][] nums) {
        List<Integer> listDiagonal = new ArrayList<>();
        int size = nums[0].length;

        for (int i = 0; i < size; i++) {
            listDiagonal.add(nums[i][i]);
        }

        for (int i = 0; i < size; i++) {
            int secondIndex = size - i - 1;
            listDiagonal.add(nums[i][secondIndex]);
        }

        List<Integer> listDiagonalSorted = listDiagonal.stream().sorted(Comparator.reverseOrder()).toList();

        return getSolution(listDiagonalSorted);
    }

    static int getSolution(List<Integer> listDiagonalSorted){
        if(listDiagonalSorted.isEmpty()){
            return 0;
        } else if (esPrimo(listDiagonalSorted.get(0))) {
            return listDiagonalSorted.get(0);
        }
        else {
            return getSolution(listDiagonalSorted.subList(1, listDiagonalSorted.size()));
        }

    }

    static boolean esPrimo(int numero) {
        if (numero <= 1)
            return false;

        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0)
                return false;
        }

        return true;
    }
}