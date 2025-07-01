package Graph;
import java.util.*;

public class AlienDictionary {
    //TC: O(N*len)+O(K+E)  SC: ~O(4K)
   public static String findOrder(String[] dict, int n, int k){
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0; i<k; i++){
        adj.add(new ArrayList<>());
    }

    for(int i=0; i<n-1; i++){
        String s1= dict[i];
        String s2= dict[i+1];
        int len= Math.min(s1.length(), s2.length());
        for(int ptr=0; ptr<len; ptr++){
            if(s1.charAt(ptr)!=s2.charAt(ptr)){
                adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');  //to convert lowercase char in the form of 0,1,2...
                break;
            }
        }
    }
    List<Integer> topo= topoSort(k, adj);
    String ans= "";
    for(int it: topo){
        ans=ans+(char)(it+(int)('a'));  //to get lowercase char back from integer 0,1,2...
    }
    return ans;
   } 

   public static List<Integer> topoSort(int V, List<List<Integer>> adj){
        int indegree[] = new int[V];
        for(int i=0; i<V; i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo= new ArrayList<>();
        int i=0; 
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            //node is in your topo sort
            //so please remove it from the indegree

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        } 
        return topo;
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
