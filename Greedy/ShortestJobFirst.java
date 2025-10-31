package Greedy;
import java.util.*;

public class ShortestJobFirst {
    //TC:O(N logN + N) SC:O(1)
    public static float sjf(int[] jobs){
        int n=jobs.length;
        Arrays.sort(jobs);
        int t=0;
        float wtTime=0;

        for(int i=0; i<n; i++){
            wtTime+=t;
            t+=jobs[i];
        }
        return wtTime/n;
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        float ans = sjf(jobs);
        System.out.println("Average waiting time: " + ans);
    }
}
