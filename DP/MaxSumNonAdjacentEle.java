package DP;
import java.util.*;

//min sum of non adjacent elements
public class MaxSumNonAdjacentEle {
    //MEMOIZATION  TC:O(N) sc:O(N)+O(N)
    public static int maxSum(int ind, int[] arr, int[] dp){
        if(ind<0) return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick=arr[ind]+maxSum(ind-2, arr, dp);
        int nonPick=maxSum(ind-1, arr, dp);
        return dp[ind]=Math.max(pick, nonPick);
    }

    //Tabulation TC:O(N) SC:O(N)
    public static int maxSum2(int ind, int[] arr, int[] dp){
        dp[0]=arr[0];
        for(int i=1; i<ind; i++){
            int pick=arr[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int nonPick=dp[i-1];
            dp[i]=Math.max(pick, nonPick);
        }
        return dp[ind-1];
    }

    //Space Optimization  TC:O(N) SC:O(1)
    public static int maxSum3(int ind, int[] arr){
        int prev=arr[0];
        int prev2=0;
        for(int i=1; i<ind; i++){
            int pick=arr[i];
            if(i>1){
                pick+=prev2;
            }
            int nonPick=prev;
            int curr=Math.max(pick, nonPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        // System.out.println(maxSum(n-1, arr, dp));
        // System.out.println(maxSum2(n, arr, dp));
        System.out.println(maxSum3(n, arr));
    }
}
