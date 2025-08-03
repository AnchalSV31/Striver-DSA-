package Graph;
import java.util.*;

public class MinMultipicationsToReachEnd {
    //TC: O(100000 * N)  SC: O(100000 * N) 
    static class Pair {
        int steps, num; 
        Pair(int steps, int num) {
            this.steps = steps;
            this.num = num; 
        }
    }

    public static int minMultiplication(int[] arr, int start, int end){
        if (start == end) return 0; // ✅ base case
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(0,start));

        int[] dist= new int[100000];   //mod=100000
        for(int i=0; i<100000; i++){
            dist[i]=(int)(1e9);
        }

        dist[start]=0;
        int mod=100000;
        int n=arr.length;

        // Multiply the start no. with each of numbers in the arr
        // until we get the end no.
        while(!q.isEmpty()){
            int node=q.peek().num;
            int steps=q.peek().steps;
            q.remove();

            for(int i=0; i<n; i++){
                int num=(arr[i]*node)%mod;

                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if(steps+1 < dist[num]){
                    dist[num]=steps+1;

                    //whenever we reach the end number return the calculated steps
                    if(num==end) return steps+1;
                    q.add(new Pair(steps+1, num));
                }
            }
        }
        // If the end no. is unattainable.
        return -1; 
    }

    public static void main(String[] args) {
        int start=3, end=75;
        int[] arr = {2,5,7};

        int ans = minMultiplication(arr,start,end);
        
        System.out.print(ans);
        System.out.println();
    }
}
