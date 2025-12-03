package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//sum of elements between k1th and k2th smallest elements
public class SumBetweenTwoKth {
    //TC: O(n log n) SC:O(1) or O(N)
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2){
        Arrays.sort(A);  // Step 1: Sort the array
        
        long first = A[(int)K1 - 1];  // K1-th smallest
        long second = A[(int)K2 - 1]; // K2-th smallest
        
        long sum = 0;
        
        // Step 2: Sum elements between K1th and K2th smallest
        for (int i = 0; i < N; i++) {
            if (A[i] > first && A[i] < second) {
                sum += A[i];
            }
        }
        
        return sum;
    }


    //TC:O(N log K2) SC:O(K2)
    public static long sumBetweenTwoKth2(long A[], long N, long K1, long K2){
        // 1. Find K1-th smallest (using max-heap of size K1)
        PriorityQueue<Long> maxHeap1 = new PriorityQueue<>(Collections.reverseOrder());
        for (long x : A) {
            maxHeap1.offer(x);
            if (maxHeap1.size() > K1) {
                maxHeap1.poll();
            }
        }
        long first = maxHeap1.peek();  // K1-th smallest

        // 2. Find K2-th smallest (using max-heap of size K2)
        PriorityQueue<Long> maxHeap2 = new PriorityQueue<>(Collections.reverseOrder());
        for (long x : A) {
            maxHeap2.offer(x);
            if (maxHeap2.size() > K2) {
                maxHeap2.poll();
            }
        }
        long second = maxHeap2.peek(); // K2-th smallest

        // 3. Sum elements strictly between them
        long sum = 0;
        for (long x : A) {
            if (x > first && x < second) {
                sum += x;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        long N  = 7;
        long A[] = {20, 8, 22, 4, 12, 10, 14};
        long K1 = 3, K2 = 6;
        System.out.println(sumBetweenTwoKth(A, N, K1, K2));
        System.out.println(sumBetweenTwoKth2(A, N, K1, K2));
    }
}
