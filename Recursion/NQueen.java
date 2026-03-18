package Recursion;

import java.util.*;

public class NQueen {
    //TC: O(N!) SC: O(N)
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row: board) Arrays.fill(row, '.');

        int[] leftRow = new int[n];        
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];

        solve(0, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
        return res;
    }

    public static void solve(int col, char[][] board, int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> res){
        //if all queens are placed
        if(col==n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }

            res.add(temp);
            return;
        }

        //iterate through rows
        for(int row=0; row<n; row++){
            //check safety
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0){
                //place queen
                board[row][col]= 'Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;

                //recurse
                solve(col+1, board, n, leftRow, upperDiagonal, lowerDiagonal, res);

                //backtrack
                board[row][col]= '.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        for (List<String> board : ans) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
