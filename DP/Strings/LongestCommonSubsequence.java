package DP.Strings;
import java.util.*;

public class LongestCommonSubsequence {
  //MEMOIZATION
  //TC: O(N*M) SC:O(N*M)+O(N+M)
  public static int lcsUtil1(String s1, String s2, int ind1, int ind2, int[][] dp){
    if(ind1<0 || ind2<0) return 0;
    if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
    
    if(s1.charAt(ind1)==s2.charAt(ind2)){
      return dp[ind1][ind2] = 1+ lcsUtil1(s1, s2, ind1-1, ind2-1, dp);
    }
    else{
      return dp[ind1][ind2] = Math.max(lcsUtil1(s1, s2, ind1-1, ind2, dp), lcsUtil1(s1, s2, ind1, ind2-1, dp));
    }
  }

  public static int lcs1(String s1, String s2){
    int n= s1.length();
    int m= s2.length();

    int[][] dp=new int[n][m];
    for(int rows[]: dp){
      Arrays.fill(rows, -1);
    }
    return lcsUtil1(s1, s2, n-1, m-1, dp);
  }

  //TABULATION
  //TC: O(N*M) SC:O(N*M)
  public static int lcs2(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int dp[][] = new int[n + 1][m + 1];

    // Initialize the dp array with -1 to indicate that subproblems are not solved yet
    for (int rows[] : dp)
      Arrays.fill(rows, -1);

      // Initialize the first row and first column with zeros since LCS with an empty string is zero
      for (int i = 0; i <= n; i++) {
        dp[i][0] = 0;
      }
      for (int i = 0; i <= m; i++) {
        dp[0][i] = 0;
      }

      // Fill the dp array using dynamic programming
      for (int ind1 = 1; ind1 <= n; ind1++) {
        for (int ind2 = 1; ind2 <= m; ind2++) {
          // If the characters at the current indices are the same, increment the LCS length
          if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
            dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
          else
            dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
      }
    }
    return dp[n][m]; 
  }

  //SPACE OPTIMIZATION
  //TC: O(N*M) SC:O(MIN(N,M))
  public static int lcs3(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Create arrays to store the LCS lengths
    int prev[] = new int[m + 1];
    int cur[] = new int[m + 1];

    // Iterate through the strings and calculate LCS lengths
    for (int ind1 = 1; ind1 <= n; ind1++) {
      for (int ind2 = 1; ind2 <= m; ind2++) {
        // If the characters at the current indices are the same, increment the LCS length
        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
          cur[ind2] = 1 + prev[ind2 - 1];
          // If the characters are different, choose the maximum LCS length by either
          // excluding a character in s1 or excluding a character in s2
        else
          cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
      }
      // Update the 'prev' array to the values of 'cur' for the next iteration
      prev = (int[]) (cur.clone());
    }

    return prev[m]; // Return the length of the Longest Common Subsequence (LCS)
  }

  public static void main(String[] args) {
    String s1= "acd";
    String s2= "ced";
    System.out.println(lcs1(s1, s2));
    System.out.println(lcs2(s1, s2));
    System.out.println(lcs3(s1, s2));
  }
}
