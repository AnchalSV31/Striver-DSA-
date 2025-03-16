package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Pair {
        int node;
        int distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }    
    public static int spanningTree(int V, ArrayList<ArrayList<Pair>> adj) {
                PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
                int[] vis = new int[V];
                //{wt, node}
                pq.add(new Pair(0,0));
                int sum=0;
                while(pq.size()>0){
                    // int wt=pq.peek().distance;
                    // int node=pq.peek().node;
                    // pq.remove();
                    Pair current = pq.poll();
                    int wt = current.distance;
                    int node = current.node;
        
                    if(vis[node]==1) continue;
                    //add it to the mst
                    vis[node]=1;
                    sum+=wt;
        
                    for (Pair edge : adj.get(node)) {
                        int adjNode = edge.node;
                        int edW = edge.distance;
                        if(vis[adjNode]==0){
                            pq.add(new Pair(edW, adjNode));
                        }
                    }
                }
                return sum;
            }
        
            public static void main(String[] args) {
                int V = 5;
                ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
                int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        
                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }
        
                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];
                    int w = edge[2];
                    adj.get(u).add(new Pair(w, v));
                    adj.get(v).add(new Pair(w, u));
                }
               

                int sum = spanningTree(V, adj);
            System.out.println("The sum of all the edge weights: " + sum);
    }    
}

