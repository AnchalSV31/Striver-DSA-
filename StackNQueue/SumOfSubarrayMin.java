package StackNQueue;

import java.util.Stack;

public class SumOfSubarrayMin {
    //Brute Force
    public static int sumOfSubarrayMin(int[] arr){
        int n=arr.length;
        int sum=0;
        int mod = (int)(1e9+7);
        for(int i=0; i<n; i++){
            int mini=arr[i];
            for(int j=i; j<n; j++){
                mini=Math.min(mini, arr[j]);
                sum=(sum+mini)%mod;
            }
        }
        return sum;
    }

    //Optimal Solution [This code is not same as strivers code for optimal solution]
    //[Watch again!!!!!!!!!]

    public static int sumOfSubarrayMin2(int[] arr){
        int n = arr.length;
        int mod = (int)(1e9 + 7);

        // Arrays to store the previous and next smaller indices
        int[] prev = new int[n];
        int[] next = new int[n];

        // Monotonic stack for calculating previous smaller element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for reuse
        stack.clear();

        // Monotonic stack for calculating next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of subarray minimums
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum = (sum + arr[i] * left * right) % mod;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        System.out.println(sumOfSubarrayMin2(arr));
    }
}
