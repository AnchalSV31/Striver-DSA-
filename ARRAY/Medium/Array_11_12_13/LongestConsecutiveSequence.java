package ARRAY.Medium.Array_11_12_13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 2, 3, 4};
        //int ans = longestConsecutiveSequence(arr);
        //int ans2 = longestConsecutiveSequence2(arr);
        int ans3 = longestConsecutiveSequence3(arr);
        System.out.println("The longest consecutive sequence is " + ans3);
    }

    //Brute Force[Linear search]
    public static int longestConsecutiveSequence(int arr[]){
        int n= arr.length;
        int longest=1;
        //pick a element and search for its consecutive numbers
        for(int i=0; i<n; i++){
            int x=arr[i];
            int cnt=1;
            //search for consecutive numbers using linear search
            while(linearSearch(arr, x+1)==true){
                x+=1;
                cnt+=1;
            }
            longest=Math.max(longest, cnt);
        }
        return longest;
    }

    public static boolean linearSearch(int []arr, int num) {
        int n = arr.length; //size of array
        for (int i = 0; i < n; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }

    //Better solution [sorting]
    public static int longestConsecutiveSequence2(int arr[]){
        int n=arr.length;
        if(n==0) return 0;

        //sort the array
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt=0;
        int longest=1;

        //find the longest sequnce
        for(int i=0; i<n; i++){
            if(arr[i]-1==lastSmaller){
                //arr[i] is the next elemnt of teh current sequence
                cnt+=1;
                lastSmaller=arr[i];
            }else if(arr[i]!=lastSmaller){
                cnt=1;
                lastSmaller=arr[i];
            }
            longest=Math.max(longest, cnt);
        }
        return longest;
    }

    //Optimal approach [Using set DS]
    public static int longestConsecutiveSequence3(int arr[]){
        int n=arr.length;
        if(n==0) return 0;
        int longest =1;
        Set<Integer> set = new HashSet<>();

        //put all the array elements into set
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }

        //Find the longest sequnce
        for(int it: set){
            //if 'it' is a starting number
            if(!set.contains(it-1)){
                //find consexutive numbers
                int cnt=1;
                int x=it;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt=cnt+1;
                }
                longest=Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
