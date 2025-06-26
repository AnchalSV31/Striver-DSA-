package DP;
import java.util.*;

public class CountSubsetsWithSumsum {
    //Memoization TC:O(N*sum) SC:O(N*sum) + O(N)
    public static int findWaysUtil(int ind, int target, int[] arr, int [][] dp){
        if(target==0) return 1;
        if(ind==0) return arr[0]==target?1:0;

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

    //Tabulation TC:O(N*sum) SC:O(N*sum)
    public static int findWays2(int[] num, int sum){
        int n=num.length;
        int dp[][]= new int[n][sum+1];
        for(int i=0; i<n; i++){
            dp[i][0]=1;
        }
        if(num[0]<=sum){
            dp[0][num[0]]=1;
        }
        for(int ind=1; ind<n; ind++){
            for(int target=1; target<=sum; target++){
                int notTaken=dp[ind-1][target];

                int taken=0;
                if(num[ind]<=target){
                    taken=dp[ind-1][target-num[ind]];
                }
                dp[ind][target]=notTaken+taken;
            }
        }
        return dp[n-1][sum];
    }

    //Space Optimization TC: O(N*Sum) SC: O(Sum)
    public static int findWays3(int[] num, int sum){
        int n=num.length;
        int[] prev= new int[sum+1];
        prev[0]=1;
        if(num[0]<=sum){
            prev[num[0]]=1;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[sum + 1];
            cur[0] = 1;
            for(int target=1; target<=sum; target++){
                int notTaken=prev[target];
                int taken=0;
                if(num[ind]<=target){
                    taken=prev[target-num[ind]];
                }
                cur[target]=notTaken+taken;
            }
            prev=cur;
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3};
        int sum = 3;
        System.out.println(findWays(arr, sum));
        System.out.println(findWays2(arr, sum));
        System.out.println(findWays3(arr, sum));
    }
}
