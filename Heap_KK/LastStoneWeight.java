package Heap_KK;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    //TC:O(n log n) SC: O(n)
    public static int lastStoneWeight(int[] stones) {
        // int n=stones.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int s: stones) pq.add(s);

        while(pq.size()>1){
            int s1=pq.poll();
            int s2=pq.poll();
            int diff=Math.abs(s1-s2);
            if(diff>0){
                pq.add(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
