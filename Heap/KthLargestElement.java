package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    //TC: O(N + K Log n) SC:O(n)
    public static int kthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //max heap
        int largest=0;
        
        for(int ele: arr)pq.offer(ele);
        
        while(k>0){
            largest=pq.poll();
            k--;
        }
        return largest;
    }

    //OPTIMAL APPROACH
    //TC: O(N log k) SC:O(k)
    public static int kthLargest2(int[] arr, int k){
        int n=arr.length; 
        PriorityQueue<Integer> pq=new PriorityQueue<>(); //min heap
        
        for(int i=0; i<k; i++)pq.offer(arr[i]);
        
        for(int i=k; i<n; i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr={10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k=4;
        System.out.println(kthLargest(arr, k));
        System.out.println(kthLargest2(arr, k));
    }
}
