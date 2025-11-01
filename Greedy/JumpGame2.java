package Greedy;
import java.util.*;

public class JumpGame2 {
    //BRUTE FORCE
    //TC:O(2^N) SC:O(N)
    public static int jump(int[] nums){
        return minJump1(nums, 0);
    }

    public static int minJump1(int[] nums, int position){
        if(position>=nums.length-1)return 0;

        if(nums[position]==0)return Integer.MAX_VALUE;

        int minStep=Integer.MAX_VALUE;
        for(int jump=1; jump<=nums[position]; jump++){
            int subResult=minJump1(nums, position+jump);
            if(subResult!=Integer.MAX_VALUE){
                minStep=Math.min(minStep, 1+subResult);
            }
        }
        return minStep;
    }

    //BETTER APPROACH
    //TC:O(N^2) SC:O(N)
    public static int jump2(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<n; i++){
            for(int j=1; j<=nums[i] && i+j<n; j++){
                dp[i+j]=Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[n-1];
    }

    //OPTIMAL APPROACH
    //TC:O(N) SC:O(1)
    public static int jump3(int[] nums){
        int jumps=0;
        int currentEnd=0;
        int farthest=0;

        for(int i=0; i<nums.length-1; i++){
            farthest=Math.max(farthest, i+nums[i]);

            if(i==currentEnd){
                jumps++;
                currentEnd=farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        // int result= jump(nums);
        // int result= jump2(nums);
        int result= jump3(nums);
        System.out.println(result);
    }
}
