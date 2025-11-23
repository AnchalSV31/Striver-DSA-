package StackNQueue;

import java.util.Stack;

public class AsteroidCollision {
    public static Stack<Integer> asteroidCollision(int[] arr){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            // If asteroid is moving right, push it to the stack
            if(arr[i]>0) st.push(arr[i]);
            // If asteroid is moving left, handle possible conditions
            else{
                // Destroy all smaller right-moving asteroids
                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(arr[i])){
                    st.pop();
                }
                // Destroy both if sizes are equal
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
                // If top of stack is a left-moving or no asteroid, add this one
                else if(st.isEmpty() || st.peek()<0){
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
