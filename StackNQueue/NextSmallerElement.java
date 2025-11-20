package StackNQueue;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> nse=new ArrayList<>();
        int[] ns= new int[n];
        
        Stack<Integer> st= new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(st.isEmpty()==false && st.peek()>=arr[i%n]){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()==false) ns[i]=st.peek();
                else ns[i]=-1;
            }
            st.push(arr[i%n]);
        }
        
        for(int i=0; i<n; i++){
            nse.add(ns[i]);
        }
        return nse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        ArrayList<Integer> result = nextSmallerElement(arr);
        System.out.println("The next smaller elements are: " + result);
    }

}
