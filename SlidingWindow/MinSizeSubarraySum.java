package SlidingWindow;

public class MinSizeSubarraySum {
    public static int minSizeSubarray(int[] arr, int target){
        int n=arr.length;
        int minL=Integer.MAX_VALUE;
        int left=0;
        int sum=0;

        for(int i=0; i<n; i++){
            sum+=arr[i];
            while(sum>=target){
                minL=Math.min(minL, i-left+1);
                sum-=arr[left];
                left++;
            }
        }
        return (minL==Integer.MAX_VALUE) ? 0 : minL;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSizeSubarray(nums, target));
    }
}
