package Recursion;

public class WordSearch {
    //TC : O(m * n * 4^L)  SC: O(L)
    public static boolean exist(char[][] board, String word){
        int rows= board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int idx){
        //if word is completely found
        if(idx==word.length()) return true;

        //boundary and mismatch check
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx)){
            return false;
        }

        //store character and mark visited
        char temp = board[i][j];
        board[i][j]= '#';

        //explore in all four directions
        boolean found = dfs(board, word, i+1, j, idx+1) || 
                        dfs(board, word, i-1, j, idx+1) || 
                        dfs(board, word, i, j+1, idx+1) || 
                        dfs(board, word, i, j-1, idx+1);

        //restore character
        board[i][j]=temp;

        return found;
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE"));    // true
        System.out.println(exist(board, "ABCB"));   // false
    }
}
