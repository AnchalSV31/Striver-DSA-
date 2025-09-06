package DP;
import java.util.*;

//Fixed starting point and variable end points
public class TriangleMinPathSum {
    //Memoization TC:O(N*N) SC:O(N*N)
    public static int minPathSum(int i, int j, int[][] arr, int n, int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==n-1) return arr[i][j];

        int down=arr[i][j]+ minPathSum(i+1, j, arr, n, dp);
        int diagonal=arr[i][j]+minPathSum(i+1, j+1, arr, n, dp);

        return dp[i][j]=Math.min(down, diagonal);
    }

    public static int minPath(int n, int arr[][]){
        int[][] dp= new int[n][n];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return minPathSum(0, 0, arr, n, dp);
    }

    //Tabulation TC:O(N*N) SC:O(N*N)
    public static int minPath2(int n, int[][] arr){
        int[][] dp= new int[n][n];
        for(int j=0; j<n; j++){
            dp[n-1][j]=arr[n-1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down=arr[i][j]+ dp[i+1][j];
                int diagonal=arr[i][j]+dp[i+1][j+1];

                dp[i][j]=Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    //Space Optimization TC:O(N*M) SC:O(N)
    public static int minPath3(int n, int[][] arr){
        int[] front = new int[n]; // Stores the results for the current row
        int[] cur = new int[n];   // Stores the results for the next row

        for(int j=0; j<n; j++){
            front[j]=arr[n-1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down=arr[i][j]+ front[j];
                int diagonal=arr[i][j]+front[j+1];

                cur[j]=Math.min(down, diagonal);
            }
            front=cur.clone();
        }
        return front[0];
    }

    public static void main(String args[]) {
        int triangle[][] = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(minPath(n, triangle));
        System.out.println(minPath2(n, triangle));
        System.out.println(minPath3(n, triangle));
    }
}
