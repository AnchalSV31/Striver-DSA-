package Graph;
import java.util.*;


public class GraphRepresentation {
    public static void main(String[] args) {
        int n=3, m=3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        //n+1
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<Integer>());
        }
        //edge1--2
        adj.get(1).add(2);
        adj.get(2).add(1);


        //edge2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge1--3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //print all the edges
        for(int i=1; i<=n; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.println(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
