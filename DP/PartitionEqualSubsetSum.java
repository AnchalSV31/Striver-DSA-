package DP;

public class PartitionEqualSubsetSum {
    //TC: O(n*k) SC:O(n*k)
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean dp[][] = new boolean[n][k + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }

    public static boolean partitionSum(int[] arr, int n){
        int totalSum=0;
        for(int i=0; i<n; i++){
            totalSum+=arr[i];
        }
        if(totalSum%2!=0) return false;   //odd total sum cannot be divided into 2 equal parts
        int target=totalSum/2;

        return subsetSumToK(n, target, arr);
    }

    public static void main(String[] args) {
        int[] arr={2,3,3,3,4,5};
        int n=arr.length;
        System.out.println(partitionSum(arr, n));
    }
}
