package StackNQueue;
import java.util.*;

public class StockSpan {
    //BRUTE FORCE
    //TC:O(N^2) SC:O(1)     
    public static int[] stockSpan1(int[] arr, int n){
        int[] ans= new int[n];
        for(int i=0; i<n; i++){
            //to store the current span of stocks
            int currSpan=0;
            //traverse backwards to find stock span
            for(int j=i; j>=0; j--){
                // Update stock span if the current price is less than or equal to current price
                if(arr[j]<=arr[i]){
                    currSpan++;
                }
                // Else, break the loop when a higher stock price is found
                else{
                    break;
                }
            }
            ans[i]=currSpan;
        }
        return ans;
    }

    //OPTIMAL APPROACH
    //TC:O(N) SC:O(N)
    public static int[] findPGE(int[] arr){
        int n=arr.length;
        int[] ans= new int[n];
        Stack<Integer> st= new Stack<>();

        for(int i=0; i<n; i++){
            //get the current element
            int currEle= arr[i];
            //pop elements from the stack until we find the greater element
            while(!st.isEmpty() && arr[st.peek()]<=currEle){
                st.pop();
            }

            //if the stack is empty, it means there is no greater element, so assign -1
            if(st.isEmpty()){
                ans[i]= -1;
            }else{
                // Otherwise, the top element is the previous greater
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
     
    public static int[] stockSpan2(int[] arr, int n) {
        // Get the indices of previous greater elements
        int[] PGE = findPGE(arr);
        
        // To store the final span results
        int[] ans = new int[n];
        
        // Compute the span for each element using the previous greater element indices
        for (int i = 0; i < n; i++) {
            ans[i] = i - PGE[i]; // Calculate span based on previous greater element
        }
        
        // Return the result (stock span for each day)
        return ans;
    }

    public static void main(String[] args) {
        int n = 7; // Number of days
        int[] arr = {120, 100, 60, 80, 90, 110, 115}; 

        // int[] ans = stockSpan1(arr, n);
        int[] ans = stockSpan2(arr, n);
        
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " "); // Display the span of each day
        }
    }
}
