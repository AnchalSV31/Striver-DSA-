package Recursion;

public class CountAllSubsequencesWithSumK {
    //TC:  O(2^n) SC: O(n)
    public static int countSubsequences(int[] nums, int target){
        return func(0, target, nums);
    }

    public static int func(int ind, int sum, int[] nums){
        //base case: if sum is 0, one valid subsequence is found
        if(sum==0) return 1;

        //base case: if sum is negative or index exceeds array size
        if(sum<0 || ind==nums.length) return 0;

        //recurse by including current number or exclding it from the sum
        return func(ind+1, sum-nums[ind], nums) + func(ind+1, sum, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Number of subsequences with target sum " + target + ": "
                + countSubsequences(nums, target));
    }
}
