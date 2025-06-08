package BinarySearch;

public class LowerAndUpperBound {
    // smallest element in arr[] that is greater than or equal to k. 
    public static int lower(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    // smallest element in arr[] that is greater than k. 
    public static int upper(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int x = 9;
        System.out.println(lower(arr,x));
        System.out.println(upper(arr,x));
        
    }
}
