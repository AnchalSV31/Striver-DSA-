package Recursion;

import java.util.Stack;

//TC: O(n²) SC: O(n)
public class ReverseStack {
    public static void reverseStack(Stack<Integer> st){
        if(!st.isEmpty()){
            if(st.isEmpty())return;

            //pop the top element
            int topVal=st.pop();
            // Recursively reverse the remaining stack
            reverseStack(st);
            // Insert the popped element at the bottom
            insertAtBottom(st, topVal);
        }
    }

    public static void insertAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }

        //pop the top element
        int topVal= st.pop();

        //recurse for the rest of the stack
        insertAtBottom(st, val);

        //push the popped element back
        st.push(topVal);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        // Reverse the stack
        reverseStack(st);

        // Print the reversed stack
        System.out.print("Reversed Stack: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
}
