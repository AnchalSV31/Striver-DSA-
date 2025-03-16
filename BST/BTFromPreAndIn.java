package BST;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
       
}
    public class BTFromPreAndIn {
        public TreeNode buildTree(int[] preorder, int[] inorder){
            Map<Integer, Integer> inMap=new HashMap<Integer, Integer>();
            for(int i=0; i<inorder.length; i++){
                inMap.put(inorder[i], i);
            }
    
            TreeNode root= buildTreePreIn(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
            return root;
        }
    
        public TreeNode buildTreePreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
            if(preStart>preEnd || inStart>inEnd) return null;
    
            TreeNode root= new TreeNode(preorder[preStart]);
            int inRoot= inMap.get(root.val);
            int numsLeft= inRoot-inStart;
    
            root.left=buildTreePreIn(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
            root.right=buildTreePreIn(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
            return root;
        }

        private void printInorder(TreeNode root) {
            if (root != null) {
                printInorder(root.left);
                System.out.print(root.val + " ");
                printInorder(root.right);
            }
        }
    
    public static void main(String[] args){
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
    
        BTFromPreAndIn obj= new BTFromPreAndIn();
        TreeNode root= obj.buildTree(preorder, inorder);

        obj.printInorder(root);
        System.out.println();
    }
}
