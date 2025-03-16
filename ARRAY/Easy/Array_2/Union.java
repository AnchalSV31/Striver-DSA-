package ARRAY.Easy.Array_2;

import java.util.*;
import java.util.ArrayList;
import java.util.Set;

public class Union {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {3,4,5,6,7,8,9};
        int n=6;
        int m=7;
        //unionSet(arr1, arr2, n, m);
        ArrayList<Integer> Union=union(arr1, arr2, n, m);
        for(int val: Union){
            System.out.print(val+" ");
        }
    }

    //Brute force
    static ArrayList<Integer> union(int arr1[], int arr2[], int n, int m){
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> Union =new ArrayList<>();
        for(int i=0; i<n; i++){
            s.add(arr1[i]);
        }
        for(int i=0; i<m; i++){
            s.add(arr2[i]);
        }
        for(int it:s){
            Union.add(it);
        }
        return Union;
    }

    //Optimal
    static int unionSet(int arr1[], int arr2[], int n, int m){
        int i=0, j=0;
        while(i<n && j<m){
            if(arr1[i]< arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
            }
            else if(arr2[j]< arr1[i]){
                System.out.print(arr2[j]+" ");
                j++;
            }
            else{
                System.out.print(arr2[j]+ " ");  //when both are equal
                j++;
                i++;
            }
        }

        //For remaining elements in the array
        while(i<n){
            System.out.print(arr1[i]+ " ");
            i++;
        }
        while(j<m){
            System.out.print(arr2[j]+ " ");
            j++;
        }
        return 0;
    }
    
}
