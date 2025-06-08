package BinarySearchTree;

public class ValidBST {
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

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(TreeNode root, long minVal, long maxVal){
        if(root==null) return true;
        if(root.val>=maxVal || root.val<=minVal) return false;

        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(18);

        System.out.println(isValidBST(root));
    }
}
