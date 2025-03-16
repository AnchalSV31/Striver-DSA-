package ARRAY.Easy.Array_1;
import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        int arr1[] = {3,2,4,5,1};
        //System.out.println(secLargest(arr1));
        //System.out.println(sort(arr1));
        //System.out.println("Second largest element " +seclargest(arr1));
        System.out.println("Second Largest "+ secLarge(arr1));
    }

    //Better approach[when there are same elements present]
    static int seclargest(int arr[]){
        int max=arr[0];
        int sLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]>sLargest && arr[i]!=max){
                sLargest= arr[i];
            }
        }
        return sLargest;
    }

    //Brute force
    static int sort(int arr[]){
        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    //optimal solution(best approach)
    static int secLarge(int arr[]){
        int largest= arr[0];
        int slarge= -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                slarge=largest;
                largest=arr[i];
            }
            else if(arr[i]>slarge && arr[i]<largest){
                slarge=arr[i];
            }
        }
        return slarge;
    }
}
