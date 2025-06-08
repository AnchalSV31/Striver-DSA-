package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BookAllocation {
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m){
        if(n<m) return -1;
        int low=Collections.max(arr);
        int high=arr.stream().mapToInt(Integer::intValue).sum();
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int students=countStudents(arr,mid);
            if(students<=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int countStudents(ArrayList<Integer> arr, int maxPages){
        int n=arr.size();
        int cnt=1;
        int pagesum=0;

        for(int i=0; i<n; i++){
            if(pagesum+arr.get(i)>maxPages){
                cnt++;
                pagesum=arr.get(i);
            }else{
                pagesum+=arr.get(i);
            }
        }
        return cnt;
        
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        int n=4;
        int m=2;
        System.out.println(allocateBooks(arr,n,m));
    }
}
