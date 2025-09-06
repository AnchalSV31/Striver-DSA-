package DP.Strings;
import java.util.*;

public class EditDistance {
  //memoization
  //TC:O(N*M) SC:O(N*M)+O(N+M)
  public static int editDistanceUtil(String s1, String s2, int i, int j, int dp[][]){
    if(i<0) return j+1;
    if(j<0) return i+1;

    if(dp[i][j]!=-1) return dp[i][j];

    if(s1.charAt(i)==s2.charAt(j)){
      return dp[i][j]=editDistanceUtil(s1, s2, i-1, j-1, dp);
    }else{
      return dp[i][j]= 1+ Math.min(editDistanceUtil(s1, s2, i-1, j-1, dp), Math.min(editDistanceUtil(s1, s2, i-1, j, dp), editDistanceUtil(s1, s2, i, j-1, dp)));
    }
  } 

  public static int editDistance(String s1, String s2){
    int n=s1.length();
    int m=s2.length();

    int dp[][]= new int[n][m];
    for(int rows[]:dp) Arrays.fill(rows, -1);

    return editDistanceUtil(s1, s2, n-1, m-1, dp);
  }

  //TABULATION
  //TC:O(N*M) SC:O(N*M)
  public static int editDistance2(String s1, String s2){
    int n=s1.length();
    int m=s2.length();

    int dp[][]= new int[n+1][m+1];

    for(int i=0;i<=n;i++) dp[i][0]=i;
    for(int j=0;j<=m;j++) dp[0][j]=j;

    for(int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          dp[i][j]=dp[i-1][j-1];
        }else{
          dp[i][j]= 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
      }
    }
    return dp[n][m];
  }

  //SPACE OPTIMIZATION
  //TC:O(N*M) SC:O(M)
  public static int editDistance3(String s1, String s2){
    int n=s1.length();
    int m=s2.length();

    int prev[]= new int[m+1];
    int curr[]= new int[m+1];
    for(int j=0;j<=m;j++) prev[j]=j;

    for(int i=1; i<=n; i++){
      curr[0]=i;
      for(int j=1; j<=m; j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          curr[j]=prev[j-1];
        }else{
          curr[j]= 1+ Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
        }
      }
      prev=curr.clone();
    }
    return curr[m];
  }
        
  public static void main(String[] args) {
    String s1="horse";
    String s2="ros";
    System.out.println(editDistance(s1, s2));
    System.out.println(editDistance2(s1, s2));
    System.out.println(editDistance3(s1, s2));
  }
}
