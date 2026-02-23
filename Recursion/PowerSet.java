package Recursion;

import java.util.*;

public class PowerSet {
    //TC: O(n * 2^n) SC: O(n * 2^n)
    public static List<String> getSubsequences(String str){
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(str, 0, current, result);

        //for non empty result
        result.remove("");

        //for sorted result
        Collections.sort(result);
        return result;
    }

    public static void helper(String str, int index, StringBuilder current, List<String> result){
        if(index==str.length()){
            result.add(current.toString());
            return;
        }

        //exclude current character and recurse
        helper(str, index+1, current, result);

        //include current character and recurse
        current.append(str.charAt(index));
        helper(str, index+1, current, result);

        //backtrack by removing last character
        current.deleteCharAt(current.length()-1); 
    }

    public static void main(String[] args) {
        String s = "abc";

        // Get all subsequences
        List<String> subsequences = getSubsequences(s);

        // Print all subsequences
        for (String subseq : subsequences) {
            System.out.println("\"" + subseq + "\"");
        }
    }
}
