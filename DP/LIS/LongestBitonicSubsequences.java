package DP.LIS;

import java.util.*;

public class LongestBitonicSubsequences{
    //TC:O(N*N) SC:O(N)
    public static int longestBitonic(int[] arr, int n){
        int[] dp1= new int[n];
        int[] dp2= new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i=0; i<n; i++){
            for(int prev_ind=0; prev_ind<i; prev_ind++){
                if(arr[prev_ind]<arr[i]){
                    dp1[i]=Math.max(dp1[i], 1+dp1[prev_ind]);
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int prev_ind=n-1; prev_ind>i; prev_ind--){
                if(arr[prev_ind]<arr[i]){
                    dp2[i]=Math.max(dp2[i], 1+dp2[prev_ind]);
                }
            }
        }
        int maxi=-1;
        for(int i=0; i<n; i++){
            maxi=Math.max(maxi, dp1[i]+dp2[i]-1);
        }

        // //if one more condition is also added:
        // //The subsequence must have at least one increasing part and one decreasing part.
        // // Ensure both LIS and LDS contribute (>1)
        // int maxi=0;
        // for (int i = 0; i < n; i++) {
        //     if (dp1[i] > 1 && dp2[i] > 1) { 
        //         maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        //     }
        // }
        
        return maxi;
    }

    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;
        System.out.println(longestBitonic(arr, n));
    }
}