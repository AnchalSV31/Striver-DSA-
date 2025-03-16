package BST;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class ZigZagTraversal {
    public static List<List<Integer>> ZigZagLevelOrder(Node root){
            List<List<Integer>> dS = new ArrayList<>();
            if(root == null){
                return dS;
            }
    
            Queue<Node> q = new LinkedList<>();
            q.add(root);
    
            boolean leftToRight=true;
    
            while(!q.isEmpty()){
                int size=q.size();
                List<Integer> row = new ArrayList<>();
    
                for(int i=0; i<size; i++){
                    Node node = q.poll();
                    row.add(node.data);

                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                }
                // If we need to reverse the row
                if(!leftToRight) {
                    Collections.reverse(row);
                }

                dS.add(row);

                // Toggle the leftToRight flag for the next level
                leftToRight = !leftToRight;
            }
            return dS;
        }
    
        static void printResult(List<List<Integer>> result) {
            for (List<Integer> row : result) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
            }
        }
    
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
    
            List<List<Integer>> result = ZigZagLevelOrder(root);

        printResult(result);
    }
}
