package Recursion;

import java.util.*;

//TC: O(4^N * N)  SC: O(N)
public class LetterCombinations {
    private final String[] map;

    public LetterCombinations(){
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    }

    public List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        helper(digits, ans, 0, "");
        return ans;
    }

    public void helper(String digits, List<String> ans, int index, String current){
        //base case
        if(index==digits.length()){
            ans.add(current);
            return;
        }

        //get characters corresponding to the current digit
        String s = map[digits.charAt(index)-'0'];

        //loop through the corresponding characters
        for(int i=0; i<s.length(); i++){
            // Recursively call function with the next index
            // Add current character to the string
            helper(digits, ans, index+1, current+s.charAt(i));
        }
    }

    public static void main(String[] args){
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "23"; // Input digits
        List<String> result = letterCombinations.letterCombinations(digits); // Get combinations

        // Print the results
        for (String combination : result) {
            System.out.print(combination + " "); // Display each combination
        }
    }
}
