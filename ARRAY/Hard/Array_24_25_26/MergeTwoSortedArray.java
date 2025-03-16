package ARRAY.Hard.Array_24_25_26;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        long[] arr1={1, 4, 8, 10};
        long[] arr2={2,3,9};
        int n=4, m=3;
        //merge(arr1, arr2, n, m);
        //merge1(arr1, arr2, n, m);
        merge2(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[]= ");
        for(int i=0; i<n; i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.print("\narr2[]= ");
        for(int i=0; i<m; i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
    }

    //Brute Force
    public static void merge(long[] arr1, long[] arr2, int n, int m){
        //declarea 3rd array and 2 pointers:
        long[] arr3 = new long[n+m];
        int left=0;
        int right=0;
        int index=0;

        //insert the elements from the 2 arrays into the 3rd array using left and right pointers:
        while(left<n && right<m){
            if(arr1[left]<=arr2[right]){
                arr3[index]=arr1[left];
                left++;
                index++;
            }
            else{
                arr3[index]=arr2[right];
                right++;
                index++;
            }
        }

        //If right pointer reaches the end:
        while(left<n){
            arr3[index++]=arr1[left++];
        }

        //if left pointer reaches the end:
        while(right<m){
            arr3[index++]=arr2[right++];
        }

        //fill back the elements from arr3[] to arr1[] and arr2[]:
        for(int i=0; i<m+n; i++){
            if(i<n){
                arr1[i]=arr3[i];
            }else{
                arr2[i-n]=arr3[i];
            }
        }
    } 

    //Optimal approach 1
    public static void merge1(long[] arr1, long[] arr2, int n, int m){
        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                long temp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        //sort the arrays:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    //Optimal approach 2[Gap method]
    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2){
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void merge2(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }
}
