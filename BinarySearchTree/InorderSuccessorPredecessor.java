package BinarySearchTree;

public class InorderSuccessorPredecessor {
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
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode successor=null;
        while(root!=null){
            if(root.val<=p.val){
                root=root.right;
            }else{
                successor=root;
                root=root.left;
            }
        }
        return successor;
    }

    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p){
        TreeNode predecessor=null;
        while(root!=null){
            if(root.val>=p.val){
                root=root.left;
            }else{
                predecessor=root;
                root=root.right;
            }
        }
        return predecessor;
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
        TreeNode successor=inorderSuccessor(root, p);
        System.out.println(successor.val);

        TreeNode predecessor=inorderPredecessor(root, p);
        System.out.println(predecessor.val);
    }
}
