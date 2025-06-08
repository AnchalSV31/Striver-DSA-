package DP;

public class ClimbingStairs {
    //TC:O(2^n) SC:O(n)
    public static int climbStairs(int n){
        if(n==1 || n==0) return 1;

        int left= climbStairs(n-1);
        int right= climbStairs(n-2);
        return left+right;
    }

    //optimized  TC:O(n) SC:O(1)
    public static int climbStairs2(int n){
        if(n==0 || n==1) return 1;
        int prev2=1,prev1=1;
        for(int i=2; i<=n; i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
    }
}
