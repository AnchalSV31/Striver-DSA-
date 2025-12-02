package Heap_KK;

import java.util.Collections;
import java.util.PriorityQueue;

//take gifts from the richest pile
public class PickGifts {
    //TC: O(N+K∗Log(N)) SC:O(N)
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int gift: gifts){
            pq.add(gift);
        }
        
        long ans=0;

        for(int i=0; i<k; i++){
            int maxGift=pq.poll();
            final int squaredMax = (int) Math.sqrt(maxGift);
            pq.offer(squaredMax);
        }

        while(!pq.isEmpty()){
            ans+=pq.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] gifts={25,64,9,4,100};
        int k=4;
        System.out.println(pickGifts(gifts, k));
    }
}
