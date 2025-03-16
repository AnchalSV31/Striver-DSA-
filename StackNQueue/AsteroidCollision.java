package StackNQueue;

import java.util.Stack;

public class AsteroidCollision {
    public static Stack<Integer> asteroidCollision(int[] arr){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(arr[i]>0) st.push(arr[i]);
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(arr[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])){
                    st.pop();
                }else if(st.isEmpty() || st.peek()<0){
                    st.push(arr[i]);
                }
            }
        }
        return st;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        Stack<Integer> collision = asteroidCollision(asteroids);
        System.out.println(collision);
    }
}
