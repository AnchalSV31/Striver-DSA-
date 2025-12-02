package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//INTERVIEW BIT
public class ProfitMaximisation {
    //TC:O(n + B log n) SC:O(n)
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        
        for(int seat: A){
            pq.offer(seat);
        }
        
        int maxProfit=0;
        
        while(B>0){
            int maxCost=pq.poll();
            maxProfit+=maxCost;
            maxCost--;
            pq.offer(maxCost);
            B--;
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        // int[]A = {2, 3};
        // int B = 3;

        int[] A = {1, 4};
        int B = 2;

        System.out.println(solve(A, B));
    }
}
