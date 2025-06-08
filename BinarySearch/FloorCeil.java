package BinarySearch;

public class FloorCeil {
    //largest element in the array which is smaller than or equal to x
    public static int floor(int[] arr, int x){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return arr[ans];
    }

    // smallest element in the array greater than or equal to x
    //lower bound
    public static int ceil(int[] arr, int x){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return arr[ans];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,4,7,8,10};
        int x = 5;
        System.out.println(floor(arr,x));
        System.out.println(ceil(arr,x));
    }
}
