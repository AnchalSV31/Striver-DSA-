package DP.MCM;
import java.util.*;

public class MatrixChainMultiplication {
    //MEMOIZATIOn
    //TC:O(n*n*n) SC:O(n*n)+O(n)
    public static int mcm(int[] arr, int n){
        int dp[][]= new int[n][n];

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        int i=1;
        int j=n-1;

        return f(arr, i, j, dp);
    }

    public static int f(int[] arr, int i, int j, int[][] dp){
        if(i==j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }   

        int mini=Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int ans= f(arr, i, k, dp)+f(arr,k+1, j, dp)+ arr[i-1]*arr[k]*arr[j];
            mini=Math.min(mini, ans);
        }

        return mini;

    }

    //TABULATIOn
    //TC:O(n*n*n) SC:O(n*n)
    public static int mcm2(int[] arr, int n){
        int[][] dp = new int[n][n];

        // Initialize the dp array with -1
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Initialize the diagonal with 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill in the dp array using bottom-up approach
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }

        // The result is stored in dp[1][n-1]
        return dp[1][n - 1];
    }
    public static int f2(int[] arr, int i, int j,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int minOp=Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int op=f2(arr, i, k, dp)+f2(arr, k+1, j, dp)+ arr[i-1]*arr[k]*arr[j];
            minOp=Math.min(minOp, op);
        }
        dp[i][j]=minOp;
        return minOp;
    }
    
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int n=arr.length;
        System.out.println(mcm(arr, n));
        System.out.println(mcm2(arr, n));
    }
}
