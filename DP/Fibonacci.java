package DP;
import java.util.*;

public class Fibonacci {
    //recursion
    public static int fibo(int n){
        if(n<=1) return n;
        return fibo(n-1)+fibo(n-2);
    }

    //memoization  TC:O(N) SC:O(N)
    public static int fibo(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
    }

    //tabulation TC:O(N) SC:O(N)
    public static int fibo2(int n, int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //space optimization TC:O(N) SC:O(1)
    public static int fibo3(int n){
        int prev2=0;
        int prev=1;
        for(int i=2; i<=n; i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(fibo(n));

        //memoization
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibo(n, dp));
        System.out.println(fibo2(n, dp));
        System.out.println(fibo3(n));
    }
}
