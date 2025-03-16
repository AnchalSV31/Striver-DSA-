package StackNQueue;

import java.util.Stack;

public class SumOfSubarrayRanges {
    //sum of the difference btw the largest and smallest element in subarrays

    //Brute Force
    public static int sumOfSubarrayRanges(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            int largest = arr[i], smallest= arr[i];
            for(int j=i+1; j<n; j++){
                largest=Math.max(largest, arr[j]);
                smallest=Math.min(smallest, arr[j]);
                sum=sum+(largest-smallest);
            }
        }
        return sum;
    }

    //Optimal solution
    public static int sumOfSubarrayRanges2(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        int[] pge = new int[n];
        int[] nse = new int[n];
        int[] nge = new int[n];


        // find previous smaller or equal element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        //clear the stack
        while(!stack.empty()) stack.pop();

        //find previous greater or equal elements
        for(int i = 0; i < n; i++){
            while(!stack.empty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.empty()) pge[i] = -1;
            else pge[i] = stack.peek();
            stack.push(i);
        }

        //clear the stack
        while(!stack.empty()) stack.pop();

        // Monotonic stack for calculating next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        //clear the stack
        while(!stack.isEmpty()) stack.pop();

        //find next greater elements
        for(int i = n-1; i >= 0; i--){
            while(!stack.empty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if(stack.empty()) nge[i] = n;
            else nge[i] = stack.peek();
            stack.push(i);
        }

        //calculate subarray min
        int sum = 0;
        for(int i = 0; i < n; i++){
            int left = i - pse[i];
            int right = nse[i]-i;
            sum+= right*left*arr[i];
        }
        
        //calculate subarray max
        int sum2 = 0;
        for(int i = 0; i < n; i++){
            int left = i - pge[i];
            int right = nge[i]-i;
            sum2+= right*left*arr[i];
        }
        return sum2-sum;

    }

    public static void main(String[] args) {
        int[] arr={1,4,3,2};
        System.out.println(sumOfSubarrayRanges2(arr));
    }
    
}
