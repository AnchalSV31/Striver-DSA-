package DP.Stocks;

//We can buy and sell a stock only once.

//TC: O(N) SC:O(1)
public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices){
    int min=prices[0];
    int maxProfit=0;

    for(int i=1; i<prices.length; i++){
      int cost=prices[i]-min;
      maxProfit=Math.max(maxProfit, cost);
      min=Math.min(min, prices[i]);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices  ={7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
  }
}