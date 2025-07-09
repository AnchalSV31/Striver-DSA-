package Graph;
import java.util.*;

public class PrintShortestPathDijkstra {
    //TC: O(E * log(V)) SC:O(V + E)
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]){
    ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
    for(int i=0; i<=n; i++){
        adj.add(new ArrayList<>());
    }

    //Build a 1-based adjacency list.Since it's an undirected graph, we add both (u→v) and (v→u).
    for(int i=0; i<m; i++){
        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
    }

    PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y) -> x.first - y.first);
    int[] dist= new int[n+1];
    int[] parent= new int[n+1];
    for(int i=1; i<=n; i++){
        dist[i]=(int)(1e9);
        parent[i]=i;
    }

    dist[1]=0;
    pq.add(new Pair(0,1));
    while(pq.size()!=0){
        Pair it=pq.peek();
        int node=it.second;
        int dis= it.first;
        pq.remove();

        //For each neighbor, check if the new path offers a shorter distance.If so, update the dist[] and parent[].
        for(Pair iter: adj.get(node)){
            int adjNode = iter.first;
            int edW = iter.second;
            if(dis + edW < dist[adjNode]){
                dist[adjNode]=dis +edW;
                pq.add(new Pair(dist[adjNode], adjNode));
                parent[adjNode]=node;
            }
        }
    }

    List<Integer> path= new ArrayList<>();
    if(dist[n]==(int)(1e9)){
        path.add(-1);
        return path;
    }

    // Construct the path
    List<Integer> nodes = new ArrayList<>();
    int node=n;
    while(parent[node]!=node){
        nodes.add(node);
        node= parent[node];
    }
    nodes.add(1);
    Collections.reverse(nodes);

    path.add(dist[n]);  // total weight at front
    path.addAll(nodes); // full path after weight

    return path;

    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };

        List<Integer> result = shortestPath(n, m, edges);
        System.out.println(result);
    }
}
