package SlidingWindow;

import java.util.HashMap;

//max length subarray with atmost 2 types of fruits
//bcoz we have only 2 baskets and we can put only same type of fruit in a basket
public class FruitIntoBasket {
    //TC:O(N)+O(N) SC:O(1)
    public static int maxFruits(int[] arr){
        int n=arr.length;
        HashMap<Integer, Integer> mp= new HashMap<>();

        int left=0, right=0;
        int maxLen=0;

        while(right<n){
            mp.put(arr[right], mp.getOrDefault(arr[right],0)+1);
            //atmost 2 unique numbers/fruits are allowed
            while(mp.size()>2){
                mp.put(arr[left], mp.get(arr[left])-1);
                if(mp.get(arr[left])==0){
                    mp.remove(arr[left]);
                }
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    //TC:O(N) SC:O(1)
    public static int maxFruits2(int[] arr){
        int n=arr.length;
        HashMap<Integer, Integer> mp= new HashMap<>();

        int left=0, right=0;
        int maxLen=0;

        while(right<n){
            mp.put(arr[right], mp.getOrDefault(arr[right],0)+1);
            //atmost 2 unique numbers/fruits are allowed
            if(mp.size()>2){
                mp.put(arr[left], mp.get(arr[left])-1);
                if(mp.get(arr[left])==0){
                    mp.remove(arr[left]);
                }
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(maxFruits(fruits));
        System.out.println(maxFruits2(fruits));
    }
}
