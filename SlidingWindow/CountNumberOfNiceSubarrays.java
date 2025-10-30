package SlidingWindow;

//number of subarrays with number of odd elements equal to k
public class CountNumberOfNiceSubarrays {
    //TC:O(2N) SC:O(1)
    public static int count(int[] nums, int k){
        int n=nums.length;
        int left=0, right=0;
        int count=0;
        int sum=0;
        
        if(k<0) return 0;

        while(right<n){
            sum+=nums[right]%2;
            while(sum>k){
                sum-=nums[left]%2;
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k){
        return count(nums, k)- count(nums,k-1);
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
