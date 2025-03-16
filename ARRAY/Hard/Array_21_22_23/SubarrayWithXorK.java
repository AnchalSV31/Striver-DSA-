package ARRAY.Hard.Array_21_22_23;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithXorK {
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k=6;
        int ans= subarrayWithXorK3(arr, k);
        System.out.println("The number of subarrays with XOR as k is: "+ ans);
    }

    //Brute Force Approach
    public static int subarrayWithXorK(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xorr = 0;
                //step 2:calculate XOR of all elements:
                for (int K = i; K <= j; K++) {
                    xorr = xorr ^ arr[K];
                }
                // step 3:check XOR and count:
                if (xorr == k) count++;
            }
        }
        return count;
    }

    //Better Approach
    public static int subarrayWithXorK2(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal Approach
    public static int subarrayWithXorK3(int arr[], int k){
        int n = arr.length;
        int xr=0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(xr,1); //setting the value of 0
        int count=0;
        for(int i=0; i<n; i++){
            xr=xr^arr[i];
            int x=xr^k;
            if(mpp.containsKey(x)){
                count+=mpp.get(x);
            }
            if(mpp.containsKey(xr)){
                mpp.put(xr, mpp.get(xr)+1);
            }else{
                mpp.put(xr, 1);
            }
        }
        return count;
    }
}