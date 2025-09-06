package DP.LIS;
import java.util.*;

public class PrintLIS {
    //TC:O(N*N) SC:O(N) 
    public static int LIS(int arr[], int n){
        int dp[]=new int[n];
        Arrays.fill(dp, 1);

        int hash[]=new int[n];
        Arrays.fill(hash, 1);

        for(int i=0; i<n; i++){
            hash[i]=i;
            for(int prev_ind=0; prev_ind<i; prev_ind++){
                if(arr[prev_ind]<arr[i] && 1+dp[prev_ind]>dp[i]){
                    dp[i]=1+dp[prev_ind];
                    hash[i]=prev_ind;
                }
            }
        }

        int ans=-1;
        int lastIndex=-1;

        for(int i=0; i<n; i++){
            if(dp[i]>ans){
                ans=dp[i];
                lastIndex=i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);
    
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);    
        }
    
        // reverse the array 
        System.out.print("The subsequence elements are ");
    
        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        System.out.println(LIS(arr, n));
    }
}
