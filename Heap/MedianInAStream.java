package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//heap hard problem

public class MedianInAStream {
    //TC: O(N log N) SC: O(N)
    static PriorityQueue<Integer> leftMaxHeap= new PriorityQueue<>(Collections.reverseOrder());  
    static PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public static ArrayList<Double> medianInStream(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            insertHeap(arr[i]);
            res.add(getMedian());
        }

        return res;
    }

    
    public static void insertHeap(int x){
        if(leftMaxHeap.isEmpty()){
            leftMaxHeap.offer(x);
            return;
        }

        if(x>leftMaxHeap.peek()){
            rightMinHeap.offer(x);
        }else{
            leftMaxHeap.offer(x);
        }

        balanceHeap();
    }

    public static void balanceHeap(){
        //min heap(right) size should not be greater than max heap(left)
        if(rightMinHeap.size()>leftMaxHeap.size()){
            leftMaxHeap.offer(rightMinHeap.poll());
        }else{
            //diff btw left-right should not be greater than 1
            if(rightMinHeap.size()<leftMaxHeap.size()-1){
                rightMinHeap.offer(leftMaxHeap.poll());
            }
        }
    }

    public static double getMedian(){
        //left>right
        if(leftMaxHeap.size()>rightMinHeap.size()){
            return leftMaxHeap.peek();
        }else{
            double ans= leftMaxHeap.peek()+rightMinHeap.peek();
            ans/=2.0;
            return ans;
        }
    }

    public static void main(String[] args) {
        // int arr[] = {5, 15, 1, 3, 2, 8};
        int arr[]={7,11,4,9,15,2,1,18}; 
        System.out.println(medianInStream(arr));
    }
}
