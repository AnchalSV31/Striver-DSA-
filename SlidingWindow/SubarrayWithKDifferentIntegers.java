package SlidingWindow;

import java.util.HashMap;

public class SubarrayWithKDifferentIntegers {
    //TC:O(2N)*2 SC:O(N)
    //count subarrays with number of distinct elements <=k
    public static int count(int[] nums, int k) {
        int n= nums.length;
        int cnt=0;
        HashMap<Integer, Integer> mp= new HashMap<>();
        int left=0, right=0;

        while(right<n){
            mp.put(nums[right], mp.getOrDefault(nums[right],0)+1);
            while(mp.size()>k){
                mp.put(nums[left], mp.get(nums[left])-1);
                if(mp.get(nums[left])==0) mp.remove(nums[left]);
                left++;
            }
            cnt+=(right-left+1);
            right++;
        }
        return cnt;
    }

    //TC:O(N) SC:O(N)
    public static int count2(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // if nums[i] <= n, else use HashMap
        int left = 0, cnt = 0, distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) distinct++;
            freq[nums[right]]++;

            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) distinct--;
                left++;
            }
            cnt += (right - left + 1);
        }
        return cnt;
    }

    public static int subarrayWithKDistinct(int[] nums, int k) {    
        // return count(nums, k)-count(nums, k-1);
        return count2(nums, k)-count2(nums, k-1);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarrayWithKDistinct(nums, k));
    }
}
