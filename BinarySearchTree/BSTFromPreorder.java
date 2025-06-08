package BinarySearchTree;

public class BSTFromPreorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        return BST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public static TreeNode BST(int[] pre, int bound, int[] i){
        if(i[0]==pre.length || pre[i[0]]>bound) return null;
        TreeNode root=new TreeNode(pre[i[0]++]);
        root.left=BST(pre, root.val,i);
        root.right=BST(pre, bound, i);
        return root;
    }

    public static void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void main(String[] args) {
        int[] preorder={10, 5, 1, 7, 40, 50}; 
        TreeNode root=bstFromPreorder(preorder);
        postOrder(root);
    }
}
