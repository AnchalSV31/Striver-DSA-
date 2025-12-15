package Heap;
import java.util.*;

//replace elements by its rank in the array
public class ReplaceByRank {
    //TC:O(n log n) SC:O(n)
    public static int[] rankTransform(int[] arr){
        int n=arr.length;
        int[] result = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: arr){
            minHeap.offer(num);
        }

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank=1;

        while(!minHeap.isEmpty()){
            int val = minHeap.poll();
            if(!rankMap.containsKey(val)){
                rankMap.put(val, rank);
                rank++;
            }
        }

        for(int i=0; i<n; i++){
            result[i]=rankMap.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={40,10,20,30};
        System.out.println(Arrays.toString(rankTransform(arr)));
    }
}
