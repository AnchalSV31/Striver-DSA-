package StackNQueue;

import java.util.Stack;

public class MaximalRectangle {
    //TC: O(N*M) SC: O(N*M)
    public static int maximalRectangle(char[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] preSum = new int[m];

        //fill up prefix sum matrix column wise
        for(int i=0; i<n; i++){
            for(int j=0; j<m ; j++){
                if(matrix[i][j]== 1){
                    preSum[j]+=1;
                }else{
                    preSum[j]=0;
                }
            }
            //find maximum rectangle area column wise
            maxArea = Math.max(maxArea, lArea(preSum));
        }
        return maxArea;
    }

    //to calculate largest rectangle area in a histogram
    public static int lArea(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n=arr.length;
        
        for(int i=0; i<=n; i++){
            int h = (i==n) ? 0 : arr[i];
            //pop elements from the stack until we find the smaller one
            while(!st.isEmpty() && arr[st.peek()]>=h){
                int height = arr[st.pop()];
                //width: nse-pse-1
                //pse= st.isEmpty() ? -1 : st.peek(); 
                //nse= i; next smaller element index is current index
                int width = st.isEmpty() ? i :i - st.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
