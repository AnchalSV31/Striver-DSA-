package SlidingWindow;

public class MaxSumSubarray {
    public static int maxSum(int[] arr, int k){
        int curr=0;
        for(int i=0; i<k; i++){
            curr+=arr[i];
        }

        int max=curr;
        for(int i=1; i<arr.length-k+1; i++){
            curr=curr-arr[i-1]+arr[i+k-1];
            max=Math.max(curr, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr= {3,8,2,5,7,6,12};
        int k=4;
        System.out.println(maxSum(arr, k));
    }
}
