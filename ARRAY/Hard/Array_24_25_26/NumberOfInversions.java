package ARRAY.Hard.Array_24_25_26;

import java.util.ArrayList;

public class NumberOfInversions {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        //int cnt = numberOfInversions(a, n);
        int cnt = numberOfInversions2(a, n);
        System.out.println("The number of inversions is: " + cnt);
    }

    //Brute Force
    public static int numberOfInversions(int[] a, int n){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(a[i]>a[j]) count++;
            }
        }
        return count;
    }

    //Optimal Approach
    public static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp=new ArrayList<>();  // temporary array
        int left=low;  // starting index of left half of arr
        int right=mid+1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int count=0;

        //storing elements in the temporary array in a sorted manner//
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                count+=(mid-left+1);  //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left 
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        //if elements on the right half are still left 
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        // transfering all elements from temporary to arr
        for(int i=low; i<=high; i++){
            arr[i]=temp.get(i-low);
        }
        return count;  // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2 ;
        count += mergeSort(arr, low, mid);  // left half
        count += mergeSort(arr, mid + 1, high); // right half
        count += merge(arr, low, mid, high);  // merging sorted halves
        return count;
    }

    public static int numberOfInversions2(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }
}
