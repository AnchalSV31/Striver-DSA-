package Heap_KK;

import java.util.Collections;
import java.util.PriorityQueue;

//REMOVE STONES TO MINIMIZE THE TOTAL NUMBER OF STONES
public class RemoveStone {
    public static int removeStones(int[] arr, int k){
        // int n=arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // long mod = 1000000007L;

        // add all chocolates
        for (int c : arr) pq.add(c);

        while (k > 0 && !pq.isEmpty()) {
            int pile = pq.poll();     // take the max
            pile=pile-(pile/2);
            pq.add(pile);         // refill half
            k--;
        }

        int minStones=0;
        while(!pq.isEmpty()){
            int stone=pq.poll();
            minStones+=stone;
        }
        return minStones;
    }

    public static void main(String[] args) {
        int[] arr={4,3,6,7};
        int k=3;
        System.out.println(removeStones(arr, k));
    }
}
