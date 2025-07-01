package Graph;
import java.util.*;

public class NumberOfEnclaves {
    ///TC: O(NxMx4) ~ O(N x M)  SC:~ O(N x M)
    static class Pair {
        int first;
        int second; 
        public Pair(int first, int second) {
            this.first = first; 
            this.second = second; 
        }
    }

    public static int countLand(int n, int m, int[][] mat){
        Queue<Pair> q= new LinkedList<Pair>();
        int vis[][]=new int[n][m];
       // traverse boundary elements
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // first row, first col, last row, last col 
                if(i==0 || j==0|| i==n-1 || j==m-1){
                    // if it is a land then store it in queue
                    if(mat[i][j]==1){
                        q.add(new Pair(i, j));
                        vis[i][j]=1;
                    }
                }
            }
        }

        int delrow[]={-1,0,+1,0};
        int delcol[]={0,1,0,-1};

        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // traverses all 4 directions
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1; 
                }
            }
        }
    
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // check for unvisited land cell
                if(vis[i][j]==0 && mat[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[][] mat= {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int[][] mat= {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};  
        int n=mat.length;
        int m=mat[0].length;

        System.out.println(countLand(n, m, mat));
    }
}
