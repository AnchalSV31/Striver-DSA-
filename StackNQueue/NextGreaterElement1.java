package StackNQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> numToNextGreater = new HashMap<>();
            Deque<Integer> stack = new ArrayDeque<>(); // a decreasing stack
    
        for (final int num : nums2) {
          while (!stack.isEmpty() && stack.peek() < num)
            numToNextGreater.put(stack.pop(), num);
          stack.push(num);
        }
    
        for (final int num : nums1)
          if (numToNextGreater.containsKey(num))
            ans.add(numToNextGreater.get(num));
          else
            ans.add(-1);
    
        return ans.stream().mapToInt(Integer::intValue).toArray();
        }
        
        public static void main(String args[]) {
            int arr1[]={4,1,2};
    
            int arr2[] = {1,3,4,2};
            int arr3[] = nextGreaterElement(arr1, arr2);
        
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
