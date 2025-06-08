package BinarySearch.TwoDArray;

import java.util.*;

public class MedianInRowWiseSortedMatrix {
    //BRUTE FORCE  TC:O(m*n)+O(m*n(log(m*n)))  SC:O(m*n)
    public static int findMedian(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[] ls= new int[n*m];
        int idx=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ls[idx++]=mat[i][j];
            }
        }
        Arrays.sort(ls);
        return ls[(n*m)/2];
    }


    //OPTIMAL APPROACH  TC:O(log(10^9))*O(m(log n)) SC:O(1)
    public static int findMedian2(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        // point low and high to right elements
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req=(n*m)/2;

        while(low<=high){
            int mid=low+(high-low)/2;
            int smallerEquals=smallerEquals(mat, mid);    //find number of elements smaller than equal to x
            if(smallerEquals<=req){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public static int smallerEquals(int[][] mat, int x){
        int n=mat.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            cnt+=upperBound(mat[i], x);   //find number of elements smaller than equal to x
        }
        return cnt;
    }

    public static int upperBound(int[] arr, int x){   
        int n=arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;    //index of smallest element greater than x
    }

    public static void main(String[] args) {
        int[][] mat={{1,3,5},{2,6,9},{3,6,9}};
        System.out.println(findMedian(mat));
        System.out.println(findMedian2(mat));
    }
}
