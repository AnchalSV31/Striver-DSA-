package DP.LIS;
import java.util.*;

public class LISBinarySearch {
    //TC:O(N*logN) SC:O(N) 
    public static int LIS(int arr[], int n){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len=1;

        for(int i=1; i<n; i++){
            // arr[i] > the last element of temp array
            if(arr[i]>temp.get(temp.size()-1)){
                temp.add(arr[i]);
                len++;
            }
            else{
                // Replacement step
                int ind= Collections.binarySearch(temp, arr[i]);
                if(ind<0){
                    ind= -ind-1;
                }
                temp.set(ind, arr[i]);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        System.out.println(LIS(arr, n));
    }
}
