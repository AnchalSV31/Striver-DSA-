package BinarySearch;

public class SingleElementInSortedArray {
    //single non dupicate element
    //BRUTE FORCE     TC:O(N) sc:O(1)
    public static int singleNonDuplicate1(int[] arr) {
        int n = arr.length; 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }


    //optimized   TC:O(log n)  SC:O(1)
    public static int singleNonDuplicate2(int[] nums) {
        int n= nums.length;
        int l=0, r=n-1;

        while(l<r){
            int mid=l+(r-l)/2;
            if(mid%2==1){
                mid--;  //ensure mid is even
            }
            if(nums[mid]!=nums[mid+1]){
                r=mid;
            }
            else{
                l=mid+2;
            }
        }
        return nums[l];  
    }

    //More Optimised code
    public static int singleNonDuplicate3(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int l=1, r=n-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            
            if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid+1]==nums[mid])) {
                l=mid+1;   //eliminate left half
            }else{
                r=mid-1;    //eliminate right half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate3(nums));
    }
}
