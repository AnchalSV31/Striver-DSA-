package DP;

import java.util.Arrays;

public class MinPathSum {
    //MEMOIZATION TC:O(N*M) SC:O((N-1)+(M-1))+O(N*M)
    public static int minPathSum(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];

        int up=grid[i][j]+minPathSum(i-1, j, grid, dp);
        int left=grid[i][j]+minPathSum(i, j-1, grid, dp);
        return dp[i][j]=Math.min(up,left);
    }

    public static int minPath(int m, int n, int[][] grid){
        int dp[][]=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return minPathSum(m-1, n-1, grid, dp);
    }

    //Tabulation  TC:O(N*M) SC:O(N*M)
    public static int minPathSum2(int m, int n, int[][] grid, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }else{
                    int up=grid[i][j];
                    if(i>0){
                        up+=dp[i-1][j];   //requiring prev row's j col
                    }else{
                        up+=(int)Math.pow(10,9);
                    }
                    int left=grid[i][j];
                
                    if(j>0){
                        left+=dp[i][j-1];     //requiring curretn row's j-1 col
                    }else{
                        left+=(int)Math.pow(10,9);
                    }
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        
        return dp[m-1][n-1];
    }

    public static int minPath2(int m, int n, int[][] grid){
        int dp[][]=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return minPathSum2(m, n, grid, dp);
    }

    //Space Optimization  TC:O(N*M) SC:O(M)  //ONLY ONE ROW
    public static int minPathSum3(int m, int n, int[][] grid){
        int[] prev=new int[n];
        for(int i=0; i<m; i++){
            int[] temp=new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=grid[i][j];
                }else{
                    int up=grid[i][j];
                    if(i>0){
                        up+=prev[j];
                    }else{
                        up+=(int)Math.pow(10,9);
                    }
                    int left=grid[i][j];
                
                    if(j>0){
                        left+=temp[j-1];
                    }else{
                        left+=(int)Math.pow(10,9);
                    }
                    temp[j]=Math.min(up,left);
                }
                
            }
            prev=temp;
        }
        
        return prev[n-1];
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {5, 9, 6},
            {11, 5, 2}
        };

        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(minPath(m, n, matrix));
        System.out.println(minPath2(m, n, matrix));
        System.out.println(minPathSum3(m, n, matrix));
    }
}
