package Graph;
import java.util.*;

public class ShortestDistanceInBinaryMaze {
    //TC: O(4*N*M) SC: O(N*M)
    static class tuple{
        int first, second, third;
        tuple(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }

    public static int shortestPathInBinaryMaze(int[][] grid, int[] source, int[] destination){
        int n=grid.length;
        int m=grid[0].length;

        //The path can only be created out of a cell if its value is 1. 
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
            return -1;

        if(source[0]==destination[0] && source[1]==destination[1]){
            return 0;
        }

        Queue<tuple> q= new LinkedList<>();
        int dist[][]= new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;
        q.add(new tuple(0, source[0], source[1]));

        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};

        while(!q.isEmpty()){
            tuple it=q.peek();
            q.remove();
            int dis=it.first;
            int r=it.second;
            int c=it.third;

            for(int i=0; i<4; i++){
                int newr= r+dr[i];
                int newc= c+dc[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && dist[newr][newc]>dis +1 ){
                    dist[newr][newc]=dis+1;
                    if(newr==destination[0] && newc==destination[1]){
                        return dis+1;
                    }
                    q.add(new tuple(1+dis, newr, newc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};
        int[][] grid={{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};

        int res = shortestPathInBinaryMaze(grid, source, destination);
        
        System.out.print(res);
        System.out.println();
    }

}
