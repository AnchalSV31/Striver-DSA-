package SlidingWindow;

public class MinOperationsToReduceXToZero {
    //TC: O(N) SC: O(1)
    public static int minoperations(int[] nums, int x){
        int n=nums.length;
        int totalSum=0;

        for(int i=0; i<n; i++){
            totalSum+=nums[i];
        }

        int target=totalSum-x;
        if(target<0) return -1;

        int maxLen=-1, sum=0, left=0;
        for(int right=0; right<n; right++){
            sum+=nums[right];
            while(sum>target && left<=right){
                sum-=nums[left++];
            }

            if(sum==target){
                maxLen=Math.max(maxLen, right-left+1);    
            }
        }
        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        int[] nums={1,1,4,2,3};
        int x=5;
        System.out.println(minoperations(nums, x));
    }
}
