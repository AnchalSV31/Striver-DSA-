package DP.Strings;
import java.util.Arrays;

public class DistinctSubsequence {
  //MEMOIZATION
  //TC:O(N*M) SC:O(N*M) + O(N+M)
  static int prime=(int)(Math.pow(10,9)+7);
  public static int countUtil1(String s1, String s2, int ind1, int ind2, int[][] dp){
    if(ind2<0) return 1;
    if(ind1<0) return 0;
    if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

    if(s1.charAt(ind1)==s2.charAt(ind2)){
      int leaveOne= countUtil1(s1, s2, ind1-1, ind2-1, dp);
      int stay = countUtil1(s1, s2, ind1-1, ind2, dp);
      return dp[ind1][ind2]=(leaveOne+stay)%prime;
    }else{
      return dp[ind1][ind2]=countUtil1(s1,s2,ind1-1, ind2, dp);
    }
  }

  public static int subsequenceCounting(String s1, String s2, int lt, int ls){
    int[][] dp = new int[lt][ls];
    for(int rows[]: dp){
      Arrays.fill(rows, -1);
    }
    return countUtil1(s1, s2, lt-1, ls-1, dp);
  }

  //TABULATION
  //TC:O(N*M) SC:O(N*M)
  public static int subsequenceCounting2(String s1, String s2, int n, int m){
    int[][] dp = new int[n+1][m+1];
    for(int i=0; i<n+1; i++){
      dp[i][0]=1;
    }
    for(int i=1; i<m+1; i++){
      dp[0][i]=0;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          // If the characters match, we can either include this character in the subsequence
          // or exclude it. So, we add the counts from both possibilities.
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
        } else {
          // If the characters don't match, we can only exclude this character.
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][m];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*M) SC:O(M)
  static int subsequenceCounting3(String s1, String s2, int n, int m) {
    int[] prev = new int[m + 1];
    prev[0] = 1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = m; j >= 1; j--) { 

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          prev[j] = (prev[j - 1] + prev[j]) % prime;
        } else {
          prev[j] = prev[j]; 
        }
      }
    }
    return prev[m];
  }
  
  public static void main(String[] args) {
    String s1="babgbag";
    String s2="bag";
    System.out.println(subsequenceCounting(s1, s2, s1.length(), s2.length()));
    System.out.println(subsequenceCounting2(s1, s2, s1.length(), s2.length()));
    System.out.println(subsequenceCounting3(s1, s2, s1.length(), s2.length()));

  }
}
