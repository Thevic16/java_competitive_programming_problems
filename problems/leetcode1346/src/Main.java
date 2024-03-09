import java.util.Arrays;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr1 = {10,2,5,3};
//        System.out.println(solution.checkIfExist(arr1));

        int[] arr2 = {-2,0,10,-19,4,6,-8};
        System.out.println(solution.checkIfExist(arr2));
    }
}

class Solution {
    public boolean checkIfExist(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < arr.length; i++) {
            int result = binarySearch(arr, arr[i]*2, 0, arr.length-1);

            if(result != -1 && result != i){
                return true;
            }
        }

        return false;
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Se encontró el elemento
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right); // Buscar en la mitad derecha
            } else {
                return binarySearch(arr, target, left, mid - 1); // Buscar en la mitad izquierda
            }
        }

        return -1; // Elemento no encontrado
    }
}