package ARRAY.Medium.Array_7_8_9;

import java.util.ArrayList;
import java.util.Collections;

//VARIETY 1
public class RearrangeArrayBySign_1 {
    public static void main(String[] args) {
        int n = 4;
        int arr[]= {1,2,-4,-5};
        //rearrangeArray(arr, n);

        // int[]ans1= rearrangeArray2(arr,n);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(ans1[i]+" ");
        // }

        
        //rearrangeArray3(arr, n);

        ArrayList<Integer> ans4=rearrangeArray4(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans4.get(i)+" ");
        }

    }

    //Rearrange Array Elements by Sign

    //Brute Force
    public static void rearrangeArray(int arr[], int n){
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        
        int posCount = 0;
        int negCount = 0;

        // Partition the array into positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                if (posCount < pos.length) {
                    pos[posCount++] = arr[i];
                }
            } else if (arr[i] < 0) {
                if (negCount < neg.length) {
                    neg[negCount++] = arr[i];
                }
            }
        }

        for(int i=0; i<posCount; i++){
            arr[2*i]=pos[i];
        }
        for(int i=0; i< negCount; i++){
            arr[2*i+1]=neg[i];
        }

        //print resultant/modified array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //Or by arraylist
    public static int[] rearrangeArray2(int[] arr, int n){
    
        // Define 2 vectors, one for storing positive 
        // and other for negative elements of the array.
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
  
        // Segregate the array into positives and negatives.
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }  
  
        // Positives on even indices, negatives on odd.
        for(int i=0;i<n/2;i++){
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }
        return arr;
    }

    //Optimal approach
    
    public static void rearrangeArray3(int arr[], int n){
        //positive elements start from 0 and negative from 1
        int posIndex=0, negIndex=1;
        int[] ans = new int[n];

        // Partition the array into positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIndex]= arr[i];
                negIndex+=2;
            } else if (arr[i] > 0) {
                ans[posIndex]= arr[i];
                posIndex+=2;
            }
        }
        //print resultant/modified array
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    //or by arraylist
    public static ArrayList<Integer> rearrangeArray4(int[] arr){
        int n=arr.length;

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        
        //positive elements start from 0 and negative from 1
        int posIndex=0, negIndex=1;
        for(int i=0; i<n; i++){
            //fill negative elements in odd indices and inc by 2
            if(arr[i]<0){
                ans.set(negIndex, arr[i]);
                negIndex+=2;
            }
            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, arr[i]);
                posIndex += 2;
            }
        }
        return ans;
    }
}

