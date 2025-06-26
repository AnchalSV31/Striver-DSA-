package Graph;
import java.util.*;

public class MinimumKnightMoves {
    static class Pair{
        int first;
        int second;
        int move;
        Pair(int first, int second, int move){
            this.first=first;
            this.second=second;
            this.move=move;
        }
    }

    public static int bfs(int sr, int sc, int dr, int dc){
        int[] nrows={-2,-1,1,2,2,1,-1,-2};
        int[] ncols={-1,-2,-2,-1,1,2,2,1};

        Queue<Pair> q= new LinkedList<>();
        boolean vis[][]= new boolean[8][8];
        q.add(new Pair(sr, sc, 0));
        vis[sr][sc]=true;

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int move=q.peek().move;
            q.remove();

            if(row==dr && col==dc) return move;

            for(int i=0; i<8; i++){
                int rows=nrows[i]+row;
                int cols=ncols[i]+col;

                if(rows>=0 && rows<8 && cols>=0 && cols<8 && vis[rows][cols]==false){
                    vis[rows][cols]=true;
                    q.add(new Pair(rows, cols, move+1));
                }
            }
        }
        return -1;
    }

    public static int minimumKnight(String src, String des){
        int sr=src.charAt(0)-'a';
        int sc=src.charAt(1)-'1';
        int dr=des.charAt(0)-'a';
        int dc=des.charAt(1)-'1';
        return bfs(sr, sc, dr, dc);
    }

    public static void main(String[] args) {
        String str1="a1";
        String str2="h8";
        System.out.println(minimumKnight(str1, str2));
    }
}
