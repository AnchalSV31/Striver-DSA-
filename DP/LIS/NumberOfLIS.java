package DP.LIS;

import java.util.Arrays;

public class NumberOfLIS {
    //TC: O(N*N) SC: O(N)
    public static int NumOfLIS(int[] arr){
        int n=arr.length;

        //length of LIS with arr[i] as its last element
        int[] dp= new int[n]; 
        
        //count of LIS(s) possible of length dp[i] with arr[i] as its last element
        int[] ct= new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(ct,1);

        int maxi=1;

        for(int i=0; i<=n-1; i++){
            for(int prev_ind=0; prev_ind<=i-1; prev_ind++){
                if(arr[prev_ind]<arr[i] && dp[prev_ind]+1>dp[i]){
                    dp[i] = dp[prev_ind]+1;
                    //inherit
                    ct[i] = ct[prev_ind];
                }
                else if(arr[prev_ind]<arr[i] && dp[prev_ind]+1==dp[i]){
                    //increase the count
                    ct[i] = ct[i] + ct[prev_ind];
                }
            }
            maxi=Math.max(maxi, dp[i]);
        }

        int nos=0;
        for(int i=0; i<=n-1; i++){
            if(dp[i]==maxi) nos+=ct[i];
        }
        return nos;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2,6,7,2};
        System.out.println(NumOfLIS(arr));
    }
}
