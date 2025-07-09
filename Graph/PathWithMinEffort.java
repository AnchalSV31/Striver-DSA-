package Graph;
import java.util.*;

public class PathWithMinEffort {
    //TC:O(4*N*M * log(N*M)) SC:O(N*M) 
    static class Tuple{
        int dist, row, col;
        Tuple(int dist, int row, int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }

    public static int pathMinEffort(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        PriorityQueue<Tuple> pq= new PriorityQueue<Tuple>((x,y) -> x.dist-y.dist); 

        int[][] dist= new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j]=(int)(1e9);
            }
        }

        dist[0][0]=0; //source cell
        pq.add(new Tuple(0,0,0));

        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(pq.size()!=0){
            Tuple it= pq.peek();
            pq.remove();
            int diff= it.dist;
            int row=it.row;
            int col=it.col;

            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if(row==n-1 && col==m-1) return diff;

            for(int i=0; i<4; i++){
                int newr=row+dr[i];
                int newc=col+dc[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m){
                    // Effort can be calculated as the max value of differences 
                    // between the heights of the node and its adjacent nodes.
                    int newEffort=Math.max(Math.abs(grid[row][col]-grid[newr][newc]), diff);

                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newEffort<dist[newr][newc]){
                        dist[newr][newc]=newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }
         // If the destination is unreachable.
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        int ans = pathMinEffort(heights);
        
        System.out.print(ans);
        System.out.println();
    }
}
