package BST;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class FlattenBT {
    TreeNode prev = null;
    public void flatten(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> st= new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.right);
            if(!st.isEmpty()){
                curr.right=st.peek();
            }
            curr.left=null;
        }
    }

    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        FlattenBT sol = new FlattenBT();

        // System.out.print("Binary Tree Preorder: ");
        // printPreorder(root);
        // System.out.println();

        sol.flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        sol.printFlattenTree(root);
        System.out.println();
    }
}
