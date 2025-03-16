package ARRAY.Easy.Array_1;
import java.util.*;

public class LargestElementInArray{
    public static void main(String[] args) {
        int arr1[] = {3, 2, 1, 5, 2};
        //System.out.println("Largest element= "+ Largest(arr1));
        System.out.println(sort(arr1));
    }

    //recursive approach
    static int Largest(int arr[]){
        int max= arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
            
        }
        return max;
    }

    //Brute force
    static int sort(int arr[]){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

}