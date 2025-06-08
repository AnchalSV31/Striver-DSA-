package BinarySearch.TwoDArray;

public class RowWithMaxNumnerOfOnes {

    //TC:O(n * log2 m)
    public static int rowWithMaxOne(int[][] arr, int n, int m){
        int cnt_max=0;
        int index=-1;
        for(int i=0; i<n; i++){
            int cnt_ones=m-lowerBound(arr[i],m,1);
            if(cnt_ones>cnt_max){
                cnt_max=cnt_ones;
                index=i;
            }
        }
        return index;
    }

    public static int lowerBound(int[] arr, int n, int x){
        int low=0, high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr={{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}};
        int n=4, m=4;
        System.out.println(rowWithMaxOne(arr,n,m));
    }
}
