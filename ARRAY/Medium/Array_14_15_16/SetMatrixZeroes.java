package ARRAY.Medium.Array_14_15_16;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        //int matrix[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int matrix[][] = {{1,1,1,1}, {1,0,1,1}, {1,1,0,1}, {1,0,0,1}};
        int n=matrix.length;
        int m=matrix[0].length;
        //int[][] ans=zeroMatrix(matrix, n, m);
        //int[][] ans2=zeroMatrix2(matrix, n, m);
        int[][] ans3=zeroMatrix3(matrix, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                System.out.print(ans3[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Brute force
    public static int[][] zeroMatrix(int matrix[][], int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
        
    }

    static void markRow(int matrix[][], int n, int m, int i){
        for (int j = 0; j < m; j++) {
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }

    static void markCol(int matrix[][], int n, int m, int j){
        for (int i = 0; i < n; i++) {
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }


    //Better approach
    public static int[][] zeroMatrix2(int matrix[][], int n, int m){
        int[] row = new int[n]; // row array
        int[] col = new int[m];  //col array

        //Traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }

    //Optimal approach
    public static int[][] zeroMatrix3(int matrix[][], int n, int m){
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]

        int col0 = 1;

        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                   //mark i-th row:
                   matrix[i][0] = 0;
                   //mark j-th column:
                   if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] != 0){
                    //check for col & row:
                    if(matrix[i][0] == 0 || matrix[0][j] ==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row
        if(matrix[0][0] == 0){
            for (int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        
        return matrix;
    }
}


