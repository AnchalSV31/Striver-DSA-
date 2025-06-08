package BinarySearchTree;

//Largest BST in Binary Tree

public class LargestBST {
    //TC:O() SC:O()
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            data=x;
            left=null;
            right=null;
        }
    }
    static class NodeValue{
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize){
            this.maxNode=maxNode;
            this.minNode=minNode;
            this.maxSize=maxSize;
        }
    }
    public static int largestBST(TreeNode root) {
        // Write your code here.
        return largestSubtree(root).maxSize;
    }

    public static NodeValue largestSubtree(TreeNode root){
        //an empty tree is a BST of size 0
        if(root==null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        //get values from left and right subtree of current tree
        NodeValue left = largestSubtree(root.left);        
        NodeValue right = largestSubtree(root.right);

        //current node is greater than max in left and smaller than min in right
        if(left.maxNode<root.data && root.data<right.minNode){
            //it is a BST
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), (1 + left.maxSize + right.maxSize));
        }

        //othervise return [-inf, inf] so that paretn can't be valid bst
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(8);
        root1.right.right = new TreeNode(7);
        System.out.println("Largest BST size: " + largestBST(root1));
    }

}
