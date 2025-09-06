package DP.LIS;
import java.util.*;

public class LongestIncreasingSubsequence {
    //MEMOIZATION
    //TC:O(N*N) SC:O(N*N)+O(N)
    public static int getAns(int arr[], int n, int ind, int prev_ind, int[][] dp){
        if(ind==n) return 0;
        if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind+1];

        int notTake= 0+ getAns(arr, n, ind+1, prev_ind, dp);

        int take=0;
        if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
            take= 1+ getAns(arr, n, ind+1, ind, dp);
        }

        return dp[ind][prev_ind+1]=Math.max(take, notTake);
    }

    public static int LIS(int arr[], int n){
        int[][] dp= new int[n][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return getAns(arr, n, 0, -1, dp);
    }

    //TABULATION
    //TC:O(N*N) SC:O(N*N)
    public static int LIS2(int arr[], int n){
        int dp[][]= new int[n+1][n+1];

        for(int ind=n-1; ind>=0; ind--){
            for(int prev_ind=ind-1; prev_ind>=-1; prev_ind--){
                int notTake= 0 +dp[ind+1][prev_ind+1];
                int take=0;
                if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
                    take= 1+dp[ind+1][ind+1];
                }
                dp[ind][prev_ind+1]=Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    //SPACE OPTIMIZATION
    //TC:O(N*N) SC:O(N)
    public static int LIS3(int[] arr, int n){
        int next[]= new int[n+1];
        int curr[]= new int[n+1];

        for(int ind=n-1; ind>=0; ind--){
            for(int prev_ind=ind-1; prev_ind>=-1; prev_ind--){
                int notTake= 0 +next[prev_ind+1];
                int take=0;
                if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
                    take= 1+next[ind+1];
                }
                curr[prev_ind+1]=Math.max(take, notTake);
            }
            next=curr;
        }
        return curr[0];
    }

    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        System.out.println(LIS(arr, n));
        System.out.println(LIS2(arr, n));
        System.out.println(LIS3(arr, n));
    }
}
