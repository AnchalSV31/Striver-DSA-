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


    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(arr));
    }
}
