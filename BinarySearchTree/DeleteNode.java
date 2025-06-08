package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
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

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode dummy=root;
        while(root!=null){
            if(key<root.val){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }   
            }else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    public static TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            TreeNode rightChild=root.right;
            TreeNode lastRight=findLastRight(root.left);
            lastRight.right=rightChild;
            return root.left;
        }
    }

    public static TreeNode findLastRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findLastRight(root.right);
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
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(5);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(7);
        root.left.left.left=new TreeNode(1);
        root.left.left.right=new TreeNode(3);
        root.left.left.right.right=new TreeNode(4);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(8);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(13);

        printLevelOrder(root); 
        System.out.println();

        int key=3;
        deleteNode(root, key);
        printLevelOrder(root);
    }
}
