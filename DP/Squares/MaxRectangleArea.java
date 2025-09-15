package DP.Squares;
import java.util.*;

//largest rectangle containing only 1's and return its area
public class MaxRectangleArea {
    //TC: O(N*(M+N)) SC:O(N)
    public static int largestRectangleArea(int[][] mat, int n, int m) {
        int maxArea=0;
        int height[]= new int[m];
        Arrays.fill(height, 0);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==1) height[j]++;
                else height[j]=0;
            }
            int area= Histogram(height);
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int Histogram(int[] arr){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int element = st.peek();
                st.pop();
                int nse=i, pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, arr[element]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, arr[element]*(nse-pse-1));
        } 
        return maxArea;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 1, 0, 0},
                       {1, 0, 1, 1, 1},
                       {1, 1, 1, 1, 1},
                       {1, 0, 0, 1, 0}};
        int n=mat.length;
        int m=mat[0].length;
        System.out.println(largestRectangleArea(mat, n, m));
        
    }
    
}
