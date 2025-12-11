package Heap;
import java.util.*;

public class HandsOfStraight {
    //TC: O(N log N) SC: O(N)
    public static boolean isNStraightHand(int[] arr, int gsize){
        // If total cards can't be divided evenly, return false
        if(arr.length % gsize!=0) return false;

        //store the frequency of each card in a sorted map
        //treemap -> keys sorted
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int card: arr){
            freq.put(card, freq.getOrDefault(card, 0)+1);
        }

        //loop through all keys in the map
        while(!freq.isEmpty()){
            int start = freq.firstKey();
            int count = freq.get(start);

            for(int i=0; i<gsize; i++){
                int card= start+i;

                //If the required card is missing OR It exists but does not have enough quantity
                //Then forming this straight hand is impossible, return false.
                if(!freq.containsKey(card) || freq.get(card)<count){
                    return false;
                }

                //decrease the frequency
                if(freq.get(card)==count) freq. remove(card);
                else freq.put(card, freq.get(card) - count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }
}
