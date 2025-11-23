package StackNQueue;

import java.util.Stack;

public class LargestRectangleInHistogram {
    //Brute force
    public static int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


    //Optimal Approach 1 [Using next smaller element and previous smaller element]
    public static int largestRectangleArea2(int[] arr) {
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

    //optimal approach
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        // Compute NSL (Nearest Smaller to Left)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            leftsmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        // Clear the stack for reuse
        st.clear();

        // Compute NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            rightsmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        // Compute max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightsmall[i] - leftsmall[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(arr));
    }
}
