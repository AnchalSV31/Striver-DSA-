import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Scanner sc= new Scanner(System.in);
        // Long number= sc.nextLong();
        // System.out.println(number);

        // Long number= 914091054l;
        // System.out.println(number);

        // char a='\u00A9';
        // System.out.println(a);

        // int a=10;
        // int b=20;
        // System.out.println(a++ +(b++ +(++a - b++)+ --b));

        Scanner sc = new Scanner(System.in);
        // number of nodes
        int n = sc.nextInt(); 
        // number of edges
        int m = sc.nextInt();

        // Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Directed graph: edge from u to v
            adj[u].add(v); 
        }

        sc.close();

        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + " -> ");
            // Print the list of neighbors for the current node 'i'
            System.out.println(adj[i]);
        }
    }
}