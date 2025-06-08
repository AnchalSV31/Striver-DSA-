package BinarySearch;

public class BS {
    //Iterative
    public static int binarysearch(int[] arr, int k) {
        // Code Here
        int n= arr.length;
        int low=0, high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    //recursive
    public static int binarysearch(int[] arr, int low, int high, int k){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==k) return mid;
        else if(arr[mid]<k) return binarysearch(arr, mid+1, high, k);
        else return binarysearch(arr, low, high-1, k);
    }

    public static int search(int[] arr, int k) {
        return binarysearch(arr, 0, arr.length-1, k);
    }
    
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 5};
        int k=4;
        // System.out.print(binarysearch(arr,k));
        System.out.println(search(arr, k));
    }
}
