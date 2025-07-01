package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    //COURSE SCHEDULE: 
    //returns the topological sort[linear ordering] of the given pre requisites if possible otherwise return an empty array
    
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }



        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        int topo[] = new int[n];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[ind++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }


        if (ind == n) return topo;
        int[] arr = {};
        return arr;
    }


    //PRE REQUISITES TASK:
    //return "yes" if it is possible to perform all tasks in linear order[topo sort/ if graph contains cycle] otherwise returns "no" 

    public static boolean isPossible(int V, int[][] prerequisites) {
            // Form a graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            int m = prerequisites.length;
            for (int i = 0; i < m; i++) {
                adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
    
            int indegree[] = new int[V];
            for (int i = 0; i < V; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }
    
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
    
            List<Integer> topo = new ArrayList<Integer>();
            // o(v + e)
            while (!q.isEmpty()) {
                int node = q.peek();
    
                q.remove();
                topo.add(node);
                // node is in your topo sort
                // so please remove it from the indegree
    
                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) q.add(it);
                }
            }
    
    
            if (topo.size() == V) return true;
            return false;
    
        }
    
    
        public static void main(String[] args) {
            int N = 4;
            int M = 3;
            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                prerequisites.add(i, new ArrayList<>());
            }
    
    
            prerequisites.get(0).add(0);
            prerequisites.get(0).add(1);
    
            prerequisites.get(1).add(1);
            prerequisites.get(1).add(2);
    
            prerequisites.get(2).add(2);
            prerequisites.get(2).add(3);
    
            int[] ans1 = CourseSchedule.findOrder(N, M, prerequisites);
            for (int task : ans1) {
                System.out.print(task + " ");
            }
            System.out.println("");
    
    
    
        //     int N = 4;
        //     int[][] prerequisites = new int[3][2];
        //     prerequisites[0][0] = 1;
        //     prerequisites[0][1] = 0;
    
        //     prerequisites[1][0] = 2;
        //     prerequisites[1][1] = 1;
    
        //     prerequisites[2][0] = 3;
        //     prerequisites[2][1] = 2;
    
        //     boolean ans2 = CourseSchedule.isPossible(N, prerequisites);
        // if (ans2)
        //     System.out.println("YES");
        // else
        //     System.out.println("NO");
    }
}
