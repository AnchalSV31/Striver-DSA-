package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestInStream {
    //TC: O(n log k)  SC: O(k + n)
    public static int[] kthLargestInStream(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //min heap
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int x: arr){
            pq.offer(x);
            if(pq.size()<k){
                list.add(-1);
            }else{
                if(pq.size()>k){
                    pq.poll();  // remove smallest in top k
                }
                list.add(pq.peek());  // kth largest
            }
        
        }
        
        int[] result= new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6};
        int k=4;
        int n=arr.length;
        int[] ans= kthLargestInStream(k, arr, n);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+ " ");
        }
    }
}
