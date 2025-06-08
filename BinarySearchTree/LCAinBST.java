package BinarySearchTree;

public class LCAinBST {
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
    
    //TC:O(H) SC:O(1)
    public static TreeNode lcaInBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int curr=root.val;
        if(curr<p.val && curr<q.val){
            return lcaInBST(root.right, p,q);
        }
        if(curr>p.val && curr>q.val){
            return lcaInBST(root.left, p,q);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(8);
        root.right=new TreeNode(22);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(12);
        root.left.right.left=new TreeNode(10);
        root.left.right.right=new TreeNode(14);

        TreeNode p=new TreeNode(10);
        TreeNode q=new TreeNode(14);
        TreeNode lca=lcaInBST(root, p,q);
        System.out.println(lca.val);
    }
}

