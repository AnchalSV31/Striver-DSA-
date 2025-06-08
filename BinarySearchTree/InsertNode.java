package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNode {
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

    public static TreeNode insertNode(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertNode(root.left, val);
        }else{
            root.right=insertNode(root.right, val);
        }
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            } 
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);

        int val=5;
        printLevelOrder(root);
        insertNode(root, val);
        System.out.println();
        printLevelOrder(root);
        
    
    }
}
