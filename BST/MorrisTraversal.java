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

public class MorrisTraversal {
    //Preorder
    public List<Integer> getPreorder(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                preorder.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    preorder.add(cur.val);
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return preorder;
    }

    //Inorder
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        MorrisTraversal sol = new MorrisTraversal();

        List<Integer> preorder = sol.getPreorder(root);

        System.out.print("Binary Tree Morris Preorder Traveral: ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i) + " ");
        }
        System.out.println();


        List<Integer> inorder = sol.getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }

}
