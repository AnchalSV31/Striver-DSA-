package DP.Subsequences;
// Package DP;
import java.util.*;
public class CoinChange2 {
  //MEMOIZATION
  //TC: O(N*T) SC: O(N*T)+O(N)
  public static long countWaysUtil1(int[] arr, int ind, int T, long dp[][]){
    if(ind==0){
      if(T%arr[0]==0) return 1;
      else return 0;
    }

    if(dp[ind][T]!=-1) return dp[ind][T];

    long notTaken=countWaysUtil1(arr, ind-1, T, dp);
    long taken= 0;
    if(arr[ind]<=T){
      taken= countWaysUtil1(arr, ind, T-arr[ind], dp);
    }
    return dp[ind][T]=notTaken+taken;
  }
  public static long countWays1(int[] arr, int T){
    int n=arr.length;
    long dp[][]=new long[n][T+1];
    for(long row[]: dp){
      Arrays.fill(row, -1);
    } 
    return countWaysUtil1(arr, n - 1, T, dp);
  }

  //Tabulation
  //TC: O(N*T) SC: O(N*T)
  public static long countWays2(int[] arr, int T){
    int n=arr.length;
    long dp[][]=new long[n][T+1];
    for(int i=0; i<=T; i++){
      if(i%arr[0]==0) dp[0][i]=1;
    } 
    for(int ind=1; ind<n; ind++){
      for(int target=0; target<=T; target++){
        long notTaken=dp[ind-1][target];
        long taken= 0;
        if(arr[ind]<=target){
          taken= dp[ind][target-arr[ind]];
        }
        dp[ind][target]=notTaken+taken;
      }
    }
    return dp[n-1][T];
  }

  //Space Optimization
  //TC: O(N*T) SC:O(T)
  public static long countWays3(int[] arr, int T){
    int n=arr.length;
    long[] prev=new long[T+1];
    for(int i=0; i<=T; i++){
      if(i%arr[0]==0) prev[i]=1;
    } 
    for(int ind=1; ind<n; ind++){
      long[] cur= new long[T+1];
      for(int target=0; target<=T; target++){
        long notTaken=prev[target];
        long taken= 0;
        if(arr[ind]<=target){
          taken= cur[target-arr[ind]];
        }
        cur[target]=notTaken+taken;
      }
      prev=cur;
    }
    return prev[T];
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
    int target = 4;

    System.out.println("The total number of ways is " + countWays1(arr, target));
    System.out.println("The total number of ways is " + countWays2(arr, target));
    System.out.println("The total number of ways is " + countWays3(arr, target));
  }
}
