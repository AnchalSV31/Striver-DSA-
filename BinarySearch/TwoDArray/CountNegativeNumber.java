package BinarySearch.TwoDArray;

public class CountNegativeNumber {
    //count negative numbers in a sorted matrix[non-increasing order both row-wise and col-wise]
    //Brute Force  TC: O(n*m) SC:O(1)
    public static int countNegative1(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
    
    // Optimal Solution TC:O(m * log n) sc:O(1)
    public static int countNegative2(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        for(int i=0; i<n; i++){
            int low=0, high=m-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(grid[i][mid]<0){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            count+=m-low;
        }
        return count;
    }

    //Two pointer Approach TC:O(m+n)
    public static int countNegative3(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        int i=n-1, j=0;
        while(i>=0 && j<m){
            if(grid[i][j]<0){
                count+=m-j;
                i--;
            }else{
                j++;
            }
        }
        return count;
    } 

    public static void main(String[] args) {
        int[][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegative1(grid));
        System.out.println(countNegative2(grid));
        System.out.println(countNegative3(grid));
    }
}
