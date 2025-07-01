package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int[] color= new int[V];
        for(int i=0; i<V; i++){
            color[i]=-1;
        }
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(check(i, V, adj, color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it: adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }
}
