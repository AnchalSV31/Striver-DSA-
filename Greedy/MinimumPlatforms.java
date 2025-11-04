package Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    //BRUTE FORCE
    //TC: O(N^2) SC:O(1)
    public static int countPlatforms(int n, int[] arr, int[] dep){
        int ans=1;
        
        for(int i=0; i<n; i++){
            int count=1;
            for(int j=i+1; j<n; j++){
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i])){
                    count++;
                }
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }

    //OPTIMAL APPROACH
    //TC: O(N logN) SC:O(1)
    public static int countPlatforms2(int n, int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms=1;
        int result=1;
        int i=1, j=0;

        while(i<n && j<n){
            // If next train arrives before current one departs
            if(arr[i]<=dep[j]){
                // One more platform needed
                platforms++;
                i++;
            }else{
                // One train departs, platform freed
                platforms--;
                j++;
            }
            result=Math.max(result, platforms);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;

        System.out.println(countPlatforms(n, arr, dep));
        System.out.println(countPlatforms2(n, arr, dep));
    }
}

