package DP;

import java.util.Arrays;

public class GridUniquePaths2 {
    //Memoization TC:O(N*M) SC:O((M-1)+(N-1)) + O(N*M)
    public static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        return dp[i][j] = up + left;
    }

    public static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);
    }


    //Tabulation TC:O(N*M) SC:O(N*M)
    public static int mazeObstaclesUtil2(int m, int n,int[][] maze, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // If there's an obstacle, no paths can go through here.
                if(i>0 && j>0 && maze[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                // There's one valid path to the start cell.
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

    public static int mazeObstacles2(int m, int n, int[][] maze){
        int dp[][]=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return mazeObstaclesUtil2(m, n,maze, dp);
    }

    //Space Optimzation
    public static int mazeObstaclesUtil3(int m, int n,int[][] maze){
        // Initialize the previous row of the DP matrix
        int[] prev=new int[m];
        for(int i=0; i<m; i++){
            // Create a temporary array for the current row
            int[] temp= new int[n];
            for(int j=0; j<n; j++){
                if(i>0 && j>0 && maze[i][j]==-1){
                    temp[j]=0;
                    continue;
                }
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
        return prev[m-1];
    }

    public static void main(String args[]) {
        int[][] maze = {
            {0, 0, 0},
            {0, -1, 0},
            {0, 0, 0}
        };

        int m = maze.length;
        int n = maze[0].length;

        System.out.println(mazeObstacles(m, n, maze));
        System.out.println(mazeObstacles2(m, n, maze));
        System.out.println(mazeObstaclesUtil3(m, n, maze));
    }
}
