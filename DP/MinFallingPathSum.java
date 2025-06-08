package DP;

import java.util.Arrays;

public class MinFallingPathSum {
    //Memoization TC:O(N*N) SC: O(N) + O(N*M)
    public static int getMin(int i, int j, int m, int[][] mat, int[][] dp){
        if(i==0) return mat[0][j];
        if(j<0 || j>=m) return Integer.MAX_VALUE; 

        if(dp[i][j]!=-1) return dp[i][j];

        int up = mat[i][j] + getMin(i - 1, j, m, mat, dp);
        int ld = Integer.MAX_VALUE;   //left diagonal
        if (j - 1 >= 0) {
            ld = mat[i][j] + getMin(i - 1, j - 1, m, mat, dp);   
        }
        int rd = Integer.MAX_VALUE;  //right diagonal
        if (j + 1 < m) {
            rd = mat[i][j] + getMin(i - 1, j + 1, m, mat, dp);
        }
        return dp[i][j]=Math.min(up, Math.min(rd, ld));
    }

    public static int getMinSum(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[][] dp= new int[n][m];

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        int mini=Integer.MAX_VALUE;
        for(int j=0; j<m; j++){
            int ans=getMin(n-1, j, m, mat, dp);
            mini=Math.min(mini, ans);
        }
        return mini;
    }

    //Tabuation  TC:O(N*M) SC:O(N*M)
    public static int getMinSum2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        // Calculate the minimum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = mat[i][j] + dp[i - 1][j];

                int leftDiagonal = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftDiagonal =  mat[i][j]+ dp[i - 1][j - 1];
                }

                int rightDiagonal = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    rightDiagonal = mat[i][j]+ dp[i - 1][j + 1];
                } 

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }


    //space optimization TC:O(N*M) SC:O(M)// stoer onyl one row
    public static int getMinSum3(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[] prev= new int[m]; //dummmy row
        int[] cur= new int[m];  //current row

        //initializing first row- base condition
        for (int j = 0; j < m; j++) {
            prev[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = mat[i][j] + prev[j];

                int leftDiagonal = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftDiagonal =  mat[i][j]+ prev[j - 1];
                }

                int rightDiagonal = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    rightDiagonal = mat[i][j]+ prev[j + 1];
                } 

                cur[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            prev=cur;
        }

        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }


    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 10, 4},
                          {100, 3, 2, 1},
                          {1, 1, 20, 2},
                          {1, 2, 2, 1}};

        System.out.println(getMinSum(matrix));
        System.out.println(getMinSum2(matrix));
        System.out.println(getMinSum3(matrix));
    }
}
