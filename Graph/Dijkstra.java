package Graph;

import java.util.*;

public class Dijkstra {
    //USING PRIORITY QUEUE
    //TC:O(E log(V))  SC:O(|E|+|V|) 

    // static class Pair{
    //     int dist;
    //     int node;

    //     Pair(int dist, int node){
    //         this.dist=dist;
    //         this.node=node;
    //     }
    // }
    
    public static int[] dijsktra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);

        int dist[] = new int[V];
        for(int i=0; i<V; i++){
            dist[i]=(int)(1e9);
        }

        dist[S]=0;
        pq.add(new Pair(0, S));

        while(pq.size()!=0){
            int dis= pq.peek().dist;
            int node= pq.peek().node;
            pq.remove();

            for(int i=0; i<adj.get(node).size(); i++){
                int adjNode= adj.get(node).get(i).get(0);
                int edgeWeight= adj.get(node).get(i).get(1);

                if(dis+edgeWeight < dist[adjNode]){
                    dist[adjNode]=dis+edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }



    //USING SET
    //TC: O((V+E)*log V)  SC: O(V+E)
    
    static class Pair implements Comparable<Pair> {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        // Required for TreeSet to sort and identify duplicates
        
        public int compareTo(Pair other) {
            if (this.dist == other.dist)
                return this.node - other.node; // Break ties using node
            return this.dist - other.dist;
        }

        // Optional but recommended for correct TreeSet behavior
        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return dist == p.dist && node == p.node;
        }

    
        public int hashCode() {
            return Objects.hash(dist, node);
        }
    }

    
    public static int[] dijsktra2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        TreeSet<Pair> st= new TreeSet<>();
        int dist[] = new int[V];
        for(int i=0; i<V; i++){
            dist[i]=(int)(1e9);
        }

        dist[S]=0;
        st.add(new Pair(0, S));

        while(!st.isEmpty()){
            Pair current = st.pollFirst();
            if (current == null) break;

            int dis = current.dist;
            int node = current.node;

            for(int i=0; i<adj.get(node).size(); i++){
                int adjNode= adj.get(node).get(i).get(0);
                int edgeWeight= adj.get(node).get(i).get(1);

                if(dis+edgeWeight < dist[adjNode]){
                    //erase if it existed
                    if(dist[adjNode]!=1e9){
                        st.remove(new Pair(dist[adjNode], adjNode));
                    }
                    dist[adjNode]=dis+edgeWeight;
                    st.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 3, S = 2;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edges like C++ version
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 6)));

        // int[] res = dijsktra(V, adj, S);
        int[] res = dijsktra2(V, adj, S);

        System.out.println("Shortest distances from node " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
    }        
}
