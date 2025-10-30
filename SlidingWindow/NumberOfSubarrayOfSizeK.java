package SlidingWindow;

//number of subarray of size k and avg greater than or equal to threshold
public class NumberOfSubarrayOfSizeK {
    public static int numOfSubarray(int[]arr, int k, int threshold){
        int n=arr.length;
        int sum=0;
        int cnt=0;

        for(int i=0; i<k; i++){
            sum+=arr[i];
        }

        if(sum/k>=threshold){
            cnt++;
        }

        for(int i=k; i<n; i++){
            sum+=arr[i]-arr[i-k];
            if(sum/k>=threshold){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr= {11,13,17,23,29,31,7,5,2,3};
        int k=3;
        int threshold=5;
        System.out.println(numOfSubarray(arr, k, threshold));
    }
}
