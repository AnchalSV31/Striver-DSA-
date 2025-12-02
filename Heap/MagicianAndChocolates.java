package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//TC: O(n + k log n) SC: O(n)
public class MagicianAndChocolates {
    public static int maximumChocolates(ArrayList<Integer> arr,int k){
        // Write your code here.
        // int n=arr.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long mod = 1000000007L;

        // add all chocolates
        for (int c : arr) pq.add(c);

        long maxChoc = 0;

        while (k > 0 && !pq.isEmpty()) {
            int choc = pq.poll();     // take the max
            maxChoc = (maxChoc + choc) % mod;
            pq.add(choc / 2);         // refill half
            k--;
        }

        return (int)(maxChoc % mod);
    } 

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(4);
        arr.add(7);
        arr.add(9);
        arr.add(10);
        int k=2;
        System.out.println(maximumChocolates(arr, k));
    }
}
