package ARRAY.Hard.Array_21_22_23;

import java.util.HashMap;

public class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        int a[]= {9, -3, 3, -1, 6, -5};
        System.out.println(maxLen2(a));
    }

    //Brute Force
    public static int maxLen(int[] a){
        int n=a.length;
        int max=0;
        for(int i=0; i<n; ++i){
            int sum=0;
            for(int j=i; j<n; ++j){
                sum+=a[j];
                if(sum==0){
                    max=Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    //Optimal Approach
    public static int maxLen2(int a[]){
        int n=a.length;
        HashMap<Integer, Integer> mpp= new HashMap<Integer, Integer>();
        int maxi=0;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=a[i];
            if(sum==0){
                maxi=i+1;
            }else{
                if(mpp.get(sum)!=null){
                    maxi=Math.max(maxi, i-mpp.get(sum));
                }else{
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
