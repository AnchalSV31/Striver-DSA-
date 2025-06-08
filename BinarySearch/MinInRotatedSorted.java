package BinarySearch;

public class MinInRotatedSorted {
    public static int findMin(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;

        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }

    public static int findMin2(int[] arr){
        int n=arr.length;
        int low=0, high=n-1;
        int ans= Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]){
                ans=Math.min(ans, arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
                ans=Math.min(ans, arr[low]);
                low=mid+1;
            }else{ 
                ans=Math.min(ans, arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2,3};
        System.out.println(findMin2(nums));
    }
}
