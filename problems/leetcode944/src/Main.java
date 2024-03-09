import java.util.*;

// https://leetcode.com/problems/delete-columns-to-make-sorted/description/

/*
I make a mistake and consider the rows instead of column in this code
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs1 = {"abc", "bce", "cae"};
        System.out.println(solution.minDeletionSize(strs1));

        String[] strs2 = {"cba","daf","ghi"};
        System.out.println(solution.minDeletionSize(strs2));

        String[] strs3 = {"a","b"};
        System.out.println(solution.minDeletionSize(strs3));

        String[] strs4 = {"zyx","wvu","tsr"};
        System.out.println(solution.minDeletionSize(strs4));
    }
}

class Solution {
    public int minDeletionSize(String[] strs) {
        List<List<Character>> listStrs = Arrays.stream(strs).map(word -> wordToListCharacter(word, new ArrayList<>())).toList();
        List<List<Character>> sortedlistStrs = listStrs.stream().map(listOfCharacters2 -> listOfCharacters2.stream().sorted().toList()).toList();
        List<List<Character>> reverseSortedlistStrs = listStrs.stream().map(listOfCharacters2 -> listOfCharacters2.stream().sorted(Comparator.reverseOrder()).toList()).toList();


        return compareSortedVsOriginal(sortedlistStrs, reverseSortedlistStrs, listStrs, 0);
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

    public int compareSortedVsOriginal(List<List<Character>> sortedlistStrs, List<List<Character>> reverseSortedlistStrs, List<List<Character>> listStrs, int cont){
        if(sortedlistStrs.isEmpty() || listStrs.isEmpty()){
            return cont;
        }
        else if(sameSortedVsOriginalUtility(sortedlistStrs.get(0), listStrs.get(0)) ||  sameSortedVsOriginalUtility(reverseSortedlistStrs.get(0), listStrs.get(0))){
            return compareSortedVsOriginal(sortedlistStrs.subList(1, sortedlistStrs.size()), reverseSortedlistStrs.subList(1, reverseSortedlistStrs.size()),  listStrs.subList(1, listStrs.size()), cont);
        }
        else {
            return compareSortedVsOriginal(sortedlistStrs.subList(1, sortedlistStrs.size()), reverseSortedlistStrs.subList(1, reverseSortedlistStrs.size()), listStrs.subList(1, listStrs.size()), cont+1);
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