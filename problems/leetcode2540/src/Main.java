import java.util.List;

// https://leetcode.com/problems/minimum-common-value/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if(binarySearch(nums2, nums1[i], 0, nums2.length-1) != -1){
                return nums1[i];
            }
        }

        return -1;
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