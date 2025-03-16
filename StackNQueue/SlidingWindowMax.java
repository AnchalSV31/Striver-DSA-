package StackNQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMax {
    //Brute Force
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n-k; i++){
            int maxi=nums[i];
            for(int j=i; j<i+k; j++){
                maxi=Math.max(maxi, nums[j]);
            }
            list.add(maxi);
        }
        return list;
    }

    //Optimal approach
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n=nums.length;
        int[] list = new int[n - k + 1];
        int listi=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                list[listi++]=nums[dq.peek()];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        // System.out.println(maxSlidingWindow(nums, k));
        int ans[]= maxSlidingWindow2(nums, k);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");
    }
}
