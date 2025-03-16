package ARRAY.Easy.Array_3;

import java.util.HashMap;
import java.util.Map;

public class GetSingleElement {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        //int ans = getSingleElement(arr);
        //int ans1 = getSingleElement1(arr);
        //int ans2 = getSingleElement2(arr);
        int ans3 = getSingleElement3(arr);
        System.out.println("The single element is: " + ans3);
    }

    //BRUTE FORCE
    public static int getSingleElement(int []arr){
        //size of the array
        int n=arr.length;

        //run the loop for selecting elements
        for(int i=0; i<n ; i++){
            int num=arr[i]; //selected element
            int count =0;

            //find the occurrence using the linear search
            for(int j=0; j<n; j++){
                if(arr[j]==num){
                    count++;
                }
            }
             //if the occurrence is 1 return ans:
             if(count==1){
                return num;
            }
        }
        return -1;
    }

    //Better solution
    //TYPE 1 (HASHING)
    public static int getSingleElement1(int []arr){
        //size of the array
        int n=arr.length;

        //find the max element
        int maxI= arr[0];
        for(int i=0; i<n; i++){
            maxI=Math.max(maxI, arr[i]);
        }

        //declare hash array of size maxI+1
        //and hash the given array
        int[] hash = new int[maxI + 1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }

        //find the single element and return the answer
        for(int i=0; i<n; i++){
            if(hash[arr[i]]==1){
                return arr[i];
            }
        }
        return -1;
    }

    //TYPE 2 {HASH MAP}
    public static int getSingleElement2(int []arr) {
        //size of the array:
        int n = arr.length;

        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        //Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }

    //Optimal solution
    public static int getSingleElement3(int []arr) {
        //size of the array:
        int n = arr.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }
}
