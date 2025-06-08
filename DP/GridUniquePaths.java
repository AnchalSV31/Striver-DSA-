package DP;
import java.util.*;

public class GridUniquePaths {
    //Memoization Approach   TC:O(M*N) SC:O((N-1)+(M-1)) + O(M*N)
    public static int countWaysUntil(int i, int j, int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=countWaysUntil(i-1, j, dp);
        int left=countWaysUntil(i, j-1, dp);

        return dp[i][j]=up+left;
    }

    public static int countWays(int m, int n){
        int dp[][]=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return countWaysUntil(m-1, n-1, dp);
    }

    //Tabulation Approach   TC:O(M*N) SC:O(M*N)
    public static int countWaysUntil2(int m, int n, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][i]=1;
                    continue;
                } 
                int up=0;
                int left=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }  
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }

    public static int countWays2(int m, int n){
        int dp[][]=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return countWaysUntil2(m, n, dp);
    }

    //Space Optimization TC:O(M*N) SC:O(N)
    public static int countWaysUntil3(int m, int n){
        int prev[]= new int[n];
        for(int i=0; i<m; i++){
            int temp[]= new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                } 
                int up=0;
                int left=0;
                if(i>0){
                    up=prev[j];
                }
                if(j>0){
                    left=temp[j-1];
                }  
                temp[j]=up+left;
            }
            prev=temp;
        }
        return prev[n-1];
    }

    public static void main(String[] args) {
        int m=3;
        int n=2;
        System.out.println(countWays(m,n));
        System.out.println(countWays2(m,n));
        System.out.println(countWaysUntil3(m,n));
    }
}
