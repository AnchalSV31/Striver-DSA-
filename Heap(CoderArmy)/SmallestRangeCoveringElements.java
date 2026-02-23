package Heap;
import java.util.*;

//smallest range covering all elements from k lists
public class SmallestRangeCoveringElements {
    static class Pair{
        int value;
        int row;
        int col;
        Pair(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    //TC: O(n log k) SC: O(k)
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        
        //insert first element from each list
        for(int i=0;i<nums.size();i++){
            int val = nums.get(i).get(0);
            pq.offer(new Pair(val, i, 0));
            max = Math.max(max, val);
        }

        //best range result
        int start=0;
        int end= Integer.MAX_VALUE;

        //process heap
        while(true){
            Pair pair= pq.poll(); //smallest element
            int minVal= pair.value;

            //update best range if smaller
            if(max-minVal < end-start){
                start=minVal;
                end=max;
            }

            //move pointer ahead in this list
            int nextIndex = pair.col + 1;
            if(nextIndex == nums.get(pair.row).size()){
                break;
            }

            int nextVal = nums.get(pair.row).get(nextIndex);

            //insert next element
            pq.offer(new Pair(nextVal, pair.row, nextIndex));

            //update max
            if(nextVal > max){
                max = nextVal;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0,  9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] ans = smallestRange(nums);
        System.out.println(Arrays.toString(ans));
    }
}
