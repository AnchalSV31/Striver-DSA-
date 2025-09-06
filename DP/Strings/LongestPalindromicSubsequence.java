package DP.Strings;
import java.util.Arrays;

public class LongestPalindromicSubsequence {
  //TABULATION
  //TC: O(N*M) SC:O(N*M)
  public static int lcs1(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int dp[][] = new int[n + 1][m + 1];

    for (int rows[] : dp)
      Arrays.fill(rows, -1);

      for (int i = 0; i <= n; i++) {
        dp[i][0] = 0;
      }
      for (int i = 0; i <= m; i++) {
        dp[0][i] = 0;
      }

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

  public static int longestPalindrome1(String s){
    String rev = new StringBuilder(s).reverse().toString();
    return lcs1(s, rev);
  }

  //SPACE OPTIMIZATION
  //TC: O(N*M) SC:O(MIN(N,M))
  public static int lcs2(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Create arrays to store the LCS lengths
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

   public static int longestPalindrome2(String s){
    String rev = new StringBuilder(s).reverse().toString();
    return lcs2(s, rev);
  }

  public static void main(String[] args) {
    String s= "bbabcbcab";
    System.out.println(longestPalindrome1(s));
    System.out.println(longestPalindrome2(s));  
  }
}
