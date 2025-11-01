package Greedy;
import java.util.*;

public class NMeetingsInOneRoom {
    //TC:O(N*logN) + O(N)  SC:O(N)
    public static List<Integer> maxMeetings(int[] start, int[] end, int n){
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            // i+1 for 1-based index
            meetings.add(new int[]{end[i], start[i], i + 1}); 
        }

        // Sort by end time
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> result= new ArrayList<>();
        int lastEnd=-1;

        for(int[] m: meetings){
            //here m[0]-> end time, m[1]-> start time, m[2]-> index
            if(m[1]>lastEnd){
                // Store original index
                result.add(m[2]);
                // Update last meeting end time
                lastEnd=m[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        List<Integer> res = maxMeetings(start, end, n);

        for (int idx : res) {
            System.out.print(idx + " ");
        }
    }
}
