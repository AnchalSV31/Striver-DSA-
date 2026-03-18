package Recursion;

import java.util.*;

//TC: O(4^(N*N))  SC: O(N*N)
public class RatInAMaze {
    public static boolean isSafe(int x, int y, int n, int[][] maze, int[][] visited){
        return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1 && visited[x][y]==0);
    }

    public static void solve(int x, int y, int n, int[][] maze, int[][] visited, String path, List<String> res){
        //if destination reached, store the path
        if(x==n-1 && y==n-1){
            res.add(path);
            return;
        }

        //mark the cell visited
        visited[x][y]=1;

        //try moving down
        if(isSafe(x+1, y, n, maze, visited)){
            solve(x+1, y, n, maze, visited, path+"D", res);
        }

        //try moving left
        if(isSafe(x, y-1, n, maze, visited)){
            solve(x, y-1, n, maze, visited, path+"L", res);
        }

        //try moving right
        if(isSafe(x, y+1, n, maze, visited)){
            solve(x, y+1, n, maze, visited, path+"R", res);
        }

        //try moving up
        if(isSafe(x-1, y, n, maze, visited)){
            solve(x-1, y, n, maze, visited, path+"U", res);
        }

        //backtrack: unmark cell as unvisited
        visited[x][y]=0;
    }

    public static List<String> findPath(int[][] maze, int n){
        List<String> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        if(maze[0][0]==1){
            solve(0, 0, n, maze, visited, "", res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int n = maze.length;
        List<String> paths = findPath(maze, n);

        for (String p : paths) {
            System.out.print(p + " ");
        }
    }
}
