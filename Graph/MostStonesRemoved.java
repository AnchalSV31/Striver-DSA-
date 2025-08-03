package Graph;
import java.util.*;

//most stones removed with same row or column
public class MostStonesRemoved {
    //TC:O(N)  SC:O(2* (max row index + max column index))
    public static int maxStones(int[][] stones, int n){
        int maxRow=0;
        int maxCol=0;
        for(int i=0; i<n; i++){
            maxRow=Math.max(maxRow, stones[i][0]);
            maxCol=Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i=0; i<n; i++){
            int nodeRow= stones[i][0];
            int nodeCol= stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, nodeRow);
            map.put(nodeCol, nodeCol);
        }

        int cnt=0;
        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(ds.parent.get(it.getValue())==it.getValue()){
                cnt++;
            }
        }
        return n-cnt;
    }

    public static class DisjointSet {
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

    //OR

    public static int removeStones(int stones[][]){
        UnionFind uf = new UnionFind();
        Set<Integer> uniqueNodes = new HashSet<>();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = ~stone[1]; // use ~ to distinguish rows and columns uniquely
            uf.union(row, col);
            uniqueNodes.add(row);
            uniqueNodes.add(col);
        }

        int count = 0;
        for (int node : uniqueNodes) {
            if (uf.find(node) == node) {
                count++;
            }
        }

        return stones.length - count;
    }

    static class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();

        public int find(int x) {
            parent.putIfAbsent(x, x);
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent.put(px, py);
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {
            {0, 0}, {0, 2},
            {1, 3}, {3, 1},
            {3, 2}, {4, 3}
        };

        int ans = maxStones(stones, n);
        // int ans = removeStones(stones);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }
}
