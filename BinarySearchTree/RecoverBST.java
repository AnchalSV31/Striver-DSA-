package BinarySearchTree;

public class RecoverBST {
    //TC:O(N) SC:O(1)
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
            left=right=null;
        }
    }

    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else if(first!=null && middle!=null){
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
    }

    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && (root.val<prev.val)){
            //if this is the first violation, mark these two nodes as first and middle
            if(first==null){
                first=prev;
                middle=root;
            }
            //if this is the second violation, mark this as last
            else{
                last=root;
            }
        }
        //mark this node as previous
        prev=root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        RecoverBST recoverBST=new RecoverBST();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);

        recoverBST.recoverTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
    }
}
