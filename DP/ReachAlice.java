package DP;

public class ReachAlice {
    //TC: O(N) SC:O(N)
    public static int countWays(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1; // One way to stand at start

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (i + 1 < n) dp[i + 1] += dp[i];
                if (i + 2 < n) dp[i + 2] += dp[i];
            } else {
                if (i + 1 < n) dp[i + 1] += dp[i];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1};
        System.out.println(countWays(arr)); 
    }
}
