package BST;

import java.util.HashMap;
import java.util.Map;

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

public class BTFromInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        Map<Integer, Integer> inMap=new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
    
        TreeNode root= buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        return root;
    }

    public TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(postStart>postEnd || inStart>inEnd) return null;

        TreeNode root= new TreeNode(postorder[postEnd]);
        int inRoot= inMap.get(root.val);
        int numsLeft= inRoot-inStart;

        root.left=buildTreePostIn(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, inMap);
        root.right=buildTreePostIn(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);
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
        int[] postorder={40,50,20,60,30,10};
        int[] inorder={40,20,50,10,60,30};
    
        BTFromInAndPost obj= new BTFromInAndPost();
        TreeNode root= obj.buildTree(inorder, postorder);

        obj.printInorder(root);
        System.out.println();
    }
}
