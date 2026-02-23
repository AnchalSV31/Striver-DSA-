package Heap;
import java.util.*;

public class MaxSumCombination {
    //TC: O(n log n + k log k) SC: O(k)
    public static List<Integer> maxCombinations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Max heap to store sums and their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->  b[0] - a[0]);
        Set<String> vis = new HashSet<>();

        maxHeap.offer(new int[]{nums1[n-1] + nums2[n-1], n-1, n-1 });
        vis.add((n-1) + "," +(n-1));

        List<Integer> res = new ArrayList<>();

        while(k-->0 && !maxHeap.isEmpty()){
            int[] curr= maxHeap.poll();
            int sum = curr[0];
            int i=curr[1];
            int j=curr[2];

            res.add(sum);

            // Check for new combination (i - 1, j)
            if(i-1>=0){
                String key1= (i-1)+","+j;
                if(!vis.contains(key1)){
                    maxHeap.offer(new int[]{nums1[i-1]+nums2[j], i-1, j});
                    vis.add(key1);
                }
            }

            //checkfor new combination(i, j-1)
            if(j-1>=0){
                String key2 = i+","+(j-1);
                if(!vis.contains(key2)){
                    maxHeap.offer( new int[]{nums1[i]+nums2[j-1], i, j-1});
                    vis.add(key2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 3};
        int[] nums2 = {1, 6};
        int k = 2;
        System.out.println(maxCombinations(nums1, nums2, k));
    }
}
