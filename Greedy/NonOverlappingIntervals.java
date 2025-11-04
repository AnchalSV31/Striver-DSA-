package Greedy;
import java.util.*;

public class NonOverlappingIntervals {
    //TC:O(N log N) SC:O(1)
    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int count=0;
        int prevEnd=intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<prevEnd){
                count++;
            }else{
                prevEnd=intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {2, 4}, {3, 5}, {1, 2} };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
