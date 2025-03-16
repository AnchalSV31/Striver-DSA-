package ARRAY.Easy.Array_1;
// import java.util.*;
// import java.util.Arrays;

public class SecondSmallest {
    public static void main(String[] args) {
        int arr1[] = {3,4,5,6,1,7};
        System.out.println("SECOND SMALLEST: "+ secSmall(arr1));
    }

    static int secSmall(int arr[]){
        int smallest= arr[0];
        int ssmall= Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<smallest){
                ssmall=smallest;
                smallest=arr[i];
            }
            else if(arr[i]<ssmall && arr[i]!=smallest){
                ssmall=arr[i];
            }
        }
        return ssmall;
    }
    
}
