package DP.Strings;
//minimum insertions/deletions to convert string A to String B

import java.util.Arrays;

public class MinInsertionDeletion {
  //Tabulation
  //TC:O(N*M) SC:O(N*M)
  static int lcs1(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int dp[][] = new int[n + 1][m + 1];
    for (int rows[] : dp)
      Arrays.fill(rows, -1);

    // Initialize the first row and first column with 0
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= m; i++) {
      dp[0][i] = 0;
    }

    // Fill the dp array using a bottom-up approach
    for (int ind1 = 1; ind1 <= n; ind1++) {
      for (int ind2 = 1; ind2 <= m; ind2++) {
        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
          dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
        else
          dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
      }
    }

    return dp[n][m];
  }

  // Function to find the minimum operations required to convert str1 to str2
  static int canYouMake(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int k = lcs1(str1, str2);

    return (n - k) + (m - k);
  }

  //SPACE OPTIMIZATION
  //TC: O(N*M) SC:O(MIN(N,M))
  public static int lcs2(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int prev[] = new int[m + 1];
    int cur[] = new int[m + 1];

    for (int ind1 = 1; ind1 <= n; ind1++) {
      for (int ind2 = 1; ind2 <= m; ind2++) {
        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
          cur[ind2] = 1 + prev[ind2 - 1];
        else
          cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
      }
      prev = (int[]) (cur.clone());
    }

    return prev[m]; 
  }

  static int canYouMake2(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    int k = lcs2(str1, str2);

    return (n - k) + (m - k);
  }

  public static void main(String args[]) {
    String str1 = "abcd";
    String str2 = "anc";
    System.out.println(canYouMake(str1, str2));
    System.out.println(canYouMake2(str1, str2));
  }
}
