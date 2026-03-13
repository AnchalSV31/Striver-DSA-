package Recursion;

import java.util.*;

public class Subset2 {
    //TC: O(N² * 2^N) SC: O(N * 2^N)
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, Set<List<Integer>> result){
        //base case
        if(ind==nums.length){
            result.add(new ArrayList<>(ds));
            return;
        }

        //Choice 1:include current element
        ds.add(nums[ind]);
        findSubsets(ind+1, nums, ds, result);

        //backtrack by removing the element to explore the other path
        ds.remove(ds.size()-1);

        findSubsets(ind+1, nums, ds, result);
    }

    public static List<List<Integer>> subsetsWithDup1(int[] nums){
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        findSubsets(0, nums, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    //optimised approach
    //TC: O(2^N) SC: O(N)
    public static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Iterate over array from 'start' index
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in current subset
            current.add(nums[i]);

            // Recurse for next index
            backtrack(i + 1, nums, current, result);

            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        // List<List<Integer>> ans = subsetsWithDup1(nums);
        List<List<Integer>> ans = subsetsWithDup2(nums);

        System.out.println(ans);
    }
}
