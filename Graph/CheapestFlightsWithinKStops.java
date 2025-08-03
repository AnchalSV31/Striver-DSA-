package Graph;
import java.util.*;

public class CheapestFlightsWithinKStops {
    //TC: O(N) SC:O(|E|+|V|)  //E=flights.length V=Number of airports
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    static class Tuple{
        int stops;
        int node;
        int cost;
        Tuple(int stops, int node, int cost){
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k){
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int m=flights.length; //number of edges
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q= new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int dist[]= new int[n];
        for(int i=0; i<n; i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple it=q.peek();
            q.remove();
            int stops=it.stops;
            int node=it.node;
            int cost=it.cost;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops>k) continue;
            for(Pair iter: adj.get(node)){
                int adjNode=iter.first;
                int edgeWeight=iter.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if(cost+edgeWeight<dist[adjNode] && stops<=k){
                    dist[adjNode]=cost+edgeWeight;
                    q.add(new Tuple(stops+1, adjNode, cost+edgeWeight));
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4; //number of cities
        int src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int ans = cheapestFlight(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();
    }
}
