import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/delete-columns-to-make-sorted/description/



public class Main2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

//        String[] strs1 = {"abc", "bce", "cae"};
//        System.out.println(solution.minDeletionSize(strs1));
//
//        String[] strs2 = {"cba","daf","ghi"};
//        System.out.println(solution.minDeletionSize(strs2));
//
//        String[] strs3 = {"a","b"};
//        System.out.println(solution.minDeletionSize(strs3));
//
//        String[] strs4 = {"zyx","wvu","tsr"};
//        System.out.println(solution.minDeletionSize(strs4));
//
//        String[] strs5 = {"rrjk","furt","guzm"};
//        System.out.println(solution.minDeletionSize(strs5));

        String[] strs6 = {"x","q"};
        System.out.println(solution.minDeletionSize(strs6));
    }
}

class Solution2 {
    public int minDeletionSize(String[] strs) {
        List<List<Character>> listStrs = Arrays.stream(strs).map(word -> wordToListCharacter(word, new ArrayList<>())).toList();

        List<List<Character>> columnListStrs = changeFromRowsToColums(listStrs);
        List<List<Character>> columnSortedlistStrs = columnListStrs.stream().map(listOfCharacters -> listOfCharacters.stream().sorted().toList()).toList();


        return compareSortedVsOriginal(columnListStrs, columnSortedlistStrs, 0);
    }

    public List<List<Character>> changeFromRowsToColums(List<List<Character>> listStrs){
        List<List<Character>> solution = new ArrayList<>();

        int columSize = listStrs.get(0).size();
        for (int i = 0; i < columSize; i++) {
            List<Character> column = new ArrayList<>();
            int rowSize = listStrs.size();

            for (int j = 0; j < rowSize; j++) {

                Character c = listStrs.get(j).get(i);
                column.add(c);
            }

            solution.add(column);
        }

        return solution;
    }

    public List<Character> wordToListCharacter(String word, List<Character> listOfCharacters) {
        if(word.isEmpty()){
            return listOfCharacters;
        }
        else {
            listOfCharacters.add(word.charAt(0));
            return  wordToListCharacter(word.substring(1, word.length()), listOfCharacters);
        }
    }

    public int compareSortedVsOriginal(List<List<Character>> sortedlistStrs, List<List<Character>> listStrs, int cont){
        if(sortedlistStrs.isEmpty() || listStrs.isEmpty()){
            return cont;
        }
        else if(sameSortedVsOriginalUtility(sortedlistStrs.get(0), listStrs.get(0))){
            return compareSortedVsOriginal(sortedlistStrs.subList(1, sortedlistStrs.size()), listStrs.subList(1, listStrs.size()), cont);
        }
        else {
            return compareSortedVsOriginal(sortedlistStrs.subList(1, sortedlistStrs.size()), listStrs.subList(1, listStrs.size()), cont+1);
        }
    }

    public Boolean sameSortedVsOriginalUtility(List<Character> sortedlistCharacters, List<Character> listCharacter){
        if(sortedlistCharacters.isEmpty() || listCharacter.isEmpty()){
            return true;
        }
        else if(sortedlistCharacters.get(0) != listCharacter.get(0)){
            return false;
        }
        else {
            return sameSortedVsOriginalUtility(sortedlistCharacters.subList(1, sortedlistCharacters.size()), listCharacter.subList(1, listCharacter.size()));
        }
    }
}