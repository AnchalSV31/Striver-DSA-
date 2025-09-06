package DP;
import java.util.*;

//3D DP - Ninja and his Friends
public class CherryPickup2 {
    //MEMOIZATION TC:0(N*M*M)*9 SC: O(N*M*M)+O(N)
    public static int maxChoco(int n, int m, int[][] grid){
        int dp[][][]= new int[n][m][m];

        for(int row1[][]: dp){
            for(int row2[]: row1){
                Arrays.fill(row2, -1);
            }
        }
        return maxChocoUtil(0, 0, m-1, n, m, grid, dp);
    }

    public static int maxChocoUtil(int i, int j1, int j2, int n, int m, int grid[][], int dp[][][]){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)Math.pow(-10, 9);
        }

        //if we are at the last row, return the sum of the chocolates in the selected column
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int maxi=Integer.MIN_VALUE;

        //Iterate through all the possible moves in the next row
        for(int di=-1; di<=1; di++){
            for(int dj=-1; dj<=1; dj++){
                int ans;

                //if(j1==j2) add chocolate once only i.e of grid[i][j1]
                if(j1==j2){
                    ans=grid[i][j1]+maxChocoUtil(i+1, j1+di, j2+dj, n, m, grid, dp);
                }
                else{
                    ans=grid[i][j1]+grid[i][j2]+maxChocoUtil(i+1, j1+di, j2+dj, n, m, grid, dp);
                }
                maxi=Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2]=maxi;
    }

    //TABULATION TC:0(N*M*M)*9 SC:O(N*M*M)
    public static int maxChoco2(int n, int m, int[][] grid){
        int dp[][][]= new int[n][m][m];

        //initialize dp rray with values from the last row of grid
        for(int j1=0; j1<m; j1++){
            for(int j2=0; j2<m; j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]= grid[n-1][j1];
                }else{
                    dp[n-1][j1][j2]= grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }

        //outer nested loop to traverse the dp array from second last row to first row
        for(int i=n-2; i>=0; i--){
            for(int j1=0; j1<m; j1++){
                for(int j2=0; j2<m; j2++){
                    int maxi=Integer.MIN_VALUE;
                    // Inner nested loops to try out 9 options
                    for(int di=-1; di<=1; di++){
                        for(int dj=-1; dj<=1; dj++){
                            int ans;

                            if(j1==j2){
                                ans=grid[i][j1];
                            }
                            else{
                                ans=grid[i][j1]+grid[i][j2];
                            }
                            
                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][m - 1];
    }

    public static void main(String args[]) {
        int matrix[][] = {{2, 3, 1, 2},
                          {3, 4, 2, 2},
                          {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(maxChoco(n, m, matrix));
        System.out.println(maxChoco2(n, m, matrix));
    }
}
