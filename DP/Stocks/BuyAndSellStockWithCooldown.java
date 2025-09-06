package DP.Stocks;
import java.util.Arrays;

//We can buy and sell stock any number of times 
//But, We can’t buy a stock on the very next day of selling it
public class BuyAndSellStockWithCooldown {
    //memoization
    //TC: O(N*2) SC: O(N*2)+O(N)
    public static long getMaximum1(long arr[], int n){
        long dp[][]= new long[n][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaxProfit(arr,0,0,n,dp);
    }
  
  public static long  getMaxProfit(long arr[], int ind, int buy, int n, long dp[][]){
    if(ind>=n) return 0;
    if(dp[ind][buy]!=-1) return dp[ind][buy];

    long profit = 0;
    if(buy==0){  //we can buy the stock
      profit= Math.max(-arr[ind]+getMaxProfit(arr,ind+1,1,n,dp),getMaxProfit(arr,ind+1,0,n,dp));
    }
    if(buy==1){//we can sell the stock
      profit=Math.max(0+getMaxProfit(arr,ind+1,1,n,dp),arr[ind]+getMaxProfit(arr,ind+2,0,n,dp));
    }

    dp[ind][buy]=profit;
    return profit;
  } 

  //TABULATION
  //TC:O(N*2) SC:O(N*2)
  public static long getMaximum2(long arr[], int n){
    long dp[][]= new long[n+2][2];

    for(int ind=n-1;ind>=0;ind--){
      for(int buy=0;buy<=1;buy++){
        long profit=0;
        if(buy==0){  //we can buy the stock
          profit= Math.max(-arr[ind]+dp[ind+1][1],dp[ind+1][0]);
        }
        if(buy==1){//we can sell the stock
          profit=Math.max(0+dp[ind+1][0],arr[ind]+dp[ind+2][0]);
        }
        dp[ind][buy]=profit;
      }
    }
    return dp[0][0];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*2) SC:O(1)
  public static long getMaximum3(long arr[], int n){
    long cur[]= new long[2];
    long front1[]= new long[2];
    long front2[]= new long[2];

    for(int ind=n-1; ind>=0; ind--){
      for(int buy=0; buy<=1; buy++){
        long profit=0;
        if(buy==0){  //we can buy the stock 
          profit= Math.max(-arr[ind]+front1[1],front1[0]);
        }
        if(buy==1){//we can sell the stock  
          profit= Math.max(0+front1[1],arr[ind]+front2[0]);
        }
        cur[buy]=profit;
      }
        System.arraycopy(front1, 0, front2, 0, 2);
        System.arraycopy(cur, 0, front1, 0, 2);
    }
    return cur[0];
    }



  public static void main(String[] args) {
    int n = 5;
    long[] Arr = {4, 9, 0, 4, 10};
    System.out.println(getMaximum1(Arr, n));
    System.out.println(getMaximum2(Arr, n));
    System.out.println(getMaximum3(Arr, n));
  }
}
