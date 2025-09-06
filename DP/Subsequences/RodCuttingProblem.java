package DP.Subsequences;
// package DP;

public class RodCuttingProblem {
  //RECURSION
  public static int cutRod(int ind, int N, int[] price){
    if(ind==0) return N*price[0];
    int notTake= 0 + cutRod(ind-1, N, price);
    int take= Integer.MIN_VALUE;
    int rodLength = ind+1;
    if(rodLength<=N){
      take = price[ind] + cutRod(ind, N-rodLength, price);
    }
    return Math.max(notTake, take);
  }

  public static int cutRodMain(int[] price, int N){
    return cutRod(N-1, N, price);
  }

  //MEMOIZATION
  //TC: O(N*N) SC: O(N*N)+ O(N)
  public static int cutRod2(int ind, int N, int[] price, int[][] dp){
    if(ind==0) return N*price[0];
    if(dp[ind][N]!=-1) return dp[ind][N];
    int notTake= 0 + cutRod(ind-1, N, price);
    int take= Integer.MIN_VALUE;
    int rodLength = ind+1;
    if(rodLength<=N){
      take = price[ind] + cutRod2(ind, N-rodLength, price, dp);
    }
    return dp[ind][N] = Math.max(notTake, take);
  }

  public static int cutRodMain2(int[] price, int N){
    int[][] dp = new int[N+1][N+1];
    for(int[] arr: dp){
      for(int i=0; i<arr.length; i++){
        arr[i]=-1;
      }
    }
    return cutRod2(N-1, N, price, dp);
  }

  //TABULATION
  //TC: O(N*N) SC: O(N*N)
  public static int cutRod3(int N, int[] price){
    int[][] dp = new int[N+1][N+1];
    for(int n=0; n<=N; n++){
      dp[0][n] = n*price[0];
    }
    for(int ind=1; ind<N; ind++){
      for(int n=0; n<=N; n++){
        int notTake= 0 + dp[ind-1][n];
        int take= Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(rodLength<=n){
          take = price[ind] + dp[ind][n-rodLength];
        }
        dp[ind][n] = Math.max(notTake, take);
      }
    }
    return dp[N-1][N];
  }

  public static int cutRodMain3(int[] price, int N){
    return cutRod3(N, price);
  }

  //SPACE OPTIMIZATION
  //TC: O(N*N) SC: O(N)
  public static int cutRodMain4(int[] price, int N){
    int[] prev = new int[N+1];
    for(int n=0; n<=N; n++){
      prev[n] = n*price[0];
    }                       
    for(int ind=1; ind<N; ind++){
      for(int n=0; n<=N; n++){
        int notTake= 0 + prev[n];
        int take= Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(rodLength<=n){
          take = price[ind] + prev[n-rodLength];
        }
        prev[n] = Math.max(notTake, take);
      }
    }
    return prev[N];
  }

  public static void main(String[] args) {
    int[] price = {2,5,7,8,10};
    int N = 5;
    System.out.println(cutRodMain(price, N));
    System.out.println(cutRodMain2(price, N));
    System.out.println(cutRodMain3(price, N));
    System.out.println(cutRodMain4(price, N));
  }
}

