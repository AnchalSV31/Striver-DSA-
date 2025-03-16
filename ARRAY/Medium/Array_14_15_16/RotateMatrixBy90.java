package ARRAY.Medium.Array_14_15_16;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int ans[][] = rotate(arr);
        //System.out.println("Rotated Image");
        // for (int i = 0; i < ans.length; i++) {
        //     for (int j = 0; j < ans.length; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        
        rotate2(arr);
        System.out.println("Rotated Image");
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr.length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
    
    //Rotate matrix/image by 90 degrees

    //Brute force
    static int[][] rotate(int[][] matrix){
        int n=matrix.length;
        int rotated[][]= new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                rotated[j][n-i-1]=matrix[i][j];
            }
        }
        return rotated;
    }

    //Optimal approach
    static void rotate2(int[][] matrix){
        int n = matrix.length;
        //Transpose
        for(int i=0; i<n; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //Reverse every row
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

        //Print rotated matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
