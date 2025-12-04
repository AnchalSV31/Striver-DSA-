package Heap;
import java.util.*;

public class BstToMaxHeap {
    //TC: O(N) SC: O(N)

    static int index;
    static ArrayList<Integer> inorderList;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    // Converts BST to special Max-Heap
    public static void convertToMaxHeap(Node root){
        inorderList = new ArrayList<>();
        index=0;

         // Step 1: store inorder (sorted)
        inorder(root);

        // Step 2: overwrite using postorder assign → creates special max heap
        postorderAssign(root);
    }

    // Inorder (sorted)
    public static void inorder(Node root){
        if(root==null)return;

        inorder(root.left);
        inorderList.add(root.data);
        inorder(root.right);
    }

    // Assign values in postorder to form Max Heap
    public static void postorderAssign(Node root){
        if(root==null)return;

        postorderAssign(root.left);
        postorderAssign(root.right);
        root.data=inorderList.get(index);
        index++;
    }

    // Utility: Insert in BST
    public static Node insertBST(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insertBST(root.left, val);
        else root.right = insertBST(root.right, val);
        return root;
    }

    // Utility: Print postorder traversal
    public static void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        /*
               BST Example:
                   4
                 /   \
                2     6
               / \   / \
              1  3  5   7
        */

        int[] values = {4, 2, 6, 1, 3, 5, 7};
        Node root = null;

        for (int v : values)
            root = insertBST(root, v);

        convertToMaxHeap(root);

        System.out.println("Postorder of special max heap: ");
        printPostorder(root);
        System.out.println();
    }
}
