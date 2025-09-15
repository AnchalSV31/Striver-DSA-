package DP.MCM;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    //MEMOIZATION
    //TC: O(N*K) SC:O(N)+O(N)
    public static int maxSumAfterPartitioning1(int[] num, int k){
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, num, k, dp);
    }

    public static int f(int ind, int[] num, int k, int[] dp){
        int n = num.length;
        // Base case:
        if (ind == n) return 0;

        if (dp[ind] != -1) return dp[ind];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + f(j + 1, num, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }

    //TABULATION
    //TC:O(N*K) SC:O(N)
    static int maxSumAfterPartitioning2(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n + 1];
        
        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            
            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, num[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int ans = maxSumAfterPartitioning1(num, k);
        int ans2 = maxSumAfterPartitioning2(num, k);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
