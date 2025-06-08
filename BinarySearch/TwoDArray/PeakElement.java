package BinarySearch.TwoDArray;

public class PeakElement {
    //TC:O(log m * n) SC:O(1)
    public static int[] findPeak(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int rowInd=maxEle(mat, n, m, mid);

            int left=mid-1>=0 ? mat[rowInd][mid-1]:-1;
            int right=mid+1<m ? mat[rowInd][mid+1]:-1;

            if(mat[rowInd][mid]>left && mat[rowInd][mid]>right){
                return new int[]{rowInd, mid};
            }else if(mat[rowInd][mid]<left){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int maxEle(int[][] mat, int n, int m , int col){
        int maxVal=-1;
        int index=-1;
        for(int i=0; i<n; i++){
            if(mat[i][col]>maxVal){
                maxVal=mat[i][col];
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] mat={{10,20,15},{21,30,14},{7,16,32}};     //peak element=30   [1,1]
        int[] ans=findPeak(mat);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
