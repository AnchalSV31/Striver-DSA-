package StackNQueue;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeDigits(String s, int k){
        Stack<Character> st = new Stack<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && k>0 && (st.peek()-'0')>(s.charAt(i)-'0')){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        while (k>0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        // Build the result from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        // Reverse the string to get the correct order
        sb.reverse();
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // Return "0" if the result is empty
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s="1432219";
        int k=3;
        System.out.println(removeDigits(s, k));
    }
}
