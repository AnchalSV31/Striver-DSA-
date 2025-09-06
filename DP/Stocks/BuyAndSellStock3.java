package DP.Stocks;
import java.util.Arrays;

//at most 2 transactions

public class BuyAndSellStock3 {
   //MEMOIZATION
   //TC:O(N*2*3) SC:O(N*2*3)+O(N)
  public static int getMaximum1(int arr[], int n){
    int dp[][][]= new int[n][2][3];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2; j++) {
            Arrays.fill(dp[i][j], -1);
        }
    }

    if(n==0) return 0;
    return getMaxProfit(arr,0,0,n,dp,2);
  }
  
  public static int  getMaxProfit(int arr[], int ind, int buy, int n, int dp[][][], int cap){
    if(ind==n || cap==0) return 0;
    if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

    int profit = 0;
    if(buy==0){  //we can buy the stock
      profit= Math.max(-arr[ind]+getMaxProfit(arr,ind+1,1,n,dp,cap),getMaxProfit(arr,ind+1,0,n,dp,cap));
    }
    if(buy==1){//we can sell the stock
      profit=Math.max(0+getMaxProfit(arr,ind+1,0,n,dp, cap),arr[ind]+getMaxProfit(arr,ind+1,0,n,dp, cap-1));
    }

    dp[ind][buy][cap]=profit;
    return profit;
  } 

  //TABULATION
  //TC:O(N*2*3) SC:O(N*2*3)
  public static int getMaximum2(int arr[], int n){
    int dp[][][]= new int[n+1][2][3];

    for(int ind=n-1;ind>=0;ind--){
      for(int buy=0;buy<=1;buy++){
        for(int cap=1; cap<=2; cap++){
            if(buy==0){  //we can buy the stock
                dp[ind][buy][cap]= Math.max(-arr[ind]+dp[ind+1][1][cap],dp[ind+1][0][cap]);
            }
            if(buy==1){//we can sell the stock
                dp[ind][buy][cap]=Math.max(0+dp[ind+1][0][cap],arr[ind]+dp[ind+1][0][cap-1]);
            }
        }
        
      }
    }
    return dp[0][0][2];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*2*3) SC:O(1)
  public static int getMaximum3(int arr[], int n){
    int ahead[][]= new int[2][3];
    int cur[][]= new int[2][3];

    for(int ind=n-1; ind>=0; ind--){
      for(int buy=0; buy<=1; buy++){
        for(int cap=1; cap<=2; cap++){
            if(buy==0){  //we can buy the stock 
                cur[buy][cap]= Math.max(-arr[ind]+ahead[1][cap],ahead[0][cap]);
            }
            if(buy==1){//we can sell the stock  
                cur[buy][cap]= Math.max(0+ahead[1][cap],arr[ind]+ahead[0][cap-1]);
            }
        }
        
      }
      for (int i = 0; i < 2; i++) {
        for (int j = 1; j < 3; j++) {
            ahead[i][j] = cur[i][j];
        }
    }
        }

        return ahead[0][2];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        System.out.println(getMaximum1(prices, n));
        System.out.println(getMaximum1(prices, n));
        System.out.println(getMaximum3(prices, n));
    }
}
