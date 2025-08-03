package Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvincesDisjointSet {
    public static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
                 
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V){
        DisjointSet ds = new DisjointSet(V);
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    ds.unionBySize(i, j);
                }
            }
        }
        int cnt=0;
        for(int i=0; i<V; i++){
            if(ds.parent.get(i)==i){
                cnt++;
            }
        }
        return cnt; 
    }

    public static void main(String[] args) {
        // adjacency matrix 
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
                
        System.out.println(numProvinces(adj,3));
    }
}
