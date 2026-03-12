package Recursion;
import java.util.*;

public class SubsetSum {
    //TC: O(2^n) SC: O(2^n)
    public static void findSums(int ind, int currSum, int[] arr, List<Integer> sums){
        if(ind==arr.length){
            sums.add(currSum);
            return;
        }

        findSums(ind+1, currSum+arr[ind], arr, sums);
        findSums(ind+1, currSum, arr, sums);
    }
    
    public static List<Integer> subsetSums(int[] arr){
        List<Integer> sums = new ArrayList<>();
        findSums(0, 0, arr, sums);
        Collections.sort(sums);
        return sums;
    } 
    public static void main(String[] args) {
        int[] arr = {5, 2, 1};
        List<Integer> result = subsetSums(arr);

        for (int sum : result) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}
