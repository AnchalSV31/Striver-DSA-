package Greedy;

public class JumpGame1 {
    //TC:O(N) SC:O(1)
    public static boolean canJump(int[] nums){
        int maxIndex=0;
        for(int i=0; i<nums.length; i++){
            if(i>maxIndex){
                return false;
            }
            maxIndex=Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 7, 1, 2};

        boolean ans = canJump(nums);
        System.out.println(ans);
    }
}
