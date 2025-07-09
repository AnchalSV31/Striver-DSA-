package Graph;
import java.util.*;

public class FindAllGroupsOfFarmland {
    //TC: O(m * n)  SC: O(m * n) 
    static class Pair{
        int row; 
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public static int[][] findFarmland(int[][] land) {
        int n = land.length, m = land[0].length;
        List<int[]> result = new ArrayList<>();
        boolean[][] vis= new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !vis[i][j]) {
                    int[] group = bfs(land, i, j, n, m, vis);
                    result.add(group);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[] bfs(int[][] land, int row, int col, int n, int m, boolean[][] vis){
        Queue<Pair> q= new LinkedList<>();
        int[] dr = {-1, 0, 1, 0};  
        int[] dc = {0, 1, 0, -1};

        q.add(new Pair(row, col));
        vis[row][col]=true;

        int maxRow=row, maxCol=col;

        while (!q.isEmpty()) {
            Pair p= q.poll();
            int r=p.row;
            int c=p.col;

            maxRow = Math.max(maxRow, r);
            maxCol = Math.max(maxCol, c);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0  && nc < m && land[nr][nc] == 1 && !vis[nr][nc]) {
                    vis[nr][nc] = true; // mark visited
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return new int[]{row, col, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] land ={{1,0,0},
                       {0,1,1},
                       {0,1,1}};
        
        int[][] ans= findFarmland(land);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

}
