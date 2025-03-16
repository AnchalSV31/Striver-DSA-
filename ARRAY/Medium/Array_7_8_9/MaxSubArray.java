package ARRAY.Medium.Array_7_8_9;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        // int maxSum = maxSubarraySum(arr, n);
        // int maxSum2 = maxSubarraySum2(arr, n);
        // long maxSum3 = maxSubarraySum3(arr, n);
        long maxSum4 = maxSubarraySumPrint(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum4);
    }

    //Brute Force
    public static int maxSubarraySum(int[] arr, int n){
        int maxi= Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum=0;
                //add all the elements of subarray
                for(int k=i; k<=j; k++){
                    sum+=arr[k];
                }
                maxi=Math.max(maxi, sum);
            }
        }
        return maxi;
    }
    
    //Better solution
    public static int maxSubarraySum2(int[] arr, int n){
        int maxi= Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                //add all the elements of subarray
                sum+=arr[j];
                
                maxi=Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    //Optimal Solution
    public static long maxSubarraySum3(int arr[], int n){
        long maxi=Long.MIN_VALUE;
        long sum=0;

        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum>maxi){
                maxi=sum;
            }

            //if sum<0: discard the sum calculated and make it 0
            if(sum<0){
                sum=0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;
        return maxi;
    }

    //To print any subarray with maximum sum
    public static long maxSubarraySumPrint(int arr[], int n){
        long maxi=Long.MIN_VALUE;
        long sum=0;

        int start=0;
        int ansStart= -1, ansEnd = -1;
        for(int i=0; i<n; i++){
            if(sum==0){
                start=i;   // starting index
            }

            sum+=arr[i];

            if(sum>maxi){
                maxi=sum;

                ansStart = start;
                ansEnd = i;
            }

            //if sum<0: discard the sum calculated and make it 0
            if(sum<0){
                sum=0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;
        return maxi;
    }
}
