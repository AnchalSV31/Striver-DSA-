package Graph;
import java.util.*;

//Kosaraju's Algorithm
public class StronglyConnectedComponents {
    //TC:~ O(V+E)  SC: O(V)+O(V)+O(V+E)
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        //perform dfs on original graph
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        //Reverse the edges
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (int it : adj.get(i)) {
                // i -> it
                // it -> i
                transpose.get(it).add(i);
            }
        }
        //Perform the DFS on transposed graph
        //And count the no. of different DFS calls to get the no. of SCC
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs3(node, vis, transpose);
            }
        }
        return scc;
    }

    public static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }

    public static void dfs3(int node, int vis[], ArrayList<ArrayList<Integer>> transpose) {
        vis[node] = 1;
        for (Integer it : transpose.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, transpose);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
