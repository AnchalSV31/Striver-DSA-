package DP;
import java.util.*;

public class FrogJump {
    //Memoization  TC:O(N) SC:O(N)+O(N)
    public static int frogJump(int n, int[] height, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int jumpTwo=Integer.MAX_VALUE;
        int jumpOne=frogJump(n-1, height, dp)+Math.abs(height[n]-height[n-1]);
        if(n>1){
            jumpTwo=frogJump(n-2, height, dp)+Math.abs(height[n]-height[n-2]);
        } 
        return dp[n]=Math.min(jumpOne, jumpTwo);
    }

    //Tabulation approach TC:O(N) SC:O(N)
    public static int frogJump2(int n, int[] height, int[] dp){
        dp[0]=0;
        for(int i=1; i<n; i++){
            int jumpTwo=Integer.MAX_VALUE;
            int jumpOne= dp[i-1]+Math.abs(height[i]-height[i-1]);
            if(i>1){
                jumpTwo=dp[i-2]+Math.abs(height[i]-height[i-2]);
            }
            dp[i]=Math.min(jumpOne, jumpTwo);
        }
        return dp[n-1];
    }

    //Space optimization TC:O(N) SC:O(1)
    public static int frogJump3(int n, int[] height, int[] dp){
        int prev=0, prev2=0;
        for(int i=1; i<n; i++){
            int jumpTwo=Integer.MAX_VALUE;
            int jumpOne=prev+ Math.abs(height[i]-height[i-1]);
            if(i>1){
                jumpTwo=prev2+Math.abs(height[i]-height[i-2]);
            }
            int curr=Math.min(jumpOne, jumpTwo);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n=6;
        int[] height={30,10,60,10,60,50};
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(n-1, height, dp));
        System.out.println(frogJump2(n, height, dp));
        System.out.println(frogJump3(n, height, dp));
    }
}
 