package Heap;

import java.util.*;

public class MergeKSortedArrays {
    static class Pair{
        int value;
        int arrayIndex;
        int elementIndex;

        Pair(int v, int ai, int ei) {
            value = v;
            arrayIndex = ai;
            elementIndex = ei;
        }
    }

    //TC: O(n log k) SC: O(n)
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        int k= mat.length;
        ArrayList<Integer> result= new ArrayList<>();
        
        //push first element of each array
        for(int i=0; i<k; i++){
            if(mat[i].length>0){
                pq.add(new Pair(mat[i][0],i,0));
            }
        }

        //extract min and push next element from same array
        while(!pq.isEmpty()){
            Pair pair= pq.poll();
            result.add(pair.value);

            int nextIdx= pair.elementIndex +1;

            if(nextIdx < mat[pair.arrayIndex].length){
                pq.add(new Pair(mat[pair.arrayIndex][nextIdx], pair.arrayIndex, nextIdx));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8}, 
                {0, 9, 10, 11}};
        
        System.out.println(mergeArrays(mat));

    }
}
