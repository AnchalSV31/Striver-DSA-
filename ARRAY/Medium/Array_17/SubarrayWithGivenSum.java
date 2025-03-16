package ARRAY.Medium.Array_17;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        //int ans = subarraysWithGivenSum(arr, k);
        //int ans2 = subarraysWithGivenSum2(arr, k);
        int ans3 = subarraysWithGivenSum3(arr, k);
        System.out.println("The number of subarrays is: " + ans3);
    }

    //Count Subarray sum Equals K

    //Brute force
    public static int subarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; 
        int cnt = 0; 

        for (int i = 0 ; i < n; i++) { 
            for (int j = i; j < n; j++) { 
                int sum = 0;
                for (int K = i; K <= j; K++)
                    sum += arr[K];

                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }


    //Better approach
    public static int subarraysWithGivenSum2(int arr[], int k) {
        int n = arr.length; 
        int cnt = 0; 

        for (int i = 0 ; i < n; i++) { 
            int sum = 0;
            for (int j = i; j < n; j++) { 
                sum += arr[j];

                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }


    //Optimal Approach [Prefix Sum]
    public static int subarraysWithGivenSum3(int arr[], int k){
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum=0, cnt=0;

        mpp.put(0, 1); //Setting 0 in the map
        for(int i=0; i<n; i++){
            // add current element to prefix Sum:
            preSum+=arr[i];
            // Calculate x-k:
            int remove=preSum-k;
            // Add the number of subarrays to be removed:
            cnt+=mpp.getOrDefault(remove,0);
            // Update the count of prefix sum in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0)+1);

        }   
        return cnt;
    }
}
