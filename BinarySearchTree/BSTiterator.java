package BinarySearchTree;

import java.util.*;

public class BSTiterator {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
            left=null;
            right=null;
        }
    }

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTiterator(TreeNode root){
        pushAll(root);
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }
    
    public int next(){
        TreeNode tmpNode= stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node){
        for(;node!=null; stack.push(node), node=node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Instantiate the BSTiterator with the root of the tree
        BSTiterator iterator = new BSTiterator(root);

        // Traverse the tree using the iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
