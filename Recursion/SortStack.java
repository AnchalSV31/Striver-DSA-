package Recursion;

import java.util.Stack;

public class SortStack {
    //TC: O(n^2) SC:O(n)
    public static void insert(Stack<Integer> st , int temp){
        if(st.isEmpty() || st.peek()<=temp){
            st.push(temp);
            return;
        }

        //pop the top element and recursively insert
        int val = st.pop();
        insert(st, temp);

        //push the popped element back
        st.push(val);
    }

    public static void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp= st.pop();
            sortStack(st);
            insert(st, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        sortStack(st);

        System.out.print("Sorted stack (descending order): ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
