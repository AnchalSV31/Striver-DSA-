package Recursion;

import java.util.*;

//TC: O(2^9 * k)  SC: O(k)
public class CombinationSum3 {
    public static void func(int sum, int last, List<Integer> nums, int k, List<List<Integer>> result){
        // If the sum is zero and the number of elements is k
        if(sum==0 && nums.size()==k){
            result.add(new ArrayList<>(nums));
            return;
        }

        // If the sum is less than or equal to zero or the number of elements exceeds k
        if(sum<=0 || nums.size()>k) return;

        // Iterate from the last number(1) to 9
        for(int i=last; i<=9; i++){
             // If the current number is less than or equal to the sum
            if(i<=sum){
                nums.add(i);
                // Recursive call with updated sum and next number
                func(sum-i, i+1, nums, k, result);
                // Remove the last number to backtrack
                nums.remove(nums.size()-1);
            }else{
                // If the number is greater than the sum, break the loop
                break;
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        func(n, 1, nums, k, result);
        return result;
    }

    public static void main(String[] args) {
        int k = 3; // Number of elements in the combination
        int n = 7; // Target sum
        List<List<Integer>> result = combinationSum3(k, n);

        // Print the result
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
