package BinarySearch.TwoDArray;

public class SearchIn2DMatrix {
    //BRUTE FORCE    TC:O(N *M) SC: O(1)
    public static boolean searchIn2DMatrix1(int[][] arr, int target){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    //BETTER APPROACH  TC:O(n + logm) SC:O(1)
    public static boolean searchIn2DMatrix2(int[][] arr, int target){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0; i<n; i++){
            if(arr[i][0]<=target && target<=arr[i][m-1]){
                return binarySearch(arr[i], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }

    //OPTIMAL APPROACH  TC:O(log (n*m)) SC:O(1)
    public static boolean searchIn2DMatrix3(int[][] arr, int target){
        int n=arr.length;
        int m=arr[0].length;

        int low=0, high=(n*m-1);
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/m, col=mid%m;
            if(arr[row][col]==target) return true;
            else if(arr[row][col]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int target=8;
        System.out.println(searchIn2DMatrix1(arr,target));
        System.out.println(searchIn2DMatrix2(arr,target));
        System.out.println(searchIn2DMatrix3(arr,target));
    }
}
