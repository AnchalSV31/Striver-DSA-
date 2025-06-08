package BinarySearchTree;

public class KthLargestSmallest {
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

    //TC:O(N) SC:O(1)
    public static int[] KthElement(TreeNode root, int k){
        int[] small= new int[]{Integer.MIN_VALUE};
        int[] large= new int[]{Integer.MIN_VALUE};

        int[] counter=new int[]{0};

        inorder(root, counter, k, small);
        counter[0]=0;
        reverseInorder(root, counter, k, large);

        return new int[]{small[0], large[0]};
    }

    public static void inorder(TreeNode root, int[] counter, int k, int[] ans){
        if(root==null || counter[0] >= k){
            return;
        }
        inorder(root.left, counter, k, ans);
        counter[0]++;
        if(counter[0]==k){
            ans[0]=root.val;
        }
        inorder(root.right, counter, k, ans);
    }

    public static void reverseInorder(TreeNode root, int[] counter, int k, int[] ans){
        if(root==null || counter[0] >= k){
            return;
        }
        reverseInorder(root.right, counter, k, ans);
        counter[0]++;
        if(counter[0]==k){
            ans[0]=root.val;
        }
        reverseInorder(root.left, counter, k, ans);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        // Find the Kth smallest and largest elements
        int k = 3; 
        System.out.println("k: " + k);
        int[] kthElements = KthElement(root, k);

        System.out.println("Kth smallest element: " + kthElements[0]);
        System.out.println("Kth largest element: " + kthElements[1]);
    }    
}
