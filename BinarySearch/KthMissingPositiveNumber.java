package BinarySearch;

public class KthMissingPositiveNumber {
    //Brute force
    public static int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k; 
    }

    //optimal solution
    public static int findKthPositive2(int[] arr, int k) {
        int n=arr.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high=mid-1;
        }
        return (low+k);
    }
    
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        int k=5;
        System.out.println(findKthPositive(arr,k));
        System.out.println(findKthPositive2(arr, k));
    }
}
