package BinarySearch;

public class SmallestDivisorGivenThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;

        if(n>threshold) return -1;

        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            high=Math.max(high,nums[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=sumByD(nums,mid);
            if(sum<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static int sumByD(int[] nums, int divisor){
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=Math.ceil((double)nums[i]/divisor);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={1,2,5,9};
        int threshold=6;
        System.out.println(smallestDivisor(nums,threshold));
    }
}
