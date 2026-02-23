package Heap;

public class IsBinaryTreeHeap {
    static class Node {
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    //TC: O(N) SC: O(H)
    public static boolean isHeap(Node tree) {
        // code here
        int num= count(tree);
        
         return isCBT(tree, 0, num) && maxHeap(tree);
    }
    
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    
    public static boolean isCBT(Node root, int index, int totalNodes){  //is complete binary tree?
        if (root == null) return true;

        if (index >= totalNodes) return false;

        return isCBT(root.left, 2 * index + 1, totalNodes) &&
               isCBT(root.right, 2 * index + 2, totalNodes);
    }
    
    public static boolean maxHeap(Node root){
        if (root == null) return true;

        // leaf node → valid
        if (root.left == null && root.right == null) return true;

        // only left child
        if (root.right == null)
            return root.data >= root.left.data && maxHeap(root.left);

        // both children exist
        return root.data >= root.left.data &&
               root.data >= root.right.data &&
               maxHeap(root.left) &&
               maxHeap(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(97);
        root.left = new Node(46);
        root.right = new Node(37);
        root.left.left = new Node(12);
        root.left.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(31);
        root.left.left.left=new Node(6);
        root.left.left.right=new Node(9);

        System.out.println(isHeap(root));
    }
}
