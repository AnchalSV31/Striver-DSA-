package DP.Squares;

//count square sub matrices with all ones
public class CountSquareSubmatrices {
    //TC:O(N*M)  SC:O(N*M)
    public static int countSquares(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dp[][]= new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0]=mat[i][0];
        }
        for(int j=0; j<m; j++){ 
            dp[0][j]=mat[0][j];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum+=dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 1, 1},
                       {1, 1, 1, 1},
                       {0, 1, 1, 1}};
        System.out.println(countSquares(mat));
    }
}
