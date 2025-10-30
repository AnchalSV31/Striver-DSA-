package SlidingWindow;


//all the 1’s together in minimum swaps.
//TC:O(N) SC:O(1)
public class MinSwaps {
    public static int minSwaps(int[] nums){
        int n=nums.length;
        int countOnes=0;

        for(int num:nums){
            if(num==1)countOnes++;
        }

        if(countOnes==0 || countOnes==n)return 0;

        int maxOnes=0;
        int currentOnes=0;

        for(int i=0; i<countOnes; i++){
            if(nums[i]==1) currentOnes++;
        }

        maxOnes=currentOnes;

        for(int i=1; i<n; i++){
            if(nums[i-1]==1)currentOnes--;
            if(nums[(i+countOnes-1)%n]==1)currentOnes++;
            maxOnes=Math.max(maxOnes, currentOnes);
        }

        return countOnes-maxOnes;
    }

    public static void main(String[] args) {
        int[] nums={1,0,1,0,1};
        System.out.println(minSwaps(nums));
    }
} 
