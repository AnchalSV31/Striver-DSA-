package DP;

import java.util.Arrays;

public class CountPartitionWithGivenDiff {
    public static int findWaysUtil(int ind, int target, int[] arr, int [][] dp){
        if(target==0) return 1;
        if(ind==0) {
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];

        int notTaken=findWaysUtil(ind-1,target,arr,dp);
        int taken=0;

        if(arr[ind]<=target){
            taken=findWaysUtil(ind-1,target-arr[ind],arr,dp);
        }
        return dp[ind][target]=notTaken+taken;
    }

    public static int findWays(int[] num, int sum){
        int n=num.length;
        int dp[][] = new int[n][sum+1];

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return findWaysUtil(n-1, sum, num, dp);
    }
}
