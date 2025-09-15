package DP.MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinCostToCutStick {
    //MEMOIZATION
    //TC:O(n*n*n) SC:O(n*n)+O(n)
    public static int cost1(int n, int c, ArrayList<Integer> cuts) {
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f1(1, c, cuts, dp);
    }

    static int f1(int i, int j, ArrayList<Integer> cuts, int[][] dp) {
        // Base case
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                      f1(i, ind - 1, cuts, dp) +
                      f1(ind + 1, j, cuts, dp);

            mini = Math.min(mini, ans);
        }

        return dp[i][j]=mini;
    }

    //TABULATION
    //TC:O(n*n*n) SC:O(n*n)
    public static int cost2(int n, int c, ArrayList<Integer> cuts) {
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println(cost1(n, c, cuts));
        System.out.println(cost2(n, c, cuts));
    }
}
