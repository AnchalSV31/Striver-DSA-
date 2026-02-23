package Heap;
import java.util.*;

//heap hard problem
public class KthElementInMatrix {
    //Brute force
    //TC:O(n² log n)  SC:O(n²)
    public static int kthSmallest(int[][] mat, int k){
        int n=mat.length;
        int[] arr= new int[n*n];
        int idx=0;

        for(int[] row: mat){
            for(int val: row) arr[idx++]=val;
        }

        Arrays.sort(arr);
        return arr[k-1];
    }

    //Min-heap
    //TC:O(k log n) SC:O(n)
    static class Node{
        int val, r, c;
        Node(int v, int i, int j) {
            val=v; r=i; c=j; 
        }
    }
    public static int kthSmallest2(int[][] mat, int k){
        int n=mat.length;
        PriorityQueue<Node> pq= new PriorityQueue<>((a,b)-> a.val-b.val);

        for(int i=0; i<n; i++){
            pq.add(new Node(mat[i][0], i, 0));
        }

        int count=0, ans=0;

        while(!pq.isEmpty()){
            Node node=pq.poll();
            ans=node.val;
            count++;

            if(count==k) return ans;

            if(node.c + 1<n){
                pq.add(new Node(mat[node.r][node.c+1], node.r, node.c +1));
            }
        }
        return ans;
    }

    //max-heap of size k
    //TC:O(n² log k) SC:O(k)
    public static int kthSmallest3(int[][] mat, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int[] row: mat){
            for(int val: row){
                pq.offer(val);
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.peek();
    }

    //Optimal approach
    //TC: O(n log(maxVal − minVal)) ~ O(n log 10⁴)  SC: O(1)
    public static int kthSmallest4(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = countLessEqual(mat, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int countLessEqual(int[][] mat, int mid) {
        int n = mat.length;
        int count = 0;
        int row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (mat[row][col] <= mid) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int k=3;
        int[][] mat= {{16, 28, 60, 64}, 
                    {22, 41, 63, 91}, 
                    {27, 50, 87, 93}, 
                    {36, 78, 87, 94}};
        System.out.println(kthSmallest(mat, k));
        System.out.println(kthSmallest2(mat, k));
        System.out.println(kthSmallest3(mat, k));
        System.out.println(kthSmallest4(mat, k));
    }
}
