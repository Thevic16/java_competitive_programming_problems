import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/arranging-coins/submissions/1186175546/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public int arrangeCoins(int n) {
        return generateListOfCoins(n, 1, new ArrayList<>()).size();
    }

    List<Integer> generateListOfCoins(int n, int i, List<Integer> listCoins){
        if(n == 0){
            return listCoins;
        } else if (n<i) {
            return listCoins;
        } else {
            listCoins.add(i);
            return generateListOfCoins(n-i, i+1, listCoins);
        }
    }
}