package Graph;
import java.util.*;

public class EventualSafeStates {
    //TC:O(V+E)+O(N*logN)   SC:O(N) + O(N) + O(N) ~ O(3N)

    //DFS
    public static List<Integer> safeStates(int V, List<List<Integer>> adj){
        int vis[]= new int[V];
        int pathVis[]=new int[V];
        int check[]= new int[V];

        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;

        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it, adj, vis, pathVis, check)==true) return true;
            }else if(pathVis[it]==1){
                return true;
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }

    //BFS
    //TC:O(V+E)+O(N*logN)   SC:O(N) + O(N) + O(N) ~ O(3N)
    
    public static List<Integer> safeStatesBFS(int V, List<List<Integer>> adj){
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // convert i -> it 
            // Into it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }


    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        // List<Integer> safeNodes = safeStates(V, adj);
        List<Integer> safeNodes = safeStatesBFS(V, adj);

        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
