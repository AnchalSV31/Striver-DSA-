package Greedy;
import java.util.*;

public interface InsertInterval {
    //TC:O(N) SC:O(N)
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int i=0;
        ArrayList<int[]> ans = new ArrayList<>();

        //Add non-overlapping intervals that come before the new interval
        while(i<n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        //Merge overlapping intervals
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }    

        ans.add(newInterval);

        //Add remaining intervals
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][]intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] result= insert(intervals, newInterval);
        for(int i=0; i<result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
