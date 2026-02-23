package Recursion;

import java.util.ArrayList;
import java.util.List;

//TC: O(2^n) SC:O(n)
public class GenerateAllBinaryStrings {
    public static void generate(int n, String curr, List<String> result){
        if(curr.length()==n){
            result.add(curr);
            return;
        }

        //always try adding '0'
        generate(n, curr+"0", result);

        //add '1' only if previous char is not '1'
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!='1'){
            generate(n, curr+"1", result);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        // List to store results
        List<String> result = new ArrayList<>();

        // Start recursion with empty string
        generate(n, "", result);

        // Print results
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
