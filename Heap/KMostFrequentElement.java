package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class KMostFrequentElement {
    //TC: O(n log k)  SC: O(n)
    public static int[] topKFrequent(int[] nums, int k){
        //Count frequencies
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]); //min heap sorted by frequency

        // keep only k most frequent in heap
        for(int key: mp.keySet()){
            pq.offer(new int[]{key, mp.get(key)});
            if(pq.size()>k){
                pq.poll();  // remove least frequent
            }
        }

        //extract result
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            result[i++]= pq.poll()[0];
        }
        return result;

    }   

    public static void main(String[] args) {
        int[] nums ={1,1,1,2,2,3};
        int k=2;
        int[] ans = topKFrequent(nums, k);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
