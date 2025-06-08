package BinarySearchTree;
import java.util.*;

public class TwoSumInBST {
    //LEETCODE TWOSUM IV
    //return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

    public Stack<TreeNode> leftmost= new Stack<TreeNode>();
    public Stack<TreeNode> rightmost= new Stack<TreeNode>();
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

    public void pushLeft(TreeNode root){
        while(root!=null){
            leftmost.push(root);
            root=root.left;
        }
    }

    public void pushRight(TreeNode root){
        while(root!=null){
            rightmost.push(root);
            root=root.right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        pushLeft(root);
        pushRight(root);

        while(!leftmost.isEmpty() && !rightmost.isEmpty() && leftmost.peek()!=rightmost.peek()){
            int left=leftmost.peek().val;
            int right=rightmost.peek().val;
            if(left+right==k){
                return true;
            }else if(left+right<k){
                TreeNode node = leftmost.peek();
                leftmost.pop();
                pushLeft(node.right);
            }else{
                TreeNode node = rightmost.peek();
                rightmost.pop();
                pushRight(node.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);  
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);

        int k=9;

        TwoSumInBST obj=new TwoSumInBST();
        System.out.println(obj.findTarget(root, k));

    }
    
}
