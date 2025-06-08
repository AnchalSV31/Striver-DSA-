package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class PaintersPartition {
    public static int paintersPartition(ArrayList<Integer> arr, int m)
    {
        //    Write your code here.
        int n=arr.size();
        if(n<m) return -1;
        int low=Collections.max(arr);
        int high=arr.stream().mapToInt(Integer::intValue).sum();
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int painters=countPainters(arr,mid);
            if(painters<=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int countPainters(ArrayList<Integer> arr, int time){
        int n=arr.size();
        int painters=1;
        int boardPainters=0;

        for(int i=0; i<n; i++){
            if(boardPainters+arr.get(i)>time){
                painters++;
                boardPainters=arr.get(i);
            }else{
                boardPainters+=arr.get(i);
            }
        }
        return painters;   
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        int k=2;
        System.out.println(paintersPartition(arr,k));
    }
}
