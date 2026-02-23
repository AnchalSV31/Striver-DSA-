package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    //Brute Force
    //TC:O(2^(2n) * n) SC:O(n)
    public static boolean isValid(String s){
        int balance=0;
        for(char c:s.toCharArray()){
            if(c== '(')balance++;
            else balance--;
            if(balance<0)return false;
        }
        return balance==0;
    }
    public static void generateAll(String curr, int n, List<String> res){
        if(curr.length()==2*n){
            if(isValid(curr))res.add(curr);
            return;
        }
        generateAll(curr+"(", n, res);
        generateAll(curr+")", n, res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll("", n, res);
        return res;
    }


    //Optimize approach
    //TC: O(2^n) SC:O(n)
    public static void backtrack(String curr, int open, int close, int n, List<String> res){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        if(open<n) backtrack(curr+"(", open+1, close, n, res);
        if(close<open) backtrack(curr+")", open, close+1, n, res);
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }

    public static void main(String[] args) {
        // List<String> result = generateParenthesis(3);
        // for (String s : result) {
        //     System.out.println(s);
        // }
        List<String> result2 = generateParenthesis2(3);
        for (String s : result2) {
            System.out.println(s);
        }
    }
}
             