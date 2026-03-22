package Recursion;

//TC:  O(9(n ^ 2)) SC: O(1)
public class SudokuSolver {
    public static boolean solveSudoku(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                //if cell is empty
                if(board[i][j]=='.'){
                    //try all digits
                    for(char c= '1'; c<='9'; c++){
                        //check if placing c is valid
                        if(isValid(board, i, j, c)){
                            board[i][j]=c;

                            if(solveSudoku(board)) return true;

                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c){
        //check curr column for duplicates
        for(int i=0; i<9; i++){
            if(board[i][col]==c) return false;
        }

        //check curr row for duplicates
        for(int j=0; j<9; j++){
            if(board[row][j]==c) return false;
        }

        //find start of 3X3 sub-box
        int boxRowStart = 3 * (row/3);
        int boxColStart = 3 * (col/3);

        //check 3X3 box for duplicates
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[boxRowStart+i][boxColStart+j]==c)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        solveSudoku(board);

        // Print solved board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
