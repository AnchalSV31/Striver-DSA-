package Graph;

import java.util.*;

//Tarjan's Algorithm
public class BridgesInGraph {
    //TC: O(V+2E)  SC:O(V+2E)+O(3V)
    private static int timer=1;
    public static void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int time[], int low[],List<List<Integer>> bridges){
        vis[node]=1;
        time[node]=low[node]=timer;
        timer++;

        for(Integer it: adj.get(node)){
            if(it==parent) continue;   //If the adjacent node is the parent itself
            if(vis[it]==0){   //If the adjacent node is not visited
                dfs(it, node, vis, adj, time, low, bridges);
                low[node]=Math.min(low[node], low[it]);
                if(low[it]>time[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else {   //If the adjacent node is already visited
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (List<Integer> it : connections) {
            int u = it.get(0); int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, time, low, bridges);
        return bridges;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1}, {1, 2},
            {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }

        List<List<Integer>> bridges = criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println("");
    }
}
