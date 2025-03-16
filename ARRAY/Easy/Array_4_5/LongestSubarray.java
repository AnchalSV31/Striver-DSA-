package ARRAY.Easy.Array_4_5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        //int len = getLongestSubarray(a, k);
        //int len2 = getLongestSubarray2(a, k);
        //int len3 = getLongestSubarray3(a, k);
        int len4 = getLongestSubarray4(a, k);
        System.out.println("The length of the longest subarray is: " + len4);
    }

    //brute force
    public static int getLongestSubarray(int []a, long k){
        int n=a.length;
        int len=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                long s=0;
                for(int K=i; K<=j; K++){
                    s+=a[K];
                }
                if(s==k){
                    len=Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    //solution 2
    public static int getLongestSubarray2(int a[], long k){
        int n=a.length;
        int len=0;
        for(int i=0; i<n; i++){
            long s=0;
            for(int j=i; j<n; j++){
                s+=a[j];
                if(s==k){
                    len=Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }


    //BETTER SOLUTION (FOR POSITIVE ONLY) (USING HASHMAP) 
    //AND OPTIMAL(FOR POSITIVES AND NEGATIVES BOTH)
    public static int getLongestSubarray3(int a[], long k){
        int n=a.length;

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum=0;
        int maxlen=0;
        for(int i=0; i<n; i++){
            //calculate the prefix sum till index i:
            sum+=a[i];

            // if the sum = k, update the maxLen:
            if(sum==k){
                maxlen=Math.max(maxlen, i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem=sum-k;

            //Calculate the length and update maxLen:
            if(preSumMap.containsKey(rem)){
                int len=i-preSumMap.get(rem);
                maxlen=Math.max(maxlen, len);
            }

            //Finally, update the map checking the conditions:
            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }
        return maxlen;
    }

    //optimal approach
    public static int getLongestSubarray4(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

}
