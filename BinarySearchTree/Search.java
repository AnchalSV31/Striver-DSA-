package BinarySearchTree;

public class Search {
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
    public static TreeNode searchInBST(TreeNode root, int val) {  //If found then return val else -1
        // if (root == null) {
        //     return -1;
        // }
        // if (root.val == val) {
        //     return root.val;
        // }
        // if (root.val > val) {
        //     return searchInBST(root.left, val);
        // } else {
        //     return searchInBST(root.right, val);
        // }


        //Or

        while(root!=null && root.val!=val){
            root=val<root.val ? root.left: root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(8);

        int target=6;
        // System.out.println(searchInBST(root, target));

        TreeNode result=searchInBST(root, target);
        if (result != null) {
            System.out.println("Value " + target + " found in the BST!");
        } else {
            System.out.println("Value " + target + " not found in the BST.");
        }
    }

}
