package BinarySearch;

public class NoOfTimesArayBeenRotated {
    //number of times an array has been rotated
    public static int countRotations(int[] arr){
        int n=arr.length;
        int low=0, high=n-1;
        int ans= Integer.MAX_VALUE;
        int index=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]){
                if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                low=mid+1;
            }else{ 
                if(arr[mid]<ans){
                    index=mid;
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return index;  
    }
    
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(countRotations(arr));
    }

}
