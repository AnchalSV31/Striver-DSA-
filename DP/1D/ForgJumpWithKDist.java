package DP;

import java.util.Arrays;

public class ForgJumpWithKDist {
    //Memoization  TC:O(N*K) SC:O(N)+O(N)
    public static int frogJumpK(int n, int[] height, int[] dp, int k){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int minSteps=Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(n-j>=0){
                int jump=frogJumpK(n-j, height, dp, k)+Math.abs(height[n]-height[n-j]);
                minSteps=Math.min(minSteps, jump);
            } 
        }
        return dp[n]=minSteps;
    }

    //Tabulation approach TC:O(N*k) SC:O(N)
    public static int frogJumpK2(int n, int[] height, int[] dp, int k){
        dp[0]=0;
        for(int i=1; i<n; i++){
            int minSteps=Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    minSteps=Math.min(jump, minSteps);
                }
            }           
            dp[i]=minSteps; 
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n=6;
        int[] height={30,10,60,10,60,50};
        int k=2;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpK(n-1, height, dp, k));
        System.out.println(frogJumpK2(n, height, dp, k));
    }
}
