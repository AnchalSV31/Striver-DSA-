package DP.Stocks;

import java.util.Arrays;

public class BuyAndSellStockWithTransaction {
    //memoization
    //TC: O(N*2) SC: O(N*2)+O(N)
    public static long getMaximum1(long arr[], int n, int fee){
        long dp[][]= new long[n][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        if (n == 0) {
            return 0;
        }

        return getMaxProfit(arr,0,0,n,dp,fee);
    }
  
  public static long  getMaxProfit(long arr[], int ind, int buy, int n, long dp[][], int fee){
    if(ind>=n) return 0;
    if(dp[ind][buy]!=-1) return dp[ind][buy];

    long profit = 0;
    if(buy==0){  //we can buy the stock
      profit= Math.max(-arr[ind]+getMaxProfit(arr,ind+1,1,n,dp,fee),getMaxProfit(arr,ind+1,0,n,dp,fee));
    }
    if(buy==1){//we can sell the stock
      profit=Math.max(0+getMaxProfit(arr,ind+1,1,n,dp,fee),arr[ind]-fee+getMaxProfit(arr,ind+1,0,n,dp,fee));
    }

    dp[ind][buy]=profit;
    return profit;
  } 

  //TABULATION
  //TC:O(N*2) SC:O(N*2)
  public static long getMaximum2(long arr[], int n, int fee){
    if(n==0) return 0;
    long dp[][]= new long[n+1][2];

    for(int ind=n-1;ind>=0;ind--){
      for(int buy=0;buy<=1;buy++){
        long profit=0;
        if(buy==0){  //we can buy the stock
          profit= Math.max(-arr[ind]+dp[ind+1][1],dp[ind+1][0]);
        }
        if(buy==1){//we can sell the stock
          profit=Math.max(0+dp[ind+1][1],arr[ind]-fee+dp[ind+1][0]);
        }
        dp[ind][buy]=profit;
      }
    }
    return dp[0][0];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*2) SC:O(1)
  public static long getMaximum3(long arr[], int n, int fee){
    if(n==0) return 0;
    long cur[]= new long[2];
    long ahead[]= new long[2];

    ahead[0] = ahead[1] = 0;
    long profit=0;

    for(int ind=n-1; ind>=0; ind--){
      for(int buy=0; buy<=1; buy++){
        
        if(buy==0){  //we can buy the stock 
          profit= Math.max(-arr[ind]+ahead[1],ahead[0]);
        }
        if(buy==1){//we can sell the stock  
          profit= Math.max(0+ahead[1],arr[ind]-fee+ahead[0]);
        }
        cur[buy]=profit;
      }
      System.arraycopy(cur, 0, ahead, 0, 2);
    }
    return cur[0];
    }



  public static void main(String[] args) {
    int n = 6;
    long[] Arr = {1, 3, 2, 8, 4, 9};
    int fee=2;
    System.out.println(getMaximum1(Arr, n, fee));
    System.out.println(getMaximum2(Arr, n, fee));
    System.out.println(getMaximum3(Arr, n, fee));
  }
}
