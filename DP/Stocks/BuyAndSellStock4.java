package DP.Stocks;
import java.util.Arrays;

//at most k transactions
public class BuyAndSellStock4{
   //MEMOIZATION
   //TC:O(N*2*k) SC:O(N*2*k)+O(N)
  public static int getMaximum1(int arr[], int n, int k){
    int dp[][][]= new int[n][2][k+1];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2; j++) {
            Arrays.fill(dp[i][j], -1);
        }
    }

    if(n==0) return 0;
    return getMaxProfit(arr,0,0,n,dp,k);
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
  //TC:O(N*2*k) SC:O(N*2*3)
  public static int getMaximum2(int arr[], int n, int k){
    int dp[][][]= new int[n+1][2][k+1];

    for(int ind=n-1;ind>=0;ind--){
      for(int buy=0;buy<=1;buy++){
        for(int cap=1; cap<=k; cap++){
            if(buy==0){  //we can buy the stock
                dp[ind][buy][cap]= Math.max(-arr[ind]+dp[ind+1][1][cap],dp[ind+1][0][cap]);
            }
            if(buy==1){//we can sell the stock
                dp[ind][buy][cap]=Math.max(0+dp[ind+1][0][cap],arr[ind]+dp[ind+1][0][cap-1]);
            }
        }
        
      }
    }
    return dp[0][0][k];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*2*k) SC:O(1)
  public static int getMaximum3(int arr[], int n, int k){
    int ahead[][]= new int[2][k+1];
    int cur[][]= new int[2][k+1];

    for(int ind=n-1; ind>=0; ind--){
      for(int buy=0; buy<=1; buy++){
        for(int cap=1; cap<=k; cap++){
            if(buy==0){  //we can buy the stock 
                cur[buy][cap]= Math.max(-arr[ind]+ahead[1][cap],ahead[0][cap]);
            }
            if(buy==1){//we can sell the stock  
                cur[buy][cap]= Math.max(0+ahead[1][cap],arr[ind]+ahead[0][cap-1]);
            }
        }
        
      }
      for (int i = 0; i < 2; i++) {
        for (int j = 1; j <= k; j++) {
            ahead[i][j] = cur[i][j];
        }
    }
        }

        return ahead[0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k=3;
        System.out.println(getMaximum1(prices, n, k));
        System.out.println(getMaximum1(prices, n, k));
        System.out.println(getMaximum3(prices, n, k));
    }
}

