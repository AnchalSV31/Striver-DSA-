package BinarySearch.TwoDArray;

public class SearchIn2DMarixII {
    //TC: O(N+M) SC: O(1)
    public static int[] searchIn2DMatrix(int[][] arr, int target){
        int n=arr.length;
        int m=arr[0].length;

        int row=0, col=m-1;
        while(row<n && col>=0){
            if(arr[row][col]==target){
                return new int[]{row,col};
            }else if(arr[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr={{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target=14;
        int[] ans=searchIn2DMatrix(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
