package DP.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;

//Partition A Set Into Two Subsets With Minimum Absolute Sum Difference
public class PartitionIntoTwoSubsetMinSumDiff {
  //MEMOIZATION
  //TC: O(N*totSum) +O(N) +O(N) SC: O(N*totSum) +O(N)
  public static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
    int totSum = 0;

    // Calculate the total sum of the array elements
    for (int i = 0; i < n; i++) {
      totSum += arr.get(i);
      }

    // Create a DP table to store subset sum information
    boolean[][] dp = new boolean[n][totSum + 1];

    // Initialize the DP table for the first row
    for (int i = 0; i <= totSum; i++) {
      dp[0][i] = (i == arr.get(0));
    }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

  
  //TABULATION
  //TC:O(N*totSum)+O(N)+O(N)  SC:O(N*totSum)

  public static int minSubsetSumDifference2(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum + 1];

        // Initialize the DP table for the first row
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the DP table for the first column
        if (arr.get(0) <= totSum) {
            dp[0][totSum] = true;
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    //SPACE OPTIMIZATION
    //TC:  O(N*totSum) +O(N) +O(N)  SC: O(totSum)
    public static int minSubsetSumDifference3(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create an array to store DP results for the previous row
        boolean[] prev = new boolean[totSum + 1];

        // Initialize the DP array for the first row
        prev[0] = true;

        // Initialize the DP array for the first column
        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store DP results for the current row
            boolean[] cur = new boolean[totSum + 1];
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = prev[target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }

                // Update the DP array for the current element and target sum
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
      ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int n = arr.size();

      // Calculate and print the minimum absolute difference
      System.out.println("The minimum absolute difference is:  "+ minSubsetSumDifference(arr, n));
      System.out.println("The minimum absolute difference is:  "+ minSubsetSumDifference2(arr, n));
      System.out.println("The minimum absolute difference is:  "+ minSubsetSumDifference3(arr, n));
    }
}
 