package BinarySearch;

public class SplitArrayLargestSum {
    public static int splitArray(int[] arr, int k) {
        int n=arr.length;
        int low=arr[0];
        int high=0;

        //to find max for low and summation for high 
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]); 
            high += arr[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int partitions=countPartitions(arr, mid);
            if(partitions>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }

    public static int countPartitions(int[] arr, int maxSum){
        int n=arr.length;
        int partitions=1;
        int subarraySum=0;

        for(int i=0; i<n; i++){
            if (subarraySum + arr[i] > maxSum) {
                partitions++;
                subarraySum = arr[i];
            } else {
                subarraySum += arr[i];
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        int[] arr={7,2,5,10,8};
        int k=2;
        System.out.println(splitArray(arr,k));
    }
}
