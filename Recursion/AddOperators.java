package Recursion;

import java.util.*;

public class AddOperators {
    //TC: O(4^n) SC: O(n)
    public static List<String> addOperators(String num, int target){
        List<String> result = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }

    public static void dfs(String num, int target, int start, long current_value, long last_operand, String expression, List<String> result){
        //base case:if reached end of string
        if(start==num.length()){
            //if the expression evaluates to teh target, add it to result
            if(current_value==target){
                result.add(expression);
            }
            return;
        }

        //loop through all substring  starting from 'start' index
        for(int i=start; i<num.length(); i++){
            //skip leading zeros in numbers
            if(i>start && num.charAt(start)== '0') return;

            //get the current number
            String current_num = num.substring(start, i+1);
            long current_num_val = Long.parseLong(current_num);

            //if we are at the first number, just start the expression
            if(start==0){
                dfs(num, target, i+1, current_num_val, current_num_val, current_num, result);
            }else{
                //add the current number with '+'
                dfs(num, target, i+1, current_value + current_num_val, current_num_val, expression + "+" + current_num, result);

                //add the current number with '-'
                dfs(num, target, i+1, current_value - current_num_val, -current_num_val, expression + "-" + current_num, result);

                //add the current number with '*'
                dfs(num, target, i+1,
                current_value - last_operand + (last_operand * current_num_val), last_operand * current_num_val,
                expression + "*" + current_num, result);
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";  
        int target = 6;      
        
        List<String> result = addOperators(num, target);
        
        for (String expr : result) {
            System.out.print(expr + " ");
        }
    }
}
