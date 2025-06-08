package BinarySearch;

public class SearchInsertPosition {
    public static int searchInsert(int[] arr, int x){
        int n=arr.length;
        int low=0, high= n-1;
        int ans=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int x = 7;
        System.out.println(searchInsert(arr,x));
    }
}
