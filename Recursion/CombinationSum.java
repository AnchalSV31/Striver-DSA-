package Recursion;
import java.util.*;

public class CombinationSum {
    //TC:  O(2^t * k) SC:o(k*x)
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(); //to store current combination
        
        findCombination(0, target, candidates, curr, result);
        return result;
    }

    public static void findCombination(int ind, int target, int[] arr, List<Integer> curr, List<List<Integer>> result){
        if(ind==arr.length){
            if(target==0){
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        //pick ele less than or equal to target
        if(arr[ind]<=target){
            curr.add(arr[ind]);
            findCombination(ind, target-arr[ind], arr, curr, result);
            curr.remove(curr.size()-1);
        }

        //skip current element and move to next index
        findCombination(ind+1, target, arr, curr, result);
    }

    //OPTIMIZED VERSION
    //TC: O(2^n) SC: O(n)
    public static void findCombination2(int ind, int target, int[] arr,
                                   List<Integer> curr,
                                   List<List<Integer>> result) {
    
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
    
        for (int i = ind; i < arr.length; i++) {
            if (arr[i] > target) break;

            curr.add(arr[i]);
            findCombination(i, target - arr[i], arr, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] v = {2, 3, 6, 7};  // Candidate numbers
        int target = 7;  // Target sum

        // Get all combinations
        List<List<Integer>> ans = combinationSum(v, target);

        // Output the combinations
        System.out.println("Combinations are: ");
        for (List<Integer> combination : ans) {
            for (int num : combination) {
                System.out.print(num + " ");  // Print each element of the combination
            }
            System.out.println();  // Print a newline after each combination
        }
    }
}
