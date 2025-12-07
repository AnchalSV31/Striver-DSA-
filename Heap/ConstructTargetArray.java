package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//construct target array with multiple sums
public class ConstructTargetArray {
    //TC: O(n + log(maxElement) log n)  SC: O(n)
    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;

        for(int i=0; i<target.length; i++){
            pq.offer(target[i]);
            sum+=target[i];
        }

        int maxEle, remSum, ele;

        while(pq.peek()!=1){
            maxEle=pq.poll();
            remSum=sum-maxEle;
            
            //maxEle= remSum+ele
            //edge cases
            if(remSum<=0 || remSum>=maxEle)return false;

            // ele=maxEle-remSum;//its giving TLE

            //hence this alternative for removing TLE
            ele=maxEle%remSum;
            if(ele==0){
                if(remSum!=1){
                    return false;
                }else{
                    return true;
                }
            }

            pq.offer(ele);
            sum=remSum+ele;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] target={9,3,5};
        System.out.println(isPossible(target));
    }

}
